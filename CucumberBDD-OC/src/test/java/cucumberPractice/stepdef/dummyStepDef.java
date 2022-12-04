package cucumberPractice.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dummyStepDef {
    @Given("I am dummy")
    public void i_am_dummy() {
        System.out.println("I am dummy");
    }
    @When("I do dummy things")
    public void i_do_dummy_things() {
        System.out.println("I do dummy things");
    }
    @Then("dummy things happen")
    public void dummy_things_happen() {
        System.out.println("dummy things happen");
    }
}
