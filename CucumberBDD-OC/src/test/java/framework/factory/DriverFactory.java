package framework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser){
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
