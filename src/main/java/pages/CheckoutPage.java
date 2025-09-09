package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    // Locators
    By proceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
    By deliveryAddress = By.xpath("//ul[@id='address_delivery']");
    By paymentSection = By.xpath("//h2[contains(text(),'Payment')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void clickCheckout() {
    	
    }

    public boolean isOnPaymentPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentSection)).isDisplayed();
    }
    public boolean verifyDeliveryAddressDisplayed() {
        return driver.findElement(deliveryAddress).isDisplayed();
    }
    public void proceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }
    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }
}
