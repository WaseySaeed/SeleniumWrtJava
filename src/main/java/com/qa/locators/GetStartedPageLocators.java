package com.qa.locators;

import org.openqa.selenium.By;

import static com.qa.pageObjects.GetStartedPage.menuItem;

public class GetStartedPageLocators {

    public static final By getStartedLink = By.xpath("//a[@aria-label='Home page']//following-sibling::div//a[text() = 'Get Started']");
    public static final By loginLinkButton = By.xpath("//a[text() = 'Login']");
    public static final By menuButton = By.xpath("//button[@title='Open menu']");
}
