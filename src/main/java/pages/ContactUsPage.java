package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
    WebDriver driver;

    // Locators
    By contactUsLink = By.linkText("Contact us");
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.name("message");
    By submitButton = By.name("submit");
    By successMessage = By.xpath("//div[@class='status alert alert-success']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();

        //  Wait for alert safely
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); // click OK
        } catch (Exception e) {
            System.out.println("No alert appeared after submit.");
        }
    }

    public boolean isMessageSent() {
        return driver.findElement(successMessage).isDisplayed();
    }
}