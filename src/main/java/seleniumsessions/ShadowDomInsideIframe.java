package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomInsideIframe {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();//browser
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");//open

		Thread.sleep(4000);
		
		//Browser --> page --> iframe --> Shadow Dom --> element
		
		driver.switchTo().frame("pact");
		
		String script = "return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\");";

		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//DOM HTML Element ---> WebElement
		WebElement teaName = (WebElement)js.executeScript(script);
		teaName.sendKeys("masala tea");
		
		
		
	}

}
