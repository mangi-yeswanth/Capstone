package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ConfigReader;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        driver.get(ConfigReader.get("url"));

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Automation Exercise",
                "Home Page title did not match!");

        getTest().pass("Home Page title verified successfully ");
    }

    @Test(priority = 2)
    public void verifySignUpButtonNavigation() {
        driver.get(ConfigReader.get("url"));

        HomePage homePage = new HomePage(driver);
        homePage.clickSignUpLogin();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"),
                "Sign Up/Login button did not navigate correctly!");

        getTest().pass("Signup/Login button clicked and navigation verified ");
    }
}
