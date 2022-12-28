package framework.hooks;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import framework.context.TestContext;
import framework.factory.DriverFactory;
import framework.runners.BaseTestNGRunnerTest;
import framework.utils.PropertyUtils;
import io.cucumber.java.*;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.io.FileOutputStream;
import java.io.IOException;
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


        driver = DriverFactory.initializeDriver(context.browser);
        context.driver = driver;


        Capabilities cap = ((RemoteWebDriver) context.driver).getCapabilities();

        //Logging will be available in Extent and Allure Report
        scenario.log("Webdriver initialized for browser: " + cap.getBrowserName() + " version " + cap.getBrowserVersion());

        //Tests will be categorised in Extent Report based on browser
        ExtentCucumberAdapter.getCurrentScenario().assignCategory(cap.getBrowserName());

    }

    @After
    public void teardown(Scenario scenario) {
        //System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
        if (driver != null) driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            //screenshot
            /*File sourcePath= 	((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
            byte[] screenshot = FileUtils.readFileToByteArray(sourcePath);*/
            final byte[] screenshot = ((TakesScreenshot) context.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
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


}
