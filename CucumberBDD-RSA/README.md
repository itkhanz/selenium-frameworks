# Cucumber BDD Framework
### BDD, Cucumber, Selenium, Java, TestNG, Maven, Extent reports, Jenkins

### Installation Requirements
* JAVA JDK (version 17 used in project)
* Maven
* suitable IDE (IntelliJ used in project)
* Jenkins (only required for remote execution)

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
