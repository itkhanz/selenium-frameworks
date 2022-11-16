package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageSteps {

    public String offerPageProductName;

    TestContextSetup testContext;

    public OfferPageSteps(TestContextSetup testContextSetup) {
        this.testContext = testContextSetup;
    }

    @And("user searched for shortname {string} in offers page")
    public void userSearchedForShortnameNameInOffersPage(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = new OffersPage(testContext.driver);
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
    }

    @Then("product name in offers page matches with Landing Page")
    public void productNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName, testContext.landingPageProductName);
        testContext.driver.quit();
    }

    public void switchToOffersPage() {
        //skip switching to offers page, if already on the offer page
        //if (testContext.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) return;
        LandingPage landingPage = new LandingPage(testContext.driver);
        landingPage.selectTopDealsPage();
        Set<String> handles = testContext.driver.getWindowHandles();
        Iterator<String> handlesIterator = handles.iterator();
        String parentWindow = handlesIterator.next();
        String childWindow = handlesIterator.next();
        testContext.driver.switchTo().window(childWindow);
    }

}
