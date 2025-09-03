package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingTime {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//Wait(I) : until();
			// FluentWait (C): until(){} + other methods
				//WebDriverWait (C) : no methods + can inherit from FluentWait
		
		//IS - A
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		By username = By.name("username11");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		WebElement usernameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		usernameEle.sendKeys("uiautomatio");
		
		
	}

}
