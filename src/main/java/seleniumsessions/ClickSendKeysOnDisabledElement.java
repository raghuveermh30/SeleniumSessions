package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickSendKeysOnDisabledElement {

	static WebDriver driver;

	public static void main(String[] args)  {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		//driver.findElement(By.id("pass")).sendKeys("test@123");
		//if element is disabled -- sendKeys --ElementNotInteractableException: element not interactable
		
		
		driver.findElement(By.id("pass")).click();
		//if element is disabled -- click --- no exception will be thrown
		
		
	}

}
