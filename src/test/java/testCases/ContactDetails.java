package testCases;

import baseTest.BaseTest;
import com.qa.pageObjects.ContactPage;
import com.qa.pageObjects.GetStartedPage;
import org.testng.annotations.*;

public class ContactDetails extends BaseTest {

    @Test
    public void validate_info_for_estonia() throws InterruptedException {
        GetStartedPage getStartedPage = new GetStartedPage(driver);
        ContactPage contactPage = new ContactPage(driver);

        getStartedPage.clickMenu();
        getStartedPage.openMenuItem("Contacts");
        contactPage.validateCurrentUrl("contacts");
        contactPage.validatePageDetailsPerCountry("estonia");
        contactPage.verifyEmailHyperLink("estonia");
        contactPage.verifyContactNumberHyperLink("estonia");
    }

    @Test
    public void validate_info_for_poland() throws InterruptedException {
        GetStartedPage getStartedPage = new GetStartedPage(driver);
        ContactPage contactPage = new ContactPage(driver);

        getStartedPage.clickMenu();
        getStartedPage.openMenuItem("Contacts");
        contactPage.validateCurrentUrl("contacts");
        contactPage.validatePageDetailsPerCountry("poland");
        contactPage.verifyEmailHyperLink("poland");
        contactPage.verifyContactNumberHyperLink("poland");
    }

}
