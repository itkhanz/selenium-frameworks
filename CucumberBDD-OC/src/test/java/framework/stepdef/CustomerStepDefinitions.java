package framework.stepdef;

import framework.constants.BaseConstants;
import framework.context.TestContext;
import framework.domainObjects.BillingDetails;
import framework.pages.PageFactoryManager;
import framework.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CustomerStepDefinitions {
    private final TestContext context;
    private final StorePage storePage;

    public CustomerStepDefinitions(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        storePage.load(BaseConstants.STORE);
    }
}
