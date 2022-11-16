package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

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
    public void userSearchedWithShortnameNameAndExtractedActualNameOfProduct(String shortName) throws InterruptedException {
        //Not a good approach to create objects of page classes, rather we use a wrapper via page factory design pattern
        //LandingPage landingPage = new LandingPage(testContext.driver);
        //pageObjectManager = new PageObjectManager(testContext.driver);
        //LandingPage landingPage = pageObjectManager.getLandingPage();

        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContext.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        //System.out.println(testContext.landingPageProductName +" is extracted from Home page");
    }

    @When("Added {string} items of the selected product to cart")
    public void Added_items_product(String quantity)
    {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
        testContext.checkoutPageProductQuantity = Integer.parseInt(quantity);
    }


}
