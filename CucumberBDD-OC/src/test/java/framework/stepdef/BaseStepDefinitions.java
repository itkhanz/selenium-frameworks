package framework.stepdef;

import framework.context.TestContext;
import org.openqa.selenium.WebDriver;

public class BaseStepDefinitions {
    private final WebDriver driver;

    public BaseStepDefinitions(TestContext context) {
        driver = context.driver;
    }

}
