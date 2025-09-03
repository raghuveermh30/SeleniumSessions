package seleniumfactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTest1 {

    public WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverFactory1 driverFactory1 = new WebDriverFactory1();
        driver = driverFactory1.getDriver("chrome");
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void getTitleTest() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void getCurrentUrl() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
