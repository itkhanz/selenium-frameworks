package framework.apis;

import framework.constants.EndPoint;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

public class CartApi {
    private Cookies cookies;    //rest-assured cookies object

    public CartApi(Cookies cookies){
        this.cookies = cookies;     //Initially object of this class will be created with empty rest-assured cookies
    }

    /**
     *  these cookies will be set when an addToCart() method is called, see the method below
     *  we will call this method to set the cookies to our Cookies' domain object, which will then inject these cookies to the browser.
     * @return the rest-assured cookies
     */
    public Cookies getCookies(){
        return cookies;
    }

    /**
     * This method will add the product the cart by making an API call. It initializes the header, form parameters, and the endpoint to hit before making POST api call.
     * In response, we are fetching all the cookies and setting it to the `Cookies` object.
     *
     * @param productId ID of the product to be added to cart
     * @param quantity quantity of the product to be added
     * @return response of the API call
     */
    public Response addToCart(int productId, int quantity){
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);

        //we will send the empty cookies because in our scenario, user is not logged in, otherwise we will need to send the login cookies
        Response response = ApiRequest.post(EndPoint.ADD_TO_CART.url, headers, formParams, cookies);
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to add product" + productId + " to the cart" +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
