package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PaymentPage;
import utils.ConfigReader;

public class PaymentPageTest extends BaseTest {

    @Test
    public void verifyPaymentAndConfirmOrder() {
        driver.get(ConfigReader.get("paymenturl"));

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPaymentDetails(
                ConfigReader.get("cardName"),
                ConfigReader.get("cardNumber"),
                ConfigReader.get("cvv"),
                ConfigReader.get("expiryMonth"),
                ConfigReader.get("expiryYear")
        );
        paymentPage.confirmOrder();

        Assert.assertTrue(
                driver.getPageSource().contains("Order Placed!"),
                "Order confirmation message not found!"
        );
    }
}
