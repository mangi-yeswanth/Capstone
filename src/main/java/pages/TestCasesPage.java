package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestCasesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By testCasesMenu = By.xpath("//a[@href='/test_cases']");
    // Constructor
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void clickTestCasesMenu() {
        driver.findElement(testCasesMenu).click();
    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isTestCasesPageDisplayed() {
        return getPageTitle().contains("Test Cases");
    }
}
