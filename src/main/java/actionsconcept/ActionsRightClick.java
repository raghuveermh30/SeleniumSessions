package actionsconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRightClick {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        //right-click on the specific element-- context click

        WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickEle).build().perform();

        List<WebElement> rightClickOptions = driver.findElements(By.xpath("//ul[@class ='context-menu-list context-menu-root']/li"));
        System.out.println(rightClickOptions.size());

        for (WebElement element : rightClickOptions) {
            String text = element.getText();
            System.out.println(text);
            if (text.equals("Copy")) {
                element.click();
                break;
            }

        }


    }
}


