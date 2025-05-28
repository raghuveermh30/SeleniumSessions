package locatorsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().window().maximize();
        Thread.sleep(3000L);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //1. id: attribute -->  Id is always unique attribute -- I
        driver.findElement(By.id("input-firstname")).sendKeys("naveen");

        //2. Name: attribute -->  Name is also unique attribute, but it can be duplicate -- II
        driver.findElement(By.name("lastname")).sendKeys("testing");


        //3. ClassName: attribute --> can be duplicate, chances are high -- III -- this we can go but class name should be unique
        //  driver.findElement(By.className("form-control")).sendKeys("naveen@gmail.com");

        //4. xpath: is not an attribute
        //xpath is the address of the element inside the DOM, this is one of the locator not the attribute
        driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("1234567891");
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("naveen@gmail.com");

        //5. cssSelector: is not a attribute, its a locator
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Naveen@123");
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Naveen@123");

        //6. linkText: this is only for link: htmlTag --> <a> --> anchor tag only
        // This will only work for Link
        driver.findElement(By.linkText("Login")).click();
        //driver.findElement(By.linkText("Register")).click();

        //7. Partial LinkText: this is only for link: htmlTag --> <a> --> anchor tag only -> Partial Link text is also applied
        driver.findElement(By.partialLinkText("Forgotten")).click();
        //Forgotten Password
        //Forgotten Username
        // the problem with this suppose if we have Forgotten UserName then it will work for the first occurance

        //8. tagName: HTML tag name: it should be unique --> then only we need to use
        String forgotPassHeader = driver.findElement(By.tagName("h1")).getText();
        System.out.println(forgotPassHeader);

        driver.quit();
    }
}
