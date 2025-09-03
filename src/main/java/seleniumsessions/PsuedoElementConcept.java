package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsuedoElementConcept {

	public static void main(String[] args) {
		
		//Psuedo Element used with Psuedo classes
		//Psuedo class: 
		// ::before ::after
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content');";
		String script1 = "return window.getComputedStyle(document.querySelector(\"label[for='input-telephone']\"), '::before').getPropertyValue('content');";
		String script2 = "return window.getComputedStyle(document.querySelector(\"label[for='input-telephone']\"), '::before').getPropertyValue('color');";

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String content = js.executeScript(script).toString();
		System.out.println(content);
		
		if(content.contains("*")) {
			System.out.println("first name is a mandatory field");
		}
		
		
		content = js.executeScript(script1).toString();
		System.out.println(content);
		
		if(content.contains("*")) {
			System.out.println("telephone is a mandatory field");
		}
		
		String color = js.executeScript(script2).toString();
		System.out.println(color);
		if(color.contains("rgb(255, 0, 0)")) {
			System.out.println("color is RED");
		}
		
		
	}

}
