package seleniumtricks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframeHandleConcept {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();//browser - chrome

        //page
        driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@id ='imageTemplateContainer']/img")).click();
        Thread.sleep(3000);

        /*//Switch to the iframe
        driver.switchTo().frame(driver.findElement(By.id("frame-one748593425")));

        // Fill the form inside the iframe
        driver.findElement(By.id("RESULT_TextField-8")).sendKeys("testAutomation");*/

        //2nd Approach --> Using Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame-one748593425")));
        driver.findElement(By.id("RESULT_TextField-8")).sendKeys("testAutomation");

        driver.quit();

    }
}
