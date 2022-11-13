package itkhan.tests;

import itkhan.TestComponents.BaseTest;
import itkhan.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(groups= {"Purchase"}, dataProvider = "getData")
    public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
        productCatalogue.addProductToCart(input.get("product"));

        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

    @Test(dependsOnMethods= {"submitOrder"})
    public void OrderHistoryTest()
    {
        //"ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
        OrderPage ordersPage = productCatalogue.goToOrdersPage();
        Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        /*return new Object[][] {
                {"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"},
                {"shetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}
        };*/

       /* HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("email", "anshika@gmail.com");
        map1.put("password", "Iamking@000");
        map1.put("product", "ZARA COAT 3");

    	HashMap<String,String> map2 = new HashMap<String,String>();
        map2.put("email", "shetty@gmail.com");
        map2.put("password", "Iamking@000");
        map2.put("product", "ADIDAS ORIGINAL");

        return new Object[][] { {map1}, {map2} };*/

        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//itkhan//data//purchaseOrder.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }
}
