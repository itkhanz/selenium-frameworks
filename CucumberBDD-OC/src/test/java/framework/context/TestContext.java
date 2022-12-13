package framework.context;

import framework.domainObjects.BillingDetails;
import framework.domainObjects.Cookies;
import framework.domainObjects.Product;
import framework.domainObjects.ProductList;
import framework.utils.JacksonUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;
    public ProductList productList = new ProductList();
    public Product product;

    public TestContext() throws IOException {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());  //assign the empty rest-assured Cookies to our domain object Cookies
        String filename = System.getProperty("user.dir") + "\\src\\test\\resources\\framework\\test-data\\products.json";
        productList.addAllProducts(JacksonUtils.deserializeJson(filename, Product[].class));
        //productList.addAllProducts(JacksonUtils.deserializeJson("products.json", Product[].class));
    }
}
