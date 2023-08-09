package com.itkhanz.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.itkhanz.config.ConfigurationManager.configuration;

public class DriverFactory extends DriverManager{
    protected DriverFactory(String browser) {
        WebDriver driver;
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(configuration().url());

        DriverManager.setDriver(driver);

    }
}
