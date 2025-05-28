package seleniumtricks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement signInBtn = driver.findElement(By.xpath("//button[@name='proceed']"));
        signInBtn.click();
        Thread.sleep(3000L);

        //1st Approach --> ******** Missed UserName
        /*Alert alert = driver.switchTo().alert();
        Thread.sleep(3000L);
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000L);*/

        //2nd Approach --> Using Explicit Wait
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000L);*/

        //3rd Approach --> Using JavaScript Executor
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        try {
            javascriptExecutor.executeScript("window.alert=function{};");
        } catch (Exception e) {
            System.out.println("Alert is present");
        }

        driver.quit();
    }
}
