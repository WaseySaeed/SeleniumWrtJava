package testCases;

import baseTest.BaseTest;
import com.qa.pageObjects.GetStartedPage;
import com.qa.pageObjects.SignUpPage;
import org.testng.annotations.Test;

public class SignUp extends BaseTest {

    @Test
    public void Register_User() throws InterruptedException {

        GetStartedPage getStartedPage = new GetStartedPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        getStartedPage.clickGetStartedButton();
        signUpPage.registerUser();
        signUpPage.validateUserLoggedIn();
    }
}
