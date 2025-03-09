package com.qa.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        return driver == null ? (driver = createBrowserSession(browser)) : driver;
    }

    private static WebDriver createBrowserSession(String browser) {
        switch (browser) {
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            case "chrome":
            default:
                ChromeOptions desiredCap = new ChromeOptions();
                desiredCap.addArguments("--start-maximized");
                return new ChromeDriver(desiredCap);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
