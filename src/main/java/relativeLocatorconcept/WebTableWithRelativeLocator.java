package relativeLocatorconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WebTableWithRelativeLocator {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /* Relative Locator is added in selenium 4.0
         * Relative Locators meaning neighboring elements --> Left, Right, Above, Below, Near to the particular WebElement
         * In this example, we will use Relative Locators to find a link in a web table
         */

        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement ele = driver.findElement(By.linkText("Joe.Root"));
        driver.findElement(with(By.id("ohrmList_chkSelectRecord_21")).toLeftOf(ele)).click();

        String aboveUser = driver.findElement(with(By.tagName("a")).above(ele)).getText();
        System.out.println(aboveUser);


        String belowUser = driver.findElement(with(By.tagName("a")).below(ele)).getText();
        System.out.println(belowUser);

        String rightRoleElement = driver.findElement(with(By.tagName("td")).toRightOf(ele)).getText();
        System.out.println(rightRoleElement);

        driver.quit();
    }
}
