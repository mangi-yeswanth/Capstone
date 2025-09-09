package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import utils.ConfigReader;

public class ProductPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyAddProductToCart() {
        driver.get(ConfigReader.get("producturl"));

        ProductPage productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        productPage.addFirstProductToCart();
        productPage.viewCart();

        Assert.assertTrue(productPage.isProductAddedToCart(), "Product was not added to the cart!");
        getTest().pass("verifyAddProductToCart is passed");
    }

    @Test(priority = 2)
    public void verifyViewProduct() {
        driver.get(ConfigReader.get("producturl"));

        ProductPage productPage = new ProductPage(driver);
        productPage.searchProduct("GRAPHIC DESIGN MEN T SHIRT - BLUE");
        productPage.searchBtn();
        productPage.viewProduct();

        Assert.assertTrue(productPage.isProductDetailDisplayed(), "Product detail page did not open!");
        getTest().pass("verifyViewProduct is passed");
    }
}
