package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUtil {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By links = By.tagName("a");
		By images = By.tagName("img");

		int totalLinks = getElementsCount(links);
		int totalImages = getElementsCount(images);

		System.out.println("total links: " + totalLinks);
		System.out.println("total images: " + totalImages);
		
		List<String> actualLinksTextList = getElementsTextList(links);
		for(String e : actualLinksTextList) {
			System.out.println(e);
		}
		
		if(actualLinksTextList.contains("Login")) {
			System.out.println("login is present--pass");
		}
		
		if(actualLinksTextList.contains("Register")) {
			System.out.println("Register is present--pass");
		}
		
		List<String> expList = Arrays.asList("Login", "Register", "Newsletter", "Order History", "About Us");
		
		
		if(actualLinksTextList.containsAll(expList)) {
			System.out.println("all the imp links are present on the page....");
		}
		
	}
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();//pc=0,vc=10; []
		for(WebElement e : eleList) {
			String text = e.getText();
				if(text.length()!=0) {
					eleTextList.add(text);
				}
		}
		return eleTextList;
		
	}
	

	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
