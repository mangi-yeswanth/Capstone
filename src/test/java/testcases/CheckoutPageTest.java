package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void verifyCheckoutPageAndPlaceOrder() {
        driver.get(ConfigReader.get("loginurl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertTrue(loginPage.isLoggedIn(), "Login failed, checkout test cannot proceed!");

        ProductPage productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        productPage.addFirstProductToCart();
        productPage.viewCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartDisplayed(), "Cart page is not displayed!");

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();
        checkoutPage.clickPlaceOrder();

        Assert.assertTrue(checkoutPage.isOnPaymentPage(),
                "Failed to navigate to Payment page after clicking Place Order!");

        getTest().pass("Checkout page verified and navigation to Payment page successful.");
    }
}
