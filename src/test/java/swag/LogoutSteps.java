package swag;

import com.swaglabs.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutSteps {

    private WebDriver driver;
    private HomePage homePage;
    private LoginSteps loginSteps;

    @Given("I am logged in")
    public void i_am_logged_in() {
        loginSteps = new LoginSteps();
        loginSteps.i_am_on_the_login_page();
        loginSteps.i_enter_my_username_and_password();
        loginSteps.i_click_the_login_button();
        loginSteps.i_should_be_logged_in_successfully();
        driver = loginSteps.getDriver(); // Get the driver from LoginSteps
        homePage = new HomePage(driver);
    }

    @When("I click the burger menu")
    public void i_click_the_burger_menu() {
        System.out.println("Clicking the burger menu...");
        try {
            homePage.clickBurgerMenu();
            Thread.sleep(2000); // Wait for the menu to open
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        System.out.println("Clicking the logout button...");
        try {
            homePage.clickLogoutLink();
            Thread.sleep(2000); // Wait for the action to complete
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should be logged out successfully")
    public void i_should_be_logged_out_successfully() {
        System.out.println("Verifying successful logout...");
        try {
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://www.saucedemo.com/", currentUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
