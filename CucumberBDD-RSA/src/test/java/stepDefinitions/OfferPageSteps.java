package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
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
        testContext.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> handles = testContext.driver.getWindowHandles();
        Iterator <String> handlesIterator = handles.iterator();
        String parentWindow = handlesIterator.next();
        String childWindow = handlesIterator.next();
        testContext.driver.switchTo().window(childWindow);
        testContext.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = testContext.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("product name in offers page matches with Landing Page")
    public void productNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName, testContext.landingPageProductName);
        testContext.driver.quit();
    }

}
