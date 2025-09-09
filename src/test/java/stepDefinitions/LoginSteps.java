package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage;
    LoginPage loginPage;

    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @When("User navigates to Login Page")
    public void user_navigates_to_login_page() {
        homePage.clickSignUpLogin();
        loginPage = new LoginPage(driver);
    }

    @When("User enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.login(email, password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        // already handled in login()
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoggedIn(), "User login failed!");
    }
}
