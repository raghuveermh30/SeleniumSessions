package seleniumsessions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSize {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		
		Dimension dim = new Dimension(768, 1024);

		driver.manage().window().setSize(dim);

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

	}

}
