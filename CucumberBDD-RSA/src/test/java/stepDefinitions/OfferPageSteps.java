package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.io.IOException;

public class OfferPageSteps {

    public String offerPageProductName;

    TestContextSetup testContext;
    OffersPage offersPage;
    LandingPage landingPage;

    public OfferPageSteps(TestContextSetup testContextSetup) {
        this.testContext = testContextSetup;
        this.landingPage = testContext.pageObjectManager.getLandingPage();
        this.offersPage = testContext.pageObjectManager.getOffersPage();
    }

    @And("user searched for shortname {string} in offers page")
    public void userSearchedForShortnameNameInOffersPage(String shortName) throws InterruptedException {
        switchToOffersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
    }

    @Then("product name in offers page matches with Landing Page")
    public void productNameInOffersPageMatchesWithLandingPage() throws IOException {
        Assert.assertEquals(offerPageProductName, testContext.landingPageProductName);
    }

    public void switchToOffersPage() {
        //skip switching to offers page, if already on the offer page
        if (offersPage.getPageUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) return;
        landingPage.selectTopDealsPage();
        testContext.genericUtils.SwitchWindowToChild();
    }

}
