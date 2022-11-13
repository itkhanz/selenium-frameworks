package itkhan.cucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import itkhan.TestComponents.BaseTest;
import itkhan.pageobjects.*;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException
    {
        landingPage = launchApplication();
    }

    // If a step contains data from the Examples, then the parameters can be written as regex with starting ^ and ending $
    @Given("^Logged in with username (.+) and password (.+)$")
    public void loggedInWithUsernameNameAndPasswordPassword(String username, String password) {
        productCatalogue = landingPage.loginApplication(username,password);
    }

    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException
    {
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName)
    {
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    //if a step contains the parameter directly, then we can write it as {string}, regex will only work with data from Examples
    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {

        Assert.assertEquals(strArg1, landingPage.getErrorMessage());
        driver.close();
    }
}
