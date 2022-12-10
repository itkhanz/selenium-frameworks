# Cucumber BDD Framework with Selenium and Java

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

---

### Framework - Parallel Execution

---

### Framework - Dependency Injection using Pico-container

---

### Framework - Optimizations

---

### Framework - API Integration using RestAssured

---

### Framework - Reports

---

### Framework - Maven Command Line

---

### Framework - Integration with GitHub

---

### Framework - CI

