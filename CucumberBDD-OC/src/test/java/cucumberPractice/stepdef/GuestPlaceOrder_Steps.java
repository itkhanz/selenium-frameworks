package cucumberPractice.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class GuestPlaceOrder_Steps {

    private static WebDriver driver;
    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        //we can keep this empty because we do not have to create or login to website with account since this is a guest checkout
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        String productName = "Blue Shoes";
        String addToCartBtnLocator = "a[aria-label='Add “" + productName + "” to your cart']";
        By addToCartBtn = By.cssSelector(addToCartBtnLocator);
        driver.findElement(addToCartBtn).click();   //Click on Add to Cart Button
        By viewCartLink = By.cssSelector("a[title='View cart']");
        driver.findElement(viewCartLink).click();       //Click on view Cart Button -> navigates to the cart
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        By proceedToCheckoutBtn = By.cssSelector(".checkout-button");
        driver.findElement(proceedToCheckoutBtn).click();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> billingDetails) {
        By billingFirstnameFId = By.id("billing_first_name");
        By billingLastnameFId = By.id("billing_last_name");
        By billingAddressOneFId = By.id("billing_address_1");
        By billingCityFId = By.id("billing_city");
        By billingStateDropdownFId = By.id("billing_state");
        By billingZipFId = By.id("billing_postcode");
        By billingEmailFId = By.id("billing_email");

        WebElement firstName = driver.findElement(billingFirstnameFId);
        WebElement lastName = driver.findElement(billingLastnameFId);
        WebElement address1 = driver.findElement(billingAddressOneFId);
        WebElement city = driver.findElement(billingCityFId);
        WebElement state_dropdown = driver.findElement(billingStateDropdownFId);
        WebElement zip = driver.findElement(billingZipFId);
        WebElement email = driver.findElement(billingEmailFId);

        Map<String, String> user = billingDetails.get(0);

        firstName.clear(); firstName.sendKeys(user.get("firstname"));
        lastName.clear(); lastName.sendKeys(user.get("lastname"));
        address1.clear(); address1.sendKeys(user.get("address_line1"));
        city.clear(); city.sendKeys(user.get("city"));
        Select state_select = new Select(state_dropdown); state_select.selectByVisibleText(user.get("state"));
        zip.clear(); zip.sendKeys(user.get("zip"));
        email.clear(); email.sendKeys(user.get("email"));
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        By placeOrderBtn = By.id("place_order");
        driver.findElement(placeOrderBtn).click();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        By noticeTxt = By.cssSelector(".woocommerce-notice");
        String actualNoticeMsg = driver.findElement(noticeTxt).getText();
        Assert.assertEquals(actualNoticeMsg, "Thank you. Your order has been received.");
        if (driver != null) driver.quit();
    }
}
