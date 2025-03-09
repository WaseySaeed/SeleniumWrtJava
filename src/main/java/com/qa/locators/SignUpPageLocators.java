package com.qa.locators;

import org.openqa.selenium.By;

import static com.qa.pageObjects.SignUpPage.*;

public class SignUpPageLocators {

    public static final By email = By.id("email");
    public static final By password = By.id("password");
    public static final By confirmPassword = By.id("confirmPassword");
    public static final By agreementCheckBoxHidden = By.id("agreements");
    public static final By agreementCheckBox = By.xpath("//input[@id='agreements']//parent::label//following-sibling::span[contains(@class,'input-bool_check')]");
    public static final By signUpBtn = By.xpath("//button[text() = 'Sign up']");
    public static By signUpEmail = By.xpath("//span[text()='"+registrationEmail+"']");

}
