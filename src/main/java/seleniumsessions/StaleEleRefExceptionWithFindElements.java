package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleEleRefExceptionWithFindElements {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com/");//DOM v1
		
		Thread.sleep(5000);
		
		JavaScriptUtil jsutil = new JavaScriptUtil(driver);
		jsutil.scrollPageDown();

		Thread.sleep(5000);
		
		//dom v1
		List<WebElement> footerList = driver.findElements(By.xpath("//footer//a"));
		System.out.println(footerList.size());
		
		for(int i=2; i<=8; i++) {
			footerList.get(i).click();
			driver.navigate().back();
			//dom v2 v3 v4 v5 v6 v7
			footerList = driver.findElements(By.xpath("//footer//a"));
		}
		
		
		
	}

}
