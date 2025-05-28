package domattributesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisplayedDisabledChecked {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement pwdElement = driver.findElement(By.id("pass"));
        boolean isDisplayed = pwdElement.isDisplayed();
        System.out.println(isDisplayed); //true

        boolean isEnabled = pwdElement.isEnabled();
        System.out.println(isEnabled); //false

        driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        WebElement policyCheckBox = driver.findElement(By.name("agree"));
        System.out.println(policyCheckBox.isSelected());//false
        policyCheckBox.click();
        System.out.println(policyCheckBox.isSelected());//true

        //isSelected() - will work for only if the tag is input in the DOM

        driver.quit();

    }
}
