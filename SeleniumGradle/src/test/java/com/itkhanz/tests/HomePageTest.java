package com.itkhanz.tests;

import com.itkhanz.pages.LoginPage;
import com.itkhanz.utils.json.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    @Test(groups = { "smoke", "regression" })
    public void unsuccessfulLogin_with_invalid_credentials_Test() {
        loginPage = new LoginPage(driver);
        loginPage.login(FakerUtils.getEmail(), FakerUtils.getPassword());
        Assert.assertTrue(loginPage.getAlertText().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @Test(groups = { "smoke", "regression" })
    public void successful_Login_with_valid_credentials_Test() {
        homePage = performLogin();
        Assert.assertTrue(homePage.isLogoutDisplayed());
    }

    @Test(groups = { "regression" })
    public void homePage_searchExist_Test() {
        homePage = performLogin();
        Assert.assertTrue(homePage.isSearchFieldDisplayed());
    }
}
