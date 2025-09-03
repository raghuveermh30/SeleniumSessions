package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();// browser - chrome

		// page
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");// page
		driver.manage().deleteAllCookies();
		
		
		By image = By.cssSelector("img[title='Vehicle-Registration-Forms-and-Examples']");

		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.waitForElementVisible(image, 10).click();

		// wait for the frame

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		wait.until(ExpectedConditions
//				.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]"))));
		
		By frameLocatgor = By.xpath("//iframe[contains(@id,'frame-one')]");
		boolean isFramePresent = waitForFrame(frameLocatgor, 10);

		if(isFramePresent) {
			driver.findElement(By.id("RESULT_TextField-1")).sendKeys("test automation");
		}
		

	}

	public static boolean waitForFrame(By frameLocator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			return true;
		} catch (TimeoutException e) {
			System.out.println("frame is not present on the page");
			return false;
		}

	}
	
	
	public static boolean waitForFrame(int frameIndex, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			return true;
		} catch (TimeoutException e) {
			System.out.println("frame is not present on the page");
			return false;
		}

	}
	
	
	public static boolean waitForFrame(String frameNameOrID, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
			return true;
		} catch (TimeoutException e) {
			System.out.println("frame is not present on the page");
			return false;
		}

	}
	
	
	

}
