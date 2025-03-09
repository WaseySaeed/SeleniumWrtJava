package testCases;

import baseTest.BaseTest;
import com.qa.pageObjects.GetStartedPage;
import com.qa.pageObjects.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Login extends BaseTest {


    private static final Logger log = LoggerFactory.getLogger(Login.class);

    @Test
    public void Login_with_invalid_data() throws InterruptedException {
        GetStartedPage getStartedPage = new GetStartedPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        getStartedPage.clickLoginButton();
        loginPage.validatePage("sign_in");
        loginPage.tryInvalidLogin();
    }

    @Test
    public void Login_with_valid_data() throws InterruptedException {

        GetStartedPage getStartedPage = new GetStartedPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        getStartedPage.clickLoginButton();
        loginPage.validatePage("sign_in");
        loginPage.loginIntoThePortal("email","password");
        loginPage.validateLoginSuccess();
    }
}
