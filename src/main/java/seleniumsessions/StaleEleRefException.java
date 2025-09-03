package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleEleRefException {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");//DOM v1

		By emailId = By.id("input-email");
		
		//DOM v1
		WebElement usernameEle = driver.findElement(emailId);
		//e2
		//e3
		//e4
		
		//DOM v1
		usernameEle.sendKeys("tom@gmail.com");
		
		driver.navigate().refresh();//back and forward, internal refresh 
		//DOM v2
		
		//re-create the element
		usernameEle = driver.findElement(emailId);
		
		//DOM v2 --> DOM v2
		usernameEle.sendKeys("naveen@gmail.com");

		
		
		
	}

}
