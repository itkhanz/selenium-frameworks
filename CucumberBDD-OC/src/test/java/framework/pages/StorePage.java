package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;

public class StorePage extends BasePage{
    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        //it could happen that the “ quotes are not recognised by the IntelliJ jUnit Test Runner
        //To resolve this issue, the raw String could be concerted to UTF-8 encoded string.
        //First the raw string has to be converted to bytes, and then we can create a new UTF-8 encoded string and pass it to our method
        String raw = "a[aria-label='Add “" + productName + "” to your cart']";
        byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
        String utf8Encoded = new String(bytes, StandardCharsets.UTF_8);

        By addToCartBtn = By.cssSelector(utf8Encoded);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
