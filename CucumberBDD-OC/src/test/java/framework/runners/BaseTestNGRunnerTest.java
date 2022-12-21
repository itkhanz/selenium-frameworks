package framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//Comment the @smoke tag in @CucumberOptions plugin to run all the scenarios

@CucumberOptions(
        features = "src/test/resources/framework/features",
        glue = {"framework"},
        monochrome=true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
        ,tags = "@smoke"
)
public class BaseTestNGRunnerTest extends AbstractTestNGCucumberTests {

    /*The default thread count of the dataprovider in parallel mode is 10.
    * To change this the dataproviderthreadcount property needs to be added to the configuration section of the Surefire plugin in the POM.
    * https://cucumber.io/docs/guides/parallel-execution/?lang=java#testng
    */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
