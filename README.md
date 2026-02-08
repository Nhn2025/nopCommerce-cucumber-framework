# Cucumber Automation Framework (Java + Selenium)

This project is an automation test framework built with **Java, Selenium WebDriver, and Cucumber (BDD)** following the **Page Object Model (POM)** design pattern.  
It is designed to be scalable, maintainable, and ready for real-world testing projects.

---

## Tech Stack

- Java
- Selenium WebDriver
- Cucumber (BDD)
- Maven
- Page Object Model (POM)
- Driver Factory Pattern
- IntelliJ IDEA

---

##  Prerequisites

Make sure you have installed:

- **Java JDK 8+**
- **Maven**
- **Google Chrome**
- **IntelliJ IDEA**
- Cucumber for Java plugin (IntelliJ)

---

##  Install Dependencies

All dependencies are defined in `pom.xml`.

Run the following command:

```bash
mvn clean install
```

---

##  Running the Tests
Run all tests
```mvn test```

Run with specific environment
```mvn test -Denv=dev```


---

##  Viewing Results
After execution, reports are generated inside:

```target/```

Includes:
- Cucumber HTML Report
- Execution logs
- Test results

---

##  Example Folder Structure
Here's an example of what your project directory might look like:
````
src
 ├── main
 │    └── java
 │         ├── commons
 │         │     ├── BasePage.java
 │         │     ├── DriverFactory.java
 │         │     ├── GlobalConstants.java
 │         │     └── PageGenerator.java
 │         │
 │         ├── pages
 │         │     ├── LoginPage.java
 │         │     └── DashboardPage.java
 │         │
 │         └── pageUIs
 │               ├── LoginPageUI.java
 │               └── DashboardPageUI.java
 │
 ├── test
 │    ├── java
 │    │     ├── stepDefinitions
 │    │     │     ├── Hooks.java
 │    │     │     └── LoginSteps.java
 │    │     │
 │    │     └── runners
 │    │           └── TestRunner.java
 │    │
 │    └── resources
 │          └── features
 │                └── login.feature
````