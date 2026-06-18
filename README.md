# OrangeHRM Selenium Automation Framework

Selenium WebDriver automation framework for OrangeHRM Demo application.
Built with Java, TestNG, and Page Object Model (POM) design pattern.

--------------------------

## Tech Stack

- Java
- Selenium WebDriver 4.x
- TestNG  7.x
- Maven
- ExtentReports 5.x
- Jenkins (CI/CD)
- Git

-------------------------

## Project Structure

src/test/java
├── base
│   └── LaunchBase.java          - Browser setup and teardown
├── pages
│   ├── LoginPage.java           - Login page locators and actions
│   ├── DashboardPage.java       - Dashboard page locators and actions
│   └── PIModule.java            - PIM module (Add/Search Employee)
├── tests
│   ├── LoginTests.java          - Valid and invalid login tests
│   ├── DashboardTests.java      - My Info and logout tests
│   └── PIMTests.java            - Add employee and search tests
└── listeners
    └── ExtentTestNGListener.java - Auto screenshot and HTML reporting

-------------------------

## How to Run

Run all tests:
mvn clean test

Run specific test class:
mvn test -Dtest=LoginTests

---

## Test Report

After execution, HTML report is generated at:
test-output/ExtentReports/Report.html

Includes pass/fail status, error logs, and failure screenshots.

--------------------------

## Author

Tejeswar
 QA Automation Engineer | Selenium | Java | TestNG | Maven | Jenkins