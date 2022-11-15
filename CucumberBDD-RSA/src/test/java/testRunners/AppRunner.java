package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/resources/features/App.feature",
        glue = "stepDefinitions",
        tags = "@Example",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"
        }
)
public class AppRunner extends AbstractTestNGCucumberTests {
}
