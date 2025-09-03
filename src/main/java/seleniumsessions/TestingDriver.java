package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingDriver {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver = new ChromeDriver();
		
		WebDriver driver1 = new FirefoxDriver();

		driver.get("https://www.google.com");
		driver1.get("https://www.amazon.com");

		driver.quit();
		driver1.quit();
		
	}

}
