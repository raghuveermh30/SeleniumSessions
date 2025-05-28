package actionsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndSendKeys {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(4000L);

        WebElement firstNameEle = driver.findElement(By.id("input-firstname"));
        WebElement agreeCheckBox = driver.findElement(By.name("agree"));

        // Equivalent to calling: Actions.click(element).sendKeys(keysToSend).
        // This method is different from WebElement.sendKeys(CharSequence)
        // see sendKeys(CharSequence) for details how
        Actions actions = new Actions(driver);
        actions.sendKeys(firstNameEle, "testing").build().perform();
        Thread.sleep(4000L);

        //Clicks in the middle of the given element.
        //Equivalent to: Actions.moveToElement(onElement).click()
        actions.click(agreeCheckBox).build().perform();

        By firstName = By.id("input-firstname");
        By checkBox = By.name("agree");

        doActionSendKeys(firstName, "naveen");
        doActionClick(checkBox);

    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void doActionSendKeys(By locator, CharSequence... value) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(getElement(locator), value).build().perform();
        Thread.sleep(4000L);
    }

    public static void doActionClick(By locator) {
        Actions actions = new Actions(driver);
        actions.click(getElement(locator)).build().perform();

    }
}
