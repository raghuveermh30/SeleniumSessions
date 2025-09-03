package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
				
		//driver.get("https://www.google.com");		
		//driver.navigate().to("https://www.google.com");
		
		
		try {
			URL url = new URL("https://www.google.com");
			driver.navigate().to(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(driver.getTitle());
		
		
		
	}

}
