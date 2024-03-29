# Cucumber BDD Framework with Selenium and Java

* This repo contains the course notes and learnings from Cucumber BDD Masterclass with Selenium 4 & Java + Framework course by Omparkash Chavan.
* It also includes additional information and links for further learning.
* I have added to the framework developed extra functionalities and extended the framework capabilities by integrating different reports, parallel
  execution and selenium Grid support. Further extensions were also added by me that show the usage of Dynamic Selenium grid with Docker containers
  and Selenoid grid.

## Table of Contents
- [Cucumber BDD Framework with Selenium and Java](#cucumber-bdd-framework-with-selenium-and-java)
  * [Table of Contents](#table-of-contents)
  * [Technology Stack](#technology-stack)
  * [Key Learnings from the Course](#key-learnings-from-the-course)
  * [Installation and Setup](#installation-and-setup)
  * [Course Notes](#course-notes)
    + [BDD](#bdd)
    + [Gherkin Syntax](#gherkin-syntax)
    + [Gherkin Anti-patterns](#gherkin-anti-patterns)
    + [Runners](#runners)
      - [CLI Runner](#cli-runner)
      - [jUnit Runner](#junit-runner)
      - [TestNG Runner](#testng-runner)
    + [Cucumber Options](#cucumber-options)
      - [plugin](#plugin)
      - [Snippets](#snippets)
      - [Performing a dry-run](#performing-a-dry-run)
      - [Formatting console output](#formatting-console-output)
      - [Select scenarios using tags:](#select-scenarios-using-tags-)
      - [Glue and feature files path](#glue-and-feature-files-path)
    + [Cucumber Expressions](#cucumber-expressions)
      - [Custom Parameter Types](#custom-parameter-types)
    + [Data Tables](#data-tables)
    + [Hooks](#hooks)
    + [Tags](#tags)
      - [Tag Inheritance](#tag-inheritance)
      - [Running a subset of scenarios](#running-a-subset-of-scenarios)
      - [Ignoring a subset of scenarios](#ignoring-a-subset-of-scenarios)
    + [Selenium Webdriver Integration](#selenium-webdriver-integration)
    + [Anti-patterns](#anti-patterns)
      - [Feature coupled Step Definitions](#feature-coupled-step-definitions)
      - [Static Keyword in Step Definitions](#static-keyword-in-step-definitions)
      - [Duplicate UI Elements definitions](#duplicate-ui-elements-definitions)
      - [Lack of Waits](#lack-of-waits)
      - [Lack of Domain Objects](#lack-of-domain-objects)
      - [Dependent Scenarios](#dependent-scenarios)
      - [Using UI for creating Application State](#using-ui-for-creating-application-state)
      - [More Anti-patterns](#more-anti-patterns)
  * [Framework](#framework)
    + [Framework - Driver Initialization](#framework---driver-initialization)
    + [Framework - Page Object Model](#framework---page-object-model)
    + [Framework - Domain Objects](#framework---domain-objects)
    + [Framework - Optimizations](#framework---optimizations)
      - [Config Properties](#config-properties)
      - [Constants & Enums](#constants---enums)
      - [Support for Mobile Browsers](#support-for-mobile-browsers)
      - [Support for Multiple Environments](#support-for-multiple-environments)
    + [Framework - Parallel Execution](#framework---parallel-execution)
      - [Using JUnit Runner](#using-junit-runner)
      - [Using TestNG Runner](#using-testng-runner)
      - [Using CLI Runner](#using-cli-runner)
    + [Framework - Dependency Injection using Pico-container](#framework---dependency-injection-using-pico-container)
      - [Concept](#concept)
      - [Example](#example)
      - [Inject WebDriver](#inject-webdriver)
      - [Split Step Definitions using Domain Concept](#split-step-definitions-using-domain-concept)
    + [Framework - Optimizations](#framework---optimizations-1)
      - [Automated Driver Management](#automated-driver-management)
      - [Page Factory Manager](#page-factory-manager)
    + [Framework - API Integration using RestAssured](#framework---api-integration-using-restassured)
    + [Framework - Reports](#framework---reports)
      - [HTML Reports](#html-reports)
      - [Cucumber Cloud Reports](#cucumber-cloud-reports)
      - [Cucumber Timeline Formatter](#cucumber-timeline-formatter)
      - [Extent Spark HTML and PDF Reports](#extent-spark-html-and-pdf-reports)
        * [Resources](#resources)
        * [POM Dependency](#pom-dependency)
        * [Plugin Configuration](#plugin-configuration)
        * [Report Activation](#report-activation)
        * [Report Attachments](#report-attachments)
        * [Extent PDF Report](#extent-pdf-report)
      - [Allure Reports](#allure-reports)
        * [Scoop Commandline and Allure Installation for Windows](#scoop-commandline-and-allure-installation-for-windows)
        * [Cucumber Allure Report](#cucumber-allure-report)
        * [Allure Environment Variables](#allure-environment-variables)
        * [Allure logs and Screenshot attachment](#allure-logs-and-screenshot-attachment)
        * [Allure Links](#allure-links)
        * [Allure Severity](#allure-severity)
        * [Allure Test Markers](#allure-test-markers)
      - [Allure Excecutors](#allure-excecutors)
        * [Allure report](#allure-report)
        * [Issues in Allure Report](#issues-in-allure-report)
      - [Master Thought Cucumber Reports](#master-thought-cucumber-reports)
    + [Framework - Rerun Failed Scenarios](#framework---rerun-failed-scenarios)
    + [Framework - Cross Browser Parallel Testing](#framework---cross-browser-parallel-testing)
    + [Framework - On Demand Browser Testing](#framework---on-demand-browser-testing)
    + [Framework - Cucumber cross-platform parallel browser execution using Selenium Grid](#framework---cucumber-cross-platform-parallel-browser-execution-using-selenium-grid)
      - [Standalone](#standalone)
      - [Hub and Node](#hub-and-node)
        * [Events](#events)
        * [Node](#node)
        * [Server](#server)
        * [Node Configuration for Chrome Browser on Windows 10](#node-configuration-for-chrome-browser-on-windows-10)
        * [Node Configuration for FireFox Browser on Windows 10](#node-configuration-for-firefox-browser-on-windows-10)
        * [Node Configuration for Edge Browser on Windows 10](#node-configuration-for-edge-browser-on-windows-10)
      - [Start Selenium Grid Hub and Node](#start-selenium-grid-hub-and-node)
        * [Querying Selenium Grid](#-querying-selenium-grid--https---wwwseleniumdev-documentation-grid-getting-started--querying-selenium-grid-)
        * [Run Tests in Parallel on different browsers and platforms](#run-tests-in-parallel-on-different-browsers-and-platforms)
    + [Framework - Integrating Selenium Grid with Docker](#framework---integrating-selenium-grid-with-docker)
      - [why Docker](#why-docker)
      - [Docker Installation and Setup](#docker-installation-and-setup)
      - [Docker Images for the Selenium Grid](#docker-images-for-the-selenium-grid)
      - [Selenium Grid configuration with docker-compose.yml](#selenium-grid-configuration-with-docker-composeyml)
      - [Running Cross Browser tests on Dockerized Grid](#running-cross-browser-tests-on-dockerized-grid)
      - [Run Cucumber Tests on Dynamic Selenium Grid with Video Recording](#run-cucumber-tests-on-dynamic-selenium-grid-with-video-recording)
      - [Invoke Selenium Grid on Docker Environment using Batch file](#invoke-selenium-grid-on-docker-environment-using-batch-file)
      - [Cucumber Tests on Selenoid Grid](#cucumber-tests-on-selenoid-grid)
        * [Add Selenoid Recordings to Allure Report](#add-selenoid-recordings-to-allure-report)
        * [Scaling Selenoid Tests with GGR and Moon](#scaling-selenoid-tests-with-ggr-and-moon)
    + [Framework - Maven Command Line](#framework---maven-command-line)
    + [Framework - Integration with GitHub](#framework---integration-with-github)
    + [Framework - CI](#framework---ci)
      - [Windows. Install and Configure Jenkins](#windows-install-and-configure-jenkins)
      - [Create Automation Jenkins Job](#create-automation-jenkins-job)
      - [Jenkins Auto Trigger - SCM Polling](#jenkins-auto-trigger---scm-polling)
      - [Jenkins Auto Trigger - Build Frequency](#jenkins-auto-trigger---build-frequency)
      - [Jenkins Auto Trigger - GitHub Web Hooks](#jenkins-auto-trigger---github-web-hooks)
      - [Jenkins - Parameterized Build](#jenkins---parameterized-build)
      - [Jenkins - Cucumber reports](#jenkins---cucumber-reports)
      - [Jenkins - Allure reports](#jenkins---allure-reports)
        * [Install Allure Jenkins Plugin](#install-allure-jenkins-plugin)
        * [Configure Allure Jenkins Plugin](#configure-allure-jenkins-plugin)
        * [Add Post-Build Action in Jenkins Job for Allure Report](#add-post-build-action-in-jenkins-job-for-allure-report)
        * [Execute Jenkins Job and view Allure Report](#execute-jenkins-job-and-view-allure-report)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>


<img src="doc/framework-architecture.png" alt="framework architecture" width="900">

## Technology Stack

![stack](doc/stack.JPG)

---

## Key Learnings from the Course

![learnings](doc/learning.JPG)

---

## Installation and Setup

* Install JAVA JDK (version 17 and above) and set **JAVA_HOME** `C:\Program Files\Java\jdk-17.0.5` as system environment variable
* Download and install Maven build tool, and set **MAVEN_HOME** `C:\Program Files\apache-maven-3.8.5` system environment variable
* Add the path of bin folders in System Path variable like _%JAVA_HOME%\bin_ and _%JAVA_HOME%\bin_
* Run the commands in Command Prompt to verify the installation `java -version` and `mvn -version`
* Intellij IDEA and install the Plugins (Cucumber, Gherkin)
* Install the maven dependencies listed in POM.xml (or build the POM.xml in this case so the dependencies can be installed)

---

## Course Notes

### BDD

Here is the list of some activities to look for that can indicate you are following BDD:

* You are having conversations around features, user stories and coming up with clearly defined Acceptance criteria
* You are having Discovery workshops to build shared understanding of the feature to be built.
* Requirements are written as behaviors
* The behaviors and not tests are driving your development.
* You are converting acceptance criteria into executable specifications in some standard format like Gherkin.
* You are automating executable specifications using collaboration tool like Cucumber

---

### Gherkin Syntax

* If you get error while executing the dummy feature, then delete the main.java and org.example package and main or app pre-generated test
  classes.Then right-click on the
  project root directory and build the project. If you change the folder paths or names, then also rebuild the project by right-clicking the project
  root directory. If the error persists, then Click on the Select Run/Debug configurations, and chose Edit Configuration. Change Build to
  Build-Project.
* Gherkin evaluates the steps with regular expressions and ignores the keywords like Given, When , Then so they will point to the same step
  definition.
* Free floating text can be put under Feature, Rule and Scenario to add the description. This text will be ignored by the Cucumber while execution.
* A feature can be represented by one or more user stories.
* Scenario and Background can be put under different rules in single feature. `Rule` can be used to group several scenarios under a business rule in
  single feature.
    * ![discovery-workshop-mapping](doc/rule.JPG)
    * <img src="doc/rule-gherkin.JPG" width="400px">
* you can put `asterisk *` to avoid writing multiple And keywords in the beginning of the step.
* But keyword designates the negation.
* **Steps Anti-Patterns**
    * Write the Gherkin in the form of business documents and avoid writing as user interaction steps. Stick to the core flow, and hide the
      implementation in steps definitions.
    * <img src="doc/steps-anti-patterns.JPG" alt="steps anti patterns" width="600">
* Group the similar scenarios and different parameters with scenario outline instead of writing multiple scenarios separately.
* Examples in scenario Outline can also be tagged to execute under different test environments or conditions.
* In case of a String parameter in Scenario Outline, put the double quotes around the parameter brackets for it to resolve e.g. _"<product_name>"_
* Single Feature file can have only one Background but if it contains Rule, then each Rule can have separate Background.
* Background Tips:
    * Do not complicate
    * Keep it short
    * Expressive and vivid
    * Keep scenarios short
    * Do not add technical steps such as initializing webdriver, clearing databases, fetching API token etc. in the Background as they have no
      interest
      in the business.
    * These steps can be implemented inside cucumber hooks.

---

### Gherkin Anti-patterns

* Well written Gherkin can give benefits such as low maintenance in case of UI changes, high re-usability of compact steps, improved business
  readability and expressive steps, and increased collaboration.
* Do not stretch the scenarios and add user actions related to UI to complicate the scenario.
* A poorly written Gherkin:
  ![bad-gherkin](doc/bad%20gherkin.JPG)
* This will result in high maintenance if the implementation is changed later, ideally scenario should only be changed if the requirement
  changes.
* It contains many incidental steps that could be removed for example When I click on the View Cart link should be removed because validating
  the product name and quantity will take care of it.
* Doing too many things in the scenario could result in the failing of main intention. For example, validating the tick mark is not necessary.
* Purpose of this scenario is to validate the functionality and not the UI, therefore avoid writing multiple When Then statements.
* Thumb rule of the scenario is to have 5 - 8 steps. Lengthy scenario should be split.
* Conjunction Step should be avoided For example, _Given I am on Homepage, add I navigate to the store page_.... by splitting with And keyword. This
  way the steps can be resued.
* Lack of good scenario name, narratives and rules is bad practice. Here scenario can be named as _Add a product from store_. Use the description text
  to add more detail.
* By following thr Gherkin good practices, the scenario can be refactored to:
* <img src="doc/refactored-gherkin.JPG" alt="refactored-gherkin" width="400">

> Gherkin serves as a Living documentation which is a single source of truth for all the stakeholders. Writing good Gherkin means a readable and
> understandable Living documentation. The Living documentation should clearly show the current state of the system, what behaviors are working, what
> are pending and what are not working. If we don't use Gherkin to describe the behavior of the system, the whole purpose of writing Gherkin gets
> defeated. Then it just becomes a UI action script written in plain language. Just an unnecessary wrapper on top of the underlying automation layers
> that can result into high maintenance.

---

### Runners

* If the cucumber feature and steps definitions are under the same root folder i.e. `src/test/java`, then Cucumber can automatically find the steps
  for the features.

> Runner must end with keyword "test" because this is how maven will find the test runner.

* But if you move the features to another source root folder i.e. `src/test/resources`, then Cucumber will throw error. In this case, the features and
  steps must be under same package/director name e.g. `cucumberPractice`.
* Runner helps us to define the explicit location of steps and feature files, run multiple scenarios, and tag the scenarios.
* Maven is needed for all the runners to be able to execute features from command line.
* Following Runners exist in Cucumber. Read the [Running Cucumber Docs](https://cucumber.io/docs/cucumber/api/?lang=java#running-cucumber)
    1. **CLI**: io.cucumber.core.cli.Main
        * Maven exec
        * Scenarios in parallel
    2. **jUNIT**: Runner Class

    * supports annotated methods
    * Features in parallel

    3. **TestNG**: Runner class

    * supports annotated methods
    * Scenarios in parallel

#### CLI Runner

* The Command-Line Interface Runner (CLI Runner) is an executable Java class that can be run from the command-line.
* Delete the target folder and run the following commands via terminal:
    * `mvn clean test` this will create the fresh target folder
    * `mvn exec:java -D"exec.classpathScope=test" -D"exec.mainClass=io.cucumber.core.cli.Main"` Since our features and steps definitions are under the
      same package, we do not need to give the argument parameter.

#### jUnit Runner

* Add the cucumber-junit dependency in POM.xml
* If you are using the `<scope>test</scope>`, then make sure that all the cucumber test classes are in src/test path.
* If you want to put the test classes inside the src/main path then change the scope to `<scope>compile</scope>`.
* Maven can only find the runners if the name ends with test, so add test suffix to all of the test runners, and run with `mvn clean test`
  Alternatively run by right-click.
* If the steps, runner and the features are different packages, then the path to feature files and glue code must be provided with **
  @CucumberOptions**.
* @Before and @After hooks get executed before and after each scenario, these hooks also come with Cucumber so use Cucumber hooks instead of jUnit for
  better portability.
* Order of terminal output of annotated hooks is in reverse order i.e. from bottom to up.
* Cucumber Hooks will execute before jUnit or TestNG hooks.

#### TestNG Runner

* [Cucumber TestNG docs](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-testng)
* Add the cucumber-testng maven dependency. Remember to disable jUnit dependency in POM.xml and comment out the jUnit runner.
* `mvn clean test` can also be used to run the TestNG test runner from cmd.

* Cucumber 7 has introduced @BeforeAll and @AfterAll that works the same as jUnit and TestNG @BeforeClass and @AfterClass to run the code before and
  after each scenario.
* Cucumber Hooks will also work with the CLI Runner.
* Cucumber Main class cannot see jUnit annotations as it is not using jUnit runner for execution. It is using its own internal mechanism.
* The default `thread count of the dataprovider` in parallel mode is 10. To change this the `dataproviderthreadcount` property needs to be added to
  the
  `configuration` section of the Surefire or Failsafe plugin in the POM.

````xml

<configuration>
    <properties>
        <property>
            <name>dataproviderthreadcount</name>
            <value>20</value>
        </property>
    </properties>
</configuration>
````

> The `dataproviderthreadcount` attribute that you have set in your pom file is going to be applicable and relevant only when you are running your
> test
> via mvn clean test. If you are trying to run this test class from within the IDE (IntelliJ or Eclipse for that matter) its not going take affect.
---

### Cucumber Options

The **@CucumberOptions** can be used to provide additional configuration to the runner.
Maven command will always override the cucumberOptions.

#### plugin

* `pretty` plugin will output the scenario steps in colorful format.
* `html:target/cucumber.html` will generate the cucumber test report.
* you can also run TestNG and jUnit tests through command line
  with `mvn clean test -Dcucumber.plugin=pretty -Dcucumber.plugin=html:target/cucumber.html`
* with CLI, you can run first `mvn clean test` and
  then `mvn exec:java -D"exec.classpathScope=test" -D"exec.mainClass=io.cucumber.core.cli.Main" -Dexec.args="--plugin pretty --plugin html:target/cucumber.html"`

#### Snippets

* if you want to tell Cucumber to print code snippets for missing step definitions use the summary plugin.
* @`CucumberOptions(plugin = {"pretty", "summary"}, snippets = CAMELCASE)`
* The default option for snippets is UNDERSCORE. These settings can be used to specify the way code snippets will be created by Cucumber.

#### Performing a dry-run

* if you want to check whether all feature file steps have corresponding step definitions, you can specify it like this:
* `@CucumberOptions(dryRun=true)`
* The default option for dryRun is false

#### Formatting console output

* if you want console output from Cucumber in a readable format, you can specify it like this:
* `@CucumberOptions(monochrome=true)`
* The default option for monochrome is false.

#### Select scenarios using tags:

* if you want to tell Cucumber to only run the scenarios specified with specific tags, you can specify it like this:
* `@CucumberOptions(tags = {"@foo and not @bar"})`
* you can have multiple tags on one scenario.
* `tags = "@smoke and @dummy"`, this will run the scenarios that have both smoke and dummy tag
* `tags = "@smoke or @dummy"`, this will run the scenarios that have either smoke tag or dummy tag or both tags.
* `tags = "@smoke and not @dummy"`, it will only execute the scenario which has smoke tag and that does not have dummy tag

#### Glue and feature files path

* If the steps and features are not under the same package name, then you have to specify the steps path with glue parameter and feature path with
  feature parameter.
* Path of the feature file starts like src/test/resources/cucumberPractice directory.
* Path of the steps definitions starts from package name under src/test/ java like cucumberPractice.stepdef
* path to hooks can also be specified under the glue parameter.

* Cucumber Options can bve overridden using System properties from Maven command line. e.g. `mvn test -Dcucumber.pluggin=pretty`

> Tip: Download source and java docs by right-clicking on the keyword and navigate to Go To -> Declaration or Usages, and then click on Download
> sources on Top right. This will show the cucumber documentation for a specific keyword when you hover on it which will help in understanding the
> implementation logic.

---

### Cucumber Expressions

* [Cucumber Regular Expressions Cheat Sheet](https://agileforall.com/wp-content/uploads/2011/08/Cucumber-Regular-Expressions-Cheat-Sheet.pdf)
* Cucumber will create a Cucumber Expression by default. To use Regular Expressions, add anchors (starting with ^ and ending with $) or forward
  slashes (/)
* Foe the step: **Then I see 1 "<product_name>" in the cart**, here is how the expression can be formulated:
    * `@Then("^I see (.*) \"([^\"]*)\" in the Cart$")` is the example of regular expression
    * `@Then("I see {int} {string} in the Cart")` is the example of cucumber expression
* Cucumber also supports optional text. It's grammatically incorrect to say 1 cucumbers, so we should make the plural s optional. That can be done by
  surrounding the optional text with parentheses: `I have {int} cucumber(s) in my belly`
* Similarly, it supports `Alternative text`, and `Escaping`.
* [Cucumber Expressions Docs](https://github.com/cucumber/cucumber-expressions#readme) read in detail about the cucumber steps.

#### Custom Parameter Types

* Cucumber Expressions can be extended so they automatically convert output parameters to your own types. It can make code readable.
* [GitHub docs](https://github.com/cucumber/cucumber-expressions#readme)
* [Cucumber configuration](https://cucumber.io/docs/cucumber/configuration/?lang=java)
* For example take this step: **When I add a "<product_name>" to the cart**, and its step definition:

```java
  @When("I add a {string} to the cart")
public void i_add_a_to_the_cart(String string){
        // Write code here that turns the phrase above into concrete actions
        }
```

* The problem is I do not understand what exactly is string in my step definition. This can be improved by changing the parameter
  to `String productName`
* If the productName is to be shared among multiple feature files, then a product object i.e. domain object should be created.
    * For this purpose, create a product Object.
  > Tip: To automatically generate a constructor, getter and setter of the class variable, right-click on the variable, and then Generate -> Getters
  and Setter
    * ```java
      public class Product {
      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public Product(String name) {
          this.name = name;
      }

      public String name;
      }
      ```
* Now we can use this product to improve readability in our step as:

```java
  @When("I add a {string} to the cart")
public void i_add_a_to_the_cart(String name){
        // Write code here that turns the phrase above into concrete actions
        Product product=new Product(name);
        System.out.println("Product Name: "+product);
        }
```

* With Cucumber Customer custom parameter type, we do not even have to instantiate the object and can access it directly

```java
@When("I add a {product} to the cart")
public void i_add_a_to_the_cart(Product product){
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Product Name: "+product.getName());
        }
```

* The cucumber `@ParameterType` annotation will automatically create the product

```java
  @ParameterType(".*")                        // regexp:
public Product product(String name){       // type, name (from method)
        return new Product(name);                   // transformer function
        }
```

* The regular expression can further be restricted to allow specific inputs e.g. to allow _Blue Shoes_ and _Anchor Bracelet_ we can write regexp
  as `"@ParameterType("\"Blue Shoes\"|\"Anchor Bracelet\"")`
* We added Backslash \ to escape the double quotes around the productName in examples.
* Create a separate class to store all of your custom parameter types, and provide path in runner file glue parameter.

> Tip: When steps definitions, hooks and other implementations are put under different packages, then put the path in Runner glue parameter. In this
> case, run the scenario from the runner file.

---

### Data Tables

* Data tables from Gherkin can be accessed by using the DataTable object as the last parameter in a step
  definition. [Read more](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-java#data-tables)
* Cucumber DataTable supports the following collections:
    * `List<List<String>> table`
    * `List<Map<String, String>> table`
    * `Map<String, String> table`
    * `Map<String, List<String>> table`
    * `Map<String, Map<String, String>> table`
* Cucumber can map step arguments as datatable list if the arguments are provided vertically with single column ny using DataTable `asList()` method.
  This datatable will be converted to List<String>.

```
  Scenario: single row with no header
  Given my credentials
  | john |
  | john123 |
```

* In case of horizontal parameters, use the DataTable `values()` method. use `row(0)` if you want to fetch the first row or `rows(startRow, endRow)`
  for multiple rows
* Use `asLists()` if you want to get `List<List<String>>` table and have multiple rows. It can also work with single row but then the
  code `creds.get(0).get(0)` is not readable.
* Instead of using Datatable datatable, you can directly use the collection in step definition argument also.

```java
@Given("many credentials")
public void manyCredentials(List<List<String>>creds){
        //List<List<String>> creds = dataTable.asLists(); //returns list of list
        System.out.println("ROW 0 USERNAME = "+creds.get(0).get(0));
        System.out.println("ROW 0 PASSWORD = "+creds.get(0).get(1));
        System.out.println("ROW 1 USERNAME = "+creds.get(1).get(0));
        System.out.println("ROW 1 PASSWORD = "+creds.get(1).get(1));
        }
```

* To make code more readable, we can create a transformer function to transform the datatable into domain object.
* In our case, we are pasing username and password to the step so we pass List<String> to the transformer method parameter. It gets values from
  Gherkin step as a List of strings and returns a new object of Customer. Therefore, we can now use Customer domain object directly in our step
  parameter instead of creating the object manually by `Customer customer = new Customer(creds.get(0).get(0), creds.get(0).get(1));`. Change the step
  parameter to use customer domain object instead.
* Cucumber supports the following parameter types for `@DataTableType`
* ![datatabletype](doc/datatabletype.png)
* Here is how the transformer function can transform the step arguments to the customer object.

```java
 @DataTableType
public Customer customerEntry(List<String> entry){
        return new Customer(entry.get(0),entry.get(0));
        }

@Given("my credentials")
public void myCredentials(Customer customer){

        //BAD Practice, use custom domain object instead
        //Customer customer = new Customer(creds.get(0).get(0), creds.get(0).get(1));
        //System.out.println("USERNAME = " + creds.get(0).get(0));
        //System.out.println("PASSWORD = " + creds.get(0).get(1));

        //Use this if you are passing customer domain object as step argument
        //GOOD practice, use domain objects with cucumber dataTable transformer
        System.out.println("USERNAME = "+customer.getUsername());
        System.out.println("PASSWORD = "+customer.getPassword());

        }
```

* If you have Gherkin step with multiple rows datatable then you cannot supply `List<List<String>>` to your transformer function annotated with
  `@DataTableType` because it is not supported as valid type. To solve this you can use `List<Customer> customers` in your step argument and access
  the index.
* This is how you can use the @DataTableType to directly map the data table to our domain object. Depending upon the shape of table, you have to
  implement the logic in transformer method and then return your domain object.
* If the Gherkin step datatable is of **single row with header** then you can use `List<List<String>>` or `List<Map<String, String>>`
* If the Gherkin step datatable is of **multiple rows with header** then you can again use `List<Map<String, String>>` and access the corresponding
  row.
* To further simplify instead of using List or Map collection, you can use use custom domain object as step argument with @DataTableType transformer.
* if the gherkin step datatable is of **single column with no header**, then either you can use collection` List<String>` or you can use Cucumber
  datatable and extract the List of strings with `datatable.asList()`
* If the Gherkin step has datatable of **single column with header**, then you can use DataTable and asMap() method to extract
  to `Map<String, String>` collection.

> You can either use DataTable as step argument and then transform it to collection within step like `List<String> cred = datatable.asList();` or you
> can directly use the collection `List<String> cred` as an argument in step. Only supported collections listed above can be used as step argument in
> step definition method. In case of using datatable we have the advantage of many methods that come with it.

* If the Gherkin step has datatable of **single column with no header DataTableType**, then you can map it to domain object and use `@Transpose`
  annotation in the step definition argument to convert the credentials to list of strings (rows).

> We use `@Transpose` because Cucumber understands the first row as header, so we need to take the transpose of the data table to convert column to
> row.

> You can also use DataTable as argument in transformer method instead of collection and access values with `dataTable.row(0).get(1)` for username
> and `dataTable.row(1).get(1)` for password and hence you do not need to take the transpose in step definition argument later.

* If the Gherkin step has datatable of **single column with header DataTableType**, then you can use the `Map<String, String>` in transformer method
  and return the customer object that can then be used in step definition with the `@Transpose` annotation in front of the argument.
* If the Gherkin step has datatable of **multiple column with header DataTableType**, then you can use the same concept as above but this time the
  argument to the step definition will be `List<Customer>`
* You can play around with the practice code in this repo by running the `data_table.feature` in `cucumberPractice` package and by running your
  desired scenario.

---

### Hooks

* [Official Cucumber Hooks Docs](https://cucumber.io/docs/cucumber/api/?lang=java#hooks)
* `@Before` and `@After` hook will execute for each of the example in scenario outline.
* Import the Hook from `io.cucumber` library and not from the jUnit or TestNG.
* You can pass the `Scenario` class object as argument to the `@Before` and `@After` hooks and can perform different actions on the scenario like
  getting the scenario name, status, tag name, and `attach()` method for creating screenshot etc. The `scenario` parameter is optional. If you use it,
  you can inspect the status of the scenario. For example, you can take a screenshot with WebDriver for failed scenarios and embed them in Cucumber’s
  report.
* `@After` hooks run after the last step of each scenario, even when the step result is `failed`, `undefined`, `pending`, or `skipped`.
* In case of UI Automation, hooks can be used to set up and teardown webdriver and in case of API automation you can put the request specification in
  before hook.
* Hooks should only contain low level technical details and not the business logic.
* You can also specify the order for hooks. Higher order hook will execute first.
* Hooks can be conditionally selected for execution based on the tags of the scenario. To run a particular hook only for certain scenarios, you can
  associate a `Before` or `After` hook with a tag expression.
* Global hooks `BeforeAll` and `Afterall` will run once before any scenario is run or after all scenario have been run.
* Step hooks invoked before and after a step. The hooks have ‘invoke around’ semantics. Meaning that if a `BeforeStep` hook is executed
  the `AfterStep`
  hooks will also be executed regardless of the result of the step. If a step did not pass, the following step and its hooks will be skipped.
* You can play around with the practice code in this repo by running the following test runner in Intellij `cucumberPractice.runners.TestNGRunnerTest`
  .
  Hooks are added in glue path.

---

### Tags

* [Official Cucumber Tag Docs](https://cucumber.io/docs/cucumber/api/?lang=java#tags)
* Tags are primarily used for
    * Running a subset of scenarios
    * Restricting hooks to a subset of scenarios
* A feature or scenario can have as many tags as you like. Separate them with spaces.
* Tags can be placed above the following Gherkin elements: `Feature` `Scenario` `Scenario Outline` `Examples`
* In `Scenario Outline`, you can use tags on different example like below:
* It is not possible to place tags above `Background` or steps (Given, When, Then, And and But).

#### Tag Inheritance

* Tags are inherited by child elements.
* Tags that are placed above a `Feature` will be inherited by `Scenario`, `Scenario Outline`, or `Examples`.
* Tags that are placed above a `Scenario Outline` will be inherited by `Examples`.

#### Running a subset of scenarios

* `mvn test -Dcucumber.filter.tags="@smoke and @fast"`
* Or changing your JUnit 4/TestNG runner class:
  '''java
  @CucumberOptions(tags = "@smoke and @fast")
  public class RunCucumberTest {}
  '''

#### Ignoring a subset of scenarios

'''java
@CucumberOptions(tags = "@smoke and not @fast")
'''

---

### Selenium Webdriver Integration

  <img src="https://www.selenium.dev/images/documentation/webdriver/test_framework.png" alt="selenium-components" width="600"/>

* Selenium WebDriver communicates with the browsers via vendor specific driver executables such as ChromeDriver, Geckodriver etc. The test
  frameworks such as jUnit, TestNG, and Cucumber are responsible for running and executing your WebDriver related steps in your
  tests. [Read more](https://www.selenium.dev/documentation/overview/components/)
* `addToCart.feature` in `cucumberPractice` has been automated as part of first automation scenario
* `guest_place_an_order.feature` in `cucumberPractice` has been automated as part of second automation scenario. Good practices of Gherkin are
  followed in
  second
  feature. There are no UI actions, and we are not adding lines such as user is on home page because this is not related to the scenario instead we
  are abstracting these details in the steps definitions. The billing details are added as part of step arguments but these can also be put in JSON or
  CSV file and extracted directly in the step definition if the details are not important for business logic.
* Run the automation scenarios either directly by hitting the run icon next to the feature or Scenario, or you can create a TestRunner.
* By-default in the run configuration, Intellij also adds `cucumberPractice.hooks` in glue parameter, so if hooks are getting executed, you can remove
  this parameter by editing the configuration.

--- 

### Anti-patterns

#### Feature coupled Step Definitions

* Step definitions should be split into multiple smaller classes based on their domain. Each domain class should contain the steps that are related to
  this domain for example, in this case the Product, Store, Checkout, Payment, and Cart could be the suitable candidates for step definitions classes.
  All
  the steps that are to be performed on this domain should be placed into the respective domain classes.

#### Static Keyword in Step Definitions

* Webdriver should be initialized only once in the step definition class, we can achieve this using `Static` keyword. This also comes with its own
  issues like you cannot run the scenario if the driver is not already initialized by another scenario previously.
* Another issue is parallelism, since we are using the `static`keyword, it means that all the steps are using the same driver instance and that could
  result in conflict i.e. it is also
  going to perform UI action in the same browser. To solve this issue, you can use Java `ThreadLocal` class, that will maintain different copies of
  webdriver for each thread.
  '''java
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
  '''
* This also has a problem if there are multiple steps definitions as you have to initialize the driver multiple times, and it nullifies the DRY (Do
  not
  Repeat Yourself) principle. For this, create a reusable method for instantiating driver in a separate class and call it in your step definitions.

#### Duplicate UI Elements definitions

* Use Page Object Model (POM) to define UI elements to avoid duplication, adn write all associate actions for it in page objects.

#### Lack of Waits

* It is advisable to put Explicit wait for the situations so it could wait for time before proceeding to the next set of instructions. Avoid
  using `Thread.sleep()` that will continue to wait even if our desired waiting condition has been met. Generally API calls could take 30 seconds to
  serve response so that can be used as standard.

#### Lack of Domain Objects

* It is advisable to use the Domain Objects which helps to share the state between steps. This improves the readability. BDD is all about domain
  objects, the feature and step definitions should not be too technical, ideally they should only be used to call the methods of automation layer.
  Instead of using Java collections as step arguments, Cucumber provides the `@ParameterType` and `@DataTableType` annotations to work with.
  '''java
  @When("I add a {product} to the cart")
  public void i_add_a_to_the_cart(Product product) {
  }
  '''

#### Dependent Scenarios

* It is advisable not to share the following between different scenarios as one scenario could change the state/value that the other scenario needs,
  so it is better to create separate test user and data so the tests could run in parallel:
    * **Driver instance** (driver instance should not be shared in scenarios which is important for parallel execution)
    * **Application state** (each scenario should start from clean application state, and should not start from state created by previous scenario)
    * **User state** (one scenario might change the user state which the other scenario is not expecting)
    * **Test data** (corruption of test data could result in failing of all the scenarios)

#### Using UI for creating Application State

* We are using UI for creating application state in step where product is to be added in cart (clicking on add to Cart button, and clicking on View
  cart button). UI automation is unreliable and slow and creates maintenance overhead if the elements or work-flow change. Instead, we could use API
  calls and inject cookies in the browser to add product to the cart which is a pre-requisite for the next steps where we are making assertions. We
  could also create a separate customer via API with pre-provided customer billing details, so we do not have to create customer details each time.

#### More Anti-patterns

* base url should be put in the configuration file and the endpoint should be put in JSON file.
* static expected text should be put in the properties file so the same text could be used for multiple assertions.
* Webdrivermanager should be used that manages the browser binaries automatically
* test should support cross browser testing therefore driver setup should provide support for it.
* test suit should be able to receive the browser and base url via maven commands.

---

## Framework

<img src="doc/framework-architecture.png" alt="framework architecture" width="765">

* Multiple components work together to create a `robust` production-ready test automation framework which will be `maintainable`, `readable`,
  and `scalable`.
* Feature files will contain Gherkin in the form of executable specifications.
* Glue code will be in steps definitions. `Hooks` will be used to initialize and close webdriver.
* The webdriver will be supplied by `factory`, and is sent to the Base Page in Page Objects. Base Page will initialize waits and other page factory
  elements. Page objects will be subclasses of base page.
* On Cucumber side, Domain objects for Customer, Product etc. will be created, and `Custom Types` will be used to directly convert Gherkin data to
  `Domain Objects`.
* The reusable REST-assured methods will be used to make API calls for Application and generate cookies.
* Steps will be distributed among multiple step definition classes, and to share the webdriver, Page objects, domain objects, and cookies between test
  steps, we will create Test Context. The `pico-container` dependency injection library will help to share the test context between steps.
* Common Information will be stored in separate `properties` files such as cucumber info will be stored in cucumber.properties, environment info will
  be
  stored in
  environment.properties.
* `Test data` will be stored as JSON, and constants will be stored in separate `CONSTANT` file.
* `Utilities` such as Faker API will be used to create test data, Jackson will help to parse JSON, cookie utility will convert REST-assured cookies to
  selenium cookies, and properties utility will be used to read the config properties file.
* The framework will support the jUnit, TestNG, and Cucumber CLI runner.
* As part of the `CI` process, framework will be integrated to `GitHub` and `Maven` build tool will trigger the tests through `Jenkins` with SCM
  polling,
  build frequency and GitHub webhooks.
* The Cucumber reports and `Serenity` reports will be used for reporting, `screenshot` will be captured on failing scenario and integrated into
  report.

---

### Framework - Driver Initialization

* DriverFactory class will initialize the Webdriver. Static keyword will bind the driver instance to the class, and helps to reuse the driver instance
  in scenario. The static methods `initilizeDriver()` and `getDriver` will not create the new instance of the class which will set the driver to null
  each time new instance of the DriverFactory is made.
* @Before and @After hooks will be used to set up and teardown drivers before and after each scenario.

---

### Framework - Page Object Model

* `BasePage` class will initialize the Selenium Wait and UI elements of the PageFactory. The driver and wait are set as protected so the child page
  classes can use these. `load(url)` method will be used to open the url provided as String.
* The constructor of Page Objects will pass the driver to BasePage which will use this driver instance to initialize waits and UI Elements.
* `StorePage` will contain the UI Elements and methods being performed on store page, like `addToCart()` method with Explicit waits for better
  reliability.
* `CartPage` will contain the UI elements of product Name and Product Quantity as well as the link to the checkout button and getting the text notice.
* `CheckoutPage` will contain all the UI elements related to billing details, and the method to fill form and placing an order.
  The `setBillingDetails` method is suing the **Builder pattern** as each of enter details method will return the object of the same class
  i.e. `CheckoutPage`, so using this object we can call the next method in the class. We are using `return this` at the end of the methods which will
  return the instance of the same class.
* The step definitions file is now fairly clean and readable.

---

### Framework - Domain Objects

* We can provide the billing details as part of `Given` step like `And my billing details are`, and then we can share the state between multiple steps
  by injecting the domain objects using the dependency injection library.
* First we will try to do this with a class instance variables, and then reuse these instance variables in different steps. This approach has many
  problems, like if we use them as static, then we lose the parallelism advantage, also the variables will not be shared between multiple step
  definition classes.To solve this, we use the dependency injection framework that allows us to share the state between multiple steps in different
  step definition classes.
* We will create domain objects for billing details, and product. This is analogs to creating a POJO class. A custom data table type will convert the
  gherkin datatable to Billing details object.
  ```java
  public class CustomDataTableType { 
     @DataTableType
     public BillingDetails billingDetailsEntry(Map<String, String> entry){
        return new BillingDetails(entry.get("firstname"),
                                  entry.get("lastname"),
                                  entry.get("address_line1"),
                                  entry.get("city"),
                                  entry.get("state"),
                                  entry.get("zip"),
                                  entry.get("email")
        );
     }
  }
  ```
  ```java
  @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
        
        //Instead of using instance variables, we now uuse Datatable
        /*Map<String, String> billingDetail = billingDetails.get(0);
        billingFirstName = billingDetail.get("firstname");
        billingLastName =  billingDetail.get("lastname");
        billingAddressOne =  billingDetail.get("address_line1");
        billingCity =  billingDetail.get("city");
        billingStateName =  billingDetail.get("state");
        billingZip =  billingDetail.get("zip");
        billingEmail =  billingDetail.get("email");*/
    }
  
  @When("I provide billing details")
    public void iProvideBillingDetails() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDetails);
        /*checkoutPage.setBillingDetails(
                billingFirstName,
                billingLastName,
                billingAddressOne,
                billingCity,
                billingStateName,
                billingZip,
                billingEmail
        );*/
    }
  ```

* Custom data table type will be created to directly convert the datatable from Gherkin to domain object.
* Similarly, a custom Parameter Type for Product will also be created, and instead of `String` as step argument, we use this custom data object
  i.e. `product`. The
  name of the method under `@ParameterType` annotation must be the same as the name in step definition method argument.
  ```java
  public class CustomParameterType {
    @ParameterType(".*")
    public Product product(String name){
        return new Product(name.replace("\"", ""));
    }
  }
  ```

---

### Framework - Optimizations

#### Config Properties

* We will create a global property `config.properties` under src/test/resources for the base Url, and read it using config loader
  utility `PropertyUtils` under the `utils` package.
* Another utility `ConfigLoader`with the private constructor is created which means that the not other class can instantiate this class. Singleton
  design pattern is employed for achieving this. This ensures only instant for this class throughout program execution. we will load the properties in
  constructor of this class. The `getInstance` method will return the new instance of the class if it not already created. The `getBaseUrl` will give
  us the URL from the loaded properties.
* So to retrieve the url. we can simply call `ConfigLoader.getInstance().getBaseUrl() + "/store/"`
* Since the endpoint could be different, and to avoid writing the above statement at multiple places in the step definition, we can modify
  the `load()` method in `BasePage` like this and only pass endPoint as argument:
  ```java
     public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }
  ```
* This utilizes the DRY principle, and we optimized our code to use the url from loaded properties via ConfigLoader and only pass the endPoint
  to `load()`
  method instead of complete URL:
   ```java
     @Given("I'm on the Store Page")
     public void i_m_on_the_store_page() {
        driver = DriverFactory.getDriver();
        //new StorePage(driver).load("https://askomdch.com/store/");
        //new StorePage(driver).load(ConfigLoader.getInstance().getBaseUrl() + "/store/");
        new StorePage(driver).load("/store");
        }
  ```

> yaml is good for multiple programming languages. Plus, it represents the data in hierarchical form. So, it looks good for complex set of data and if
> you want to put everything in one file.

> Properties are good for simple key value pairs and maintaining multiple files, each file representing one set of configuration.

#### Constants & Enums

* As `endpoints` are constant, so we can create an `Enum` class for the endpoints and can access from there. or alternatively a class to hold
  constants as static final class variables. [Read more on Enums](https://refreshjava.com/java/enum-in-java)
  ```java
     public enum EndPoint {
        STORE("/store"), ACCOUNT("/account");

        public final String url;

        EndPoint(String url) {
         this.url = url;
        }
    }
  ```
* To access the endpoints, use the `new StorePage(driver).load(EndPoint.STORE.url);` or `new StorePage(driver).load(BaseConstants.STORE);` depending
  on whether you are using Enum or final class variables.

#### Support for Mobile Browsers

* The preferred way to add a multi browser support is to enable the code to accept the browser as maven command arguments during runtime. We can also
  send this maven command from jenkins.
* For this purpose, we can pass the browser options as a string parameter in the `initializeDriver(String browser)` method of the `DriverFactory`.
* We need to pass the browser as system property in before hook `System.getProperty("browser", "chrome")` with chrome as the default value.
* Run the tests witH `BaseTestNGTestRunner` or through the command line with `mvn clean test`. By-default it runs tests in chrome.
* To run with firefox, use command `mvn clean test -Dbrowser=firefox`, and to run with chrome use command, `mvn clean test -Dbrowser=chrome`
* Firefox browser has known issue of not being able to scroll down to the select dropdown option if it is not in view so to get around we used
  Javascript executor to first click on the dropdown element and then scroll down to the option and click it.
* Another issue that occurred in Firefox tests execution because of the overlay, the place order button could not be clicked, so a method is added in
  BasePage that waits of the overlay to disappear before proceeding to click on the element.

#### Support for Multiple Environments

* Separate properties file with different baseUrl for production and staging environments are created.
* ConfigLoader will accept the environment variable as system property, and load the corresponding property file. It will take by default the staging
  environment if no value is provided for environment through maven command.
* Use the commands `mvn clean test -Denv=PROD` and `mvn clean test -Denv=STAGE` to run the tests in production and staging environment respectively.
* At the moment, the PROD environment url is a dummy one so the tests will fail.

---

### Framework - Parallel Execution

[Cucumber Parallel Execution](https://cucumber.io/docs/guides/parallel-execution/?lang=java)

* For each scenario, Cucumber creates a new instance of Step definitions and hooks class so for each copy it wil get the separate copy of instance
  variables of this class, in our case it will be driver and billingDetails. So we can still run the scenarios without having to use ThreadLocal as
  long as we are not using the static keyword.
* The problem with parallel occurs in DriverFactory class where driver is declared as static variable `private static WebDriver driver;`. In case of
  parallel execution, the statement `driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));` in BeforeHook for the second
  scenario will initialize a new driver, and the previous driver for first scenario will get overwritten which was declared as static in
  DriverFactory. Hence, the first scenario loses the driver object and browser instance becomes stale.
* We need to add `ThreadLocal` class in DriverFactory so each thread gets its own copy of the driver, so whatever scenarios are getting executed by
  that thread they will get their own copy of the driver object.

````java
    public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        DriverFactory.driver.set(driver);  //Sets the current thread's copy of this thread-local variable to the specified value
        return driver;
    }

    public static WebDriver getDriver() {
        return driver.get();           //Returns the value in the current thread's copy of this thread-local variable.
    }
}
````

#### Using JUnit Runner

* Cucumber can be executed in parallel using **JUnit and Maven test execution plugins**. In JUnit the **feature files are run in parallel rather than
  scenarios**, which means **all the scenarios in a feature file will be executed by the same thread**.
* Add the **Surefire plugin configuration** to the `build` section to the `POM`.
  ```xml
  <build>
      <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M7</version>
            <configuration>
              <parallel>methods</parallel>
              <threadCount>3</threadCount>
            </configuration>
          </plugin>
  </build>
  ```
* Execute the tests with `mvn clean test`. It should open two browser instances to run both features in parallel, and after one scenario is finished
  it will open the another browser window to execute the second example in Scenario Outline.

#### Using TestNG Runner

* Comment the JUNit Runner and POM dependency when you execute the TestNG runner. This is important to avoid conflicts.
* Cucumber can be executed in parallel using T**estNG and Maven test execution plugins** by setting the **dataprovider parallel option to true**. In
  TestNG
  the **scenarios and rows in a scenario outline are executed in multiple threads**.
  ````java
  import org.testng.annotations.DataProvider;
  import io.cucumber.testng.AbstractTestNGCucumberTests;
  
  public class RunCucumberTest extends AbstractTestNGCucumberTests{
  
      @Override
      @DataProvider(parallel = true)
      public Object[][] scenarios() {
          return super.scenarios();
      }
  }
  ````
* Add the **Maven Surefire plugin configuration** to the build section of the `POM`.
* Execute the tests with `mvn clean test`. It should open the three browser instances and run them in parallel.

* <img src="doc/tesng-parallel.png" alt="TestNG Runner parallel" width="738">

#### Using CLI Runner

* Below command will execute the scenarios sequentially via CLI Runner, specify the package of your step definitions in glue parameter and the feature
  files or folder in exec.args:
* `mvn exec:java -D"exec.classpathScope=test" -D"exec.mainClass=io.cucumber.core.cli.Main" -D"exec.args=src/test/resources/framework/features --glue framework"`
* To execute the scenarios in parallel, specify the number of threads in `exec.args` argument in command line:
* `mvn exec:java -D"exec.classpathScope=test" -D"exec.mainClass=io.cucumber.core.cli.Main" -D"exec.args=src/test/resources/framework/features --glue framework --threads 3"`
* Please note that for CLI Runner, maven surefire plugin is not required.

---

### Framework - Dependency Injection using Pico-container

#### Concept

* Keeping all step definitions in a single class quickly becomes impractical, so you use many classes. Cucumber supports several Dependency
  Injection (DI) containers - it simply tells a DI container to instantiate your step definition classes and wire them up
  correctly. [Read More] (https://cucumber.io/blog/bdd/polymorphic-step-definitions/)
* Cucumber scans your classes with step definitions in them, passes them to PicoContainer, then asks it to create new instances for every scenario.
  Before PicoContainer can instantiate these classes it will create an instance of AutomationApi, and then pass the same instance to both
  constructors. Simple!

````java
public class SomeStepDefs {
    public SomeStepDefs(AutomationApi api) {
    }
}

public class SomeOtherStepDefs {
    public SomeOtherStepDefs(AutomationApi api) {
    }
}
````

* [Sharing state between steps in Cucumber-JVM using PicoContainer](http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer)
* [GitHub Code](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-picocontainer)
* With the DI, we can avoid writing the `static` and `ThreadLocal`.

#### Example

* Add the `pico-container` dependency from `io.cucumber` in your POM.
* Create a new package `context` and new class `TestContext` inside it which holds an instance variable `scenarioName`

````java
public class TestContext {
    public String scenarioName
}
````

* If we want Pico-container to create the instance of `TestContext`, we can create a constructor of the Hooks class and pass TestContext as an
  argument. Pico-container will scan the step definitions and hooks classes, and look for the constructor and then creates an instance of the
  TestContext.
* The scenarioName in the TestContext will be different for each Scenario because for each scenario, the new instance of TestContext will be generated
  by Pico-container.

````java
public class BaseHooks {
    private WebDriver driver;
    private final TestContext context;

    public BaseHooks(TestContext testContext) {
        this.context = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        context.scenarioName = scenario.getName();
        System.out.println("DI Scenario Name: " + context.scenarioName);
    }
}
````

* If you want to use the `context.scenarioName` in a different class, for example, in a step definitions class, we need to create a constructor of the
  class and add TestContext as an argument to that. With this, Pico-container will not create another instance of the TestContext class, it will
  inject the already created instance of TestContext class to the steps definitions when an instance of steps definitions is created.

> Please note that we did not re-assigned the testContext in the constructor of step definition `this.context = testContext;` since we already did
> that in Hooks

````java
public class BaseStepDefinitions {

    public BaseStepDefinitions(TestContext context) {
        System.out.println("Step Definitions DI: Scenario Name" + context.scenarioName);
    }
}
````

* If it prints the scenarioName, then the Pico-container is working well. In the output below, you can see that the scenarioName is getting printed in
  steps definitions for each of the scenario. This is how the pico-container injects the object of TestContext in another class, so we can inject the
  TestContext in any class where we want to use that. **The only requirement is class should have an empty constructor.**

 <img src="doc/picocontainer-example.png" alt="pico-container output" width="765">

#### Inject WebDriver

* We can get rid of the `ThreadLocal Webdriver` variable, and `getDriver()` method in PageFactory.
* Declare a Webdriver driver variable in the TestContext, and assign it in BeforeHook `context.driver = driver;`
* In the steps definitions method, we can remove the `driver = DriverFactory.getDriver();` and use the context driver initialized in hooks as below:

````java
public class BaseStepDefinitions {
    private final WebDriver driver;

    public BaseStepDefinitions(TestContext context) {
        driver = context.driver;
    }
}
````

* Pico-container will make sure that this driver is specific to the scenario, so there will be no conflict when scenarios get executed in parallel.

#### Split Step Definitions using Domain Concept

* Since we now have the DI setup with Pico-container, we can split the step definition classes. The billingDetails need to be shared among multiple
  classes, so we will inject it through TestContext DI.
* Create a new `public BillingDetails billingDetails;` in `TestContext`:
* As we are setting the billingDetails from Gherkin in **CustomerStepDefinitions**, so we need to create an instance variable for TestContext and
  assign it in the constructor.

````java
public class CustomerStepDefinitions {
    private final WebDriver driver;
    private final TestContext context;

    public CustomerStepDefinitions(TestContext context) {
        this.context = context;
        driver = context.driver;
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }
}
````

* Updating the step definitions classes will now be very easy because we know which class to change if some step changes. Each step definition class
  is focusing on specific domain, so we are following the Single Responsibility Principle (SRP). This will reduce the maintenance effort.

---

### Framework - Optimizations

#### Automated Driver Management

* Use **WebDriverManager** dependency from `io.github.bonigarcia` that will automatically manage the webdriver binaries if browser updates.
* Alternatively, if you are using **Selenium version 4.6.0** or higher, then you do not even need this external dependency as **Selenium Manager**
  takes care of it.

#### Page Factory Manager

* In our step definition classes, we are using the `new` keyword multiple times that creates the new instance of page to perform any actions for
  example `new CartPage(driver).checkout();`.
* It is better to create just one instance of the Page in the beginning and maintain it throughout the program execution. Having one instance of the
  page objects is fine in this case because we are not manipulating the page variables and methods, rather we are only using it.
* To achieve this, we will create the class `PageFactoryManager` and initialize the page objects as static because we need to reuse and maintain them
  throughout program execution.

````java
public class PageFactoryManager {
    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    public static StorePage getStorePage(WebDriver driver) {
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver) {
        return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
    }
}
````

* Now in the step definitions, we can directly call the static methods of `PageFactoryManager` to create the new instance or return already created
  instance of the page objects. We can also get rid of the driver since we are not using it in step definition class.

````java
public class CartStepDefinitions {
    private final CartPage cartPage;

    public CartStepDefinitions(TestContext context) {
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        cartPage.checkout();
    }
}
````

---

### Framework - API Integration using RestAssured

* We are creating the application state through UI by adding product to the cart, and navigating to the view cart Link by button click. **Selenium
  should not be used to prepare a test case**. All repetitive actions and preparations for a test case, should be done through other methods.
* [Generating application state](https://www.selenium.dev/documentation/test_practices/encouraged/generating_application_state/)
* We use [Rest Assured](https://rest-assured.io/) to generate the application state. Add the rest
  assured [Maven dependency](https://mvnrepository.com/artifact/io.rest-assured/rest-assured) to your `POM`
* `CookieUtils` class will be used to convert the rest assured cookies to the Selenium cookies.
* Now we need to create a domain object of `Cookies` that will contain the getter and setter for rest-assured cookies and a method to inject the
  selenium cookies to browser. This method utilizes the `CookieUtils` and get the list of selenium cookies and then iterate over them and add them to
  the browser with `driver.manage().addCookie(cookie);` command.
* The `SpecBuilder` class under the package `apis` will hold the `RequestSpecification` and `ResponseSpecification`. Basically the common things that
  we send as
  part of the API Request. In this case we are setting the Base Url (read from configLoader), logging and building it. Similarity for
  the `ResponseSpecification`, we are
  logging the response, building it and returning the object. These methods will be used by get and post methods in `APIRequest` class to make API
  calls.
* The `ApiReuqest` under the package `apis` class will hold the reusable GET and POST methods. These methods are in the form of Given, When and Then.
* The `CartApi` under the package `apis` will set the cookies in its constructor and have the separate `getCookies()` method to fetch the cookies. It
  also has `addToCart(int productId, int quantity)` method to add product to the cart using API call from `ApiRequest` class `post` method. This
  method makes a call to the Endpoint `ADD_TO_CART("/?wc-ajax=add_to_cart")` defined in `constants.EndPoint`. In response, we are fetching all the
  cookies and setting it to the rest-assured `Cookies` object.
* In the `TestContext`, define the `Cookies` domain object as class variable, and in the constructor of TestContext, and initialize the cookies object
  and assign the `empty rest-assured Cookies` to our domain object Cookies because our scenario requires the empty cookies to be sent as part of API
  request.

````java
import framework.domainObjects.BillingDetails;
import framework.domainObjects.Cookies;
import org.openqa.selenium.WebDriver;

public class TestContext {

    public Cookies cookies;

    public TestContext() {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }
}
````

* Now in our step definition, instead of adding product to the cart via UI, we will make an API call.

````java
@And("I have a product in the cart")
public void iHaveAProductInTheCart(){
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi=new CartApi(context.cookies.getCookies());        //Initialize the CartAPI with empty rest assured cookies
        cartApi.addToCart(1215,1);                           //make post API and save the response and set the received rest-assured cookies to cookies class variable in CartAPI 
        context.cookies.setCookies(cartApi.getCookies());   //Fetch the cookies from CartAPI and set the TestContext Cookies domain object with it
        context.cookies.injectCookiesToBrowser(context.driver);     //injects selenium cookies to the browser. It calls the method from CookieUtils class to convert rest-assured cookies to the selenium cookies
        }
````

* Also, we need to now directly navigate to the checkout page, because the product has been added to the cart already.

````java
@And("I am on the checkout page")
public void iAmOnTheCheckoutPage(){
        //cartPage.checkout();
        checkoutPage.load(EndPoint.CHECKOUT.url);
        }
````

---

### Framework - Reports

#### HTML Reports

* The Cucumber Report can be generated by adding the `plugin = {"html:target/cucumber/cucumber.html"}` to the `@CucumberOptions` in JUnit or TestNG
  Runner.
* It will generate a cucumber.html report inside target/cucumber folder

  <img src="doc/cucumber-report-summary.png" alt="cucumber report summary" width="1632">
  <img src="doc/cucumber-report-scenarios.png" alt="cucumber report scenarios" width="1630">

#### Cucumber Cloud Reports

* You can Share your Cucumber Report with your team at https://reports.cucumber.io as indicated in terminal output

  <img src="doc/reports-terminal.png" alt="cucumber report terminal output" width="625">

* If you specify the above properties in `cucumber.properties`, then you will get the following terminal output:

  <img src="doc/cucumber-cloud-reports.png" alt="cucumber cloud report" width="827">

* You can also keep the reports forever if you login on Cucumber Reports with GitHub on the cloud report, and create a collection. This will give you
  a
  token`CUCUMBER_PUBLISH_TOKEN` that you can define as environment variable before running cucumber.

---

#### Cucumber Timeline Formatter

* For a **visual representation** of threads, add the **timeline report** using the `plugin` option of `CucumberOptions` annotation on a JUnit or
  TestNG runner.

````java
@CucumberOptions(plugin = {"timeline:<report folder>"})
````

* Below is a sample report when I run the tests in parallel on-demand on Chrome browser with maven
  command ` mvn clean install -D"browser=chrome" -D"ondemand=true" -D"scenariosInParallel=true" -PRegression`

<img src="doc/thread-timeline.JPG" alt="Cucumber Tests Timeline Formatter" width="1364">

* This report is available inside the report folder you put in the timeline plugin, and the report can be filtered with tags and scenarios.
* https://cucumber.io/docs/guides/parallel-execution/?lang=java#timeline-formatter

---

#### Extent Spark HTML and PDF Reports

##### Resources

* [GitHub grasshopper7 extentreports-cucumber7-adapter](https://github.com/grasshopper7/extentreports-cucumber7-adapter)
* [Cucumber-JVM 7 Report generation using ExtentReports Adapter plugin](https://ghchirp.online/3196/)
* [extent.properties](https://github.com/grasshopper7/cuke7-extent-adapter-report/blob/master/cuke7-extent-adapter-report/src/test/resources/extent.properties)
* [Extent Report 4](https://www.extentreports.com/docs/versions/4/java/cucumber4.html)
* [Cucumber4 Adapter for Extent Framework](https://github.com/extent-framework/extentreports-cucumber4-adapter)
* [Capture Screenshots on Failure](https://www.browserstack.com/guide/take-screenshot-for-failed-test-cases-in-cucumber)
* [Cucumber PDF Report](http://ghchirp.online/2224/)
* [GitHuBGenerating Extent reports for Cucumber-JVM version 7 using the extentreports-cucumber7-adapter plugin] (https://github.com/grasshopper7/cuke7-extent-adapter-report)

##### POM Dependency

* Add the following maven dependencies to your POM.xml
    * To add the Extent report library, add the following dependency
      script.[Extent Reports](https://mvnrepository.com/artifact/com.aventstack/extentreports/5.0.9)
  ````xml
  <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
  <dependency>
      <groupId>com.aventstack</groupId>
      <artifactId>extentreports</artifactId>
      <version>5.0.9</version>
  </dependency>
  ````
    * The latest version
      of [ExtentReports Cucumber7 Adapter](https://mvnrepository.com/artifact/tech.grasshopper/extentreports-cucumber7-adapter/1.9.2) dependency needs
      to be added to the POM, to work with ExtentReports version 5.
  ````xml
  <dependency>
     <groupId>tech.grasshopper</groupId>
     <artifactId>extentreports-cucumber7-adapter</artifactId>
     <version>1.9.2</version>
     <scope>test</scope>
  </dependency>
  ````

##### Plugin Configuration

* The extentreports-cucumber7-adapter plugin needs to be added to the CucumberOptions annotation of the runner.

````java
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
````

##### Report Activation

* First method of activating the report generation is to place `extent.properties` file in the `src/test/resources` folder

````properties
basefolder.name=test-output/ExtentReport
basefolder.datetimepattern=d-MMM-YY HH-mm-ss
extent.reporter.spark.start=true
extent.reporter.spark.out=SparkReport/Spark.html
````

* The test report will be generated in a subfolder `SparkReport/Spark.html` inside the parent folder`test-output/ExtentReport d-MMM-YY HH-mm-ss`. The
  **datetimepattern** property ensures that for each run, a new folder is created for the ExtentReport so the old report does not get replaced.
  The `basefolder`optional and creates the report in base folder name with date time
  format. [Read complete properties](https://github.com/grasshopper7/cuke7-extent-adapter-report/blob/master/cuke7-extent-adapter-report/src/test/resources/extent.properties)

##### Report Attachments

* To add attachments, like screen images, two settings need to be added to the extent.properties. First property, named `screenshot.dir`, is the
  directory where the attachments are stored. Second is `screenshot.rel.path`, which is the relative path from the report file to the screenshot
  directory. The screenshot gets available inside the folder where you have directed it in the extent.properties file.

````properties
extent.reporter.spark.out=SparkReport/Spark.html
screenshot.dir=SparkReport/screenshots
screenshot.rel.path=./screenshots/
````

* Attach a screenshot to the failed scenario by adding a new `@AfterStep` Hook, later Extent report will read the screenshot attached to scenario to
  display it in report.

````java
    @AfterStep
public void AddScreenshot(Scenario scenario)throws IOException
        {
        if(scenario.isFailed())
        {
        //screenshot
        File sourcePath=((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
        byte[]fileContent=FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent,"image/png","image");
        }
        }
````

* To attach the screenshot to scenario, it needs to be converted into Byte format for which we can use FileUtils utility
  from [comms-io](https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0) maven plugin.
* Since so far, we do not have any failing scenario, so let's add a new scenario in the `add_to_cart.feature` that fails and screenshot gets captured
  and attached to report.

````gherkin
Scenario: Add product from Store that does not exist

This scenario fails because it was written to capture the screenshot on failure and attach to Extent Report.
It fails in the second step because the Invalid Product does not exist on the store page, so the scenario fails to add it to cart

Given I'm on the Store Page
When I add a "Invalid Product" to the cart
Then I should see 1 "Invalid Product" in the cart
````

* Now run the TestNG runner, and the extent report will get generated in `test-output/ExtentReport d-MMM-YY HH-mm-ss/SparkReport/Spark.html` and the
  screenshots will be stored in test-output/ExtentReport d-MMM-YY HH-mm-ss/SparkReport/screenshots` folder and also attached to failed scenario in
  report.

<img src="doc/extent-report-folder.png" alt="extent report folder" width="339">

<img src="doc/extent-report-summary.png" alt="extent report summary" width="1200">


<img src="doc/extent-report-tests.png" alt="extent report tests" width="1200">


<img src="doc/extent-report-exception.png" alt="extent report exception" width="1200">

> if you get Fatal error compiling: `java.lang.IllegalAccessError: class lombok.javac.apt.LombokProcessor`, then add the lombok maven dependency in
> your POM

* To change settings like theme, title, encoding, offlineMode etc, a separate xml file
  eg. [html-config.xml](https://github.com/grasshopper7/cuke5-extent-adapter-report/blob/master/cuke5-extent-adapter-report/src/test/resources/spark-config.xml)
  is required. The location for this file eg.
  html report needs to be mentioned as value for the key `extent.reporter.html.config`.

````properties
extent.reporter.html.config=src/test/resources/html-config.xml
````

* It is now possible to add environment or system info properties in the extent.properties or pass them in the maven command line. These key value
  pairs are displayed in the ‘Environment’ section of the dashboard page. The key string should begin with the prefix – `systeminfo.`. Be careful of
  the dot at the end. These can be added to the extent.properties as following – `systeminfo.os=windows`.

##### Extent PDF Report

* [Cucumber PDF Report] (https://ghchirp.online/2224/)
* We will be using Cucumber-JVM 7 Report generation using ExtentReports Adapter plugin.
* The report contains of six sections – dashboard, summary, tags, features, scenarios and detailed sections.
* Now that you have already completed the Extent Spark reporter plugin integration with Cucumber, you can enable the generation of PDF reports by
  adding following two lines in your extent.properties

````properties
extent.reporter.pdf.start=true
extent.reporter.pdf.out=PdfReport/ExtentPdf.pdf
````

* The Cucumber JSON report is required for PDF to be generated, so add the `"json:target/cucumber/cucumber.json"` as `plugin` in `@CucumberOptions`
  annotation in your Test Runner.
* The report settings can be used to toggle on and off optional report sections, change report title, text color for various data, background color
  and other options. The settings are stored in a YAML file with the name `pdf-config.yaml`, located in the src/test/resources folder of the project.
  If the file is not present or any settings are not set, the default values are used. To change the default values, add
  a [pdf-config.yaml file](https://github.com/grasshopper7/cuke7-extent-adapter-report/blob/master/cuke7-extent-adapter-report/src/test/resources/pdf-config1.yaml)
  in the `src/test/resources` folder of the project with only the settings with new values.

* <img src="doc/pdf-report-dashboard.JPG" alt="extent report PDF dashboard" width="1569">
* <img src="doc/pdf-report-summary.JPG" alt="extent report PDF dashboard" width="885">
* <img src="doc/pdf-report-details.JPG" alt="extent report PDF dashboard" width="910">

> Do not use this report if the setup contains multiple runners as concurrent modification of the same PDF will result in errors. Better solution
> would be use a Maven plugin for [creating just the PDF report](https://ghchirp.online/2224/) or the complete ExtentReport
> suite(https://ghchirp.online/2114/).

---

#### Allure Reports

##### Scoop Commandline and Allure Installation for Windows

* Allure Report requires a web server to view the results. If we directly open the index.html file, we won't see any reports. To install Allure,
  first download and install Scoop and then install allure using it.
* [Scoop](https://scoop.sh/) is a command-line package manager for Windows. Installing programs with Scoops removes the graphical interface and
  eliminates the permission pop-ups. Scoop automatically finds and installs the dependencies for the program you just installed.
    * Launch Powershell and enter following command `Set-ExecutionPolicy RemoteSigned -scope CurrentUser`.This allows the current user to run scripts
      which have originated from a remote source.
    * Execute `scoop install allure` in the Powershell. **iwr** is short for Invoke Web Request. This
      command starts a session to access something on the internet. Altogether, this command line will download and install Scoop.
      <img src="doc/scoop-allure-install.JPG" alt="scoop allure installation" width="715">
* Refer to following resources:
    * [How to Install Scoop in Windows](https://www.makeuseof.com/windows-install-scoop/)
    * [How to Install Scoop on Windows 10](https://www.youtube.com/watch?app=desktop&v=p9-wnf5RWC8)
    * [Install Scoop command line package manager on Windows OS](https://www.programsbuzz.com/article/install-scoop-command-line-package-manager-windows-os)
    * [How to Install Allure in Windows](https://www.programsbuzz.com/article/how-install-allure-windows)

##### Cucumber Allure Report

* [Cucumber JVM Allure Documentation](https://docs.qameta.io/allure/#_cucumber_jvm)
* Add following dependency to your POM.xml. In our case, we are using Cucumber7, so added allure-cucumber7-jvm dependency.

````xml
<!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-cucumber7-jvm -->
<dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-cucumber7-jvm</artifactId>
    <version>2.20.1</version>
</dependency>
````

* Later, the project might throw an error at the time of compilation such as:
  _[ERROR] Failures:
  [ERROR]   BaseTestNGRunnerTest>AbstractTestNGCucumberTests.setUpClass:27 » NoSuchMethod 'java.util.stream.Stream
  io.cucumber.gherkin.GherkinParser.parse(java.lang.String, java.io.InputStream)'_
* The above [error](https://stackoverflow.com/a/61095109) occurs because the allure somehow imports the Gherkin dependencies from **info.cukes**
  instead of **io.cucumber**, so add the following dependency in POM.

````xml
<!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>gherkin</artifactId>
    <version>26.0.1</version>
</dependency>
````

* [what is the difference between io.cucumber and info.cukes](https://stackoverflow.com/a/50212219)
* Add the following plulgin to Test Runner class in @CucumberOptions annotation:

````java
plugin={"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
````

* Location of allure-results directory can be configured by adding the `allure.properties` in **src/test/resources folder**

````properties
allure.results.directory=target/allure-results
allure.link.issue.pattern=https://example.org/browse/{}
allure.link.tms.pattern=https://example.org/browse/{}
````

* Then execute `mvn clean test` goal. After tests executed allure JSON files will be placed in **target/allure-results** directory.
* Navigate to the project build directory **target** and type `allure serve allure-results` which will display the allure report in browser window.
* [Allure  Report Generation](https://docs.qameta.io/allure/#_report_generation)
* The report will look like below

##### Allure Environment Variables

* According to the allure report [documentation](https://docs.qameta.io/allure/#_environment), to add information to Environment widget just create
  environment.properties (or environment.xml) file to allure-results directory before report generation.
* Since allure-results are being generated in the **target/allure-results** directory as configured in the `allure.properties` so
  the `environment.properties` file has to be created at that location.
* The `environment.properties` file need to be created programmatically. Instead of hard-coding environment values, it is is better to read the system
  environment variable values and generate the file dynamically. This file will also contain the POM dependency versions of Selenium and Cucumber.
    * There are three ways to read the Maven properties, I will discuss them both below:
        * First is to use [Maven resource plugin - copy resources](https://maven.apache.org/plugins/maven-resources-plugin/) that copies the resources
          to
          specified output directory.
            * [Allure: Environment file in target folder](https://stackoverflow.com/a/31479278)
        * Second way is to use [Maven Filtering](https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html). That will cause Maven
          to
          copy that file into your output classes and translate the resource during that copy, interpreting the property.
            * [Retrieve version from maven pom.xml in code](https://stackoverflow.com/a/3697482)
            * [Getting maven project version and artifact ID from pom](https://stackoverflow.com/a/26573884)
            * [How to get the pom properties at runtime?](https://igorski.co/how-to-get-the-pom-properties-at-runtime/)
        * Third way is to use the [Apache maven model](https://mvnrepository.com/artifact/org.apache.maven/maven-model) that has been used in this
          project:
            * [Retrieve version from maven pom.xml in code](https://stackoverflow.com/a/41791885)
            * [Access maven properties defined in the pom](https://stackoverflow.com/a/11500619)
                * Add the following Maven dependency to project
              ````xml
              <!-- https://mvnrepository.com/artifact/org.apache.maven/maven-model -->
              <dependency>
                  <groupId>org.apache.maven</groupId>
                  <artifactId>maven-model</artifactId>
                  <version>3.8.6</version>
              </dependency>
              ````
                * Create a new method in **PropertyUtils** class that will read the POM.xml and returns the Properties defined inside it:
              ````java
              public static Properties mavenPropsLoader(String filePath) throws IOException, XmlPullParserException {
                MavenXpp3Reader reader = new MavenXpp3Reader();
                Model model = reader.read(new FileReader(filePath));
                return model.getProperties();
              }
              ````
                * Now define a method inside your Hooks with Cucumber @AfterAll annotation that will load the maven properties as well as system
                  properties
                  and then generate `environment.properties` file dynamically at run-time with this information:
              ````java
              @AfterAll
              public static void setAllureEnvVariables() throws IOException, XmlPullParserException {
                //Instantiating the properties file
                Properties props = new Properties();
                //Populating the properties file
                props.put("OS", System.getProperty("os.name"));
                props.put("Browser", System.getProperty("browser", "Chrome"));
                props.put("Environment", System.getProperty("env", "STAGE"));
                props.put("Java version", System.getProperty("java.version"));
    
                //Loading the Maven Properties from POM.xml
                final Properties mavenProps = PropertyUtils.mavenPropsLoader("pom.xml");
                props.put("Selenium version", mavenProps.getProperty("selenium.java.version"));
                props.put("Cucumber version", mavenProps.getProperty("cucumber.java.version"));
    
                //Instantiating the FileInputStream for output file
                try (FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "\\target\\allure-results\\environment.properties")) {
                    //Storing the properties file
                    props.store(fileOutputStream, "Allure Report environment variables");
                }
    
              }
              ````
        * It is important that you define the `selenium.java.version` and `cucumber.java.version` in your POM.xml properties so they can be read and
          written into Allure.

##### Allure logs and Screenshot attachment

* The logging and screenshot attachment in Allure report is similar to the Extent Reports so now new code need to be added.
* For logging the browser information, following code is added to the method annotated with @Before in Hooks.

````java
    Capabilities cap=((RemoteWebDriver)context.driver).getCapabilities();

        //Logging will be available in Extent and Allure Report
        scenario.log("Webdriver initialized for browser: "+cap.getBrowserName()+" version "+cap.getBrowserVersion());
````

* For screenshot attachment, the following code is added the method annotated with @AfterStep in Hooks.

````java
    @AfterStep
public void AddScreenshot(Scenario scenario)throws IOException{
        if(scenario.isFailed()){
//screenshot
            /*File sourcePath= 	((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
            byte[] screenshot = FileUtils.readFileToByteArray(sourcePath);*/
final byte[]screenshot=((TakesScreenshot)context.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","image");
        }
        }
````

* This is how the logs and screenshot are visible in Allure Reports
* <img src="doc/allure-logs-screenshot.png" alt="Allure logs" width="874">

##### Allure Links

* [Allure links](https://docs.qameta.io/allure/#_links_4)
* To pass issues to report, just add `@issue=<ISSUE-NUMBER> `on top of Scenario on Feature in your .feature file.
* To pass TMS links to report, just add `@tmsLink=<TEST-CASE-ID>` on top of Scenario on Feature in your .feature file.

> do not forget to configure allure properties with link patterns.

##### Allure Severity

* [Allure severity](https://docs.qameta.io/allure/#_severity_4)
* To set severity, add `@severity=blocker` on top of Scenario on Feature in your .feature file.
* If severity has wrong value it will be forced to normal (default).

##### Allure Test Markers

* [Allure test markers](https://docs.qameta.io/allure/#_test_markers)
* Every Feature or Scenario can be annotated by following tags: `@flaky`, `@muted`, `@known`

#### Allure Excecutors

* The Executor is display if you have an `executor.json` file in your **allure-results** folder when you generate your report.
* This file is usually generated by your builder, for example Jenkins with the plugin allure.
* Typical json configurations looks like this

````json
{
  "name": "Jenkins",
  "type": "jenkins",
  "url": "http://example.org",
  "buildOrder": 13,
  "buildName": "allure-report_deploy#13",
  "buildUrl": "http://example.org/build#13",
  "reportUrl": "http://example.org/build#13/AllureReport",
  "reportName": "Demo allure report"
}
````

##### Allure report

* Run the tests with `mvn clean test -Dbrowser=chrome -Denv=STAGE -Dcucumber.filter.tags=@regression` and view the results
  with `allure serve allure-results` from target folder inside project.
* Read the [Allure Report Structure](https://docs.qameta.io/allure/#_report_structure) to understand the dashboard widgets and tabs.
* <img src="doc/allure-dashboard.JPG" alt="allure report dashboard" width="1901">
* <img src="doc/allure-categories.JPG" alt="allure report categories" width="1910">
* <img src="doc/allure-suites.JPG" alt="allure report suites" width="1904">
* <img src="doc/allure-graphs.png" alt="allure report graphs" width="1920">
* <img src="doc/allure-timeline.JPG" alt="allure report timeline" width="1892">
* <img src="doc/allure-behaviors.JPG" alt="allure report behaviors" width="1908">
* <img src="doc/allure-packages.JPG" alt="allure report packages" width="1901">

##### Issues in Allure Report

* [No Support for Allure Cucumber Jvm Report for Cross browser and Parallel execution](https://stackoverflow.com/questions/58417607/allure-cucumber-jvm-report-for-cross-browser-and-parallel-execution)
    * If the test suite has multiple tests with same Runner classes running on different browsers, then the test results will show for only one of the
      browser and remaining tests will get added to the Retries tab. This happens because the feature and scenario names are same.
    * [Allure2 report do NOT support for cross browser testing - GitHub Issue](https://github.com/allure-framework/allure-java/issues/381)
    * [If classes with the same names are used in the tests run by TestNG, then only the last result will be recorded. - GitHub issue](https://github.com/allure-framework/allure-java/issues/632)
    * [TestNG - Mutiple Test are there in the xml file ..TC count not displayed in the report properly -GitHub issue](https://github.com/allure-framework/allure-java/issues/576)
* [Using @flaky or @muted or @known tags in Cucumber Scenarios or Feature doesn't reflect in Allure report - GitHub Issue](https://github.com/allure-framework/allure2/issues/1611)
    * The scenarios or features marked as @flaky does not show up in the test report with corresponding marker.

---

#### Master Thought Cucumber Reports

* This is a Java report publisher primarily created to publish [cucumber reports](https://github.com/damianszczepanik/cucumber-reporting) on the
  Jenkins build server. It publishes pretty html reports with charts showing the results of cucumber runs. It has been split out into a standalone
  package, so it can be used for Jenkins and maven command line as well as any other packaging that might be useful. Generated report has no
  dependency so can be viewed offline.
* This project allows you to publish the results of a cucumber run as pretty html reports. In order for this to work you must generate a cucumber json
  report. The project converts the json report into an overview html linking to separate feature files with stats and results.
* Add a [maven dependency](https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting) to your project

````xml
<!-- https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting -->
<dependency>
    <groupId>net.masterthought</groupId>
    <artifactId>cucumber-reporting</artifactId>
    <version>5.7.4</version>
</dependency>
````

* Add `Masterthought` plugin in pom.xml. In the plugin section, we can configure details like project name, output directory, build version. Note that
  since our generate json report is saved as `cucumber.json`, therefore we specified the name pattern as `<param>**/cucumber.json</param>`.

````xml

<plugin>
    <groupId>net.masterthought</groupId>
    <artifactId>maven-cucumber-reporting</artifactId>
    <version>5.7.4</version>
    <executions>
        <execution>
            <id>execution</id>
            <phase>test</phase>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <projectName>cucumberReporting</projectName>
                <skip>false</skip>
                <outputDirectory>${project.build.directory}</outputDirectory>
                <inputDirectory>${project.build.directory}</inputDirectory>
                <jsonFiles>
                    <param>**/cucumber.json</param>
                </jsonFiles>
                <mergeFeaturesById>false</mergeFeaturesById>
                <mergeFeaturesWithRetest>false</mergeFeaturesWithRetest>
                <checkBuildResult>false</checkBuildResult>
            </configuration>
        </execution>
    </executions>
</plugin>
````

* If the build is failed due to failing scenario then the report will not get generated. To overcome
  this [issue](https://stackoverflow.com/a/47904940), Add the following configuration to the sure fire plugin. It will not stop the maven execution
  after the failure. Then it will generate the report.`<testFailureIgnore>true</testFailureIgnore>`
* as given below with your existing configuration.

````xml

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0-M7</version>
    <configuration>
        <testFailureIgnore>true</testFailureIgnore>
    </configuration>
</plugin>
````

* It will generate the report but the build will mark as BUILD SUCCESS. To solve this [issue](https://stackoverflow.com/a/52206782), add the
  following flag to your plugin configuration.

````xml

<checkBuildResult>true</checkBuildResult>

        <!-- Set true to fail build on test failures -->
        <!-- Set false to pass build on test failures -->
````

* You need to set in the configuration tag as below:

````xml

<configuration>
    <projectName>cucumberReporting</projectName>
    <skip>false</skip>
    <outputDirectory>${project.build.directory}</outputDirectory>
    <inputDirectory>${project.build.directory}</inputDirectory>
    <jsonFiles>
        <param>**/cucumber.json</param>
    </jsonFiles>
    <mergeFeaturesById>false</mergeFeaturesById>
    <mergeFeaturesWithRetest>false</mergeFeaturesWithRetest>
    <checkBuildResult>true</checkBuildResult>
</configuration>
````

* Execute project using `mvn clean test -D"cucumber.filter.tags=@regression"` command. Console will show the status of report generation.
* <img src="doc/masterthought-console.png" alt="masterthought cucumber report console output" width="984">

* Refresh your project and check inside `target\cucumber-html-reports` that report generated with name feature-overview.
* <img src="doc/masterthought-features.png" alt="masterthought cucumber report features" width="1885">
* <img src="doc/masterthought-scenario-error.png" alt="masterthought cucumber report scenario error" width="1642">
* <img src="doc/masterthought-scenario-attachment.png" alt="masterthought cucumber report scenario attachment" width="1590">

* [Maven mojo](https://github.com/damianszczepanik/maven-cucumber-reporting) for the cucumber-reporting - put this into your pom.xml and run mvn
  verify so cucumber reports will be generated in `target/cucumber-html-reports`. I changed the execution phase to test, so I can generate reports and
  run tests with `mvn clean test`.
* An external [plugin](https://gitlab.com/jamietanna/cucumber-reporting-plugin) is also available that wraps `damianszczepanik/cucumber-reporting` in
  a Cucumber plug-in so it can be used directly when running Cucumber.
* It delegates to the CucumberJsonReporter on-the-fly and finally passes the JSON `todamianszczepanik/cucumber-reporting`.
* https://gitlab.com/jamietanna/cucumber-reporting-plugin
* https://mvnrepository.com/artifact/me.jvt.cucumber/reporting-plugin

---

### Framework - Rerun Failed Scenarios

* Dealing with Test Flakiness is often challenging and the test framework should be robust to it. Cucumber provides a rerun
  plugin option in the Runner class that generates a file which contains the information about the failed tests.
* Add `rerun:target/failed_scenarios.txt` in the plugin. The runner file will look like this:

````java

@CucumberOptions(
        features = "src/test/resources/framework/features",
        glue = {"framework"},
        plugin = {
                "html:target/cucumber/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
)
public class BaseTestNGRunnerTest extends AbstractTestNGCucumberTests {
}
````

* In case of execution failure, it will generate a text file in the target folder. This text file will contain the information on the scenarios that
  get failed.
* `failed_scenarios.txt` will contain the path of the feature file and line number for the scenarios that failed. Here it tells us the path to failing
  scenario and the line number next to it.

````text
file:src/test/resources/framework/features/add_to_cart.feature:13
````

* The next step is to run failed scenarios present in the text file. For this purpose, we have to create a seprate test runner and give the path to
  failed_scenario.txt in features option like `features = "@target/failed_scenarios.txt"`

````java

@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = {"framework"},
        plugin = {
                "html:target/cucumber/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
)
public class FailedRunnerTest extends AbstractTestNGCucumberTests {

}
````

* Now we can simply run the FailedRun class after automation suite execution in case of test failures. It will execute only the failed scenarios and
  update the text file again.

---

### Framework - Cross Browser Parallel Testing

* We will use TestNG suite XML files. This allows flexible configuration of the tests to be run. These files are created in the normal way, and then
  added to the Surefire Plugin configuration.
* Create a folder in your root directory test-suites and inside the folder create a file smoke-tests.xml. We will create a file based on testng.xml
  and add our tests to it. Since we want to execute our tests parallelly in both browsers, we will create two tests and add a browser parameter to
  each of the test. The test suite will have attribute parallel set to tests, which means that both the tests will run in parallel. The class tag
  should contain your Test runner in the form of package.class. My test runner is under the packages framework and runners and is named
  BaseTestNGRunnerTest therefore I have written it like this `framework.runners.BaseTestNGRunnerTest`

````xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Smoke Test Suite" thread-count="10" parallel="tests">
    <test name="Chrome Browser Test">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

    <test name="Firefox Browser Test">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->
````

* The next step you have to do is to create a maven build profile in your POM.xml, copy and paste the following code into your POM.xml. The
  tag <suiteXmlFiles> should contain the path to your TestNG suit XML file. Read more about using Maven build profiles here:

````xml

<profiles>
    <profile>
        <id>Smoke</id>   <!--To tun this profile through command line, mvn test -PSmoke-->
        <build>
            <pluginManagement>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>3.0.0-M7</version>
                        <configuration>
                            <suiteXmlFiles>
                                <suiteXmlFile>test-suites/smoke-tests.xml</suiteXmlFile>
                            </suiteXmlFiles>
                        </configuration>
                    </plugin>

                </plugins>
            </pluginManagement>
        </build>
    </profile>
</profiles>
````

* Now you can run this profile simply with the following command. Give the id of thr profile after -P, this will run the tests specified in your suite
  xml file with `mvn clean test -PSmoke`.
* The first part of the equation is already done. Now you have to pass the TestNG suite XML file browser parameter to the tests and initialize the
  WebDriver based on it. Previously we were receiving the browser parameter through maven command line or jenkins, and if no browser is set as system
  variable then we were setting it as chrome in our Hooks.
* Fortunately TestNG gives us a way to access the parameters from suite XML files. We will read this parameter and if it is set we will set it as
  context browser variable, else we will use the browser parameter from system variable. Finally we will pass this browser context variable to
  initializeDriver() method.

````java
@Before
public void setup(Scenario scenario){

        //Reads the browser parameter from TestNG suite xml file
        String browserParam=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");

        //Initializes the browser driver in order of following preferences
        //First it looks for the browserParam which is coming from TestNG suite xml files
        //Then it looks for the system variables from the maven command line or Jenkins
        //Lastly it sets the chrome as default browser for driver initialization

        context.browser=browserParam!=null?browserParam:System.getProperty("browser","chrome");

        driver=DriverFactory.initializeDriver(context.browser);
        context.driver=driver;
        }
````

* with command `mvn clean test -PSmoke` will run the following test suite in parallel on firefox and chrome. I have 2 @smoke scenarios in cart
  feature, and 1 @smoke scenario in order feature so in total 3 scenarios for each test (browser). The above command will opens the 3 browser
  instances for Chrome, and 3 browser instances for FF and run all 6 tests in parallel. The thread-count property in testng suite xml controls how
  many browser instances will get opened. This can also be controlled through command line.
* If you wish to control the execution of tests running in parallel, then TestNG provides a way to pass this as command line argument that will
  override the parallel attribute in suite xml:
  `mvn clean install -D"parallel=false" -PSmoke`
* This will run the tests for both of the browsers sequentially, but the tests belonging to single browser will be run in parallel because this is how
  they are configured in suite xml.
* [TestNG-Parallel attribute](https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#parallel)
* [TestNG-thread-count attribute](https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#threadcount)
* To achieve fine grain control of running scenarios in parallel or sequentially through maven CLI can bve achieved by implementing a custom
  annotation
  transformer listener that will transform the parallel attribute of @DataProvider annotation to the value provided from CLI.
* I created a custom Listener that will read the scenariosInParallel system property and set it to `@DataProvider` annotation.

````java
package framework.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IDataProviderAnnotation;

import java.lang.reflect.Method;

public class ScenariosParallelTransformer implements IAnnotationTransformer {

    @Override
    public void transform(IDataProviderAnnotation annotation, Method method) {
        boolean runInParallel = Boolean.getBoolean("scenariosInParallel");
        if (runInParallel) {
            annotation.setParallel(true);
        }
    }
}
````

* [IDataProviderAnnotation](https://github.com/cbeust/testng/blob/master/testng-core-api/src/main/java/org/testng/annotations/IDataProviderAnnotation.java)
* [IAnnotationTransformer](https://github.com/cbeust/testng/blob/master/testng-core-api/src/main/java/org/testng/IAnnotationTransformer.java)
* [Set (parallel = false/true) from command line for DataProvider in scenarios method AbstractTestNGCucumberTests](https://stackoverflow.com/a/73181904)
* Now in the test-suite we just need to add this listener before our tests:

````xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Smoke Test Suite" thread-count="10" parallel="tests">
    <listeners>
        <listener class-name="framework.listeners.ScenariosParallelTransformer"/>
    </listeners>
    <test name="Chrome Browser Test">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

    <test name="Firefox Browser Test">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->
````

* Now if you want to run the Browsers In Parallel then set `-Dparallel=tests`, and if not, then set -`Dparallel=false`
* Run the scenarios in feature files in Parallel then set `-DscenariosInParallel=true`, and if not then you can skp this parameter.
* So now you can remove the below snippet from Test Runner because you have the control of running scenarios in parallel via CLI therefore it must be
  removed:

````java
@Override
@DataProvider(parallel = true)
public Object[][]scenarios(){
        return super.scenarios();
        }
````

* To summarize:
    * `mvn clean install -D"parallel=tests" -D"scenariosInParallel=true" -PSmoke` This will execute the tests in parallel on both browsers, but not
      the scenarios in feature files.
    * `mvn clean install -D"parallel=false" -D"scenariosInParallel=true" -PSmoke` This will execute sequentially first the tests for Chrome browser
      and then the tests for firefox browser, but the scenarios for each browser will run parallel.
    * `mvn clean install -D"parallel=false" -PSmoke` This will execute the tests for browsers as well as scenarios for each test sequentially.
    * The default `mvn clean install -PSmoke` will run the tests in parallel for both browsers, but each browser will execute scenarios sequentially.

> Default Cucumber report will not work with this configuration and will only show the results of last test runner.

* Use Extent Spark Reports for viewing the test results. There is no additional configuration settings required for parallel execution with a single
  or multiple runners. This is also true for single threaded multiple runner execution. The complete test report can be viewed in console or Extent
  Spark report.
* Read More:
    * https://ghchirp.online/3196/
    * https://ghchirp.online/466/

> PDF report generation is not supported for multiple runners due to concurrent modification of the pdf file. This is mentioned in the
> article https://ghchirp.online/2098/, look for the “PDF Extent Report”. You should use the report generation plugin using JSON
> – https://ghchirp.online/2114/

---

### Framework - On Demand Browser Testing

* It is indeed possible to run the tests on-demand only on Chrome or only on FF, without updating the TestNG.xml. **TestNG has the capability built
  into it wherein it also queries the System properties (JVM arguments) and tries to read the values of parameters whose name matches with what was
  given in the suite xml file.**
* Create a new TestNG suite xml for example for regression tests

````xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Regression Test Suite" thread-count="10" parallel="tests">
    <test name="Cross Browser Tests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->
````

* As you can see, I am passing the browser parameter as firefox here, so if you do not pass any any JVM arggument from maven commands, then the tests
  will run on firefox. Let's say we want to pass chrome as browser parameter: `mvn clean install -D"browser=chrome" -D"ondemand=true" -PRegression
  `
* Now we need to capture this JVM argument in our TestNG Hook (not the Cucumber hook), so I declared a static class variable browser and used TestNG
  @BeforeTest Hook inside my runner. I also tried initially with ThreadLocal but the Cucumber Hook @Before and Runner @BeforeTest both were getting
  run in different threads, so ThreadLocal was null therefore I chose to use static keyword. Since in on-demand broswer testing, the static browser is
  fixed so it is fine for our use case.

````java
public class BaseTestNGRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    public static String browser;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browser) {
        BaseTestNGRunnerTest.browser = browser;
    }
}
````

* The next step now comes is to use this browser parameter in our Cucumber Hook where we are initializing webdriver. Previously I was reading this
  browser parameter from my testng suite xml and setting it as a `context.browser` in Cucumber @Before Hook.
* Now we have the additional requirement to check if any browser parameter is set as TestNG parameter in command line argument and if it is provided
  then we will not read the browser parameter from suite xml file. Moreover, I added an extra check with a command line argument ondemand that will
  ensure to only read the static browser variable the tests are to be executed on single browser, otherwise it will ignore it and read the browser
  value from suite xml in case of cross browser testing.

````java
@Before
public void setup(Scenario scenario){

//Reads the browser static value from @BeforeTest that was set as command line argument in TestNG Parameter
        if(BaseTestNGRunnerTest.browser!=null&&Objects.equals(System.getProperty("ondemand"),"true")){
        context.browser=BaseTestNGRunnerTest.browser;
        };

        //Reads the browser parameter from TestNG suite xml file
        if(context.browser==null){
        String browserParam=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        context.browser=browserParam!=null?browserParam:System.getProperty("browser","chrome");
        }

        driver=DriverFactory.initializeDriver(context.browser);
        context.driver=driver;

        }
````

* Thats's it, now if you want to run the tests on-damand only on FireFox or Chrome, give following command
    * `mvn clean install -Dbrowser=firefox -Dondemand=true -PRegression`
    * `mvn clean install -Dbrowser=chrome -Dondemand=true -PRegression`
* If you want to run cross browser tests in parallel on both FireFox and Chrome, then give following command
  *` mvn clean install -PSmoke`
* Alternatively you can just provide the command line arguments to run tests without any specifc profile
    * `mvn clean test -Denv=STAGE -Dbrowser=chrome -Dcucumber.filter.tags=@smoke`
* or just give this command since browser Param is set @Optional
    * `mvn clean test`

* If you want more control over parallelism and instead only want to run features in parallel instead of scenarios, then one way is to create a
  multiple runners classes for features and set the parallel attribute to classes. This will then run all the features in parallel and scenarios
  sequentially.
*

---

### Framework - Cucumber cross-platform parallel browser execution using Selenium Grid

* Create a new test suite and add its profile in maven POM.xml. The test suite allows to run smoke tests parallel on different browsers and platforms:

````xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Smoke Test Suite - Distributed Grid" thread-count="10" parallel="tests">
    <listeners>
        <listener class-name="framework.listeners.ScenariosParallelTransformer"/>
    </listeners>
    <test name="Google Chrome Browser Test">
        <parameter name="browser" value="chrome"/>
        <parameter name="browserVersion" value="108"/>
        <parameter name="platformName" value="windows 10"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

    <test name="Mozilla Firefox Browser Test">
        <parameter name="browser" value="firefox"/>
        <parameter name="browserVersion" value="108"/>
        <parameter name="platformName" value="windows 10"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

    <test name="Microsoft Edge Browser Test">
        <parameter name="browser" value="edge"/>
        <parameter name="browserVersion" value="108"/>
        <parameter name="platformName" value="windows 10"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

    <!--<test  name="Safari Browser Test">
        <parameter name="browser" value="safari"/>
        <parameter name="browserVersion" value="108"/>
        <parameter name="platformName" value="mac"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test>--> <!-- Test -->
</suite> <!-- Suite -->
````

* Create the `grid.properties` file in **src\test\resources\framework\properties** directory. This file serves the primary purpose of storing grid
  properties e.g. HUB URL. Add your IP address against the `hubUrl` property and the default port is 4444. Change the port also if you wish to start
  the hub on another port.

````properties
hubURL=http://192.168.50.152:4444/
````

* The Grid support is to be integrarted along with the existing framework, and should be able to control executions via maven commandline. Therefore,
  a system property `gridMode` must be sent to distinguish between tests running locally or remote. Previously the driver was getting initialized
  localy with following command in Hooks `driver = DriverFactory.initializeDriver(context.browser);` which is now changed to:

````java
//Initializes the remote webdriver for Selenium Grid distributed parallel testing
//Make sure to pass the maven command line argument -DgridMode e.g.  mvn clean test -D"gridMode=true" -PsmokeDistributed
//Start the selenium hub and nodes on machines separately before running the tests on remote webdriver
if(Objects.equals(System.getProperty("gridMode","false"),"true")){
        String browserVersion=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserVersion");
        String platform=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformName");
        try{
        driver=DriverFactory.initializeRemoteDriver(context.browser,browserVersion,platform);
        }catch(MalformedURLException e){
        e.printStackTrace();
        throw new RuntimeException("unable to initialize Remote Webdriver for "+context.browser+" version: "+browserVersion+" Platform: "+platform+" "+e.getMessage());
        }
        }
        else{
        driver=DriverFactory.initializeDriver(context.browser);
        }
````

* A new method `initializeRemoteDriver` is defined in the DriverFactory class that will initialize remote webdriver with browser options. We are using
  Browser options which is the latest recommendation from selenium. Use of Desired capabilities is deprecated now.
* The [Remote Webdriver Options](https://www.selenium.dev/documentation/webdriver/drivers/remote_webdriver/) are described in selenium documentation.
* [Browsers custome capabilities](https://www.selenium.dev/documentation/webdriver/browsers/)
* [Firefox Options](https://developer.mozilla.org/en-US/docs/Web/WebDriver/Capabilities/firefoxOptions)
* [Chrome Options](https://chromedriver.chromium.org/capabilities)
* [Edge Options](https://learn.microsoft.com/en-us/microsoft-edge/webdriver-chromium/capabilities-edge-options)

````java
    /**
 * This method initializes the remote webdriver with browser capabilities defined in Test Suite parameters.
 * If the tests are to be executed on Selenium Grid with remote drivers and tests are run with gridMode= true then we initialize remote webdriver
 *
 * @param browserName Name of the browser is set in smoke-tests-distributed.xml file as test parameter "browser" e.g. chrome, firefox, edge, safari
 * @param browserVersion Browser version is set in smoke-tests-distributed.xml file as test parameter "browserVersion"
 * @param platform platform is set in smoke-tests-distributed.xml file as test parameter "platformName" e.g. windows mac, linux
 * @return RemoteWebDriver on hubURL configured in grid.properties with corresponding browser options
 * @throws MalformedURLException
 */
public static WebDriver initializeRemoteDriver(String browserName,String browserVersion,String platform)throws MalformedURLException{
        WebDriver driver;
        Properties gridProps=PropertyUtils.propertyLoader("src/test/resources/framework/properties/grid.properties");
        String hubAddress=gridProps.getProperty("hubURL");
        switch(browserName){
        case"chrome"->{
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setCapability("browserVersion",browserVersion);
        chromeOptions.setCapability("platformName",platform);
        driver=new RemoteWebDriver(new URL(hubAddress),chromeOptions);
        }
        case"firefox"->{
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.setCapability("browserVersion",browserVersion);
        firefoxOptions.setCapability("platformName",platform);
        driver=new RemoteWebDriver(new URL(hubAddress),firefoxOptions);
        }
        case"edge"->{
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setCapability("browserVersion",browserVersion);
        edgeOptions.setCapability("platformName",platform);
        driver=new RemoteWebDriver(new URL(hubAddress),edgeOptions);
        }
        case"safari"->{
        SafariOptions safariOptions=new SafariOptions();
        DesiredCapabilities caps=new DesiredCapabilities();
        safariOptions.setCapability("browserVersion",browserVersion);
        safariOptions.setCapability("platformName",platform);
        driver=new RemoteWebDriver(new URL(hubAddress),safariOptions);
        }
default ->throw new IllegalStateException("INVALID BROWSER: "+browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
        }
````

* Download the latest [Selenium Server (Grid)](https://www.selenium.dev/downloads/) and place in your machine. Latest Stable version is 4.7.2
* Ensure the following browsers are installed and updated on your machines where nodes will run. Download the web drivers for your browsers:
    * [ChromeDriver](https://chromedriver.chromium.org/downloads)
    * [Firefox-geckodriver](https://github.com/mozilla/geckodriver/releases)
    * [Microsoft Edge WebDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

#### Standalone

* [Standalone mode](https://www.selenium.dev/documentation/grid/getting_started/#standalone)  is also the easiest mode to spin up a Selenium Grid. By
  default, the server will listen for **RemoteWebDriver** requests on `http://localhost:4444`. By default, the server will detect the available
  drivers that
  it can use from the System PATH.

````java
java-jar selenium-server-<version>.jar standalone
````

#### Hub and Node

* [Hub and Node](https://www.selenium.dev/documentation/grid/getting_started/#hub-and-node) is the most used role because it allows to:
    * Combine different machines in a single Grid
        * Machines with different operating systems and/or browser versions.

* Navigate to the directory where selenium server jar is downloaded and run `java -jar selenium-server-4.7.2.jar hub`
* Since we have multiple browsers and multiple platforms, therefore we will configure our nodes wíth **Toml** files as recommended by Selenium.

> We recommend the use of Toml files to configure a Grid. Configuration files improve readability, and you can also check them in source control.
> When needed, you can combine a Toml file configuration with CLI arguments.

* Selenium provides a good [documentation](https://www.selenium.dev/documentation/grid/configuration/cli_options/) for different configurations and
  CLI options in the Selenium Grid.
* The [Info commands](https://www.selenium.dev/documentation/grid/configuration/help/) provide details of possible options for any component. For our
  use, you can try following commands:

````java
java-jar selenium-server-<version>.jar info config
        java-jar selenium-server-<version>.jar--config-help
        java-jar selenium-server-<version>.jar hub--help
        java-jar selenium-server-<version>.jar node--help
````

* Before moving on to node configuration with Toml files, here is a brief summary of important options used:

##### [Events](https://www.selenium.dev/documentation/grid/configuration/cli_options/#events)

`--publish-events` Connection string for publishing events to the event bus
`--subscribe-events` Connection string for subscribing to events from the event bus

##### [Node](https://www.selenium.dev/documentation/grid/configuration/cli_options/#node)

`--detect-drivers` Autodetect which drivers are available on the current system, and add them to the Node.
`--driver-configuration` List of configured drivers a Node supports. It is recommended to provide this type of configuration through a toml config
file to improve readability
`--grid-url`    Public URL of the Grid as a whole (typically the address of the Hub or the Router)
`--max-sessions` Maximum number of concurrent sessions. Default value is the number of available processors.
`--override-max-sessions`    Maximum number of concurrent sessions. Default value is the number of available processors.
`--session-timeout` Let X be the session-timeout in seconds. The Node will automatically kill a session that has not had any activity in the last X
seconds. This will release the slot for other tests.
`--hub` The address of the Hub in a Hub-and-Node configuration.

##### [Server](https://www.selenium.dev/documentation/grid/configuration/cli_options/#server)

`--port` Port to listen on. There is no default as this parameter is used by different components.

> maxInstance is used to limit the number of browser initialization in a node.
> maxSession is used to configure how many numbers of browsers can be used parallel in the remote system.

* [Selenium Grid 4 complete guide to configuration flags](https://www.webelement.click/en/selenium_grid_4_complete_guide_to_configuration_flags)
* create the toml files for each of the node with desired browser and platform. Start each node on different port and mention the hub url.
* Also specify the path of downloaded webdrivers in `webdriver-path`
* The firefox browser may not pick up the browser binary from default installation location, so we also specified it under binary option.

##### Node Configuration for Chrome Browser on Windows 10

* Here is how my `nodeConfigChrome.toml` file looks like:

````toml
[events]
publish = "tcp://localhost:4442"
subscribe = "tcp://localhost:4443"

[server]
port = 5555

[node]
hub = "http://localhost:4444"
detect-drivers = false
override-max-sessions = true
session-timeout = 60
drain-after-session-count = 0

[[node.driver-configuration]]
display-name = "firefox"
webdriver-path = "C:\\selenium\\webdrivers"
stereotype = '{"browserName": "firefox", "platformName": "windows 10", "browserVersion":"108", "maxInstances":"2", "networkname:applicationName":"node_firefox", "nodename:applicationName":"AskOmDch"}'
max-sessions = 2

````

##### Node Configuration for FireFox Browser on Windows 10

* Here is how my `nodeConfigFirefox.toml` file looks like:

````toml
[events]
publish = "tcp://localhost:4442"
subscribe = "tcp://localhost:4443"

[server]
port = 5556

[node]
hub = "http://localhost:4444"
detect-drivers = false
override-max-sessions = true
session-timeout = 60
drain-after-session-count = 0

[[node.driver-configuration]]
display-name = "firefox"
webdriver-path = "C:\\selenium\\webdrivers"
stereotype = '{"browserName": "firefox", "platformName": "windows 10", "browserVersion":"108", "maxInstances":"2", "networkname:applicationName":"node_firefox", "nodename:applicationName":"AskOmDch", "moz:firefoxOptions":{"binary":"C:\\Program Files\\Mozilla Firefox\\firefox.exe"}}'
max-sessions = 2

````

##### Node Configuration for Edge Browser on Windows 10

* Here is how my `nodeConfigEdge.toml` file looks like:

````toml
[events]
publish = "tcp://localhost:4442"
subscribe = "tcp://localhost:4443"

[server]
port = 5557

[node]
hub = "http://localhost:4444"
detect-drivers = false
override-max-sessions = true
session-timeout = 60
drain-after-session-count = 0

[[node.driver-configuration]]
display-name = "edge"
webdriver-path = "C:\\selenium\\webdrivers"
stereotype = '{"browserName": "MicrosoftEdge", "platformName": "windows 10", "browserVersion":"108", "maxInstances":"2", "networkname:applicationName":"node_msedge", "nodename:applicationName":"AskOmDch" }'
max-sessions = 2
````

#### Start Selenium Grid Hub and Node

* Navigate to the directory where selenium server jar is placed and run following commands:
* To start Selenium Grid Hub
  `java -jar selenium-server-4.7.2.jar hub`

* To start Selenium Grid nodes

````java
java-jar selenium-server-4.7.2.jar node--config C:\selenium\grid\nodeConfigChrome.toml
        java-jar selenium-server-4.7.2.jar node--config C:\selenium\grid\nodeConfigFirefox.toml
        java-jar selenium-server-4.7.2.jar node--config C:\selenium\grid\nodeConfigEdge.toml
````

* <img src="doc/hub-node-cmd.png"  alt="selenium grid hub and node" width="1908">

##### [Querying Selenium Grid](https://www.selenium.dev/documentation/grid/getting_started/#querying-selenium-grid)

* After starting a Grid, there are mainly two ways of querying its status, through the Grid UI or via an API call.
* The Grid UI can be reached by opening your preferred browser and heading to http://localhost:4444.
* <img src="doc/selenium-grid-overview.png"  alt="selenium grid overview" width="1899">

##### Run Tests in Parallel on different browsers and platforms

* Run your tests with `gridMode` setTo true and by referring to your maven profile e.eg.  `mvn clean test -D"gridMode=true" -PsmokeDistributed`
* If you want scenarios in feature to also run in parallel, `mvn clean test -D"gridMode=true" -D"scenariosInParallel=true" -PsmokeDistributed`
* Below you can see in image tests running in parallel on different browsers
* <img src="doc/selenium-grid-sessions.png"  alt="selenium grid sessions" width="1617">

* In Allure report timeline, you can see that all 9 tests with `@smoke` tag ran in parallel i.e. 3 tests on each of the browser
* <img src="doc/selenium-grid-timeline-allure-smoke-tests-parallel.png"  alt="selenium grid timeline allure" width="1905">

---

### Framework - Integrating Selenium Grid with Docker

#### why Docker

* Firing up Selenium Grid architecture can be lengthy process. Selenium JAR will have to be downloaded in hub and each of the node. After this you
  have to fire the command in the hub to get the server up. From that, you can get the IP address. In the nodes, you can get the server up by adding
  the IP of the hub and port number. This is very time-consuming and tedious process.
* Things become more difficult to manage when tests are required to be run on different versions of a browser. Managing multiple browser versions on a
  system and running tests on them is an exhausting process.
* Docker manages these tasks with relative ease.
* Docker is an open-source containerization platform that makes it easy to create, deploy, and run applications in a secure manner using containers.
* Container in Docker is a stand unit of software that packages the code and all the required dependencies so that the application can run more
  quickly and reliably from one computing environment to another.
* Read more on:
    * [Selenium Grid With Docker](https://nitinbhardwaj6.medium.com/selenium-grid-with-docker-c8ecb0d8404)
    * [Testing a website with Selenium and Docker](https://blog.logrocket.com/testing-website-selenium-docker/)
    * [How To Run Selenium Tests In Docker?](https://www.lambdatest.com/blog/run-selenium-tests-in-docker/)
    * [How to run Selenium Tests in Docker](https://www.browserstack.com/guide/run-selenium-tests-in-docker)
    * [Parallel Execution of Tests using Selenium Grid 4 with Docker Compose](https://medium.com/@iamfaisalkhatri/parallel-execution-of-tests-using-selenium-grid-4-with-docker-compose-2dc243f4fe8b)
* Now you can test on Google Chrome, Mozilla Firefox, and Microsoft Edge on the Dev and Beta channels using Docker
  Selenium. [Dev and Beta Channel Browsers via Docker Selenium](https://www.selenium.dev/blog/2022/dev-and-beta-channel-browsers-via-docker-selenium/)

#### Docker Installation and Setup

* Download the [Docker Desktop](https://docs.docker.com/desktop/)
* Before Installing the Docker Desktop, Your Windows machine must meet the
  following [requirements](https://docs.docker.com/desktop/install/windows-install/#system-requirements) to successfully install Docker Desktop.
    * Make sure the system RAM, windows version,processor and the BIOS virtualization is enabled.
    * Enable the WSL 2 feature on Windows. For detailed instructions, refer to
      the [Microsoft documentation](https://learn.microsoft.com/en-us/windows/wsl/install-manual#step-4---download-the-linux-kernel-update-package).
        * [Download the Linux kernel update package](https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi)
        * [Set WSL 2 as your default version](https://learn.microsoft.com/en-us/windows/wsl/install-manual#step-5---set-wsl-2-as-your-default-version)
            * Open PowerShell and run this command to set WSL 2 as the default version when installing a new Linux
              distribution: `wsl --set-default-version 2`
        * [Install your Linux distribution of choice](https://learn.microsoft.com/en-us/windows/wsl/install-manual#step-5---set-wsl-2-as-your-default-version)
* Now install the Docker-Desktop. After Installation, check by running the following command to see if the Docker is successfully
  installed `docker -v`
* Restart the machine after installing Docker
  <img src="doc/docker-version.png"  alt="docker version" width="400">
* Following articles offer summary of insallation steps:
    * [Installing Docker (Docker Made Easy - Part 2)](https://www.evernote.com/shard/s433/client/snv?noteGuid=bb14b240-dd58-4916-9c3b-da56f3eee2f5&noteKey=fee22191532adef8&sn=https%3A%2F%2Fwww.evernote.com%2Fshard%2Fs433%2Fsh%2Fbb14b240-dd58-4916-9c3b-da56f3eee2f5%2Ffee22191532adef8&title=Installing%2BDocker%2B%2528Docker%2BMade%2BEasy%2B-%2BPart%2B2%2529)
    * [How to install and setup the Docker on Windows](https://www.lambdatest.com/blog/run-selenium-tests-in-docker/#Howtoinstall)

#### Docker Images for the Selenium Grid

* [Read the Official Documentation of docker-selenium](https://github.com/SeleniumHQ/docker-selenium)
* These images are published to the Docker Hub registry at [Selenium Docker Hub](https://hub.docker.com/u/selenium).
* Since we will be running our Selenium Grid in Hub and Node configuration and each node needs to be configured for different browser so we need to
  download docker images foe the node.
* Run the following commands in CMD:
    * For [Hub](https://hub.docker.com/r/selenium/hub), run `docker pull selenium/hub`
    * For [Chrome Browser Node](https://hub.docker.com/r/selenium/node-chrome), run `docker pull selenium/node-chrome`
    * For [Firefox Browser Node](https://hub.docker.com/r/selenium/node-firefox), run `docker pull selenium/node-firefox`
    * For [Edge Browser Node](https://hub.docker.com/r/selenium/node-edge), run `docker pull selenium/node-edge`
* It is also possible to download the node with specific version of Selenium and browser by speciying the tag e.g. `docker pull selenium/hub:4.7.2`.
  By default, it will pull the latest version when no tag is specified.
* Run the command `docker images`, that will show the images downloaded in your system.
  <img src="doc/docker-images.png"  alt="docker images commandline" width="1200">
* Alternatively, open the docker desktop and downloaded images are listed under Images tab.
  <img src="doc/docker-images-desktop.png"  alt="docker images desktop" width="1200">
* The command `docker images -f "reference=selenium/*:latest"` will filter out the images and only show images that start with selenium/.
*

#### Selenium Grid configuration with docker-compose.yml

* [Compose](https://docs.docker.com/compose/) is a tool for defining and running multi-container Docker applications. With Compose, you use a YAML
  file to configure your application’s services. Then, with a single command, you create and start all the services from your configuration.
* The easiest and recommended way to get Docker Compose is to install Docker Desktop. Docker Desktop includes Docker Compose along with Docker Engine
  and Docker CLI which are Compose prerequisites.
* [Docker Compose](https://github.com/SeleniumHQ/docker-selenium#docker-compose) is the simplest way to start a Grid. Use the linked resources below,
  save them locally, and check the execution instructions on top of each file.
* Example configuration for [docker-compose-v3.yml](https://github.com/SeleniumHQ/docker-selenium#docker-compose)
* In the root directory of the project, create the `docker-compose.yml` and add the following code

````yaml
version: "3"
services:
  chrome:
    image: selenium/node-chrome
    shm_size: 2gb
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
      - SE_NODE_MAX_INSTANCES=3
      - SE_NODE_MAX_SESSIONS=3
      - SE_VNC_NO_PASSWORD=1
    ports:
      - "5900"
      - "7900"


  edge:
    image: selenium/node-edge
    shm_size: 2gb
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
      - SE_NODE_MAX_INSTANCES=3
      - SE_NODE_MAX_SESSIONS=3
      - SE_VNC_NO_PASSWORD=1
    ports:
      - "5900"
      - "7900"

  firefox:
    image: selenium/node-firefox
    shm_size: 2gb
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
      - SE_NODE_MAX_INSTANCES=3
      - SE_NODE_MAX_SESSIONS=3
      - SE_VNC_NO_PASSWORD=1
    ports:
      - "5900"
      - "7900"

  selenium-hub:
    image: selenium/hub
    container_name: selenium-hub
    ports:
      - "4442:4442"
      - "4443:4443"
      - "4444:4444"
````

* Check out [Compose file version 3 reference](https://docs.docker.com/compose/compose-file/compose-file-v3) to find out the meaning of parameters
  specified in YAML file. Here I have linked the resources for parameters in our docker-compose.vml with a brief info:
    * [version](https://docs.docker.com/compose/compose-file/compose-versioning/) There are several versions of the Compose file format – 1, 2, 2.x,
      and 3.x
    * [services](https://docs.docker.com/compose/compose-file/#the-compose-application-model) Computing components of an application are defined as
      Services.
    * [image](https://docs.docker.com/compose/compose-file/compose-file-v3/#image) Specify the image to start the container from.
    * [shm_size](https://docs.docker.com/compose/compose-file/compose-file-v3/#shm_size) Set the size of the /dev/shm partition for this build’s
      containers
    * [depends_on](https://docs.docker.com/compose/compose-file/compose-file-v3/#depends_on) Express dependency between services.
    * [container_name](https://docs.docker.com/compose/compose-file/compose-file-v3/#container_name) Specify a custom container name, rather than a
      generated default name.
    * [ports](https://docs.docker.com/compose/compose-file/compose-file-v3/#ports) Expose ports. Specify both ports (HOST:CONTAINER)
    * [environment](https://docs.docker.com/compose/compose-file/compose-file-v3/#environment) Add environment variables.
* [Configuration](https://github.com/SeleniumHQ/docker-selenium/wiki/Getting-Started-with-Docker-Compose#step-3-customizing-with-environment-variables)
  of the selenium hub and nodes is handled primarily through docker environment variables. For a full list of environment variables
  supported on each image, find your image at Docker and check the "Selenium Configuration" section of the "Dockerfile"
    * [NODE Environment Variables](https://github.com/SeleniumHQ/docker-selenium/blob/trunk/NodeBase/Dockerfile)
    * [HUB Environment variables](https://github.com/SeleniumHQ/docker-selenium/blob/trunk/Hub/Dockerfile)
    * [Selenium Grid 4 Environment variables](https://www.webelement.click/en/selenium_grid_4_complete_guide_to_configuration_flags#_mind_this_for_docker_images)
* If you want to run VNC without password authentication you can set the environment variable `SE_VNC_NO_PASSWORD=1`.
* You can download a VNC client like [Real VNC](https://www.realvnc.com/en/) and connect to the Port in Docker container where tests are running to
  see what is happening in browsers.
  [The VNC server is listening to port 5900, you can use a VNC client and connect to it](https://github.com/SeleniumHQ/docker-selenium#using-a-vnc-client)
* [Port Mapping in Docker Containers](https://www.youtube.com/watch?v=C-wTVx4WWGs)
* Selenium Grid 4 also supports noVNC which means you can connect to the docker container VNC service from within the browser itself without having
  to install any external VNC viewer client. Port 7900 is used to start noVNC, so you will need to connect to that port with your browser.
* Using the docker-compose.yml file, the containers can be scaled up and down i.e. multiple containers can be created from same image at the same
  time. Therefore, it is better not to map specific port of the host machine to Docker container like "7901:7900" because Docker will automatically
  publish the port which is free at the time to corresponding VNC (5900) and noVNC (7900) ports.
* For accessing the VNC service use VNC viewer client and go to `127.0.0.1:<PORT>`, and for viewing noVNC service, go to browser and
  hit `localhost:<PORT>`
* You can view which port is VNC using by typing `docker ps` in commandline and connect to the port in your browser
  <img src="doc/docker-novnc-cmd.png"  alt="docker novnc cmd" width="1200">
  <img src="doc/docker-novnc-browser.png"  alt="docker novnc browser" width="1200">
* `docker ps -a` it will also show the containers that are stopped
* Open the Docker Desktop and click on the container for example, node chrome to and see its logs and inspect tabs to see the configurations' node is
  started with:
  <img src="doc/docker-node-logs.png"  alt="docker node logs" width="900">
  <img src="doc/docker-node-inspect.png"  alt="docker node inspect" width="900">
* `docker stats` command will show the CPU usage and memory utilization of docker containers. Alternatively stats tab of individual docker container
  in
  Docker desktop will also show the stats of that container.
* Tests execution can be recorded by using the selenium/video:ffmpeg-4.3.1-20221219 Docker image. One container is needed per each container where a
  browser is running. This means if you are running 5 Nodes/Standalone containers, you will need 5 video containers, the mapping is
  1-1. [Read More](https://github.com/SeleniumHQ/docker-selenium#video-recording)
* Add the following lines to `docker-compose.yml` which will add the video recording for each of the nodes. The recordings will be displayed in the
  directory where `docker-compose.yml` file is located and inside **test-recordings** directory, you will get 3 separate recorded videos.

````yaml
chrome_video:
  image: selenium/video:ffmpeg-4.3.1-20221219
  volumes:
    - ./test-recordings:/videos
  depends_on:
    - chrome
  environment:
    - DISPLAY_CONTAINER_NAME=chrome
    - FILE_NAME=chrome_video.mp4

  edge_video:
    image: selenium/video:ffmpeg-4.3.1-20221219
    volumes:
      - ./test-recordings:/videos
    depends_on:
      - edge
    environment:
      - DISPLAY_CONTAINER_NAME=edge
      - FILE_NAME=edge_video.mp4

  firefox_video:
    image: selenium/video:ffmpeg-4.3.1-20221219
    volumes:
      - ./test-recordings:/videos
    depends_on:
      - firefox
    environment:
      - DISPLAY_CONTAINER_NAME=firefox
      - FILE_NAME=firefox_video.mp4
````

* The above approach has one issue that in case of parallel scenarios executions for each browser, the recorded video will only capture singe browser
  which is at the front of screen and the other browser instances will be hidden in background.
* To solve this, either use Dynamic Grid or a container per test. With the current setup there is no way to break a video per test because ffmpeg
  records the
  visible screen, not each browser apart.

#### Running Cross Browser tests on Dockerized Grid

* Add the following property in `grid.properties`. This is the IP address of the hub where hub docker node is operating.

````properties
hubURL=http://localhost:4444/
````

* Create TestNG suite xml file `smoke-tests-dockerized-grid.xml` and also add its profile in POM.xml so we can later run it through maven.
* Add the following code to above suite xml file. Note that we have set the platform to linux because docker images provided by Selenium are based on
  Linux OS

````xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Smoke Test Suite - Dockerized Selenium Grid" thread-count="10" parallel="tests">
    <listeners>
        <listener class-name="framework.listeners.ScenariosParallelTransformer"/>
    </listeners>
    <test name="Google Chrome Browser Test">
        <parameter name="browser" value="chrome"/>
        <parameter name="platformName" value="linux"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

    <test name="Mozilla Firefox Browser Test">
        <parameter name="browser" value="firefox"/>
        <parameter name="platformName" value="linux"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

    <test name="Microsoft Edge Browser Test">
        <parameter name="browser" value="edge"/>
        <parameter name="platformName" value="linux"/>
        <classes>
            <class name="framework.runners.BaseTestNGRunnerTest"/>
        </classes>
    </test> <!-- Test -->

</suite> <!-- Suite -->
````

* Remove the `chromeOptions.setCapability("browserVersion", browserVersion);` from `initializeRemoteDriver()` in `DriverFactory` class for all the
  browsers since we are not specifying the browser version in our docker compose so this line will result in error if the browser version does not
  match.
* [Overview of docker compose CLI](https://docs.docker.com/compose/reference/) provides the explanation of various Docker CMD commands.
    * `docker-compose -f /path/to/docker-compose.yml up -d` will start the docker services in containers.
        * -d : Detach mode.It means that you can still use the CMD window after executing above command.
          -f /path/to/docker-compose.yml : It is only required if docker-compose.yml is not present in project root directory and you have to specify
          the path of file. If the yml file is in root directory then you can simply enter `docker-compose up -d`
    * `docker ps` List containers
    * `docker-compose -f /path/to/docker-compose.yml down` Containers will be stopped. Grid network will be destroyed.
    * `docker-compose -f /path/to/docker-compose.yml restart` Containers will be restarted
    * `docker start CONTAINER_ID` starts the container
    * `docker stop CONTAINER_ID` terminates the container
    * `docker rm CONTAINER_ID` deletes the container
    * `docker rmi IMAGE_ID` removes the docker image
    * `docker exec -ti <CONTAINER_ID> /bin/bash` will allows us to use command line within the docker container. The selenium jars will be placed
      in **opt/seleium** folder as well as config.json

* Now it is time to start the docker grid containers for Hub and Nodes. Run the command `docker compose -f docker-compose.yml up -d`
* Verify the status of Grid by running command `docker ps`
* <img src="doc/docker-containers.png"  alt="docker containers running" width="1287">
* And by visiting the URl http://localhost:4444/, it should list the created nodes that are attached to the Hub in Selenium Grid running in docker
  containers.
  <img src="doc/docker-grid-overview.png"  alt="docker grid overview" width="1900">
* Run the tests with `mvn clean test -D"gridMode=true" -D"scenariosInParallel=true" -PsmokeDockergrid` which will run the 9 tests in parallel on 3
  different docker containers. Total of 3 smoke tests will run in parallel on Edge, Chrome and Firefox browsers.
  <img src="doc/docker-grid-sessions.png"  alt="docker grid sessions" width="1900">
* `noVNC` comes bundled with the Selenium 4 Docker Grid so you can view what is happening in a browser session in any container by clicking on video
  icon next to the browser session name. Enter password "secret" and it will open up the window showing tests running inside docker container in
  browser.
  <img src="doc/docker-grid-vnc.png"  alt="docker grid vnc" width="1300">
* The Docker grid can be scaled up and down by command line:
    * `docker-compose up --scale chrome=5 -d` to scale up (here chrome is the name of service)
    * `docker-compose up --scale chrome=1 -d` to scale Down (here chrome is the name of service)
* The grid can be stopped by the command `docker compose -f docker-compose.yml down`
* Test run fails when a container crashes,
  therefore [restart policy](https://docs.docker.com/config/containers/start-containers-automatically/#use-a-restart-policy) is used.
    * No (default)
    * On-failure (restart on non-zero exit code)
    * Always (unless docker daemon is stopped)
    * Unless-Stopped (Restarts always except manually stopped)
* If there are hundreds of tests that need to run in parallel then there is only a limited resources that a single machine/VM/Cloud instance can
  offer, and it is not possible to spin so many containers on single machine. So it is recommended to start hub and nodes on different machines inside
  Docker and network them. Tools to manage, scale, and maintain containerized applications are called orchestrators, and the most common examples of
  these are [Docker Swarm](https://docs.docker.com/get-started/swarm-deploy/) and [Kubernetes](https://docs.docker.com/get-started/kube-deploy/)
* [Scaling Tests with Docker](https://testautomationu.applitools.com/scaling-tests-with-docker/index.html)

#### Run Cucumber Tests on Dynamic Selenium Grid with Video Recording

* In the previous section ,we set up Selenium Grid on Docker in Hub and Node configuration. So before the test execution docker containers need to be
  setup. Also, the problem was that the test recording was specific to the docker node and not for each of the browser session so if multiple tests
  were executing in parallel on same node then the test recording will capture only one browser test and other executions were going in background and
  could not be recorded. To overcome this issue, we have dynamic grid which runs each test on separate container and records the video for each test
  separately.
* Grid 4 has the ability to start Docker containers on demand, this means that it starts a Docker container in the background for each new session
  request, the test gets executed there, and when the test completes, the container gets thrown
  away. [Read More](https://github.com/SeleniumHQ/docker-selenium#dynamic-grid)
* Create a toml configuration file and specify the browser and selenium docker images to be used to set up containers. In a nutshell, the config.toml
  file is telling the node which browser container type to spin up when it sends a request to the event bus based on the browserName option that is
  sent in the capabilities. There is also a docker image that gives the ability to generate a video of the test run — this .mp4 is placed where the
  ./assets folder is after test run.

````toml
configs = [
    "selenium/standalone-firefox:4.4.0", "{\"browserName\": \"firefox\"}",
    "selenium/standalone-chrome:4.4.0", "{\"browserName\": \"chrome\"}",
    "selenium/standalone-edge:4.4.0", "{\"browserName\": \"MicrosoftEdge\"}"
]

# URL for connecting to the docker daemon
# Most simple approach, leave it as http://127.0.0.1:2375, and mount /var/run/docker.sock.
# 127.0.0.1 is used because interally the container uses socat when /var/run/docker.sock is mounted
# If var/run/docker.sock is not mounted:
# Windows: make sure Docker Desktop exposes the daemon via tcp, and use http://host.docker.internal:2375.
# macOS: install socat and run the following command, socat -4 TCP-LISTEN:2375,fork UNIX-CONNECT:/var/run/docker.sock,
# then use http://host.docker.internal:2375.
# Linux: varies from machine to machine, please mount /var/run/docker.sock. If this does not work, please create an issue.
url = "http://host.docker.internal:2375"
# Docker image used for video recording
video-image = "selenium/video:ffmpeg-4.3.1-20221219"

# Uncomment the following section if you are running the node on a separate VM
# Fill out the placeholders with appropriate values
#[server]
#host = <ip-from-node-machine>
#port = <port-from-node-machine>
````

* This can be expanded to a full Grid deployment, all components deployed individually. The overall idea is to have the Hub in one virtual machine,
  and each of the Nodes in separate and more powerful virtual machines.
* Create a docker compose file e.g. I named it `docker-compose-v3-dynamic-grid.yml` and map the path and ports of the node configurations.

````yaml
# To execute this docker-compose yml file use `docker-compose -f docker-compose-v3-dynamic-grid.yml up`
# Add the `-d` flag at the end for detached execution
# To stop the execution, hit Ctrl+C, and then `docker-compose -f docker-compose-v3-dynamic-grid.yml down`
version: "3"
services:
  node-docker:
    image: selenium/node-docker:4.4.0
    volumes:
      - ./assets/test-recordings:/opt/selenium/assets
      - ./src/test/resources/framework/selenium-grid-config/dynamic-grid-config.toml:/opt/bin/config.toml
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443

  selenium-hub:
    image: selenium/hub:4.4.0
    container_name: selenium-hub
    ports:
      - "4442:4442"
      - "4443:4443"
      - "4444:4444"
````

* To record your WebDriver session, you need to add a se:recordVideo field set to
  true. [Read More](https://github.com/SeleniumHQ/docker-selenium#video-recording-screen-resolution-and-time-zones-in-a-dynamic-grid)
* So in the DriverFactory class add the following option for each of the browser request `options.setCapability("se:recordVideo", true);`
* Start the dynamic grid with `docker-compose -f docker-compose-v3-dynamic-grid.yml up`. After test execution the grid can be stopped by
  running ` docker-compose -f docker-compose-v3-dynamic-grid.yml down`
* Run the tests with `mvn clean test -D"gridMode=true" -PsmokeDockergrid`. This will spin up the containers dynamically best on session requests from
  selenium hub.
* As specified in the yml file, the videos will be generated in root project folder under directory `assets/test-recordings`
* <img src="doc/docker-test-recordings.png"  alt="docker test recordings" width="517">
* A step ahead you can also add the video recording in your allure reports but note thatVideo recording is a CPU intensive operation adn requires a
  strong machine to handle the CPU load.

````java
    @After
public void AddVideo(Scenario scenario){
        SessionId sID=((RemoteWebDriver)context.driver).getSessionId();
        try{
        String videoPath=System.getProperty("user.dir")+"\\assets\\test-recordings\\"+sID.toString()+"video.mp4";
        byte[]byteArr=IOUtils.toByteArray(new FileInputStream(videoPath));
        Allure.addAttachment(scenario.getName(),"video/mp4",new ByteArrayInputStream(byteArr),"mp4");
        }catch(IOException e){
        e.printStackTrace();
        }
        }
````

* The latest version of Selenium 4.7.2-20221219 is having some issues related to crashing of browser containers and content length that will be fixed
  in the next release so I tested the Dynamic Grid with older version Selenium 4.4.0.
* Resources:
    * [Selenium Dynamic Grid](https://github.com/SeleniumHQ/docker-selenium#dynamic-grid)
    * [Selenium Grid 4 — Getting Started with the Dynamic Grid](https://bamtests.medium.com/selenium-grid-4-getting-started-with-the-dynamic-grid-f77b6bf109b3)
    * [Understanding all-new Dynamic Selenium Grid 4 along with video support!](https://www.youtube.com/watch?v=nEyo8cNhZb4)

#### Invoke Selenium Grid on Docker Environment using Batch file

* Add the batch files in your project root directory
    * **start_dockergrid.bat** contains the command to start docker containers: `docker-compose -f docker-compose.yml up`
    * **stop_dockergrid.bat** contains the command to stop docker containers: `docker-compose -f docker-compose.yml down`
* Add the following lines of code in Test Runner i.e. BaseTestNGRunnerTest that will run the cmd batch scripts to spin up and down docker containers
  before and after test suite:

````java
//Starts the docker containers before test suite
@BeforeSuite
public void startDockerGrid()throws IOException,InterruptedException{
        Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
        Thread.sleep(15000);
        }

//stops the docker containers after test suite
@AfterSuite
public void stopDockerGrid()throws IOException,InterruptedException{
        Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
        Thread.sleep(5000);

        Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); //closes command prompt
        }
````

* Now execute the tests wih `mvn clean test -D"gridMode=true" -PsmokeDockergrid` which will start the command prompt windows and run the commands to
  spin up docker containers before test suite and stop the containers automatically after the test suite.
* Make sure the Docker Daemon is up and running on host environment. Now you do not need to start and stop docker containers manually.
* This will also enable us to start and stop docker containers when running tests via Jenkins CI
* Resources:
    * [How to Invoke Selenium Grid on Docker Environment using Batch file](https://www.youtube.com/watch?v=CVFYaz9E2lo)
    * [How to Integrate Docker,Selenium Grid with Jenkins](https://www.youtube.com/watch?v=JgrJhRxO-6Q)
    * [Docker : How to run selenium grid in docker using Jenkins](https://www.youtube.com/watch?v=O9zbuQuLpMU)

#### Cucumber Tests on Selenoid Grid

* Dynamic Grid that comes with Selenium has currently open issues and is not stable. An alternative to Dynamic Gris is Selenoid which is a powerful
  implementation of Selenium hub using Docker containers to launch browsers.
* It gives us options to record videos and capture logs and also has updated images for different browsers.
* Lightweight and Lightning Fast
  Suitable for personal usage and in big clusters:
    * Consumes 10 times less memory than Java-based Selenium server under the same load
    * Small 6 Mb binary with no external dependencies (no need to install Java)
    * Browser consumption API working out of the box
    * Ability to send browser logs to centralized log storage (e.g. to the ELK-stack)
    * Fully isolated and reproducible environment
* Read More on:
    * [Selenoid GitHub](https://github.com/aerokube/selenoid)
    * [Selenoid UI GitHub](https://github.com/aerokube/selenoid-ui)
    * [Selenoid Repo](https://aerokube.com/selenoid/latest/)
* I will briefly go through the steps needed to integrate the framework with Selenoid and how I configured the hooks to attach selenoid video
  recordings to Allure reports.
* Download and Install the latest Selenoid configuration manager according to your operating system. At the moment v1.10.9 is the latest release
  [Selenoid Release](https://github.com/aerokube/selenoid/releases/tag/1.10.9)
  [Selenoid Configuration Manager](https://aerokube.com/cm/latest/)
* Extract and rename the downloaded exe to whatever name you prefer, I renamed it to **cm.exe**
* On Windows run this command in powershell to start selenoid. It will start selenoid and automatically pull the latest browser images for chrome,
  firefox and opera.

```
./cm.exe selenoid start --vnc
```

* <img src="doc/selenoid-start.png"  alt="selenoid" width="863">
* If you want to start the selenoid grid with custom browser binaries and versions, then you need to start the selenoid with **--browsers.json**
  command line parameter and specify path to your browser configuration file. I added the following configuration:
* [Browser Configuration File](https://aerokube.com/selenoid/latest/#_browsers_configuration_file)

```json
{
  "MicrosoftEdge": {
    "default": "108.0",
    "versions": {
      "108.0": {
        "image": "browsers/edge:108.0",
        "port": "4444",
        "path": "/"
      }
    }
  },
  "chrome": {
    "default": "108.0",
    "versions": {
      "108.0": {
        "image": "selenoid/chrome:108.0",
        "port": "4444",
        "path": "/"
      }
    }
  },
  "firefox": {
    "default": "108.0",
    "versions": {
      "108.0": {
        "image": "selenoid/firefox:108.0",
        "port": "4444",
        "path": "/wd/hub"
      }
    }
  }
}
```

* Selenoid was not pulling the docker image for edge automatically so I had to fetch the image manually with `docker pull browsers/edge:108.0`
* <img src="doc/selenoid-pull-edge.png"  alt="selenoid pull edge" width="845">
* [Docker Hub Selenoid Images](https://hub.docker.com/u/selenoid)
* [Browser Images available for Selenoid](https://aerokube.com/images/latest/)
* In some cases you may want to configure Selenoid to use an existing `browsers.json` configuration file. This is mainly needed to always use the same
  browser versions instead of downloading latest versions. To achieve this:
    * Prepare a desired browsers.json configuration file
    * Launch cm with `--browsers-json` flag:
    * [Using Existing Configuration File](https://aerokube.com/cm/latest/#_using_existing_configuration_file)

```
./cm selenoid start --browsers-json /path/to/browsers.json
```

* To quickly run Selenoid UI type:

```json
./cm selenoid-ui start
```

* [Starting Selenoid UI](https://aerokube.com/cm/latest/#_starting_selenoid_ui)
* [Run Selenoid Tests](https://aerokube.com/cm/latest/#_starting_selenoid_ui)
    * Run your tests against Selenoid like you do with regular Selenium hub. Test Endpoint
  ```
  http://localhost:4444/wd/hub
  ```
    * If something does not work, you can easily check that Selenoid is running with opening status url:
    * Current Selenoid Status
  ```
  http://localhost:4444/status
  ```
    * To open Selenoid UI navigate to the following page in your browser:
  ```
  http://localhost:8080/
  ```
* <img src="doc/selenoid-start-browser-config.png"  alt="selenoid start browser config" width="997">
* <img src="doc/selenoid-capabilities.png"  alt="selenoid capabilities" width="1900">
* Since the endpoint of selenoid grid has `wd/hub` at the end, so I defined a separate property in my `grid.property` file for **selenoid**. If it is
  set to true, I will append the suffix to grid url

```java
Properties gridProps=PropertyUtils.propertyLoader("src/test/resources/framework/properties/grid.properties");
        String hubAddress=gridProps.getProperty("hubURL");
//selenoid grid have url of localhost:4444/wd/hub while Docker grid have url of localhost:44444
        hubAddress+=gridProps.getProperty("selenoid").equals("true")?"wd/hub":"";
```

* As seen in the above image, we need to add the browser options/capabilities to enable VNC and video recording option for selenoid containers.
* [Selenoid Video Recording](https://aerokube.com/selenoid/latest/#_video_recording)
* [Selenoid saving Session Logs](https://aerokube.com/selenoid/latest/#_saving_session_logs)
* Instead of using DesiredCapabilities, I used browser options which is now supported and recommended way of adding options to remote browsers. The
  problem was that ew the classes for browser options are separate like EdgeOptions, ChromeOptions etc. So I applied the DRY (Do not Repeat Yourself)
  clean coding priniciple with the help of Java generics to use the `AbstractDriverOptions` that is the parent class of all the browser options class.

```java
    /**
 * This method initializes the remote webdriver with browser capabilities defined in Test Suite parameters.
 * If the tests are to be executed on Selenium Grid with remote drivers and tests are run with gridMode= true then we initialize remote webdriver
 *
 * @param browserName Name of the browser is set in smoke-tests-distributed.xml file as test parameter "browser" e.g. chrome, firefox, edge, safari
 * @param browserVersion Browser version is set in smoke-tests-distributed.xml file as test parameter "browserVersion"
 * @param platform platform is set in smoke-tests-distributed.xml file as test parameter "platformName" e.g. windows mac, linux
 * @return RemoteWebDriver on hubURL configured in grid.properties with corresponding browser options
 * @throws MalformedURLException
 */
public static WebDriver initializeRemoteDriver(String browserName,String browserVersion,String platform)throws MalformedURLException{
        WebDriver driver;
        Properties gridProps=PropertyUtils.propertyLoader("src/test/resources/framework/properties/grid.properties");
        String hubAddress=gridProps.getProperty("hubURL");
        //selenoid grid have url of localhost:4444/wd/hub while Docker grid have url of localhost:44444
        hubAddress+=gridProps.getProperty("selenoid").equals("true")?"wd/hub":"";
        switch(browserName){
        case"chrome"->{
        ChromeOptions options=new ChromeOptions();
        setBrowserOptions(options);
        driver=new RemoteWebDriver(new URL(hubAddress),options);
        }
        case"firefox"->{
        FirefoxOptions options=new FirefoxOptions();
        setBrowserOptions(options);
        driver=new RemoteWebDriver(new URL(hubAddress),options);
        }
        case"edge"->{
        EdgeOptions options=new EdgeOptions();
        setBrowserOptions(options);
        driver=new RemoteWebDriver(new URL(hubAddress),options);
        }
        case"safari"->{
        //Docker grid and selenoid does not provide safari images
        SafariOptions options=new SafariOptions();
        options.setCapability("se:recordVideo",true);
        driver=new RemoteWebDriver(new URL(hubAddress),options);
        }
default ->throw new IllegalStateException("INVALID BROWSER: "+browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
        }

public static<T extends AbstractDriverOptions<?>> void setBrowserOptions(T options){
        //options.setCapability("browserVersion", browserVersion);
        //options.setCapability("platformName", platform);

        //**************************************//
        //selenoid video recording capabilities
        //**************************************//
        options.setCapability("selenoid:options",new HashMap<String, Object>(){{
        /* How to enable vnc Live Browser Screen */
        put("enableVNC",true);

        /* How to enable video recording */
        put("enableVideo",true);

        /* How To enable saving logs for a session */
        put("enableLog",true);

        /* How to set session timeout */
        put("sessionTimeout","5m");
        }});
        }
```

* [Selenoid with Docker Compose](https://aerokube.com/selenoid/latest/#_browsers_configuration_file)
* Now I created a new docker compose file named **docker-compose-selenoid.yml** with the following configuration. The videos and logs will get
  captured in project root directory under a new **selenoid** folder. I added the limit and timeout properties for my needs which may not be necessary
  for you if you are following.

```yaml
version: '3'
services:
  selenoid:
    network_mode: bridge
    image: aerokube/selenoid:latest-release
    volumes:
      - ./src/test/resources/framework/selenoid:/etc/selenoid
      - /var/run/docker.sock:/var/run/docker.sock
      - ./selenoid/video:/opt/selenoid/video
      - ./selenoid/logs:/opt/selenoid/logs
    environment:
      - OVERRIDE_VIDEO_OUTPUT_DIR=$PWD/selenoid/video
      - TZ=Europe/Berlin
    command: [ "-conf", "/etc/selenoid/browsers.json", "-video-output-dir", "/opt/selenoid/video", "-log-output-dir", "/opt/selenoid/logs", "-limit", "6", "-timeout", "5m0s", "-session-attempt-timeout", "5m0s" ]
    ports:
      - "4444:4444"

  selenoid-ui:
    image: aerokube/selenoid-ui:latest-release
    command: [ "--selenoid-uri", "http://selenoid:4444" ]
    network_mode: bridge
    links:
      - selenoid
    depends_on:
      - selenoid
    ports:
      - "8080:8080"
```

* Start the selenoid docker grid with `docker-compose -f docker-compose-selenoid.yml up`. It will start the selenoid and selenoid-ui.
* Now run the tests with `mvn clean test -D"gridMode=true" -D"scenariosInParallel=true" -PsmokeDockergrid` which will run the tests in chrome,
  firefox, and edge selenoid containers in parallel.
* <img src="doc/selenoid-containers.png"  alt="selenoid docker containers" width="1269">
* <img src="doc/selenoid-sessions.png"  alt="selenoid parallel sessions UI" width="1902">
* <img src="doc/selenoid-chrome-vnc.png"  alt="selenoid chrome session VNC" width="1919">

##### Add Selenoid Recordings to Allure Report

* Since I mentioned in one of the previous posts that we can add the recording videos from dynamic grid to allure report, so I implemented this use
  case for selenoid grid.
* The problem was that the selenoid recordings are generated inside a folder that gets renamed after the session is closed with a name of session ID.
* If you call Allure attachment method before, then it will generate error because Allure could not find the designated directory path.
* I had to hack around this problem with a bit of complex logic. I called the video attachment from the same method in hooks which waits for specied
  duration until the recording directory gets renamed to session ID and then it adds the video to allure report.
* I have also added the link to video file for th=e test case which gets stored on the host where selenoid is running
* Listing All Video Files `http://selenoid-host.example.com:4444/video/`
  *[Downloading Video Files from Selenoid](https://aerokube.com/selenoid/latest/#_downloading_video_files_from_selenoid)
* In my `BaseHooks.java` class inside the method where driver is shutdown, I added my custom
  method `AddVideo(sessionID, scenarioName, sessionBrowser);` to attach video

```java
    @After(order = 1)
public void teardown(Scenario scenario)throws InterruptedException{
        Capabilities cap=((RemoteWebDriver)context.driver).getCapabilities();
        String sessionBrowser=cap.getBrowserName();
        SessionId sID=((RemoteWebDriver)context.driver).getSessionId();
        String sessionID=sID.toString();
        String scenarioName=scenario.getName();

        if(driver!=null)driver.quit();

        //This method waits for driver session to be closed which will result in renaming of selenoid video so we can attach it to report
        //This method is intentionally placed in hook otherwise if placed in separate hook the session won't close
        AddVideo(sessionID,scenarioName,sessionBrowser);
        }
```

* The `addVideo()` method embeds the video to allure report and add some other properties like scenario name, browser info, session ID, local
  recording
  path, and the URL to video recording. It waits for the specified time until it finds the directory with name of session ID.

```java
    /**
 * Adds test video recording to allure report.
 * Order of 1 indicates that it will execute after driver is shutdown in the After hook with order 0
 * This order is necessary because selenoid recordings get renamed after the browser session is stopped
 * @param sessionID
 * @param scenarioName
 * @param sessionBrowser
 * @throws InterruptedException
 */
public void AddVideo(String sessionID,String scenarioName,String sessionBrowser)throws InterruptedException{

        //use this path for Dynamic Grid
        //String videoPath = System.getProperty("user.dir") + "\\assets\\test-recordings\\" + sID.toString() + "video.mp4";
        //use this path for Selenoid Grid
        String videoPath=System.getProperty("user.dir")+"\\selenoid\\video\\"+sessionID+".mp4";

        //Link to Video Recording on Selenoid server
        Properties gridProps=PropertyUtils.propertyLoader("src/test/resources/framework/properties/grid.properties");
        String hubAddress=gridProps.getProperty("hubURL");
        String selenoidRecordingUrl=hubAddress+"video/"+sessionID+".mp4";
        Allure.addAttachment("Selenoid Video Recording",
        "text/html",
        "<html><head></head><body>"+
        "<p><b>Scenario:</b> "+scenarioName+"</p>"+
        "<p><b>Browser:</b> "+sessionBrowser+"</p>"+
        "<p><b>Session ID:</b> "+sessionID+"</p>"+
        "<p><b>Session recording root path :</b> /selenoid/video/"+sessionID+".mp4</p>"+
        "Video Url: <a href='"+selenoidRecordingUrl+"' target='_blank'>"+selenoidRecordingUrl+"</a>"+
        "</body></html>",
        ".html");

        //Embedded mp4 video recording in Allure report
        if(waitForSelenoidVideoToRename(videoPath,30000)){
        try{
        byte[]byteArr=IOUtils.toByteArray(new FileInputStream(videoPath));
        Allure.addAttachment("Embedded mp4 recording "+sessionID+".mp4","video/mp4",new ByteArrayInputStream(byteArr),"mp4");
        }catch(IOException e){
        e.printStackTrace();
        }
        }else{
        System.out.println("Unable to add video recording to allure report for test: "+scenarioName);
        System.out.println("Selenoid video recording not found for session ID: "+sessionID+" , Browser: "+sessionBrowser);
        }
        }
```

* This method `waitForSelenoidVideoToRename` waits for the specified file with the specified duratiuon before returning:

```java
/**
 * Selenoid video file name by default is <session-id>.mp4.
 * Example - selenoid7a408b66263ee21c5e896514aa938105.mp4 is temporary file name which is renamed to correct one when browser session is stopped.
 * This method waits for 30 seconds and performs check for presence of renamed file in specified path. If found it will return true.
 * If renamed file is not found in specified path then method will return false after waiting for a maximum of 30 seconds.
 * @param filePath File path string where selenoid session recording is downloaded
 * @param maxWaitInMillis maximum waiting time in milliseconds to check the presence of renamed file before returning false
 * @return true if file is found within 10 seconds else false
 * @throws InterruptedException
 */
public boolean waitForSelenoidVideoToRename(String filePath,long maxWaitInMillis)throws InterruptedException{
        File file=new File(filePath);
        //Start time
        Instant start=Instant.now();
        while(!file.exists()){
        Thread.sleep(1000);
        //End time
        Instant finish=Instant.now();
        long timeElapsed=Duration.between(start,finish).toMillis();
        if(timeElapsed>maxWaitInMillis)return false;
        }
        return true;
        }
```

* And here is the result where you can see the attached video recording of selenoid session to test in allure report:
* <img src="doc/selenoid-video-allure.png"  alt="selenoid recording attachment in allure report" width="844">
* Further Readings:
    * [Selenoid Tutorial | Docker-Selenium Alternative for Parallel Testing](https://www.swtestacademy.com/selenoid-tutorial/)
    * [Execute Tests in Docker Containers using Selenoid](https://docs.bellatrix.solutions/web-automation/execute-tests-selenoid/)
    * [Execute Tests in Docker Containers Using Selenoid](https://www.automatetheplanet.com/execute-webdriver-tests-docker-selenoid/)
    * [How to install Selenoid with Docker Compose](https://devopslite.com/how-to-install-selenoid-with-docker-compose/)

##### Scaling Selenoid Tests with GGR and Moon

* **Ggr**
    * Go Grid Router (aka Ggr) is a lightweight active load balancer used to create scalable and highly-available Selenium clusters.
    * [Ggr GitHub](https://github.com/aerokube/ggr)
* **Moon - Selenoid on Kubernetes**
    * Moon is a commercial closed-source solution for organizing browser automation infrastructure. It is fully compatible with Selenium, Playwright,
      Cypress and Puppeteer. Moon is using Kubernetes or Openshift to launch browsers.
    * [Moon GitHub](https://github.com/aerokube/moon)
    * [Moon Aerokube](https://aerokube.com/moon/)

* **Further Readings**
* [Selenium Grid 4: Do you really need it?](https://blog.aerokube.com/selenium-grid-4-do-you-really-need-it-ab03366625b0)
* [Next Mission to Moon: Cross Browser Selenium Testing in Kubernetes](https://blog.aerokube.com/next-mission-to-moon-cross-browser-selenium-testing-in-kubernetes-e2721144591a)
* [Selenium in Kubernetes: Moon vs Selenoid by Personio](https://www.youtube.com/watch?v=13OxAUuQ5q4)
* [Scalable Selenium Cluster: Up & Running | Ivan Krutov](https://www.youtube.com/watch?v=TGjpc32my0Y)
* [Master-class: Bulletproof Selenium cluster by Ivan Krutov #SeConf2020](https://www.youtube.com/watch?v=v3uvpAvdSq8)

---

### Framework - Maven Command Line

* We can use maven commands in Jenkins to run the tests as a part of CI pipeline.
* `mvn clean test` will execute the tests in default environment i.e. STAGE and default browser i.e. chrome.
* To customize the test run, we can add parameters like `mvn clean test -Denv=STAGE -Dbrowser=chrome`.
* If we want to run specific scenarios, then we can provide the tags like `mvn clean test -Denv=STAGE -Dbrowser=chrome -Dcucumber.filter.tags=@smoke`,
  this will run only the scenarios that are tagged as `@smoke`.
* If we want to use run through CLI runner, then we can give the following command as below. The
  `mvn exec:java -Dexec.classpathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main -Dexec.args="src/test/resources/framework/features --glue framework --threads 2" -Dcucumber.filter.tags=@smoke`
* Another way is to provide cucumber tags directly as part of args:
  `mvn exec:java -Dexec.classpathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main -Dexec.args="src/test/resources/framework/features --glue framework --tags @smoke --threads 2"`

---

### Framework - Integration with GitHub

* Create a GitHub Repository
* Initialize the git repo locally and set a remote origin to your GitHub repo
* Add git files for staging
* Commit the code wih a message
* Push changes to remote repo

---

### Framework - CI

[Jenkins Tutorial] (https://www.guru99.com/jenkins-tutorial.html)

#### Windows. Install and Configure Jenkins

* Download site: https://www.jenkins.io/download/
* Open CMD prompt from directory where .war file is placed and type `java -jar jenkins.war`
* Launch `http://localhost:8080`
    * If the default port is occupied, you can also change the port via `java -jar jenkins.war --httpPort=8085`
* Unlock Jenkins by copying the Admin Password from the address shown in installation window. Usually in **Jenkins\secrets\initalAdminPassword**
  location.
* Create first admin user and login

#### Create Automation Jenkins Job

* Creat a new `Freestyle prject`
* In `Source Code Management`, select `Git` so jenkins can download the source code from Git Repo and execute maven commands to run tests.
* Provide the repo URL (HTTPS) and add GitHub credentials
* If you want to build a specific branch, then under `Branches to Build`, specify your branch for example `*/cucumber-BDD-OC`
* If you want Jenkins to only checkout the specific folder in Git repo and execute the build, then follow the following steps:
    * Click on `Additional Behaviors Add` dropdown and choose `Sparse Checkout paths`
    * Give relative path to your folder where POM.xml exists for example in this case it will be `CucumberBDD-OC/`
    *
  <img src="doc/git-branch.JPG"  alt="Git branch and sparse checkout" width="1285">
* If the POM.xml is not located in the root folder of the project, then specify the location in `Goals` for-example in this case it will
  be `$workspace\CucumberBDD-OC\pom.xml`
* Under `Build Triggers` , there are various options for example:
    * `Build Periodically` will execute the tests after specified periodic interval
      regularly.
    * [Schedule Jenkins build periodically - hourly, daily, weekly. Jenkins schedule format](https://www.lenar.io/jenkins-schedule-build-periodically/)
      <img src="doc/jenkins-schedule-format.JPG"  alt="jenkins build schedule format" width="600">

    * `Poll SCM` will poll the GitHub with a specified frequency for any code changes and trigger build
    * `Github hook trigger for GITScm polling` will trigger the Jenkins build on every commit
    * `Build after other projects are built` will trigger after another specified Jenkins job is triggered
* Under `Build` option, choose `Invoke top-level Maven targets` since we will use Maven commands to run our tests
    * Under `Goals`, provide the maven command that will run the tests for example, `test`. (do no need to write mvn test, because Jenkins
      automatically adds it)
    * you can also add optional parameters like `mvn clean test -Denv=STAGE -Dbrowser=chrome` by clicking on advanced section and the under
      properties:
        * you can send the goal `clean test` with parameters as key-value pairs on new line without `-D` like:
      ````properties
       env=STAGE
       browser=chrome
      ````
* Click on `Build Now` that will trigger the Jenkins job. In the `Build History` you have the options to:
    * view logs with `Console Output` to see the current status

#### Jenkins Auto Trigger - SCM Polling

* Click on the Jenkins job, then `Configure` and under `Build Triggers`, choose `Poll SCM` option
* Click on the question mark icon next to it which will show the detail of cron syntax to specify the polling interval. It will poll the repo for any
  changes, and trigger the build if it finds any new commits.
* If there are multiple jobs to be triggered on the same time then to avoid conflicts use `H/20 * * * *` which will trigger build every 20 minutes.
* Jenkins will also show the prompt below to tell when will the build trigger next.
* Under `Git Polling Log`, you can see all the logs when Jenkins polled the repo for any changes and commits

#### Jenkins Auto Trigger - Build Frequency

* Under `Build Triggers - Build periodically` - Schedule you can create a schedule (or multiple schedules) for Jenkins to build periodically or on a
  specific date/time.
* This option is useful for nightly builds
* The best approach is to use GitHub web hook trigger so continuous integration can start build as soon as change is made in main repo.

#### Jenkins Auto Trigger - GitHub Web Hooks

* Under `Build Triggers - GitHub hook trigger for GITScm polling`, jenkins will trigger `GIT SCM polling logic` only if it receives push from GitHub
  that will only be made if there is a change in GitHub repo with a merge or pull-request.
* To use this option, install the plugin via `Manage Jekins -> Manage plugins` and install `GitHub Integration` plugin.
* In order for GitHub to communicate to Jenkins, the local jenkins instance must be exposed to internet.
    * Download and Install the ngrok https://ngrok.com/download
    * To start an HTTP tunnel on port 80, run this command from where the `ngrok.exe` is downloaded: `ngrok http 80`. It will convert the local
      jenkins
      instance to a URL which can be used to access our jenkins online.
* Now navigate to the GitHub repo online and under GitHub `Settings -> WebHooks -> Add WebHook`, provide the url from ngrok as Payload Url and
  append `/github-webhook/` at the end of Url
* Choose Content-type as application/json
* Choose Enable SSL Verification
* Choose `Just the push event` to trigger the WebHook
* Then click on `Add webhook`
* GitHub will make the post call to Jenkins via URL we provided as Payload URL in Github-webhook whenever there is a change to repo.
* Confirm the connection by verifying the `re-deliver` option of webhook in GitHub

#### Jenkins - Parameterized Build

* Under General section, choose `This project is parameterized`, and in `Add parameter` dropdown, choose `Choice Parameter`
* Now specify the maven additional parameters as key-value pairs:
    * for different browsers support, enter `browser` as Name, and give firefox and chrome as choices as these are configured in DriverFactory.
    * for different environment support, enter `environment` as Name, and give PROD and STAGE as choices as these are configured in ConfigLoader to
      load url.
    * Similarly, you can also add a choice parameter for tags
* Now in the `Goals` section, enter the goal `test -Dcucumber.filter.tags="@"$tags"" -Dbrowser="$browser" -Denv="$environment"`
* <img src="doc/jenkins-build-steps.JPG"  alt="jenkins build steps" width="1274">
* Now Go to the project in Jenkins, and you will see the option `Build with parameters`
* <img src="doc/jenkins-parameterized-build.JPG"  alt="jenkins parameterized build" width="959">
* Jenkins will trigger the build with specified parameters, and after the build is finished you can go to `Console Output` and navigate to the
  Cucumber reports URL, which will show you the result of test run.
* <img src="doc/cucumber-jenkins-report.JPG"  alt="jenkins cucumber report" width="1296">
* Alternatively you can navigate to the jenkins workspace directory on your PC to locate the Extent Spark reports generated in test-output folder.
* <img src="doc/extent-report-jenkins-workspace.JPG"  alt="extent report" width="1898">

#### Jenkins - Cucumber reports

* If you are running your tests from Jenkins, it is important for you to the reports from CI in our case Jenkins.
* [Cucumber reports](https://plugins.jenkins.io/cucumber-reports/) a Java Jenkins plugin which publishes html showing the results of cucumber runs.
* To use this option, install the plugin via `Manage Jekins -> Manage plugins` and install `Cucumber Reports` plugin. After installation, restart the
  Jenkins server.
* <img src="doc/cucumber-reports-plugin.JPG"  alt="cucumber report plugin" width="994">
* This plugin requires that you use cucumber library to generate a json report. The plugin uses the json report to produce html reports that are
  available from jenkins on the build page after a build has run. So to do this, just add the following line in your `@CucumberOptions` annotation
  inside `plugin`

````java
"json:target/cucumber/cucumber.json"
````

* Make sure to push the changes to GitHub so Jenkins can fetch these changes from git before triggering the build.
* In Jenkins, Go to your project, click on Configure and at the very bottom in Post-build Actions, choose Cucumber reports from dropdown selector.
* In JSON Report Location options, specify the following 2 options:
    * Give the path of your base folder where json report will be published, in our case you can give the following in JSON Reports Path
      `$workspace\<NAME OF YOUR PROJECT FOLDER>\target\cucumber`
    * Name of your json report as `cucumber.json`
* You can also ignore the above 2 parameters in which case the plugin will scan the entire workspace for build and find the files ending with .json to
  publish the report.
* To execute, click the “Build Now” button from the left menu for the job. The build should be successful. Instead of watching console output, select
  “Cucumber reports” at the end of the build.
* <img src="doc/cucumber-reports-features.JPG"  alt="cucumber report features" width="1885">
* <img src="doc/cucumber-reports-scenarios.JPG"  alt="cucumber report scenarios" width="1891">
* <img src="doc/cucumber-reports-steps.JPG"  alt="cucumber report steps " width="1885">
* <img src="doc/cucumber-reports-steps-stats.JPG"  alt="cucumber report steps stats" width="1875">
* <img src="doc/cucumber-reports-tags.JPG"  alt="cucumber report tags" width="1897">
* <img src="doc/cucumber-reports-trends.JPG"  alt="cucumber report trends" width="1860">
* <img src="doc/cucumber-reports-failures.JPG"  alt="cucumber report failures" width="1878">

---

#### Jenkins - Allure reports

* [Allure Jenkins](https://docs.qameta.io/allure/#_jenkins)
* To generate Allure Report in Jenkins, we need to download [Allure Plugin](https://plugins.jenkins.io/allure-jenkins-plugin/). This plugin allows to
  automatically generate Allure Report and attach it to build during Jenkins job run.

##### Install Allure Jenkins Plugin

* [How to install Plugins in Jenkins](https://qaautomation.expert/2022/12/12/how-to-install-plugins-in-jenkins/)
* Click on the **Manage Jenkins**. As soon as we click on the Manage Jenkins link, we will redirect toward the Manage Jenkins page, and here we need
  to
  click on “**Manage Plugins**” under the System Configuration section.
* On the Plugins Page, go to the Available option, and install Allure plugin.

##### Configure Allure Jenkins Plugin

* [Integration of Allure Report with Jenkins](https://qaautomation.expert/2022/12/02/integration-of-allure-report-with-jenkins/)
* Go back to the **Manage Jenkins** link, and click on the **Global Tool Configuration** option under System Configuration.
* We need to set the **Allure Commandline** in Jenkins. Click on the **Allure Command line installations** button. By default, “Install Automatically”
  will be checked, so since we are going to use the Allure installed on our local machine, **Install automatically** will install the latest version
  of
  Allure.
* Provide the Name as **ALLURE_HOME** because that is what is currently installed on my machine, and also provide the path of Allure in the
  ALLURE_HOME textbox.
* Click on Apply and Save button.

##### Add Post-Build Action in Jenkins Job for Allure Report

* Scroll down to ‘**Post Build Actions**’ and click on the ‘**Add Post Build Actions**’ drop-down list. Select “**Allure Report**“.
* Enter the Results Path where the allure-results are getting generated in your project. In my case, it is getting generated under target directory
  <img src="doc/jenkins-allure-report-post-build.JPG"  alt="jenkins allure report post build action" width="1200">
* Click on Apply and Save button.

##### Execute Jenkins Job and view Allure Report

* Execute the build, click on **Console Output** to see the result.
  <img src="doc/jenkins-allure-console-output.JPG"  alt="jenkins allure console output" width="1200">
* Once the execution is completed, we could see a link to view the **Allure Report**.
  <img src="doc/jenkins-allure-view-results.JPG"  alt="jenkins allure view results" width="1200">
* The Allure Report generated via Jenkins plugin will look like this:
  <img src="doc/allure-dashboard.JPG"  alt="jenkins allure dashboard" width="1200">