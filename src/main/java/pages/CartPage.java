package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Locators
    By cartLink = By.linkText("Cart");
    
    By cartTable = By.id("cart_info_table");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void cartClick() {
        driver.findElement(cartLink).click();
    }
    public boolean isCartDisplayed() {
        return driver.findElement(cartTable).isDisplayed();
    }

    
}
