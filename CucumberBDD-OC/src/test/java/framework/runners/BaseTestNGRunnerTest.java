package framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//Comment the @smoke tag in @CucumberOptions plugin to run all the scenarios

@CucumberOptions(
        features = "src/test/resources/framework/features",
        glue = {"framework"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "timeline:target/test-output-thread",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed_scenarios.txt"
        }
        , tags = "@smoke"
)
public class BaseTestNGRunnerTest extends AbstractTestNGCucumberTests {


    //Instead of hardcoding, annotation transformer listener is implemented that will run the scenarios in parallel or sequentially based on CLI argument -DscenariosInParallel
    /*The default thread count of the data provider in parallel mode is 10.
     * To change this the dataproviderthreadcount property needs to be added to the configuration section of the Surefire plugin in the POM.
     * https://cucumber.io/docs/guides/parallel-execution/?lang=java#testng
     */
    /*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
    public static String browser;

    //@Parameters and @Optional annotations in TestNG
    //In this annotation, if the defined parameter is not found in the testng.xml file, Then Test method will receive the default value from the @Optional annotation.
    //Below method will help to read the browser parameter at run time to run the tests on-demand on any browser for regression test-suite
    @Parameters("browser")
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browser) {
        if (browser != null) {
            BaseTestNGRunnerTest.browser = browser;
        }
    }

}
