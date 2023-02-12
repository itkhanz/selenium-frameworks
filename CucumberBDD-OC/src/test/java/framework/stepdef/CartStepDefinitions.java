package framework.stepdef;

import framework.apis.CartApi;
import framework.context.TestContext;
import framework.domainObjects.Product;
import framework.pages.CartPage;
import framework.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefinitions {
    private final CartPage cartPage;
    private final TestContext context;

    public CartStepDefinitions(TestContext context){
        this.context = context;
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

    @And("I have {int} {product} in the cart")
    public void iHaveInTheCart(int quantity, Product product) throws Exception {
//        storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        product = context.productList.getProductByName(product.getName());
        cartApi.addToCart(product.getId(), quantity);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
        context.product = product;
    }
}
