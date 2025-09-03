package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {

		//1. CD d = new CD
		//valid but not recommended; limited to one browser only
		//can not be used for cross browser testing
//		ChromeDriver driver = new ChromeDriver();
//		FirefoxDriver driver1 = new FirefoxDriver();
//		EdgeDriver driver2 = new EdgeDriver();
		
		//2. WD d = new CD();
		//local testing
		//valid and recommended: used for cross browser testing
//		WebDriver driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver = new EdgeDriver();
		
		
		//3. WD d = new RWD();
		//valid and recommended
		//remote testing
		//used for running tests on selenium grid, remote, server, AWS cloud, VMs, jenkins cicd, browserstack, lambdatest
		//WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);
		//capabilities= ch/ff/sf/edge
		
		//4. SC d = new CD();
		//valid and not recommended
		//SearchContext driver = new ChromeDriver();
		
		
		//5. RWD d = new CD();
		//valid and recommended: used for cross browser testing
//		RemoteWebDriver driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver = new EdgeDriver();
		
		
		//6. ChD d = new CD();
		//valid but not recommended; used only for chrome and edge 
//		ChromiumDriver driver = new ChromeDriver();
//		driver = new EdgeDriver();
		
		//7. SC d = new RWD();
		//valid but not recommended
		//SearchContext driver = new RemoteWebDriver(remoteAddress, capabilities);
		
		
	}

}
