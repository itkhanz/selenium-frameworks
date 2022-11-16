package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public String landingPageProductName;

    public TestContextSetup() {
        pageObjectManager = new PageObjectManager(driver);
    }
}
