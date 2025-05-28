package alertconcept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptPopupsHandling {

    public static void main(String[] args) throws InterruptedException {

        // alert JS Pop ups:
        //1. alert
        //2. Confirmation
        //3. prompt

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        Thread.sleep(3000);

       /* WebElement element = driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']"));
        element.click();
        Thread.sleep(3000L);

        //this will be applied on only Javascript Popups
        //Alert is the Interface
         Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept(); //click on OK button
        // alert.dismiss(); // dismiss the alert*/

        driver.quit();

        //Click on JS Confirm
        /*WebElement confirmEle = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));

        confirmEle.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept();//click on ok button
//		alert.dismiss();//dismiss the alert*/

        //Prompt based JS
        WebElement element = driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']"));
        element.click();
        Thread.sleep(3000L);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.sendKeys("test automation");
        alert.accept();


    }
}
