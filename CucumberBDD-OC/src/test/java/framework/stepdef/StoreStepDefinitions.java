package framework.stepdef;

import framework.apis.CartApi;
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

    @When("I add it again")
    public void iAddItAgain() {
        storePage.addToCart(context.product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());        //Initialize the CartAPI with empty rest assured cookies
        cartApi.addToCart(1215,1);          //make post API and save the response and set the received rest-assured cookies to cookies class variable in CartAPI
        context.cookies.setCookies(cartApi.getCookies());   //Fetch the cookies from CartAPI and set the TestContext Cookies domain object with it
        context.cookies.injectCookiesToBrowser(context.driver);     //injects selenium cookies to the browser. It calls the method from CookieUtils class to convert rest-assured cookies to the selenium cookies
    }
}
