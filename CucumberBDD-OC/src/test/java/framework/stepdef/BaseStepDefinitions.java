package framework.stepdef;

import framework.domainObjects.BillingDetails;
import framework.domainObjects.Product;
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

public class BaseStepDefinitions {
    private WebDriver driver;
    private BillingDetails billingDetails;

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("/store/");
    }
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        new StorePage(driver).addToCart(product.getName());
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getProductQuantity(), quantity);
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("/store");
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
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
    public void iProvideBillingDetails() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDetails);
        /*checkoutPage.setBillingDetails(
                billingFirstName,
                billingLastName,
                billingAddressOne,
                billingCity,
                billingStateName,
                billingZip,
                billingEmail
        );*/
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
