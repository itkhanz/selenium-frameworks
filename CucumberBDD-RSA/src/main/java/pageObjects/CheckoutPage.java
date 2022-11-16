package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage{
    public WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private By cartBag = By.cssSelector("[alt='Cart']");
    private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoBtn = By.cssSelector(".promoBtn");
    private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
    private By productName = By.xpath("//p[@class='product-name']");
    private By productQuantity = By.xpath("//td//p[@class='quantity']");

    private By productCart = By.xpath("//table[@id='productCartTables']");

    public void CheckoutItems()
    {
        driver.findElement(cartBag).click();
        driver.findElement(checkOutButton).click();
    }

    public Boolean VerifyPromoBtn()
    {
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean VerifyPlaceOrder()
    {
        return driver.findElement(placeOrder).isDisplayed();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public Integer getProductQuantity() {
        return Integer.parseInt(driver.findElement(productQuantity).getText());
    }
}
