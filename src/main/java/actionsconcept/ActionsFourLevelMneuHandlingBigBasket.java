package actionsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsFourLevelMneuHandlingBigBasket {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://www.bigbasket.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        By level1Menu = By.xpath("(//span[text() = 'Shop by'])[2]");

         /* By level2Menu = By.linkText("Beverages");
        By level3Menu = By.linkText("Tea");
        By level4Menu = By.linkText("Green Tea");*/

        By level2Menu = By.linkText("Bakery, Cakes & Dairy");
        By level3Menu = By.linkText("Dairy");
        By level4Menu = By.linkText("Milk");

        driver.findElement(level1Menu).click();
        Thread.sleep(3000L);
        Actions actions = new Actions(driver);


        //Approach 1
        actions.moveToElement(driver.findElement(level2Menu)).build().perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(level3Menu)).build().perform();
        Thread.sleep(2000);
        driver.findElement(level4Menu).click();


        //Approach 2 --> This approach won;t work due to delay is not added
        /* actions.pause(2000).moveToElement(driver.findElement(level2Menu)).pause(2000)
                .moveToElement(driver.findElement(level3Menu)).pause(2000).click(driver.findElement(level4Menu)).build().perform();
        */

        driver.quit();

    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void handleFourLevelMenuSubMenuHandling(By level1Menu, By level2Menu, By level3Menu, By level4Menu) throws InterruptedException {
        getElement(level1Menu).click();
        Thread.sleep(3000L);
        Actions actions = new Actions(driver);

        actions.moveToElement(getElement(level2Menu)).build().perform();
        Thread.sleep(2000);
        actions.moveToElement(getElement(level3Menu)).build().perform();
        Thread.sleep(2000);
        getElement(level4Menu).click();
    }
}
