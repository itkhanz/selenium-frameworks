package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageSteps {

    TestContextSetup testContext;

    public LandingPageSteps(TestContextSetup testContextSetup) {
        this.testContext = testContextSetup;
    }

    @Given("user is on GreenKart Landing page")
    public void userIsOnGreenKartLandingPage() {
        testContext.driver = new ChromeDriver();
        testContext.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void userSearchedWithShortnameNameAndExtractedActualNameOfProduct(String shortName) throws InterruptedException {
        LandingPage landingPage = new LandingPage(testContext.driver);
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContext.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContext.landingPageProductName +" is extracted from Home page");
    }


}
