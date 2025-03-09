package com.qa.locators;

import com.qa.utilities.configReader;
import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By email = By.id("email");
    public static final By password = By.id("password");
    public static final By signInBtn = By.xpath("//button[text() = 'Sign in']");
    public static final By invalidLoginAlert = By.xpath("//div[@role='alert']//div[contains(text(),'Invalid email or password.')]");
    public static final By incompleteEmailLabel = By.xpath("//div[text()='Invalid email address.']");
    public static final By emptyCredentialsLabel = By.xpath("//div[text()='The \"Email\" must be a valid email address.']");
    public static final By loggedInEmail = By.xpath("//span[text()='"+ configReader.getProperty("email")+"']");

}
