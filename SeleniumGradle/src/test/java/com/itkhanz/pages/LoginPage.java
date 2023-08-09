package com.itkhanz.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "input-email")
    private WebElement usernameInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//img[@title='naveenopencart']")
    private WebElement logo;

    @FindBy(css = ".alert.alert-danger")
    private WebElement alert;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String username, String password) {
        logger.info("Performing login with username: {} and passsord: {}", username, password);
        type(usernameInput, username, String.format("Entering %s in username field", username));
        type(passwordInput, password, String.format("Entering %s in password field", password));
        click(loginBtn, "clicking on the login button");
        return new HomePage(driver);
    }

    public boolean isLogoDisplayed() {
        return checkForDisplay(logo, "Checking for display of logo on LoginPage");
    }

    public String getAlertText() {
        return getText(alert, "Retrieving text for alert on LoginPage");
    }
}
