package framework.stepdef;

import framework.constants.BaseConstants;
import framework.context.TestContext;
import framework.domainObjects.BillingDetails;
import framework.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinitions {
    private final WebDriver driver;
    private final TestContext context;

    public CustomerStepDefinitions(TestContext context) {
        this.context = context;
        driver = context.driver;
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        new StorePage(driver).load(BaseConstants.STORE);
    }
}
