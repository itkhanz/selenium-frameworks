package itkhan.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/itkhan/cucumber/features",
        glue = "itkhan.cucumber.stepDefinitions",
        monochrome=true, tags = "@Regression", plugin= {"html:target/cucumber.html"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
