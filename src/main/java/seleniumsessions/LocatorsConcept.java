package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();//browser
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//1. id: unique attribute -- I
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		//2. name: attribute: can be duplicate -- II
//		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("test@123");
		
		
		//3. className: attribute: can be duplicate -- III
		//will use only if class name is unique
		//driver.findElement(By.className("form-control")).sendKeys("test@gmail.com");
		//driver.findElement(By.className("img-responsive")).click();
		
//		By imageLogo = By.className("img-responsive");
//		doClick(imageLogo);
		
		//4. xpath: its not an attribute; its an address of the element in DOM
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@123");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
//		By email = By.xpath("//*[@id=\"input-email\"]");
//		By password = By.xpath("//*[@id=\"input-password\"]");
//		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		
//		doSendKeys(email, "test@gmail.com");
//		doSendKeys(password, "test@123");
//		doClick(loginBtn);
		
		//5. cssSelector: its not an attribute
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test@123");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		
		//6. linkText: only for links
		//link: htmltag: <a> -- text
		//driver.findElement(By.linkText("About Us")).click();
		//driver.findElement(By.linkText("Forgotten Password")).click();
		
//		By forgotPwdLink = By.linkText("Forgotten Password");
//		doClick(forgotPwdLink);
		
		//7. partialLinkText: only for links
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		//driver.findElement(By.partialLinkText("Password")).click();

		//Forgotten Password
		//Forgotten Username -- click on this
		//driver.findElement(By.partialLinkText("Forgotten")).click();

		//8. tagName: html tag
//		String header = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
		By pageHeader = By.tagName("h2");
		String header = doElementGetText(pageHeader);
		System.out.println("page header: "+ header);
		
		//id, name, classname, xpath, cssselector, linktext, partiallinktext, tagname
		
		
		
		
	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	
	
	
	
	
	
	
	

}
