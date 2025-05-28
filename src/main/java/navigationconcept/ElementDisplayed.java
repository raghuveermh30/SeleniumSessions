package navigationconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriverconcept.BrowserUtil;

public class ElementDisplayed {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);
        String title = driver.getTitle();


        boolean flag = driver.findElement(By.id("input-email")).isDisplayed();
        System.out.println(flag);

        /* Suppose, if the flag value is FALSE --> NoSuchElementException
         * If the element is not available in the page then it will give NoSuchElementException
         */

        /*
         * NoSuchElementException: no such element: Unable to locate element:
         * There is no exception called ElementNotFound exception in the selenium
         */
        try {
            driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
        } catch (NoSuchElementException e) {
            //Wait for Element concept
        }

        By emailId = By.id("input-email");
        if (doElementIsDisplayed(emailId)){
            getElement(emailId).sendKeys("naveen@gmail.com");
        } else {
            System.out.println("Element is not displayed.."); //This is unreachable code, due to we will get the Exception, if element is not present
        }

        driver.quit();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static boolean doElementIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }
}
