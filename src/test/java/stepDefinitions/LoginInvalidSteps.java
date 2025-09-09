package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginInvalidSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @When("User enters invalid email {string} and password {string}")
    public void user_enters_invalid_email_and_password(String email, String password) {
        loginPage.login(email, password);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        // already handled in login()
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedError) {
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error message mismatch!");
    }
}
