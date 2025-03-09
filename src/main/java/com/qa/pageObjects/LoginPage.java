package com.qa.pageObjects;

import com.qa.utilities.CommonFunction;
import com.qa.utilities.configReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.qa.locators.LoginPageLocators.*;


public class LoginPage extends CommonFunction {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginIntoThePortal(String emailText, String passwordText) throws InterruptedException {

        if (emailText != null && passwordText != null) {
            enterText(email, configReader.getProperty(emailText));
            enterText(password, configReader.getProperty(passwordText));
        } else {
            clearTextForAnInputField(email);
            clearTextForAnInputField(password);
        }
        clickElement(signInBtn);
    }

    public void validatePage(String keyword) {
        validateCurrentUrl(keyword);
    }

    public void validateLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInEmail));
        validateCurrentUrl("profile");
        Assert.assertTrue(element.isDisplayed(), "Email not found on Profile page.");
    }

    public void validateInvalidLoginErrorMessage(String email) {

        if (email.equalsIgnoreCase("invalidCredentials") ||
                email.equalsIgnoreCase("invalidPassword") ||
                email.equalsIgnoreCase("invalidEmail")) {

            WebElement element = waitForElementToBeVisible(invalidLoginAlert);
            assertTextEquals(element.getText(), configReader.getProperty("invalidLoginCredentialsMessage"), "Invalid Credentials Entered");
        } else if (email.equalsIgnoreCase("emptyData")) {
            WebElement element = waitForElementToBeVisible(emptyCredentialsLabel);
            assertTextEquals(element.getText(), configReader.getProperty("emptyLoginCredentialsMessage"), "No credentials Entered");
        } else if (email.equalsIgnoreCase("incompleteEmail")) {
            WebElement element = waitForElementToBeVisible(incompleteEmailLabel);
            assertTextEquals(element.getText(), configReader.getProperty("incompleteLoginCredentialsMessage"), "Incorrect email format entered");
        }
    }

    public void tryInvalidLogin() throws InterruptedException {
        List<String[]> invalidScenarios = Arrays.asList(
                new String[]{null, null, "emptyData"},
                new String[]{"invalidEmail", "invalidPassword", "invalidCredentials"},
                new String[]{"email", "invalidPassword", "invalidPassword"},
                new String[]{"invalidEmail", "password", "invalidEmail"},
                new String[]{"incompleteEmail", "password", "incompleteEmail"}

        );
        for (String[] scenario : invalidScenarios) {
            loginIntoThePortal(scenario[0], scenario[1]);
            validateInvalidLoginErrorMessage(scenario[2]);
        }
    }
}
