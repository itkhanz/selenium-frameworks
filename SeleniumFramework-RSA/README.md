# Selenium Framework 
### TestNG, Page Objects, Maven, Jenkins, Datadriven, Cucumber, Extent reports
> This project was done as part of the Selenium WebDriver with Java -Basics to Advanced+Frameworks course by Rahul Shetty.

Key concepts implemented in this project include:

* Why Framework? Its advantages
* created **MAVEN** structured frameowrk with all necessary automation dependencies
* created an End-to-End e-commerce application automation scenario
* Implemented **Page Object Model** design pattern to drive the locators from respective classes
* Drive object creation within Page object classes **encapsulating** it from Tests
* create Base Test which sets browser configuration details and **Global Properties**
* Decide the **Test Strategy** with clubbing and distribution of tests with annotations
* create **TestNG runner** file to trigger the tests with single point of execution control
* **Grouping in TestNG.xml** to categorize the tests with different tags of execution
* Implemented **Data driven testing & Parameterization** using TestNG Data provider HashMap & Json File readers
* Implemented **TestNG Listener**s to capture **screenshot** on automatic test failures and logging
* create **Extent report** wrapper to generate HTML reports for the application
* Incorporated changes to support **parallel execution** with **Thread safe mechanism**
* Implemented TestNG **retry mechanism** to rerun the failed flaky tests in the application
* Run the Framework tests with Maven commands with **TestNG Maven Integration** plugin
* Implemented **Maven Run time variables** to replace global parameters of test data at run time
* Integrated the framework with **Jenkins** with parameterized **Build Pipeline** Jobs & Schedule the jobs on specific times
* Added **Cucumber Wrapper** to existing framework with Cucumber TestNG Runner
* Created **Feature files** & **Step definitions** to support Cucumber execution of Selenium Tests

### Installation Requirements
* JAVA JDK (version 17 used in project)
* Maven
* IDE (IntelliJ or Eclipse)
* Jenkins (only required for remote execution)

### How to Run
* Select the suite you want to run and run it directly by right clicking the testng.xml file
* or through the terminal `mvn test -PRegression -Dbrowser=chrome`
* or through jenkins:
  * start jenkins server with java -jar jenkins.war --httpPort=8085
  * open http://localhost:8085
  * create project with desired parameters
  * with build command `test -P "$Profile" -Dbrowser="$browserName"`
