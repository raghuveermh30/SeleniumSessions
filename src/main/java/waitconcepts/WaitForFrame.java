package waitconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelementconcept.ElementUtil;

import java.time.Duration;

public class WaitForFrame {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();//browser - chrome

        //page
        driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");//page

        By formImage = By.xpath("//div[@id ='imageTemplateContainer']/img");
        By frame = By.id("frame-one748593425");
        By firstName = By.id("RESULT_TextField-8");
        By lastName = By.id("RESULT_TextField-9");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.waitForElementVisible(formImage, 10).click();

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));*/

        elementUtil.waitForFrameByLocatorAndSwitchToFrame(frame, 10);
        elementUtil.waitForElementToBePresent(firstName, 10).sendKeys("testAutomation");
        elementUtil.doSendKeys(lastName, "selenium");

        driver.switchTo().defaultContent();
        String headerText = driver.findElement(By.xpath("//h3[@class ='details__form-preview-title']")).getText();
        System.out.println(headerText);

    }

    public static void waitForFrameByLocatorAndSwitchToFrame(By frameLocator, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public static void waitForFrameByIndexAndSwitchToFrame(int frameIndex, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }

    public static void waitForFrameByNameAndSwitchToFrame(String frameIdOrName, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));
    }

    public static void waitForFrameByElementAndSwitchToFrame(WebElement frameElement, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }
}
