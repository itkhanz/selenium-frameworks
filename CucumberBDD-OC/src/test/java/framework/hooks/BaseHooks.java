package framework.hooks;

import framework.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class BaseHooks {
    private static WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
