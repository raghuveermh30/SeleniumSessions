package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsPresent {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");//---> 1
		By forgotPwdLink = By.linkText("Forgotten Password");//--->2

//		List<WebElement> eleList = driver.findElements(emailId);//size=1;
//		System.out.println(eleList.size());
//		
//		if(eleList.size() == 1) {
//			System.out.println("element is present on the page");
//		}
//		else {
//			System.out.println("element is not present on the page");
//		}
		
		if(isElementExist(emailId)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		
		if(isElementExist(forgotPwdLink, 2)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
	}

	public static boolean isElementExist(By locator) {
		if(driver.findElements(locator).size() == 1) {
			System.out.println("the element : "+ locator +" is present on the page one time");
			return true;
		}
		else {
			System.out.println("the element : "+ locator +" is not present on the page");
			return false;
		}
	}
	
	public static boolean isElementExist(By locator, int expectedEleCount) {
		if(driver.findElements(locator).size() == expectedEleCount) {
			System.out.println("the element : "+ locator +" is present on the page " +expectedEleCount+ " times");
			return true;
		}
		else {
			System.out.println("the element : "+ locator +" is not present on the page " +expectedEleCount+ " times");
			return false;
		}
	}
	
	
	
	
	
}
