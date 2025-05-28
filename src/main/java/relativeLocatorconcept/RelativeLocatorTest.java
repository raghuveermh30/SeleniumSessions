package relativeLocatorconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorTest {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /* Relative Locator is added in selenium 4.0
         * Relative Locators meaning neighboring elements --> Left, Right, Above, Below, Near to the particular WebElement
         *
         */

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement privacyPolicy = driver.findElement(By.cssSelector("a.agree"));
        driver.findElement(with(By.name("agree")).toRightOf(privacyPolicy))
                .click();

       // driver.findElement(with(By.xpath("//input[@value='Continue']")).toRightOf(privacyPolicy)).click();

        //near --> The distance between the nearest and base element should be less than 50 pixels
        //Suppose if the distance is more than 50 pixels, then it will not work

        driver.findElement(with(By.xpath("//input[@value='Continue']")).near(privacyPolicy)).click();


        // driver.quit();
    }
}
