package domattributesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        String name = "Naveen";
        StringBuilder stringBuilder = new StringBuilder("Automation");
        StringBuffer sf = new StringBuffer("Naveen Automation Labs");

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(name, stringBuilder, sf, " Selenium");

        String propValue = firstName.getDomProperty("value");
        System.out.println(propValue);

        //Last Name
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
      //  lastName.sendKeys(null); //Here it will give IllegalAttributeException: Keys to send should be a not null CharSequence
        //SendKeys will not allowed the Null Values

        driver.quit();
    }
}
