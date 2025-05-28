package waitconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForUrl {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");

        driver.findElement(By.linkText("Privacy Policy.")).click();
        String url = waitForUrlContains("Privacy-Policy.pdf", 10);
        System.out.println(url);

    }

    public static String waitForUrlContains(String fractionUrl, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            if (wait.until(ExpectedConditions.urlContains(fractionUrl))) {
                return driver.getCurrentUrl();
            }
        } catch (TimeoutException exception) {
            System.out.println("URL is not found after " + timeOut + " seconds");

        }
        return null;
    }

    public static String waitForUrlToBe(String url, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            if (wait.until(ExpectedConditions.urlToBe(url))) {
                return driver.getCurrentUrl();
            }
        } catch (TimeoutException exception) {
            System.out.println("URL is not found after " + timeOut + " seconds");

        }
        return null;
    }
}
