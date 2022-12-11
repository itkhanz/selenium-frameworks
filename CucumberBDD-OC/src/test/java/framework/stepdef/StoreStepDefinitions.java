package framework.stepdef;

import framework.constants.EndPoint;
import framework.context.TestContext;
import framework.domainObjects.Product;
import framework.pages.PageFactoryManager;
import framework.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
    private final StorePage storePage;
    private final TestContext context;

    public StoreStepDefinitions(TestContext context){
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        storePage.addToCart(product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        storePage.addToCart("Blue Shoes");
    }
}
