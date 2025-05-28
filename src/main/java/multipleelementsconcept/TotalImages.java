package multipleelementsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TotalImages {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Total Links on the Page
        //Print the text on the each link if the text is available

        driver = new ChromeDriver();
        driver.get("https://www.flipkart.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        //Total Num of Images on the Page
        List<WebElement> getAllImages = driver.findElements(By.tagName("img"));
        System.out.println("total number of images : " + getAllImages.size());

        driver.quit();
    }
}
