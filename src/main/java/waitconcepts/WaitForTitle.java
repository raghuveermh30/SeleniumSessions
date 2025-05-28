package waitconcepts;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForTitle {

    static WebDriver driver;

    public static void main(String[] args) {


        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        String title = driver.getTitle();
        System.out.println(title); //Loading...
        // Never use directly like driver.getTitle() in the code
        //Use is via Explicit wait

        String title1 = waitForTitleContains("Register", 10);
        System.out.println(title1);
        String title2 = waitForTitleIs("Register Account", 10);
        System.out.println(title2);
    }

    public static String waitForTitleContains(String fractionTitle, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            if (wait.until(ExpectedConditions.titleContains(fractionTitle))) {
                return driver.getTitle();
            }
        } catch (TimeoutException exception) {
            System.out.println("Title is not found after " + timeOut + " seconds");

        }
        return null;

    }

    public static String waitForTitleIs(String title, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            if (wait.until(ExpectedConditions.titleIs(title))) {
                return driver.getTitle();
            }
        } catch (TimeoutException exception) {
            System.out.println("Title is not found after " + timeOut + " seconds");

        }
        return null;
    }

}
