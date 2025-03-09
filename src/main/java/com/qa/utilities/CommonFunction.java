package com.qa.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Keys;

import java.time.Duration;
//import static com.qa.locators.LoginPageLocators.email;


public class CommonFunction {

    WebDriver driver;

    public CommonFunction(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
            }
        } catch (NoSuchElementException e) {
            System.err.println("Element not found");
        }
    }


    public void enterText(By locator, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            if (!element.getAttribute("value").isEmpty()) {
                clearTextForAnInputField(locator);
            }

            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            System.err.println("Element not found");
        }
    }

    public void selectCheckbox(By visibleCheckbox, By hiddenCheckbox, boolean shouldSelect) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement hiddenElement = wait.until(ExpectedConditions.presenceOfElementLocated(hiddenCheckbox));
            WebElement visibleElement = wait.until(ExpectedConditions.elementToBeClickable(visibleCheckbox));

            boolean isChecked = hiddenElement.isSelected();
            if ((shouldSelect && !isChecked) || (!shouldSelect && isChecked)) {
                visibleElement.click();
            }

        } catch (NoSuchElementException e) {
            System.err.println("Checkbox element not found!");
        }
    }

    public void selectCheckbox(By visibleCheckbox, boolean shouldSelect) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(visibleCheckbox));

            boolean isChecked = visibleElement.isSelected();
            if ((shouldSelect && !isChecked) || (!shouldSelect && isChecked)) {
                visibleElement.click();
            }

        } catch (NoSuchElementException e) {
            System.err.println("Checkbox element not found!");
        }
    }

    public void assertTextEquals(String actualText, String expectedText, String errorMessage) {
        Assert.assertEquals(actualText, expectedText, errorMessage);
    }

    public void assertElementVisible(By locator, String errorMessage) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), errorMessage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clearTextForAnInputField(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        String fieldLength = element.getAttribute("value");
        for (int i = 0; i < fieldLength.length(); i++) {
            element.click();
            element.sendKeys(Keys.BACK_SPACE);
        }

        // Because the run was too fast, element.clear() wasnt working properly
        //        element.clear();

    }

    public WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void validateCurrentUrl(String expectedUrlKeyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(expectedUrlKeyword));
    }
}

