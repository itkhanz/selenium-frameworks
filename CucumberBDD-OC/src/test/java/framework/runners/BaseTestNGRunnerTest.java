package framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/framework/features",
        glue = {"framework"}
)
public class BaseTestNGRunnerTest extends AbstractTestNGCucumberTests {

}
