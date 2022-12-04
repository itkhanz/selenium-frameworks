package cucumberPractice.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "src/test/resources/cucumberPractice",
        glue = {"cucumberPractice.stepdef", "cucumberPractice.hooks", "cucumberPractice.types"},
        monochrome = true,
        dryRun = false,
        snippets = CAMELCASE,
        plugin = {"pretty", "html:target/cucumber.html", "summary"},
        tags = "@smoke and not @dummy"
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
    //Use either TestNG @BeforeClass @AfterClass or Cucumber @BeforeAll @AfterAll, both run after each of the cucumber scenario.
    /*@BeforeClass
    public static void setup() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("After Class");
    }*/

}
