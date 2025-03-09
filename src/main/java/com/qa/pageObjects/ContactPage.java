package com.qa.pageObjects;

import com.qa.utilities.CommonFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.qa.locators.ContactPageLocators.*;

public class ContactPage extends CommonFunction {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void validatePageDetailsPerCountry(String country) {

        switch (country) {
            case "estonia":
                assertElementVisible(estoniaAddress, "Address for Estonia not visible");
                assertElementVisible(emailInEstoniaModule, "Email for BTC_bit for Estonia not present");
                assertElementVisible(estoniaPhoneNumber, "Phone number for Estonia is missing");

                break;
            case "poland":
                assertElementVisible(polandAddress, "Address for Poland not visible");
                assertElementVisible(emailInPolandModule, "Email for BTC_bit for Poland not present");
                assertElementVisible(polandPhoneNumber, "Phone number for Poland is missing");
                break;
        }
    }

    public void verifyEmailHyperLink(String country) {
        WebElement element = null;
        String emailHref = null;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

        if (country.equalsIgnoreCase("estonia")) {
            assertElementVisible(emailInEstoniaModule, "Email for BTC_bit for Estonia not present");
            element = wait.until(ExpectedConditions.elementToBeClickable(emailInEstoniaModule));
        } else if (country.equalsIgnoreCase("poland")) {
            assertElementVisible(emailInPolandModule, "Email for BTC_bit for Poland not present");
            element = wait.until(ExpectedConditions.elementToBeClickable(emailInEstoniaModule));
        }
        assert element != null;
        emailHref = element.getAttribute("href");
        Assert.assertTrue(emailHref.contains("mailto:info@btcbit.net"));

    }

    public void verifyContactNumberHyperLink(String country) {
        WebElement element = null;
        String emailHref = null;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

        if (country.equalsIgnoreCase("estonia")) {
            assertElementVisible(estoniaPhoneNumber, "Email for BTC_bit for Estonia not present");
            element = wait.until(ExpectedConditions.elementToBeClickable(estoniaPhoneNumber));
            assert element != null;
            emailHref = element.getAttribute("href");
            Assert.assertTrue(emailHref.contains("tel:+3728803222"));
        } else if (country.equalsIgnoreCase("poland")) {
            assertElementVisible(polandPhoneNumber, "Email for BTC_bit for Poland not present");
            element = wait.until(ExpectedConditions.elementToBeClickable(polandPhoneNumber));
            assert element != null;
            emailHref = element.getAttribute("href");
            Assert.assertTrue(emailHref.contains("tel:+48588813222"));
        }

    }
}
