package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/greenKart.feature",
                 glue = "stepDefinitions",
                 monochrome = true
)
public class GreenKartRunner extends AbstractTestNGCucumberTests {
}
