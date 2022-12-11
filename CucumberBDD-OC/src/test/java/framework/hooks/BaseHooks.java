package framework.hooks;

import framework.context.TestContext;
import framework.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseHooks {
    private WebDriver driver;
    private final TestContext context;

    public BaseHooks(TestContext testContext) {
        this.context = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
        driver.quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException
    {
        if(scenario.isFailed())
        {
            //screenshot
            File sourcePath= 	((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
