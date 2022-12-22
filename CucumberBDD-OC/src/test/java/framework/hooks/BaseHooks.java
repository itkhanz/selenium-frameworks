package framework.hooks;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import framework.context.TestContext;
import framework.factory.DriverFactory;
import framework.runners.BaseTestNGRunnerTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Objects;

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
        if (BaseTestNGRunnerTest.browser!=null && Objects.equals(System.getProperty("ondemand"), "true")){
            context.browser = BaseTestNGRunnerTest.browser;
        };

        //Reads the browser parameter from TestNG suite xml file
        if (context.browser==null) {
            String browserParam = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
            //Initializes the browser driver in order of following preferences
            //First it looks for the browserParam which is coming from TestNG suite xml files
            //Then it looks for the system variables from the maven command line or Jenkins
            //Lastly it sets the chrome as default browser for driver initialization
            context.browser = browserParam != null ? browserParam : System.getProperty("browser", "chrome");
        }


        driver = DriverFactory.initializeDriver(context.browser);
        context.driver = driver;

        //Logs the browser info
        Capabilities cap = ((RemoteWebDriver) context.driver).getCapabilities();
        scenario.log("Webdriver initialized for browser: " + cap.getBrowserName() + " version " + cap.getBrowserVersion());
        ExtentCucumberAdapter.getCurrentScenario().assignCategory(cap.getBrowserName());

    }

    @After
    public void teardown(Scenario scenario) {
        //System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
        if (driver!=null) driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException
    {
        if(scenario.isFailed())
        {
            //screenshot
            /*File sourcePath= 	((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
            byte[] screenshot = FileUtils.readFileToByteArray(sourcePath);*/
            final byte[] screenshot = ((TakesScreenshot)context.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }
}
