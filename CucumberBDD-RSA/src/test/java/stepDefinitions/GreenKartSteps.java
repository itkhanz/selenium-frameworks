package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartSteps {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    @Given("user is on GreenKart Landing page")
    public void userIsOnGreenKartLandingPage() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void userSearchedWithShortnameNameAndExtractedActualNameOfProduct(String shortName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from the  Home page");
    }

    @And("user searched for shortname {string} in offers page")
    public void userSearchedForShortnameNameInOffersPage(String shortName) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator <String> handlesIterator = handles.iterator();
        String parentWindow = handlesIterator.next();
        String childWindow = handlesIterator.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("product name in offers page matches with Landing Page")
    public void productNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName, landingPageProductName);
        driver.quit();
    }

}
