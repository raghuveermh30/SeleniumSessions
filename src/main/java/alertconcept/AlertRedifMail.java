package alertconcept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertRedifMail {


    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement signInBtn = driver.findElement(By.xpath("//button[@name='proceed']"));
        signInBtn.click();
        Thread.sleep(3000L);

        //******** Missed UserName
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000L);
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000L);

        //****** Missed Password

        WebElement emailId = driver.findElement(By.xpath("//input[@name='login']"));
        emailId.sendKeys("shushmaraghuveer3019@gmail.com");
        Thread.sleep(3000L);
        signInBtn.click();
        Thread.sleep(3000L);

        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000L);
        System.out.println(alert1.getText());
        alert1.accept();
        Thread.sleep(3000L);

        driver.quit();

    }
}
