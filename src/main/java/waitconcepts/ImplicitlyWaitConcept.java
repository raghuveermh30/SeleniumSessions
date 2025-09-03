package waitconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitlyWaitConcept {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS); --> this is deprecated. this is not recommended and its present in selenium 3

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //this is available in selenium 4

        /* ImplicitlyWait wait is global wait.
         * It will be applied to all the elements in the script.
         * Once its applied to the driver, it will be applied to all the upcoming elements in the script.
         * It cannot be applied to a specific element.
         * Explicitly wait cannot be applied for WebElement
         * It cannot be used for non Web elements --> Example --> Title, Javascript popup's ,Popup, Alert, etc. Here Implicit wait cannot be applied.
         * Default time is 0 seconds.
         */

        //WebElement
        //Registration page has 10 seconds
        driver.findElement(By.id("input-firstname")).sendKeys("testing");
        //e2
        //e3
        //e4

        //Home page : 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //e5
        //e6
        //e7

        //click logout and go to Registration page -> Here again 5 seconds will be applied, if we want to override the previous 10 seconds then we need to write
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //e5
        //e6
        //e7

        //Suppose if we want to wait for longer periof then we need to write the implicit wait needs to be written again



        //forgot password page: 0 seconds : nullification on implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        //Registration page: 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /* Cons on Implicit wait:
         * Here, we need to keep changing the implicit wait time for each and every page
         * Implicit wait will not be applied for non web elements
         * Implicit wait will be checking each and every element on each driver instance, even though page got loaded completely
         *
         */




        driver.quit();

    }
}
