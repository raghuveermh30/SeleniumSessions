package waitconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PollingTimeConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /* Polling time is the time interval between two requests
         * Polling Time or Interval Time
         * Default Polling time is 500 milliseconds
         */


        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname11")));

        //When we pass wrong locator or When element didn;t find in this interval in the DOM
        //selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.id: input-firstname11 (tried for 10 second(s) with 2000 milliseconds interval)

        /* Duration.ofSeconds(2) --> This is the sleep time between two requests
         * The first request will send to the server is 0 seconds, Server will be waited for 2 seconds
         * After that second request will be sent to the server
         * In every 2 seconds, the request will be sent to the server until the 10 seconds are over
         * Gap between 2 requests is 2 seconds in above case
         */
    }
}
