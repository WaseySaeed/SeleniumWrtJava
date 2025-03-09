package baseTest;

import com.qa.driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.qa.utilities.*;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void startBrowserSession()
    {
        String baseUrl = configReader.getProperty("baseUrl");
        String browser = configReader.getProperty("browser").toLowerCase();
        driver = DriverFactory.getDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to(baseUrl);
    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
