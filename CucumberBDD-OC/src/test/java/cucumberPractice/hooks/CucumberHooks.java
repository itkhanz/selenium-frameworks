package cucumberPractice.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class CucumberHooks {
    @BeforeAll
    public static void setup() {
        System.out.println("Before ALL");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After ALL");
    }
}
