package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleAndURL {

	// url
	// title: loading.... checking....

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		
//		String title = waitForTitleContains("Free CRM customer relationship", 5);
//		System.out.println(title);
		
		String title = waitForTitleIs("Free CRM software for customer relationship management, sales, and support.", 5);
		System.out.println(title);
	}

	public static String waitForTitleContains(String fractionTitleValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.titleContains(fractionTitleValue));
		} catch (TimeoutException e) {
			System.out.println("expected title value : "+ fractionTitleValue + " is not present");
		}

		return driver.getTitle();
	}
	
	
	public static String waitForTitleIs(String expectedTitleValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.titleIs(expectedTitleValue));
		} catch (TimeoutException e) {
			System.out.println("expected title value : "+ expectedTitleValue + " is not present");
		}

		return driver.getTitle();
	}
	
	
	
	public static String waitForURLContains(String fractionURLValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.urlContains(fractionURLValue));
		} catch (TimeoutException e) {
			System.out.println("expected URL value : "+ fractionURLValue + " is not present");
		}

		return driver.getCurrentUrl();
	}
	
	
	public static String waitForURLIs(String epxectedURLValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.urlToBe(epxectedURLValue));
		} catch (TimeoutException e) {
			System.out.println("expected URL value : "+ epxectedURLValue + " is not present");
		}

		return driver.getCurrentUrl();
	}
	
	
	
	

}
