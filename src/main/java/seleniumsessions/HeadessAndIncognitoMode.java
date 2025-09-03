package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadessAndIncognitoMode {

	public static void main(String[] args) {
		
		//headless: no browser is launched
		//testing is happening behind the scene
		//adv:
			//1. speed
			//2. useful in ci cd pipeline--linux machine/docker 
		
		
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		//co.addArguments("--incognito");

		//WebDriver driver = new ChromeDriver(co);
		
		FirefoxOptions fo = new FirefoxOptions();
		//fo.addArguments("--headless");
		fo.addArguments("--incognito");
		WebDriver driver = new FirefoxDriver(fo);
		
//		EdgeOptions eo = new EdgeOptions();
//		eo.addArguments("--headless");
//		WebDriver driver = new EdgeDriver(eo);
		//Edge -- open in the incognito/mode -- find out the switch for edge: inPrivate
		
		//safari?? does not support headless mode
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
		
		
		
		
		

	}

}
