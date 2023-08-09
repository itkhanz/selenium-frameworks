package com.itkhanz.tests;

import com.itkhanz.pages.BasePage;
import com.itkhanz.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @Test
    public void loginPage_title_Test() {
        Assert.assertEquals(driver.getTitle(), "Account Login");
    }

    @Test
    public void loginPage_logo_Test() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLogoDisplayed());
    }
}
