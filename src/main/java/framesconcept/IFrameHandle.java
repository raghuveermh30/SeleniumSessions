package framesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();//browser - chrome

        //page
        driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@id ='imageTemplateContainer']/img")).click();
        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.id("frame-one748593425")));

        driver.findElement(By.id("RESULT_TextField-8")).sendKeys("testAutomation");

        //Fill the entire Form in the application

        //come out of the iframe and come back to the main page
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        String headerText = driver.findElement(By.xpath("//h3[@class ='details__form-preview-title']")).getText();
        System.out.println(headerText);
    }
}
