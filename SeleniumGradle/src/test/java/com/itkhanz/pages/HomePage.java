package com.itkhanz.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(linkText = "Logout")
    private WebElement logoutBtn;

    @FindBy(name = "search")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoutDisplayed() {
        return checkForDisplay(logoutBtn, "Checking for display of Logout on HomePage");
    }

    public boolean isSearchFieldDisplayed() {
        return checkForDisplay(searchField, "Checking for display of searchField on HomePage");
    }
}
