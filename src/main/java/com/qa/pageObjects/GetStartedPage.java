package com.qa.pageObjects;

import com.qa.utilities.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.locators.GetStartedPageLocators.*;

public class GetStartedPage extends CommonFunction{

    public static String menuItem;

    public GetStartedPage(WebDriver driver) {
        super(driver);
    }

    public void clickGetStartedButton() {
        clickElement(getStartedLink);
    }

    public void clickLoginButton() {
        clickElement(loginLinkButton);
    }

    public void clickMenu()
    {
        clickElement(menuButton);
    }

    public void openMenuItem(String item)
    {
        By menuItemLabel = By.xpath("//div[@role='menu']//a[text()='"+item+"']");
        clickElement(menuItemLabel);
    }
}
