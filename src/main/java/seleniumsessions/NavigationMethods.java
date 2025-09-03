package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());

		Thread.sleep(1000);

		//driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		Thread.sleep(1000);

		driver.navigate().forward();
		System.out.println(driver.getTitle());

		Thread.sleep(1000);

		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();//refresh the page

	}

}
