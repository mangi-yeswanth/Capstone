package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    // Locators
    By searchButton = By.xpath("//button[@id='submit_search']");
    By firstProductAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");
    By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");
    By searchBox = By.id("search_product");
    By productDetailHeading = By.xpath("//div[@class='product-information']");
    By viewProductLink = By.linkText("View Product");
    By cartItems = By.xpath("//table[@id='cart_info_table']//tr");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchProduct(String find) {
    	driver.findElement(searchBox).sendKeys(find);
    }
    public void searchBtn() {
    	driver.findElement(searchButton).click();
    }
    public void viewProduct() {
    	driver.findElement(viewProductLink).click();
    }
    
    
    
    public boolean isProductDetailDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailHeading)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void addFirstProductToCart() {
    	WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCart));
        product.click();
    }
    

    public boolean isProductAddedToCart() {
        return driver.findElements(cartItems).size() > 0;
    }

    public void continueShopping() {
    	WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueBtn.click();
    }

    public void viewCart() {
    	WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartBtn.click();
    }
}
