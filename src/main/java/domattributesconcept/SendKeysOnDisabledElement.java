package domattributesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysOnDisabledElement {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement pwdElement = driver.findElement(By.id("pass"));
        //pwdElement.sendKeys("123"); //org.openqa.selenium.ElementNotInteractableException: element not interactable

        pwdElement.click(); //Using click() on the disabled element --> Here nothing will happen --> No Exceptions

       String isElementDisabled =  pwdElement.getDomAttribute("disabled");
        System.out.println(isElementDisabled); //true

        driver.quit();

    }
}
