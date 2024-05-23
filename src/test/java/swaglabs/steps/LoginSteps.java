package swaglabs.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.LoginPage;
import swaglabs.utils.ChromeDriverSetup;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    // Add this method to the existing LoginSteps class
    public WebDriver getDriver() {
        return driver;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        try {
            // Automatically download and setup ChromeDriver for version 125.0.6422.60
            ChromeDriverSetup.downloadAndExtractChromeDriver();
            driver = ChromeDriverSetup.createWebDriver();
            driver.get("https://www.saucedemo.com/");
            // Initialize the LoginPage object
            loginPage = new LoginPage(driver);
            System.out.println("LoginPage object initialized successfully.");
        } catch (Exception e) {
            System.err.println("Error initializing LoginPage object: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("I enter invalid username and\\/or password")
    public void i_enter_invalid_username_and_password() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("invalid_password");
    }

    @When("I enter my username and an unregistered password")
    public void i_enter_my_username_and_an_unregistered_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_password");
    }

    @When("I enter an unregistered username and my password")
    public void i_enter_an_unregistered_username_and_my_password() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("I leave the username field empty")
    public void i_leave_the_username_field_empty() {
        loginPage.enterUsername("");
    }

    @When("I enter my password")
    public void i_enter_my_password() {
        loginPage.enterPassword("secret_sauce");
    }

    @When("I leave the password field empty")
    public void i_leave_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("I enter my username")
    public void i_enter_my_username() {
        loginPage.enterUsername("standard_user");
    }

    @When("I leave the username and password fields empty")
    public void i_leave_the_username_and_password_fields_empty() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @Then("I should see an error message password invalid")
    public void i_should_see_an_error_message_password_invalid() {
        // Locate the error message element
        WebElement errorMessageElement = driver.findElement(By.className("error-message-container"));

        // Extract the text from the error message element
        String actualErrorMessage = errorMessageElement.getText();

        // Define the expected error message
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        // Assert that the actual error message matches the expected error message
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see an error message username invalid")
    public void i_should_see_an_error_message_username_invalid() {
        // Locate the error message element
        WebElement errorMessageElement = driver.findElement(By.className("error-message-container"));

        // Extract the text from the error message element
        String actualErrorMessage = errorMessageElement.getText();

        // Define the expected error message
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        // Assert that the actual error message matches the expected error message
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see an error message empty username")
    public void i_should_see_an_error_message_username_is_required() {
        // Locate the error message element
        WebElement errorMessageElement = driver.findElement(By.className("error-message-container"));

        // Extract the text from the error message element
        String actualErrorMessage = errorMessageElement.getText();

        // Define the expected error message
        String expectedErrorMessage = "Epic sadface: You Need Username";

        // Assert that the actual error message matches the expected error message
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see an error message empty password")
    public void i_should_see_an_error_message_password_is_required() {
        // Locate the error message element
        WebElement errorMessageElement = driver.findElement(By.className("error-message-container"));

        // Extract the text from the error message element
        String actualErrorMessage = errorMessageElement.getText();

        // Define the expected error message
        String expectedErrorMessage = "Epic sadface: You Need Password";

        // Assert that the actual error message matches the expected error message
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see an error message empty username and password")
    public void i_should_see_an_error_message_username_is_required_and_password_is_required() {
        // Locate the error message element
        WebElement errorMessageElement = driver.findElement(By.className("error-message-container"));

        // Extract the text from the error message element
        String actualErrorMessage = errorMessageElement.getText();

        // Define the expected error message
        String expectedErrorMessage = "Epic sadface: You Need Username & Password";

        // Assert that the actual error message matches the expected error message
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
