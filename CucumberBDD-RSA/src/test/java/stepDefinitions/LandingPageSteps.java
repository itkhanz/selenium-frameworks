package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
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
        testContext.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        testContext.landingPageProductName = testContext.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(testContext.landingPageProductName + " is extracted from the  Home page");
    }


}
