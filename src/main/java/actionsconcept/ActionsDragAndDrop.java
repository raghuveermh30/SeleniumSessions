package actionsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

        /*
         * Drag and Drop will work only for WebElement
         */


        WebElement sourceEle = driver.findElement(By.id("draggable"));
        WebElement targetEle = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceEle).moveToElement(targetEle).build().perform(); //this will also work

        // actions.dragAndDrop(sourceEle, targetEle).build().perform(); //this will also work
        // All the actions method returning the Actions class only, Hence its achieving the Builder Pattern
        // build() is using Action Interface
        // perform() is void in nature

    }
}
