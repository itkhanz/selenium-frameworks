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
* Folder Structure
  * \src\main\resources is marked as `Test Resources Root`
  * \src\main\resources contains the `feature files`
  * \src\main\java is marked as `Test Sources Root`
  * \src\main\java contain the package `step_definitions`
  * The test runner class should contain the package `step_definitions` as `glue`
* Configure the `maven surefire plugin` and `testng.xml` in pom.xml to run tests with `mvn test`
* Individual steps results are only supported by JUnit test runner and not by TestNG
* [Intellij Cucumber support documentation](https://www.jetbrains.com/help/idea/cucumber-support.html)
* Dependency injection (DI)
  * `Dependency injection (DI)` is one of the design patterns and implementations of the IoC. DI takes the dependent object creation outside of the class and provides required objects in different ways.
  * There are many DI types that you can use, such as Constructor Injection, Property Injection, and Method Injection.
  * In `constructor injection`, the injector provides the required dependency through the constructor. Some third-party tools would help you to implement DI on a constructor. 
  * `Cucumber Picocontainer` is a third-party framework for providing required dependencies in your classes. This framework will make your classes loosely coupled and take all responsibility for injecting required dependencies.
  * you are only responsible for creating constructors and reference names. The rest of the responsibility for providing objects to your class belongs to third-party dependency, Cucumber Picocontainer.
  * After implementation, you are only responsible for creating the constructor and defining what you need in the class. Picocontainer becomes the main responsible for the rest of the assigning and injection.
  * Cucumber scans your classes with step definitions in them, passes them to PicoContainer, then asks it to create new instances for every scenario.
  * Further Reading:
    * [Implementing Dependency Injection with Java-Selenium-Cucumber](https://www.kloia.com/blog/implementing-dependency-injection-with-java-selenium-cucumber)
    * [Dependency injection in Cucumber](https://www.numpyninja.com/post/dependency-injection-in-cucumber)
    * [SHARING STATE BETWEEN CUCUMBER STEPS WITH DEPENDENCY INJECTION](https://angiejones.tech/sharing-state-between-steps-in-cucumber-with-dependency-injection/)
    * [Cucumber Pico-Container Use In Automation](https://medium.com/@jitendra.pisal44/cucumber-pico-container-use-in-automation-79c597d0ef04)
    * [Share WebDriver instance in Cucumber using PicoContainer](https://www.programsbuzz.com/article/share-webdriver-instance-cucumber-using-picocontainer)
    * [Sharing Test Context between Cucumber Step Definitions](https://www.toolsqa.com/selenium-cucumber-framework/sharing-test-context-between-cucumber-step-definitions/)
* Each of the step definitions class should contain the steps for that particular application logic and classes should be loosely coupled.
* 