package multipleelementsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TotalNumTextFields {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Total Links on the Page
        //Print the text on the each link if the text is available

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        //Total Num of Images on the Page
        List<WebElement> getRegTextFields = driver.findElements(By.className("form-control"));
        System.out.println("total number of text fields : " + getRegTextFields.size());
        System.out.println("**************");

        List<WebElement> getAllTextFields = driver.findElements(By.xpath("//form//input[@class='form-control']"));
        System.out.println("total number of text fields : " + getAllTextFields.size());

        driver.quit();
    }
}
