package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() {
        //create new webdriver only if driver is not initialized previously otherwise it creates a new driver each time method is called
        if (driver == null) {
            driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        }

        return driver;
    }

}
