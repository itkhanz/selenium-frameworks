package framework.stepdef;

import framework.context.TestContext;
import framework.domainObjects.Product;
import framework.pages.CartPage;
import framework.pages.PageFactoryManager;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefinitions {
    private final CartPage cartPage;

    public CartStepDefinitions(TestContext context){
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    /*@And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        cartPage.checkout();
    }*/

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getProductQuantity(), quantity);
    }
}
