package framework.pages;

import framework.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    /**
     * To get around with the exception in Firefox, when clicking on a place order button, then we can call  this method
     * Element <button id="place_order" class="button alt" name="woocommerce_checkout_place_order" type="submit"> is not clickable at point (1034,468)
     * because another element <div class="blockUI blockOverlay"> obscures it
     * @param overlay
     */
    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if(overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        } else{
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }
}
