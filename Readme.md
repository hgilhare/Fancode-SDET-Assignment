# API Automation with Cucumber

This project demonstrates API automation testing using Behavior-Driven Development (BDD) with Cucumber.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Project Structure](#project-structure)
- [Writing Tests](#writing-tests)
- [Running Tests](#running-tests)
- [Reporting](#reporting)

## Prerequisites

- Java JDK 8 or higher
- Maven
- Your favorite IDE (IntelliJ IDEA, Eclipse, etc.)

1. Clone this repository:
   ```
   git clone https://github.com/hgilhare/Fancode-SDET-Assignment.git
   ```

2. Install dependencies:
   ```
   mvn clean install
   ```
## Project Structure

```
api-automation-cucumber/
├── src/
│   ├── main/       
│   └── test/
│       ├── java/
│            ├── featureFile
│            ├── helperFile
│            ├── PageFile
│            ├── PropertyFile
│            ├── stepsdefination
│            └── Testrunner
│        
├── pom.xml
└── Readme.md
```

## Writing Tests

1. Create feature files in `src/test/java/featureFile/` using Gherkin syntax.
2. Implement step definitions in `src/test/java/stepdefinationFile/`.
3. Create API request and response page object model in `src/test/java/pageFile`.

Example feature file (`fanCodeCityTestCases.feature`):

```gherkin
Feature: verifying fanCode city user
   Scenario: All the users of City FanCode should have more than half of their todos task completed.
      Given User has the todo tasks
      When User belongs to the city FanCode
      Then User Completed task percentage should be greater than <50> percent
```
## Running Tests

Execute tests using Maven:

```
mvn clean test
```

To run specific tags:

```
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Reporting

Cucumber generates reports in the `target/cucumber-reports/Report.html` directory after test execution.