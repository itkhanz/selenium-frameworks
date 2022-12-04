package cucumberPractice.stepdef;

import cucumberPractice.objects.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addToCart_Steps {

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am on Store Page");
    }
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Product Name: " + product.getName());
    }

    @When("I add it again")
    public void i_add_it_again() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer int1, Product product) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Product Name: " + product.getName());
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
