package framework.hooks;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import framework.context.TestContext;
import framework.factory.DriverFactory;
import framework.runners.BaseTestNGRunnerTest;
import framework.utils.PropertyUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Reporter;

import java.io.*;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Objects;
import java.util.Properties;

public class BaseHooks {
    private WebDriver driver;
    private final TestContext context;

    public BaseHooks(TestContext testContext) {
        this.context = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        //System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

        //Reads the browser static value from @BeforeTest that was set as command line argument in TestNG Parameter
        if (BaseTestNGRunnerTest.browser != null && Objects.equals(System.getProperty("ondemand"), "true")) {
            context.browser = BaseTestNGRunnerTest.browser;
        }
        ;

        //Reads the browser parameter from TestNG suite xml file
        if (context.browser == null) {
            String browserParam = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
            //Initializes the browser driver in order of following preferences
            //First it looks for the browserParam which is coming from TestNG suite xml files
            //Then it looks for the system variables from the maven command line or Jenkins
            //Lastly it sets the chrome as default browser for driver initialization
            context.browser = browserParam != null ? browserParam : System.getProperty("browser", "chrome");
        }


        //Initializes the remote webdriver for Selenium Grid distributed parallel testing
        //Make sure to pass the maven command line argument -DgridMode e.g.  mvn clean test -D"gridMode=true" -PsmokeDistributed
        //Start the selenium hub and nodes on machines separately before running the tests on remote webdriver
        if(Objects.equals(System.getProperty("gridMode", "false"), "true")) {
            String browserVersion =  Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserVersion");
            String platform =  Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformName");
            try {
                driver = DriverFactory.initializeRemoteDriver(context.browser, browserVersion, platform);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("unable to initialize Remote Webdriver for " + context.browser + " version: " + browserVersion + " Platform: " + platform + " " + e.getMessage());
            }
        } else {
            driver = DriverFactory.initializeDriver(context.browser);
        }

        context.driver = driver;

        Capabilities cap = ((RemoteWebDriver) context.driver).getCapabilities();

        //Logging will be available in Extent and Allure Report
        scenario.log("Webdriver initialized for browser: " + cap.getBrowserName() + " version " + cap.getBrowserVersion());

        //Tests will be categorised in Extent Report based on browser
        ExtentCucumberAdapter.getCurrentScenario().assignCategory(cap.getBrowserName());

        //TODO: Till now cross-browser tests are put under Retries tab and there is no way to categorize the tests based on browser and display separately
        //One solution is to change the allure results directory for different browsers and then serve the results of both reports together
    }

    @After (order = 1)
    public void teardown(Scenario scenario) throws InterruptedException {
        Capabilities cap = ((RemoteWebDriver) context.driver).getCapabilities();
        String sessionBrowser = cap.getBrowserName();
        SessionId sID = ((RemoteWebDriver) context.driver).getSessionId();
        String sessionID = sID.toString();
        String scenarioName = scenario.getName();

        if (driver != null) driver.quit();

        //This method waits for driver session to be closed which will result in renaming of selenoid video so we can attach it to report
        //This method is intentionally placed in hook otherwise if placed in separate hook the session won't close
        AddVideo(sessionID, scenarioName, sessionBrowser);
    }

    /**
     * Adds screenshot to Allure and Extent Reports
     * @param scenario
     * @throws IOException
     */
    @After (order = 0)
    public void AddScreenshot(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            //screenshot
            /*File sourcePath= 	((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
            byte[] screenshot = FileUtils.readFileToByteArray(sourcePath);*/

            // displays the screenshot name as current time of given zone without zone information : 2023-01-22T15:08:53.146449100
            //String attachmentName = String.valueOf(LocalDateTime.now(TimeZone.getTimeZone("Europe/Madrid").toZoneId()));
            // displays the screenshot name as current time of given zone with zone information : 2023-01-22T15:08:53.146449100+01:00[Europe/Berlin]
            String attachmentName = String.valueOf(Instant.now().atZone(ZoneId.of("Europe/Berlin")));
            final byte[] screenshot = ((TakesScreenshot) context.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", attachmentName);

        }
    }


