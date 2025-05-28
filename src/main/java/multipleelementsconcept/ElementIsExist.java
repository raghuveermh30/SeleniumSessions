package multipleelementsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class ElementIsExist {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        List<WebElement> emailList = driver.findElements(By.id("input-email"));

        if (emailList.size() == 1) {
            System.out.println("Email filed is displayed on the page");
        } else {
            System.out.println("Email filed is not displayed on the Page");
        }
        System.out.println("*************");

        By emailId = By.id("input-email");
        System.out.println(isElementDisplayed(emailId));
        System.out.println("*************");

        By emailId1 = By.id("input-email1");
        System.out.println(isElementDisplayed(emailId1));

        By forgottenPassword = By.linkText("Forgotten Password");
        System.out.println(isElementDisplayed(forgottenPassword, 2));

        By forgottenUsername = By.linkText("Forgotten username");
        System.out.println(isElementDisplayed(forgottenUsername, 0));

        By naveen = By.id("naveen");
        System.out.println(doElementIsDisplayed(naveen));


        driver.quit();
    }

    public static List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public static boolean isElementDisplayed(By locator) {
        if (getElements(locator).size() == 1) {
            System.out.println("Element is available one time on the page ");
            return true;
        } else {
            System.out.println("Element is not available one time on the page ");
            return false;
        }
    }

    public static boolean isElementDisplayed(By locator, int eleCount) {
        if (getElements(locator).size() == eleCount) {
            System.out.println(locator + "Element is available " + eleCount + " times on the page ");
            return true;
        } else {
            System.out.println(locator + "Element is not available " + eleCount + " times on the page ");
            return false;
        }
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static boolean doElementIsDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element is not displayed");
            return false;
        }
    }

}
