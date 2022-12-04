package cucumberPractice.types;

import cucumberPractice.objects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterTypes {

    @ParameterType("\"Blue Shoes\"|\"Anchor Bracelet\"")    // regexp:
    public Product product(String name) {                   // type, name (from method)
        return new Product(name);                           // transformer function
    }
}
