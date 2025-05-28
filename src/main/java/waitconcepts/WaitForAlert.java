package waitconcepts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForAlert {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement element = driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']"));
        element.click();

        // Wait for the alert to be present and switch to it
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());*/

        Alert alert = waitForAlert(10);
        // System.out.println(alert.getText()); // Print the alert text
        System.out.println(getAlertText(10));
        // alert.accept(); // Accept the alert (click OK)
        acceptAlert(10); // Accept the alert (click OK)
        // alert.dismiss(); // Dismiss the alert (click Cancel)
        // dismissAlert(10); // Dismiss the alert (click Cancel)

        driver.quit();
    }

    public static Alert waitForAlert(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public static String getAlertText(long timeout) {
        return waitForAlert(timeout).getText();
    }

    public static void acceptAlert(long timeout) {
        waitForAlert(timeout).accept();
    }

    public static void dismissAlert(long timeout) {
        waitForAlert(timeout).dismiss();
    }

    public static void sendKeysToAlert(long timeout, String keys) {
        waitForAlert(timeout).sendKeys(keys);
    }

}
