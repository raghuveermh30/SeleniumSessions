package waitconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelementconcept.ElementUtil;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WaitForWindow {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");

        driver.findElement(By.linkText("Privacy Policy.")).click();

        By orangeHrmLink = By.linkText("OrangeHRM");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.clickElementWhenReady(orangeHrmLink, 10);

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));*/

        if (waitForWindow(2, 10)) {

            // 1. fetch the window ids
            Set<String> handles = driver.getWindowHandles();

            Iterator<String> it = handles.iterator();

            String parentWindowId = it.next();
            System.out.println("parent window id: " + parentWindowId);

            String childWindowId = it.next();
            System.out.println("child window id: " + childWindowId);

            // 2. switching work:
            driver.switchTo().window(childWindowId);
            System.out.println("child window title: " + driver.getTitle());
        }

        // close the child window:
        driver.close();
    }

    public static boolean waitForWindow(int numberOfWindows, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
        } catch (TimeoutException exception) {
            System.out.println("Window is not found after " + timeout + " seconds");
            return false;
        }
    }

}
