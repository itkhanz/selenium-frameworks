package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageSteps {
    public CheckoutPage checkoutPage;
    TestContextSetup testContext;

    public CheckoutPageSteps(TestContextSetup testContextSetup)
    {
        this.testContext=testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_productName_in_checkout_page(String productName) throws InterruptedException
    {
        checkoutPage.CheckoutItems();
        Thread.sleep(2000);
        //Assertion to extract name from screen and compare with name
        String checkoutProduct = checkoutPage.getProductName().split("-")[0].trim();
        Assert.assertEquals(checkoutProduct, productName);
        Assert.assertEquals(checkoutPage.getProductQuantity(), testContext.checkoutPageProductQuantity);
    }

    @Then("verify user has ability to enter promo code and place the order")
    public void  verify_user_has_ability_enter_promo()
    {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }
}
