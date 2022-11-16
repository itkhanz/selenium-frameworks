package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage extends PageObjectManager{
    public WebDriver driver;

    public OffersPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("tr td:nth-child(1)");


    public void searchItem(String name)
    {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public String getPageUrl()
    {
        return driver.getCurrentUrl();
    }
}