    /**
     * Adds test video recording to allure report.
     * Order of 1 indicates that it will execute after driver is shutdown in the After hook with order 0
     * This order is necessary because selenoid recordings get renamed after the browser session is stopped
     * @param sessionID
     * @param scenarioName
     * @param sessionBrowser
     * @throws InterruptedException
     */
    public void AddVideo(String sessionID, String scenarioName, String sessionBrowser) throws InterruptedException {

        //use this path for Dynamic Grid
        //String videoPath = System.getProperty("user.dir") + "\\assets\\test-recordings\\" + sID.toString() + "video.mp4";
        //use this path for Selenoid Grid
        String videoPath = System.getProperty("user.dir") + "\\selenoid\\video\\" + sessionID + ".mp4";

        //Link to Video Recording on Selenoid server
        Properties gridProps = PropertyUtils.propertyLoader("src/test/resources/framework/properties/grid.properties");
        String hubAddress  = gridProps.getProperty("hubURL");
        String selenoidRecordingUrl = hubAddress + "video/" + sessionID + ".mp4";
        Allure.addAttachment("Selenoid Video Recording",
                              "text/html",
                            "<html><head></head><body>" +
                                    "<p><b>Scenario:</b> " + scenarioName + "</p>" +
                                    "<p><b>Browser:</b> " + sessionBrowser + "</p>" +
                                    "<p><b>Session ID:</b> " + sessionID + "</p>" +
                                    "<p><b>Session recording root path :</b> /selenoid/video/" + sessionID + ".mp4</p>" +
                                    "Video Url: <a href='" + selenoidRecordingUrl + "' target='_blank'>" + selenoidRecordingUrl +  "</a>" +
                                    "</body></html>",
                         ".html");

        //Embedded mp4 video recording in Allure report
        if (waitForSelenoidVideoToRename(videoPath, 30000)) {
            try {
                byte[] byteArr = IOUtils.toByteArray(new FileInputStream(videoPath));
                Allure.addAttachment("Embedded mp4 recording " + sessionID + ".mp4", "video/mp4", new ByteArrayInputStream(byteArr), "mp4");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Unable to add video recording to allure report for test: " + scenarioName);
            System.out.println("Selenoid video recording not found for session ID: " + sessionID + " , Browser: " + sessionBrowser);
        }
    }


    /**
     * This method generates environment.properties file in the allure-results directory to display the environment variables in allure report ENVIRONMENT widget.
     * To add information to Environment widget just create environment.properties (or environment.xml) file to allure-results directory before report generation.
     * https://docs.qameta.io/allure/#_environment
     * @throws IOException
     */
    @AfterAll
    public static void setAllureEnvVariables() throws IOException, XmlPullParserException {
        //Instantiating the properties file
        Properties props = new Properties();
        //Populating the properties file
        props.put("OS", System.getProperty("os.name"));
        props.put("Browser", System.getProperty("browser", "Chrome"));
        props.put("Environment", System.getProperty("env", "STAGE"));
        props.put("Java version", System.getProperty("java.version"));

        //Loading the Maven Properties from POM.xml
        final Properties mavenProps = PropertyUtils.mavenPropsLoader("pom.xml");
        props.put("Selenium version", mavenProps.getProperty("selenium.java.version"));
        props.put("Cucumber version", mavenProps.getProperty("cucumber.java.version"));

        //Instantiating the FileInputStream for output file
        //In this case, a new file is created when we instantiate the FileOutputStream object. If a file with a given name already exists, it will be overwritten.
        //If, however, the existing file is a directory or a new file cannot be created for any reason, then we'll get a FileNotFoundException.
        //Additionally, note we used a try-with-resources statement – to be sure that a stream is properly closed.
        try (FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "\\target\\allure-results\\environment.properties")) {
            //Storing the properties file
            props.store(fileOutputStream, "Allure Report environment variables");
        }

    }

    /**
     * Selenoid video file name by default is <session-id>.mp4.
     * Example - selenoid7a408b66263ee21c5e896514aa938105.mp4 is temporary file name which is renamed to correct one when browser session is stopped.
     * This method waits for 30 seconds and performs check for presence of renamed file in specified path. If found it will return true.
     * If renamed file is not found in specified path then method will return false after waiting for a maximum of 30 seconds.
     * @param filePath File path string where selenoid session recording is downloaded
     * @param maxWaitInMillis maximum waiting time in milliseconds to check the presence of renamed file before returning false
     * @return true if file is found within 10 seconds else false
     * @throws InterruptedException
     */
    public boolean waitForSelenoidVideoToRename(String filePath, long maxWaitInMillis) throws InterruptedException {
        File file = new File(filePath);
        //Start time
        Instant start = Instant.now();
        while (!file.exists()) {
            Thread.sleep(1000);
            //End time
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            if (timeElapsed > maxWaitInMillis) return false;
        }
        return true;
    }

}
