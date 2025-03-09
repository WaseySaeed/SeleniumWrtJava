package com.qa.pageObjects;

import com.qa.utilities.CommonFunction;
import com.qa.utilities.configReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.qa.locators.SignUpPageLocators.*;


public class SignUpPage extends CommonFunction {

    public static String registrationEmail;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() {
        enterEmailAndPassword();
        submitAndSignUp();
    }

    private void submitAndSignUp() {
        clickElement(signUpBtn);
    }


    private void enterEmailAndPassword() {

//        registrationEmail =  configReader.getProperty("email").replace("@", System.currentTimeMillis() + "@");
//        enterText(email,registrationEmail);
        enterText(email, configReader.getProperty("email"));
        enterText(password, configReader.getProperty("password"));
        enterText(confirmPassword, configReader.getProperty("password"));
        selectCheckbox(agreementCheckBox, agreementCheckBoxHidden, true);
    }

    public void validateUserLoggedIn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpEmail));
        validateCurrentUrl("profile");
        Assert.assertTrue(element.isDisplayed(), "Email not found on Profile page.");
    }

}
