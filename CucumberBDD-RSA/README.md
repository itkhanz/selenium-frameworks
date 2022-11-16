# Cucumber BDD Framework
### BDD, Cucumber, Selenium, Java, TestNG, Maven, Extent reports, Jenkins

### Installation Requirements
* JAVA JDK (version 17 used in project)
* Maven
* suitable IDE (IntelliJ used in project)
* Jenkins (only required for remote execution)

### Key Concepts covered
* Build `Maven` Project with all the framework dependencies
* Develop `End-to-End` Selenium web scenarios in the feature file
* Implement `TestNG / JUnit runner` to run the framework
* Understand the `Single responsibility` principle to distribute the implementation into multiple step definitions
* Importance of dependency injection to share the data between steps files
* Understand the `Page Object` design pattern to drive locators from the pages
* Implement `Factory desig`n pattern by writing PageObjectManager class to create objects of all PO classes
* Configure and `Distribute the driver` across files in framework
* Run the Cucumber scenarios in Parallel mode using Cucumber TestNG Runner
* Build Test Utilities for `reusable` Selenium methods
* Implement `Cucumber Hooks` to capture Screenshots on test failures
* Implement `Cucumber Tags` to run selected tests in the framework
* Parameterizing the test data to run the Scenarios with multiple data sets
* Creating HTML & `Extent reports` to run the Cucumber Selenium tests
* Running tests in `parallel` mode and generate Extent reports with `Screenshot` attached for the failed scenarios
* Run the Cucumber tests using Maven and Command line options
* Integrate the framework to `CI/CD Jenkins` and schedule the Jobs on regular time interval
* Create `parameterized Jenkins jobs` to dynamically send the global properties at run time of job execution


### Notes
* Check if Cucumber for Java and Gherkin plugins are installed and enabled.
* \src\main\resources is marked as `Test Resources Root`
* \src\main\resources contains the `feature files`
* \src\main\java is marked as `Test Sources Root`
* \src\main\java contain the package `step_definitions`
* The test runner class should contain the package `step_definitions` as `glue`
* Configure the `maven surefire plugin` and `testng.xml` in pom.xml to run tests with `mvn test`
* Individual steps results are only supported by JUnit test runner and not by TestNG
* [Intellij Cucumber support documentation](https://www.jetbrains.com/help/idea/cucumber-support.html)
* 
