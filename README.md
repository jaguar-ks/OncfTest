# ONCF Test Automation Project

This repository contains a UI test automation project for ONCF login scenarios using Selenium, Cucumber, and Maven.

## Overview

The project validates login behavior on https://www.oncf-voyages.ma/ with a Cucumber scenario outline and generates HTML and JSON reports under target/cucumber-reports.

## Technologies Used

| Technology | Badge | Version |
| --- | --- | --- |
| Java | ![Java](https://img.shields.io/badge/Java-17-007396?logo=openjdk&logoColor=white) | 17 |
| Maven | ![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white) | 3.8+ |
| Selenium WebDriver | ![Selenium](https://img.shields.io/badge/Selenium-4.20.0-43B02A?logo=selenium&logoColor=white) | 4.20.0 |
| Cucumber Java | ![Cucumber](https://img.shields.io/badge/Cucumber%20Java-7.15.0-23D96C?logo=cucumber&logoColor=white) | 7.15.0 |
| Cucumber JUnit | ![Cucumber](https://img.shields.io/badge/Cucumber%20JUnit-7.15.0-23D96C?logo=cucumber&logoColor=white) | 7.15.0 |
| JUnit 4 (runner) | ![JUnit](https://img.shields.io/badge/JUnit%204-4.13.2-25A162?logo=junit5&logoColor=white) | 4.13.2 |
| JUnit 5 (BOM/libs) | ![JUnit](https://img.shields.io/badge/JUnit%205-5.11.0-25A162?logo=junit5&logoColor=white) | 5.11.0 |
| dotenv-java | ![dotenv](https://img.shields.io/badge/dotenv--java-3.2.0-2D2D2D) | 3.2.0 |

## Prerequisites

Install the following tools:

- JDK 17+
- Maven 3.8+
- Google Chrome or Mozilla Firefox

Notes:

- Browser selection is controlled by the environment variable browser loaded from a .env file.
- Supported values are chrome and firefox.
- Selenium 4 Selenium Manager can handle browser driver resolution automatically in many environments.

## Installation (Step-by-Step)

1. Verify Java and Maven are installed.

```bash
java -version
mvn -version
```

2. Clone the repository.

```bash
git clone git@github.com:jaguar-ks/OncfTest.git
```

3. Enter the project folder.

```bash
cd oncf-test
```

4. Create a .env file at the project root.

```bash
touch .env
```

5. Add browser configuration to .env.

Example .env:

```env
browser=chrome
```

Supported values:

- chrome
- firefox

6. Build the project and download dependencies.

```bash
mvn clean compile
```

## Running Tests

Run all tests:

```bash
mvn clean test
```

Run only the Cucumber runner class:

```bash
mvn -Dtest=oncf.runners.TestRunner test
```

## Test Reports

After execution, reports are generated in:

- target/cucumber-reports/report.html
- target/cucumber-reports/report.json

Surefire reports are generated in:

- target/surefire-reports

## Repository Structure

```text
oncf-test/
|-- pom.xml
|-- README.md
|-- src/
|   |-- main/
|   |   |-- java/
|   |       |-- oncf/
|   |           |-- App.java
|   |-- test/
|       |-- java/
|           |-- oncf/
|           |   |-- base/
|           |   |   |-- BaseTest.java
|           |   |-- pages/
|           |   |   |-- LoginPage.java
|           |   |-- runners/
|           |   |   |-- TestRunner.java
|           |   |-- steps/
|           |   |   |-- LoginSteps.java
|           |   |-- utils/
|           |       |-- DriverFactory.java
|           |-- resources/
|               |-- features/
|                   |-- login.feature
|-- target/
    |-- cucumber-reports/
    |-- surefire-reports/
    |-- classes/
    |-- test-classes/
```

## Current Covered Scenario

- Login with invalid credentials and verify error message.
- Login with valid credentials and verify success message.

## Troubleshooting

- If browser is not configured, the test fails with browser not specified.
- If browser value is not chrome or firefox, the driver factory throws a not supported error.
- If UI selectors change on the ONCF website, page object locators may need updates.
