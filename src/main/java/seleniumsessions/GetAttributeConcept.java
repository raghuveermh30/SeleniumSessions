package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		
		
		
		
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");		
		
		driver.findElement(By.id("qwe")).getAttribute("id");
		
//		String hrefVal = driver.findElement(By.linkText("Forgotten Password")).getDomAttribute("href");
//		System.out.println(hrefVal);
//		
//		String classVal = driver.findElement(By.linkText("Forgotten Password")).getDomAttribute("class");
//		System.out.println(classVal);//null
//		
		String className = driver.findElement(By.linkText("Forgotten Password")).getDomProperty("className");
		System.out.println(className);
		
		String placeholderVal = driver.findElement(By.id("input-email")).getDomAttribute("placeholder");
		System.out.println(placeholderVal);
		
		
		String outerHtml = driver.findElement(By.id("input-email")).getDomProperty("outerHTML");
		System.out.println(outerHtml);
		
		
		
	}

}
