package framework.stepdef;

import framework.context.TestContext;
import framework.domainObjects.Product;
import framework.pages.CartPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {
    private final WebDriver driver;

    public CartStepDefinitions(TestContext context){
        driver = context.driver;
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getProductQuantity(), quantity);
    }
}
