package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestCasesPage;
import utils.ConfigReader;

public class TestCasesPageTest extends BaseTest {

    @Test
    public void verifyTestCasesPage() {
        driver.get(ConfigReader.get("url"));

        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.clickTestCasesMenu();

        String title = testCasesPage.getPageTitle();
        Assert.assertTrue(testCasesPage.isTestCasesPageDisplayed(),
                "Test Cases page was not displayed! Actual title: " + title);

        getTest().pass("verifyTestCasesPage is passed successfully.");
    }
}
