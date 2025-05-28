package actionsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.plaf.TableHeaderUI;

public class ActionsScrolling {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        Actions actions = new Actions(driver);
        //1. Partial Scrolling
        /*
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        Thread.sleep(3000L);
        actions.sendKeys(Keys.PAGE_UP).build().perform();*/

        //2. scroll to the footer of the page using COMMAND END  Key
        /*actions.sendKeys(Keys.COMMAND).sendKeys(Keys.END).build().perform(); //Page Down
        Thread.sleep(3000L);
        //scroll to the top of the page using COMMAND HOME Key
        actions.sendKeys(Keys.COMMAND).sendKeys(Keys.HOME).build().perform(); //Page Up*/


        //scroll to the Specific Element
        actions.scrollToElement(driver.findElement(By.linkText("OpenCart"))).pause(2000).click(driver.findElement(By.linkText("OpenCart"))).perform();


        driver.quit();

    }
}
