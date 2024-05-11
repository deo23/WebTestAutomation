package swag;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    private WebDriver driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("Opening the login page...");
        try {
            // Setting up WebDriver for Chrome
            System.setProperty("webdriver.chrome.driver", "/home/dafanf/Downloads/ChromeDriver/chromedriver-linux64/chromedriver");

            // Launch Chrome browser
            driver = new ChromeDriver();

            // Navigate to the login page
            driver.get("https://www.saucedemo.com/");

            // Adding sleep to pause execution for 5 seconds (5000 milliseconds)
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        System.out.println("Entering username and password...");
        try {
            // Enter username and password
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        System.out.println("Clicking the login button...");
        try {
            // Click the login button
            driver.findElement(By.id("login-button")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I enter invalid username and\\/or password")
    public void i_enter_invalid_username_and_password() {
        System.out.println("Entering invalid username and/or password...");
        try {
            // Enter invalid username and/or password
            driver.findElement(By.id("user-name")).sendKeys("invalid_user");
            driver.findElement(By.id("password")).sendKeys("invalid_password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("Verifying successful login...");
        try {
            // Verifying successful login
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        System.out.println("Verifying error message...");
        try {
            // Verifying error message is displayed when login fails
            boolean errorMessageDisplayed = driver.findElement(By.className("error-message-container")).isDisplayed();
            Assert.assertTrue(errorMessageDisplayed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @After
    public void closeBrowser() {
        // Close the browser after scenario execution
        System.out.println("Closing the browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
