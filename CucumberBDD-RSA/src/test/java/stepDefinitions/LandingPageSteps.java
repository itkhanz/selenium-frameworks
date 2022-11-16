package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageSteps {

    TestContextSetup testContext;
    LandingPage landingPage;

    public LandingPageSteps(TestContextSetup testContextSetup) {
        this.testContext = testContextSetup;
        this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("user is on GreenKart Landing page")
    public void userIsOnGreenKartLandingPage() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^user searched with shortname (.+) and extracted actual name of product$")
    public void userSearchedWithShortnameNameAndExtractedActualNameOfProduct(String shortName) throws InterruptedException, IOException {
        //Not a good approach to create objects of page classes, rather we use a wrapper via page factory design pattern
        //LandingPage landingPage = new LandingPage(testContext.driver);
        //pageObjectManager = new PageObjectManager(testContext.driver);
        //LandingPage landingPage = pageObjectManager.getLandingPage();

        //search for the product, wait until products list is shortened to single result and grab the text of first result
        landingPage.searchItem(shortName);
        testContext.pageObjectManager.waitForNumberOfElementsToBeOne(landingPage.getProductsLocator());
        testContext.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
    }

    @When("Added {string} items of the selected product to cart")
    public void Added_items_product(String quantity)
    {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
        testContext.checkoutPageProductQuantity = Integer.parseInt(quantity);
    }


}
