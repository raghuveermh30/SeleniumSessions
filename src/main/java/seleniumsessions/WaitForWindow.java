package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWindow {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
//		JavaScriptUtil jsutil = new JavaScriptUtil(driver);
//		jsutil.scrollPageDown();
		
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.linkText("Data Security Promise"))).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean isWindowOpened = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		System.out.println(isWindowOpened);
		
		if(isWindowOpened) {
			//code to get handle and switch
		}
		

	}

}
