package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/",
                 glue = "stepDefinitions",
                 monochrome = true,
                 tags = "@PlaceOrder or @SearchProduct",
                 plugin = {
                            "html:target/cucumber.html",
                            "json:target/cucumber.json",
                            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                 }
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    /****** Uncomment below section to run the scenarios in parallel ************/
    @Override
    @DataProvider(parallel=true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
