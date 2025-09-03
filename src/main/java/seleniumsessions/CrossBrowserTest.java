package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {

	static WebDriver driver; //null
	
	public static void main(String[] args) { //S --> S

		String browser = "safari";
		browser = "aman";
		
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("plz pass the right browser name..." + browser);
			throw new BrowserException("====INVLAID BROWSER====");
		}
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String title = driver.getTitle();
		System.out.println("Page title : "+ title);
		
		if(title.equals("Account Login")) {
			System.out.println("title is correct --- PASS");
		}
		else {
			System.out.println("title is incorrect --- FAIL");
		}
		
		
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Page url : "+ pageUrl);
		
		if(pageUrl.contains("route=account/login")) {
			System.out.println("url is correct --- PASS");
		}
		else {
			System.out.println("url is incorrect --- FAIL");
		}
		
		driver.quit();

	}

}
