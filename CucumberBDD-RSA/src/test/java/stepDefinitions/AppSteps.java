package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppSteps {
    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        System.out.println("user is on landing  page");
    }

    @When("user enters the {string} and {string}")
    public void userEntersTheAnd(String username, String password) {
        System.out.println("user enters the credentials: " + username + " " +  password);
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        System.out.println("user clicks on the login button");
    }

    @Then("landing page is opened")
    public void landingPageIsOpened() {
        System.out.println("landing  page is opened");
    }
}
