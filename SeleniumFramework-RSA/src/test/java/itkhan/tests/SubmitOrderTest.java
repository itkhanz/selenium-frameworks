package itkhan.tests;

import itkhan.TestComponents.BaseTest;
import itkhan.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(groups= {"Purchase"}, dataProvider = "getData")
    public void submitOrder(String email, String password, String productName) throws InterruptedException, IOException {

        ProductCatalogue productCatalogue = landingPage.loginApplication(email,password);
        productCatalogue.addProductToCart(productName);

        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
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
    public Object[][] getData() {
        return new Object[][] {
                {"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"},
                {"shetty@gmail.com", "Iamking@000", "ADIDAS ORIGINAL"}
        };
    }
}
