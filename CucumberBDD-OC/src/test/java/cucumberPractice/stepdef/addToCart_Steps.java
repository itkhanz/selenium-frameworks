package cucumberPractice.stepdef;

import cucumberPractice.objects.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class addToCart_Steps {

    public WebDriver driver;

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("I am on Store Page");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("Product Name: " + product.getName());
        String productName = product.getName().replace("\"", "");
        String addToCartBtnLocator = "a[aria-label='Add “" + productName + "” to your cart']";
        By addToCartBtn = By.cssSelector(addToCartBtnLocator);
        driver.findElement(addToCartBtn).click();   //Click on Add to Cart Button
        By viewCartLink = By.cssSelector("a[title='View cart']");
        driver.findElement(viewCartLink).click();       //Click on view Cart Button -> navigates to the cart
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, Product product) {
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("Product Name: " + product.getName());
        String productName = product.getName().replace("\"", "");
        String productQuantity = String.valueOf(quantity);
        By productNameFId = By.cssSelector("td[class='product-name']");
        String actualProductName = driver.findElement(productNameFId).getText();
        By productQuantityFId = By.xpath("//td[@class='product-quantity']//input[@type='number']");
        String actualQuantity = driver.findElement(productQuantityFId).getAttribute("value");
        Assert.assertEquals(actualProductName, productName);
        Assert.assertEquals(actualQuantity, productQuantity);
        if (driver != null) driver.quit();
    }

    @When("I add it again")
    public void i_add_it_again() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I'm browsing {string}")
    public void i_m_browsing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I add {int} quantity to the cart")
    public void i_add_quantity_to_the_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I have {int} {string} in the cart")
    public void i_have_in_the_cart(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I add {int} quantity")
    public void i_add_quantity(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see an error")
    public void i_should_see_an_error() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the selected quantity is {int}")
    public void the_selected_quantity_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I use down arrow to change the quantity")
    public void i_use_down_arrow_to_change_the_quantity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I use up arrow to change the quantity")
    public void i_use_up_arrow_to_change_the_quantity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the selected quantity changes to {int}")
    public void the_selected_quantity_changes_to(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
