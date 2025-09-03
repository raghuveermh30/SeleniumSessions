package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchHrefValueOfLinks {
	
	static WebDriver driver;


	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		for(WebElement e : linksList) {
			String hrefVal = e.getDomAttribute("href");
			String text = e.getText();
			System.out.println(text + ":::" + hrefVal);
		}
		
	}

}
