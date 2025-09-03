package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//1. Open browser: chrome
		WebDriver driver = new ChromeDriver();
				
		//2. enter the url
		driver.get("https://www.google.com");
		
		//3. get the page title
		String title = driver.getTitle();
		System.out.println("page title : "+ title);
		
		//Automation Steps + Validation(Assertions) --> Automation Testing
		
		//4. validation, checkpoint: act vs exp result
		if(title.equals("Google")) {
			System.out.println("title is correct --- PASS");
		}
		else {
			System.out.println("title is not correct --- FAIL");
		}
		
		driver.quit();//close browser
		//cnrl+shift+f
	}

}
