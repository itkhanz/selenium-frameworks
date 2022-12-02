# Cucumber BDD Framework with Selenium and Java

### Technology Stack

![stack](doc/stack.JPG)

### Key Learnings from the Course

![learnings](doc/learning.JPG)

## Installation and Setup

* Install JAVA JDK (version 17 and above) and set **JAVA_HOME** `C:\Program Files\Java\jdk-17.0.5` as system environment variable
* Download and install Maven build tool, and set **MAVEN_HOME** `C:\Program Files\apache-maven-3.8.5` system environment variable
* Add the path of bin folders in System Path variable like _%JAVA_HOME%\bin_ and _%JAVA_HOME%\bin_
* Run the commands in Command Prompt to verify the installation `java -version` and `mvn -version`
* Intellij IDEA and install the Plugins (Cucumber, Gherkin)
* Install the maven dependencies listed in POM.xml (or build the POM.xml in this case so the dependencies can be installed)

### Course Notes

* If you get error while executing the dummy feature, then delete the main.java and org.example package and  main or app pre-generated test classes.Then right click on the
  project root directory and build the project. If you change the folder paths or names, then also rebuild the project by right clicking the project root directory.
* 