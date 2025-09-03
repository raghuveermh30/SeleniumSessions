package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsWithTwoDirections {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement header = driver.findElement(By.xpath("//h2[text()='New Customer']"));
		WebElement continueButton = driver.findElement(By.linkText("Continue"));
		
		String para = driver
						.findElement(RelativeLocator.with(By.tagName("p"))
										.below(header)
												.above(continueButton))
															.getText();
		System.out.println(para);
		
		
	}

}
