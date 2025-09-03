package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConcept {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		
		driver.switchTo().newWindow(WindowType.WINDOW);//4.x
		
		driver.get("https://google.com");
		//driver.close();
		
		
		

	}

}
