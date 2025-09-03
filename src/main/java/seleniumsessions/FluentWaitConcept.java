package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//Wait(I) : until();
			// FluentWait (C): until(){} + other methods
				//WebDriverWait (C) : no methods + can inherit from FluentWait
		
		//IS - A
		
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		By username = By.name("username");
		//wait is written with fluent wait features
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(10))
//								.pollingEvery(Duration.ofMillis(200))
//								.ignoring(NoSuchElementException.class)
//								.ignoring(StaleElementReferenceException.class)
//								.withMessage("=====ELEMENT NOT PRESENT ON THE PAGE====");
//		
//		
//		WebElement usernameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
//		usernameEle.sendKeys("uiautomatio");
		
		waitForElementVisibleWithFluentWait(username, 10, 2).sendKeys("uiautomation");
		
		
		//WebDriverWait is written with fluent wait features
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class)
//				.withMessage("=====ELEMENT NOT PRESENT ON THE PAGE====");
//		
//		
//		WebElement usernameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
//		usernameEle.sendKeys("uiautomatio");

		
	}

	public static WebElement waitForElementVisibleWithFluentWait(By locator, int timeout, int pollingtime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeout))//10
				.pollingEvery(Duration.ofMillis(pollingtime))//2
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("=====ELEMENT NOT PRESENT ON THE PAGE====");
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	
}
