package waitconcepts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FluentWaitConcepts {

    static WebDriver driver;

    public static void main(String[] args) {

        //Wait is the Interface --> Wait has until() method
        // -> FluentWait is the Class and Implements Wait Interface  --> until() method+ Other Individual Methods
        // --> WebDriverWait is the child Class --> this has no Individual methods + all inherited methods are available in WebDriverWait
        // There is no difference in the WebDriverWait and FluentWait
        // Both WebDriverWait and FluentWait are same both are doing the same action

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        By firstName = By.id("input-firstname");
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element not found within the given time frame");
        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Testing");

        //Second Example
        /*WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .withMessage("Element not found within the given time frame");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Testing");*/

        /* Do We have any difference in FluentWait and WebDriverWait
         * suppose if we want to create our own Wait classes then we can extend the FluentWait class
         *
         */
    }

    public static void waitForElementToBePresent(By locator, long timeout, long pollingTime) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .withMessage("Element not found within the given time frame");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementVisibleUsingFluentFeatures(By locator, long timeout, long pollingTime) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element not found within the given time frame");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
