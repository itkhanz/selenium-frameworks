package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
    public WebDriver driver;
    public TestBase testBase;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;

    public String landingPageProductName;

    public TestContextSetup() {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
