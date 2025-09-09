package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import utils.ConfigReader;

public class ContactUsTest extends BaseTest {

    @Test
    public void verifyContactUsFormSubmission() {
        driver.get(ConfigReader.get("url"));

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.clickContactUs();

        contactUsPage.fillContactForm(
                "Chandhini Priya",
                "testeruserchandhi@gmail.com",
                "Testing Contact Form",
                "This is a test message for Contact Us form."
        );
        contactUsPage.submitForm();

        Assert.assertTrue(contactUsPage.isMessageSent(),
                "Contact Us form submission failed!");

        getTest().pass("Contact Us form submitted successfully and success message displayed.");
    }
}
