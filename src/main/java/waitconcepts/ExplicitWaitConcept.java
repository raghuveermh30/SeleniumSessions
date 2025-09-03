package waitconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitConcept {
    static WebDriver driver;

    public static void main(String[] args) {

        /* Explicit Wait: It is a high level concept
         * It is used to wait for a specific condition to be true.
         * Advantage: It will be applied to a specific element only.
         * Disadvantage: It is not applicable to all the elements in the page.
         * It is not a global wait.
         *
         */

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        By firstName = By.id("input-firstname");
        By lastName = By.id("input-lastname");

        WebElement firstNameEle = waitForElementToBePresent(firstName, 10);
        firstNameEle.sendKeys("testing");

        /* Suppose if the element is not available with in 10 seconds then it will throw
         * org.openqa.selenium.TimeoutException: Expected condition failed: waiting for presence of element located by:
         * By.id: input-firstname11 (tried for 10 second(s) with 500 milliseconds interval)
         */

        driver.findElement(lastName).sendKeys("Automation");


        /* In a Page, Lets say 25 elements are available
         * 1st element -> 10 Seconds : WebDriverWait
         * 2nd to 10th --> no Waits
         * 11th to 15th --> 5 seconds : WebDriverWait
         * 16th to 25th --> no waits
         *
         * This approach is possible with Explicit wait, but in implicit wait its not possible.
         */

        driver.quit();

    }

    /*
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible.
     * Let's say, we have 100 elements in the DOM, presenceOfElementLocated will work only if the element is presnt in the DOM. Not on the page
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForElementToBePresent(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /*
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * This method is more powerful than presenceOfElementLocated.
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForElementVisible(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
