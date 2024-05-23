# WebTestAutomation

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?style=flat-square&logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat-square&logo=selenium&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit&logoColor=white)

## Project Overview

This project is a web automation testing suite for the site [Sauce Demo](https://www.saucedemo.com/) using Selenium and Cucumber. The tests are written in Java and managed using Maven.

## Project Structure

```
WebTestAutomation
   ├─ main
   │  └─ java
   │     └─ com
   │        └─ swaglabs
   └─ test
      ├─ java
      │  └─ swaglabs
      │     ├─ pages
      │     │  ├─ HomePage.java
      │     │  ├─ LoginPage.java
      │     │  └─ LogoutPage.java
      │     ├─ runner
      │     │  └─ RunCucumberTest.java
      │     ├─ steps
      │     │  ├─ LoginSteps.java
      │     │  └─ LogoutSteps.java
      │     └─ utils
      │        ├─ ChromeDriverSetup.java
      │        └─ CucumberReportGenerator.java
      └─ resources
         ├─ features
         │  ├─ login.feature
         │  └─ logout.feature
         └─ properties-1.properties
```

### Explanation of Project Structure

- **main/java/com/swaglabs**: Contains the main Java source files. Currently, this directory is reserved for future expansions and core application code.

- **test/java/swaglabs/pages**: Contains the Page Object Model (POM) classes.
  - **HomePage.java**: Represents the home page of the application.
  - **LoginPage.java**: Represents the login page of the application.
  - **LogoutPage.java**: Represents the logout functionality of the application.

- **test/java/swaglabs/runner**: Contains the test runner class.
  - **RunCucumberTest.java**: Configures and executes the Cucumber tests.

- **test/java/swaglabs/steps**: Contains the step definitions for the Cucumber tests.
  - **LoginSteps.java**: Contains the step definitions for the login scenarios.
  - **LogoutSteps.java**: Contains the step definitions for the logout scenarios.

- **test/java/swaglabs/utils**: Contains utility classes.
  - **ChromeDriverSetup.java**: Sets up the Chrome WebDriver for the tests.
  - **CucumberReportGenerator.java**: Generates Cucumber HTML reports after tests execution.

- **resources/features**: Contains the feature files written in Gherkin language.
  - **login.feature**: Contains the scenarios related to login functionality.
  - **logout.feature**: Contains the scenarios related to logout functionality.

- **resources/properties-1.properties**: Contains properties and configuration files for the project.

## Prerequisite

- **Java (JDK 17)**: Ensure Java is installed and configured properly.
- **Maven**: Install Maven for managing project dependencies and running tests.
- **IDE (e.g., Visual Studio Code)**: Recommended for code editing and project management.

## How to Run

1. **Clone the project**:
   ```bash
   git clone https://github.com/your-repo/WebTestAutomation.git
   ```

2. **Open a terminal and navigate to the project directory**:
   ```bash
   cd WebTestAutomation
   ```

3. **Run the tests**:
   ```bash
   mvn clean verify
   ```

4. **View the test report**:
   - Test report can be found at `target/cucumber-html-reports`.

## Features and Scenarios

### Login Feature

#### User Login

**Feature**: User Login
  As a user
  I want to be able to login to my account
  So that I can access my personalized content

  - **@TC1**: Successful login
    - Given I am on the login page
    - When I enter my username and password
    - And I click the login button
    - Then I should be logged in successfully

  - **@TC2**: Failed login with unregistered password
    - Given I am on the login page
    - When I enter my username and an unregistered password
    - And I click the login button
    - Then I should see an error message password invalid

  - **@TC3**: Failed login with unregistered username
    - Given I am on the login page
    - When I enter an unregistered username and my password
    - And I click the login button
    - Then I should see an error message username invalid

  - **@TC4**: Failed login with empty username
    - Given I am on the login page
    - When I leave the username field empty
    - And I enter my password
    - And I click the login button
    - Then I should see an error message empty username

  - **@TC5**: Failed login with empty password
    - Given I am on the login page
    - When I enter my username
    - And I leave the password field empty
    - And I click the login button
    - Then I should see an error message empty password

  - **@TC6**: Failed login with empty username and password
    - Given I am on the login page
    - When I leave the username and password fields empty
    - And I click the login button
    - Then I should see an error message empty username and password

### Logout Feature

#### User Logout

**Feature**: User Logout
  As a logged-in user
  I want to be able to logout from my account
  So that I can securely end my session

  - **@TC7**: Logout from the application
    - Given I am logged in
    - When I click the burger menu
    - And I click the logout button
    - Then I should be logged out successfully

## Authors

- **Dafa Nurul Fauziansyah** - [GitHub](https://github.com/dafanf)
- **Fariz Rahman Maulana** - [GitHub](https://github.com/FarizRahmanM)
- **Muhammad Deo Audha Rizki** - [GitHub](https://github.com/deo23)
