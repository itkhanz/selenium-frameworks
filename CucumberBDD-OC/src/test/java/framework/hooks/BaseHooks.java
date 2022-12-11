package framework.hooks;

import framework.context.TestContext;
import framework.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

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
}
