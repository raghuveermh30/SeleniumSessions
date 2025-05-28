package actionsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethodChainingRegisterPage {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement firstName = driver.findElement(By.id("input-firstname"));

        Actions actions = new Actions(driver);

        /*
         * This type of actions is called Accessability testing
         * This we have achived using one locator and entered all the details in the Registration Page
         *
         */

        Action action = actions.sendKeys(firstName, "Mohit123")
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys("Sharma").pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys("mohit@gmail.com").pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys("123456789").pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys("mohit@123").pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys("mohit@123").pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys(Keys.SPACE).pause(1000)
                .sendKeys(Keys.TAB).pause(1000)
                .sendKeys(Keys.ENTER).pause(1000)
                .build();
        action.perform();
    }
}
