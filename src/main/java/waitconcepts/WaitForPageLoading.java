package waitconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForPageLoading {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /* When Page is completely loaded, then only we need to perform the action on the element
         * How we will get to know that the page is completely loaded?
         * document.readyState --> has 3 stages --> loading, interactive, complete
         * interactive -> page is loaded but not all the elements are loaded, some css are not loaded
         */


        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");

        if (waitForPageLoading(10)) {
            System.out.println("Page is fully loaded");
        }

    }

    public static boolean waitForPageLoading(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        String isPageLoaded = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';")).toString();
        return Boolean.parseBoolean(isPageLoaded);
    }
}
