package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.get("https://classic.crmpro.com/");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		
//		String title = js.executeScript("return document.title").toString();
//		System.out.println(title);
//				
//		driver.quit();
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
//		String title = jsUtil.getTitleByJS();
//		System.out.println(title);
//		
//		System.out.println(jsUtil.getURLByJS());
//		
//		jsUtil.generateAlert("this is login page");
		
		
//		String pageText = jsUtil.getPageInnerText();
//		System.out.println(pageText);
//		
//		if(pageText.contains("Calls & Voice")) {
//			System.out.println("PASS");
//		}

//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
		
//		WebElement element = driver.findElement(By.xpath("//h3[text()='Reports']"));
////		
////		jsUtil.scrollIntoView(element);
//		
//		WebElement username = driver.findElement(By.name("username"));
//		WebElement password = driver.findElement(By.name("password"));
//
//		jsUtil.drawBorder(username);
//		jsUtil.drawBorder(element);		
//		
//		WebElement loginForm = driver.findElement(By.id("loginForm"));
//		jsUtil.drawBorder(loginForm);
//		
//		jsUtil.flash(username);
//		username.sendKeys("apiautomation");
//		
//		jsUtil.flash(password);
//		password.sendKeys("test@123");
//		
//		jsUtil.flash(loginForm);

		WebElement forgotPWdLink = driver.findElement(By.linkText("Forgot Password?"));
		jsUtil.clickElementByJS(forgotPWdLink);
		
		
		//ShadowDOM
		//Pseudo Element
		//SVG element
		
		
		
		
	}

}
