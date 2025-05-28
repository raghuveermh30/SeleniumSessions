package multipleelementsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FooterLinks {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Capture Get all the footer links and print the text on each console

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        List<WebElement> getAllFooterList = driver.findElements(By.xpath("//footer//a"));
        System.out.println("Total Footer Links: " + getAllFooterList.size());

        for (WebElement e : getAllFooterList) {
            System.out.println(e.getText());
        }
        System.out.println("***************");

        //Get Right hand side Links and print the text on each console
        List<WebElement> getRightSideList = driver.findElements(By.xpath("//aside//a"));
        System.out.println("Total Number of Links are present in Right hand side : "+getRightSideList.size());

        for (WebElement e : getRightSideList) {
            System.out.println(e.getText());
        }
        driver.quit();
    }
}
