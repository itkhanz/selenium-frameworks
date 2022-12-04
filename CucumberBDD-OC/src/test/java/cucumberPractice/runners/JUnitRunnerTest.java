/*package cucumberPractice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumberPractice",
        glue = {"cucumberPractice.stepdef", "cucumberPractice.hooks"},
        monochrome = true,
        dryRun = false,
        snippets = CAMELCASE,
        plugin = {"pretty", "html:target/cucumber.html", "summary"},
        tags = "@smoke and @dummy"
)
public class JUnitRunnerTest {
    @BeforeClass
    public static void setup() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("After Class");
    }
}*/
