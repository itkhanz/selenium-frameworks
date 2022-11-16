package utils;

import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public TestBase testBase;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;

    public String landingPageProductName;

    public Integer checkoutPageProductQuantity;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
