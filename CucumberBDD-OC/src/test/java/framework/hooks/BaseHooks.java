package framework.hooks;

import framework.context.TestContext;
import framework.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.IOException;

public class BaseHooks {
    private WebDriver driver;
    private final TestContext context;

    public BaseHooks(TestContext testContext) {
        this.context = testContext;
    }


    @Before
    public void setup(Scenario scenario) {
        //System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

        //Reads the browser parameter from TestNG suite xml file
        String browserParam = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");

        //Initializes the browser driver in order of following preferences
        //First it looks for the browserParam which is coming from TestNG suite xml files
        //Then it looks for the system variables from the maven command line or Jenkins
        //Lastly it sets the chrome as default browser for driver initialization
        context.browser = browserParam != null ? browserParam : System.getProperty("browser", "chrome");

        driver = DriverFactory.initializeDriver(context.browser);
        context.driver = driver;
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
