# Cucumber BDD Framework with Selenium and Java

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
    * ![discovery workshop mapping](doc/rule.JPG)
    * ![rule gherkin](doc/rule%20gherkin.JPG)
* you can put `asterisk *` to avoid writing multiple And keywords in the beginning of the step.
* But keyword designates the negation.
* **Steps Anti-Patterns**
    * Write the Gherkin in the form of business documents and avoid writing as user interaction steps. Stick to the core flow, and hide the
      implementation in steps definitions.
    * ![steps anti-patterns](doc/steps-anti-patterns.JPG)
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
* ![refactored-gherkin](doc/refactored-gherkin.JPG)

> Gherkin serves as a Living documentation which is a single source of truth for all the stakeholders. Writing good Gherkin means a readable and
> understandable Living documentation. The Living documentation should clearly show the current state of the system, what behaviors are working, what
> are pending and what are not working. If we don't use Gherkin to describe the behavior of the system, the whole purpose of writing Gherkin gets
> defeated. Then it just becomes a UI action script written in plain language. Just an unnecessary wrapper on top of the underlying automation layers
> that can result into high maintenance.

---

### Runners

* If the cucumber feature and steps definitions are under the same root folder i.e. `src/test/java`, then Cucumber can automatically find the steps
  for
  the features.
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
* Step hooks invoked before and after a step. The hooks have ‘invoke around’ semantics. Meaning that if a `BeforeStep` hook is executed the `AfterStep`
  hooks will also be executed regardless of the result of the step. If a step did not pass, the following step and its hooks will be skipped.
* 

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

---

### Anti-patterns

---

## Framework

### Framework - Driver Initialization

### Framework - Page Object Model

### Framework - Domain Objects

### Framework - Optimizations

### Framework - Parallel Execution

### Framework - Dependency Injection using Pico-container

### Framework - Optimizations

### Framework - API Integration using RestAssured

### Framework - Reports

### Framework - Maven Command Line

### Framework - Integration with GitHub

### Framework - CI

