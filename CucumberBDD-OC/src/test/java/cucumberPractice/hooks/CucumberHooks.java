package cucumberPractice.hooks;

import io.cucumber.java.*;

public class CucumberHooks {
    @BeforeAll
    public static void setup() {
        System.out.println("BEFORE ALL gets execute before any scenario is executed");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("AFTER ALL gets executed after all the scenarios have been executed");
    }

    @Before
    public void before(Scenario scenario){
        System.out.println("BEFORE HOOK will execute before each scenario");
        System.out.println("SCENARIO NAME = " + scenario.getName());
        System.out.println("SCENARIO LINE = " + scenario.getLine());
        System.out.println("SCENARIO TAGS = " + scenario.getSourceTagNames());
        System.out.println("SCENARIO STATUS = " + scenario.getStatus());
        System.out.println("SCENARIO URI = " + scenario.getUri());
        System.out.println("SCENARIO isFailed = " + scenario.isFailed() + "\n");
    }
    @After
    public void after() {
        System.out.println("AFTER HOOK will execute after each scenario");
    }

    @After (order = 0)
    public void after0() {
        System.out.println("AFTER HOOK order 0");
    }

    @After (order = 1)
    public void after1() {
        System.out.println("AFTER HOOK order 1");
    }

    @After("@smoke and not @dummy")
    public void afterSmoke() {
        System.out.println("this AFTER HOOK will only execute after scenarios tagged as @smoke and not as @dummy");
    }

    @After("@dummy")
    public void afterDummy() {
        System.out.println("this AFTER HOOK will only execute after scenarios tagged as @dummy");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("BEFORE STEP will execute before every step");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("AFTER HOOK will execute after every step");
    }
}
