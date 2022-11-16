package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/searchProduct.feature",
                 glue = "stepDefinitions",
                 monochrome = true
)
public class SearchProductRunner extends AbstractTestNGCucumberTests {
}
