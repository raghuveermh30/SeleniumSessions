package seleniumfactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.getDriver("chrome");
    }

    @Test
    public void googleTitleTest() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void googleCurrentUrlTest() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
