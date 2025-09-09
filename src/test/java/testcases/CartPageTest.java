package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import utils.ConfigReader;

public class CartPageTest extends BaseTest {

    @Test
    public void verifyCartAndProceedToCheckout() {
        driver.get(ConfigReader.get("loginurl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertTrue(loginPage.isLoggedIn(), "Login failed, cannot proceed to cart test.");

        CartPage cartPage = new CartPage(driver);
        cartPage.cartClick();

        Assert.assertTrue(cartPage.isCartDisplayed(), "Cart is not displayed!");
        getTest().pass("Cart page is displayed successfully.");
    }
}
