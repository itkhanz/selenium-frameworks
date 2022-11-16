package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectManager {

    public LandingPage landingPage;
    public OffersPage offersPage;
    public CheckoutPage checkoutPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToClickable(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void waitForNumberOfElementsToBeOne(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(findBy, 1));
    }

    public LandingPage getLandingPage()
    {
        landingPage= new LandingPage(driver);
        return landingPage;
    }

    public OffersPage getOffersPage()
    {
        offersPage = new OffersPage(driver);
        return offersPage;
    }

    public CheckoutPage getCheckoutPage()
    {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }

}

