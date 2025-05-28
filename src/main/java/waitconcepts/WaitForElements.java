package waitconcepts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelementconcept.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WaitForElements {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");

        By footerMainLoc = By.xpath("//footer//a");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> footerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(footerMainLoc));
        //An Expectation for checking that there is at least one element present on the web page. Then will give List<WebElement> of elements

        List<WebElement> footerList1 =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerMainLoc));
        //An Expectation for checking that all elements are present on the web page that match the locator are visible.
        // Then will give List<WebElement> of elements
        //Visibility means that elements are not only displayed but also have a height and width that is greater than 0.
        //This approach is preferable

        System.out.println(footerList.size());
        System.out.println(footerList1.size());

        for (WebElement element : footerList) {
            System.out.println(element.getText());
        }

        driver.quit();
    }

    public static List<WebElement> waitForElementsToBePresent(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static List<WebElement> waitForElementsToVisible(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
