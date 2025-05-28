package actionsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {

    static WebDriver driver;

    /*
     * Actions is a class, Here we need to provide the WebDriver (driver)
     *
     *
     */

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000L);

        /*WebElement addOnsElement = driver.findElement(By.xpath("//div[contains(text(), 'Add-ons')]"));
        WebElement visaServiceElement = driver.findElement(By.xpath("//div[contains(text(), 'Visa Services')]"));

        Actions actions = new Actions(driver);

        // actions.moveToElement(addOnsElement).perform(); --> this will also work --> perform method will call build() internally
        *//*
         * actions.build.perform --> correct
         * actions.perform --> will not work
         * actions.perform --> correct
         * actions --> will not work
         *//*

        actions.moveToElement(addOnsElement).build().perform();
        Thread.sleep(2000L);
        visaServiceElement.click();
        Thread.sleep(2000L);*/


        //driver.quit();


        By addOnsElement = By.xpath("//div[contains(text(), 'Add-ons')]");
        By visaServiceElement = By.xpath("//div[contains(text(), 'Visa Services')]");
        By taxiElement = By.xpath("//div[contains(text(), 'Taxi')]");

        handleTwoLevelMenuSubMenuHandling(addOnsElement, visaServiceElement);
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void handleTwoLevelMenuSubMenuHandling(By parentMenuLocator, By childMenuLocator) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(parentMenuLocator)).build().perform();
        Thread.sleep(2000L);
        getElement(childMenuLocator).click();
    }
}
