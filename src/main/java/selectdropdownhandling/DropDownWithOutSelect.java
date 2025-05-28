package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithOutSelect {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.cardekho.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000L);

        driver.findElement(By.id("vehicleTypeName")).sendKeys("MUV");
        Thread.sleep(4000L);

       driver.findElement(By.xpath("(//li[contains(text(), 'MUV')])[1]")).click();


    }
    }
