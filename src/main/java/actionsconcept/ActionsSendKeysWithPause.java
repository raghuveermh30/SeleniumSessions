package actionsconcept;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysWithPause {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        By firstName = By.id("input-firstname");
        WebElement element = driver.findElement(firstName);
        String name = "naveen automation labs";

        Actions actions = new Actions(driver);
       /* char nameCharArray[] = name.toCharArray();

        for (char ch : nameCharArray) {
            actions.sendKeys(element, String.valueOf(ch))
                    .pause(500).perform();
        }*/

        doSendKeysWithPause(firstName, name, 500L);
        driver.quit();

    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void doSendKeysWithPause(By locator, String value, long pauseDuration) {
        Actions actions = new Actions(driver);
        char[] nameCharArray = value.toCharArray();

        for (char ch : nameCharArray) {
            actions.sendKeys(getElement(locator), String.valueOf(ch))
                    .pause(pauseDuration).perform();
        }

    }

}
