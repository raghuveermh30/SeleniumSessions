package framesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassAttributeConcept {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.hubspot.com/login/legacy");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        // driver.findElement(By.className("form-control private-form__control")).sendKeys("testAutomation");
        //InvalidSelectorException: Compound class names not permitted --> this exception we will get
        //If we are using class name then Multiple classes are not allowed. it won't work
        //Compound class names are not supported

        driver.findElement(By.xpath("(//input[@class = 'form-control private-form__control'])[1]")).sendKeys("testautomation");
        //this is valid

        //invalid
        //driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("test@gmail.com");
        //InvalidSelectorException: Compound class names not permitted --> this is most important


        //single class: valid
        //driver.findElement(By.className("login-email")).sendKeys("test@gmail.com");

        //valid: compound classes
//		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("test@gmail.com");

        //invalid
        //driver.findElement(By.xpath("//input[@class='login-email']")).sendKeys("test@gmail.com");

        //valid:
        //driver.findElement(By.xpath("//input[contains(@class,'login-email')]")).sendKeys("test@gmail.com");

        //valid: compound classes
        //driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email")).sendKeys("test@gmail.com");

        //valid
        //driver.findElement(By.cssSelector("input.login-email")).sendKeys("test@gmail.com");

        //InvalidSelectorException: invalid selector
        driver.findElement(By.xpath("//input@[@id==='username' @]")).sendKeys("test@gmail.com");

        //NSE
        driver.findElement(By.xpath("//input[@id='naveen']")).sendKeys("test@gmail.com");


    }
}
