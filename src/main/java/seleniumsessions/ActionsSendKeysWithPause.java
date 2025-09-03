package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysWithPause {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		
//		WebElement firstName = driver.findElement(By.id("input-firstname"));
//		
//		Actions act = new Actions(driver);
//
//		
//		String name = "Naveen Automation Labs";
//		
//		char value[] = name.toCharArray();
//		
//		for(char ch : value) {
//			act
//				.sendKeys(firstName, String.valueOf(ch))//Nave
//					.pause(500)
//						.perform();
//		}
		
		By firstname = By.id("input-firstname");
		doSendKeysWithPause(firstname, "welcome to naveen automation labs", 200);
		
	}
	
	
	
	public static void doSendKeysWithPause(By locator, String value, long pauseTime) {
		Actions act = new Actions(driver);
		
		char val[] = value.toCharArray();
		for(char ch : val) {
			act
				.sendKeys(getElement(locator), String.valueOf(ch))
					.pause(pauseTime)
						.perform();
		}
		
	}
	
	
	
	public static WebElement getElement(By lcoator) {
		return driver.findElement(lcoator);
	} 
	
	
	
	
	
	
	

}
