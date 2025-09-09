package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators for login
    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");

    // Locators for signup
    By signupNameField = By.xpath("//input[@data-qa='signup-name']");
    By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");

    // Locators for account info form
    By titleMr = By.xpath("//input[@id='id_gender1']");
    By passwordSignupField = By.id("password");
    By daysDropdown = By.id("days");
    By monthsDropdown = By.id("months");
    By yearsDropdown = By.id("years");
    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By companyField = By.id("company");
    By address1Field = By.id("address1");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumberField = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    // Locators for status messages
    By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");
    By accountInfoHeading = By.xpath("//b[text()='Enter Account Information']");
    By accountCreatedMessage = By.xpath("//b[contains(text(),'Account Created!')]");
    By accountDeletedMessage = By.xpath("//b[contains(text(),'Account Deleted!')]");
    By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    By signupErrorMsg = By.xpath("//p[contains(text(),'Email Address already exist!')]");
    By deleteButton = By.xpath("//a[@href='/delete_account']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Login
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Signup
    public void signup(String name, String email) {
        driver.findElement(signupNameField).sendKeys(name);
        driver.findElement(signupEmailField).sendKeys(email);
        driver.findElement(signupButton).click();
    }

    // Fill account info
    public void fillAccountInformation(
            String firstName, String lastName, String password,
            String day, String month, String year,
            String company, String address, String state, String city,
            String country, String zipcode, String mobileNumber
    ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for Title radio button
        WebElement titleRadio = wait.until(ExpectedConditions.elementToBeClickable(titleMr));
        titleRadio.click();

        driver.findElement(passwordSignupField).sendKeys(password);

        driver.findElement(daysDropdown).sendKeys(day);
        driver.findElement(monthsDropdown).sendKeys(month);
        driver.findElement(yearsDropdown).sendKeys(year);

        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(address1Field).sendKeys(address);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);

        driver.findElement(createAccountButton).click();
    }
    // Status checks
    public boolean isAccountCreated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage)).isDisplayed();
    }

    public boolean isAccountDeleted() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMessage)).isDisplayed();
    }

    public boolean isLoggedIn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUser)).isDisplayed();
    }

    public boolean isAccountInfoPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoHeading)).isDisplayed();
    }

    // Error messages
    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }

    public String getSignupErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(signupErrorMsg));
        return error.getText();
    }

    // Delete account
    public void deleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }
}
