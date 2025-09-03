package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {
	
	static WebDriver driver;//null

	public static void main(String[] args) {
		
		driver = new ChromeDriver();//browser
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");//page
		
		//Create a WebElement(FE) + perform action(click, sendKeys, getText, isDiplayed)
		
		//1st:
//		driver.findElement(By.id("input-email")).sendKeys("tom@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("tom@123");
		
		//2nd:
//		WebElement emailEle = driver.findElement(By.id("input-email"));
//		WebElement pwdEle = driver.findElement(By.id("input-password"));
//
//		emailEle.sendKeys("tom@gmail.com");
//		pwdEle.sendKeys("tom@123");
		
		//3rd: By locator - OR
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailEle = driver.findElement(email);
//		WebElement pwdEle = driver.findElement(password);
//		
//		emailEle.sendKeys("tom@gmail.com");
//		pwdEle.sendKeys("tom@123");
		
		//4th: By locator + generic util(method)- getElement
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(email).sendKeys("tom@gmail.com");
//		getElement(password).sendKeys("tom@123");
		
		//5th: By locator + generic util(method)- getElement , doSendKeys()
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		doSendKeys(email, "tom@gmail.com");
		doSendKeys(password, "tom@123");
		
		//6th: By locator + generic util(method)- getElement , doSendKeys() in ElementUtil class
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(email, "tom@gmail.com");
//		eleUtil.doSendKeys(password, "tom@123");
		
		
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	
	
	
	
	
	
	
	

}
