package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");

		Thread.sleep(4000);
		
		//Browser --> page --> shadow Dom --> Shadow Dom --> element
		
		
		String script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\");";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//DOM HTML Element ---> WebElement
		WebElement pizzaName = (WebElement)js.executeScript(script);
		
		pizzaName.sendKeys("Veg Pizza");
		
		
	}

}
