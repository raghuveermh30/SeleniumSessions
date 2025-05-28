package multipleelementsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class EmptyWebElementList {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Capture Get all the footer links and print the text on each console

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        List<WebElement> list = driver.findElements(By.className("naveen"));
        System.out.println(list.size());

        /*
         * FindElement is used to find the single Element -> FindElements is used to find the multiple Element
         * Return type of FindElement is Single WebElement --> Return type of FindElement is List of WebElement
         * If element is not available --> FindElement will give NoSuchElementException
         * If element is not available --> FindElements will give 0
         *
         */
    }
}
