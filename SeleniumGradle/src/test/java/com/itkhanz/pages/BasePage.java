package com.itkhanz.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.itkhanz.constants.GlobalConstants.WAIT_DURATION;

public class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver dr) {
        this.driver = dr;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
    }

    // Wait until the element is both visible and clickable
    private boolean isIntractable(WebElement element) {
        return wait.until(ExpectedConditions.and(                          //An expectation with the logical and condition of the given list of conditions.
                ExpectedConditions.visibilityOf(element),           //An expectation for checking that an element, known to be present on the DOM of a page, is visible.
                ExpectedConditions.elementToBeClickable(element)    //An expectation for checking an element is visible and enabled such that you can click it.
        ));
    }

    protected void click(WebElement element) {
        logger.info("Clicking on element {}", element);
        if (isIntractable(element)) element.click();
    }

    protected void type(WebElement element, String text) {
        logger.info("Entering text {} in element {}", text, element);
        if (isIntractable(element)) element.sendKeys(text);
    };

    protected boolean checkForDisplay(WebElement element) {
        logger.info("Verifying the display of element: {}", element);
        return element.isDisplayed();
    }


    //Overloading the driver action methods to include user-friendly log message
    //Reason is there is no straightforward way to get the name of WebElement in java
    //TODO refactor the actions to capture the name of WebElement variable via extending the interface or custom name annotation

    protected void click(WebElement element, String msg) {
        logger.info(msg);
        if (isIntractable(element)) element.click();
    }

    protected void type(WebElement element, String text, String msg) {
        logger.info(msg);
        if (isIntractable(element)) element.sendKeys(text);
    };

    protected boolean checkForDisplay(WebElement element, String msg) {
        logger.info(msg);
        return element.isDisplayed();
    }

    protected String getAttribute(WebElement element, String attribute, String msg) {
        logger.info(msg);
        String elementAttribute = element.getAttribute(attribute);
        logger.info("Retrieved attribute value is {}", elementAttribute);
        return elementAttribute;
    }

    protected String getText(WebElement element, String msg) {
        String elementText = element.getText().trim();
        logger.info("{} -- Retrieved text is {}",msg, elementText);
        return elementText;
    }


}
