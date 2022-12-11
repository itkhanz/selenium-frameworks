package framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/framework/features",
        glue = {"framework"},
        plugin = {"html:target/cucumber/cucumber.html"}
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
