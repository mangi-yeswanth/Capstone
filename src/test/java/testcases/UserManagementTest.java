package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class UserManagementTest extends BaseTest {

	private final String registerUserEmail = "testeruser11234@gmail.com";
	private final String registeredPassword = "Chandhi@Priya1234";

	@Test(priority = 1)
	public void registerUser() {
		driver.get(ConfigReader.get("loginurl"));

		LoginPage loginPage = new LoginPage(driver);

		// Fill signup form
		loginPage.signup("Tester Chandhi", registerUserEmail);

		// Fill account details
		loginPage.fillAccountInformation("Chandhi", "Priya", registeredPassword, "01", "January", "2003",
				"WiproCompany", "123 house, xyz Street, sklm village, Andhra Pradesh", "Andhra Pradesh", "Tekkali",
				"India", "532201", "9441619977");

		// Verify account creation
		Assert.assertTrue(loginPage.isAccountCreated(),
				"Account was not created successfully for email: " + registerUserEmail);

		getTest().pass("registerUser is passed successfully.");
	}

	@Test(priority = 2, dependsOnMethods = "registerUser")
	public void deleteUser() {
		driver.get(ConfigReader.get("loginurl"));

		LoginPage loginPage = new LoginPage(driver);

		// Login with registered credentials
		loginPage.login(registerUserEmail, registeredPassword);

		// Delete account
		loginPage.deleteAccount();

		// Verify deletion
		Assert.assertTrue(loginPage.isAccountDeleted(),
				"Account was not deleted successfully for email: " + registerUserEmail);

		getTest().pass("deleteUser is passed successfully.");
	}
}
