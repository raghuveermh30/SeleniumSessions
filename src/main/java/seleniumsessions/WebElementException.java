package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementException {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();// browser
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// create webelement + perform action
		try {
			driver.findElement(By.id("input-email11")).sendKeys("naveen@gmail.com");
		} catch (NoSuchElementException e) {
			System.out.println("element is not found...");
			e.printStackTrace();
		}
		// NoSuchElementException: no such element

		System.out.println(driver.getTitle());

	}

}
