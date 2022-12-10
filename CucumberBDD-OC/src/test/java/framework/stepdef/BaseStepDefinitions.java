package framework.stepdef;

import framework.factory.DriverFactory;
import framework.pages.CartPage;
import framework.pages.CheckoutPage;
import framework.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class BaseStepDefinitions {
    private WebDriver driver;

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store/");
    }
    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String productName) {
        new StorePage(driver).addToCart(productName);
    }

    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int quantity, String productName) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductName(), productName);
        Assert.assertEquals(cartPage.getProductQuantity(), quantity);
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store/");
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        new StorePage(driver).addToCart("Blue Shoes");
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        new CartPage(driver).checkout();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> billingDetails) {
        Map<String, String> billingDetail = billingDetails.get(0);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(
                billingDetail.get("firstname"),
                billingDetail.get("lastname"),
                billingDetail.get("address_line1"),
                billingDetail.get("city"),
                billingDetail.get("state"),
                billingDetail.get("zip"),
                billingDetail.get("email")
        );
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals(new CheckoutPage(driver).getNotice(), "Thank you. Your order has been received.");
    }

}
