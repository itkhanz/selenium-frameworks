package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/searchProduct.feature",
                 glue = "stepDefinitions",
                 monochrome = true
)
public class SearchProductRunner extends AbstractTestNGCucumberTests {

    /****** Uncomment below section to run the scenarios in parallel ************/
    @Override
    @DataProvider(parallel=true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
