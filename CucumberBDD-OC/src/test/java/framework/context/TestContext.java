package framework.context;

import framework.domainObjects.BillingDetails;
import framework.domainObjects.Cookies;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;

    public TestContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());  //assign the empty rest-assured Cookies to our domain object Cookies
    }
}
