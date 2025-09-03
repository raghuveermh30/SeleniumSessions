package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsConcept {

	public static void main(String[] args) {

		//selenium 4.x: RelativeLocator : with
		
//		  above
//			|	
//left <--- ele  ---> right
//			|
//		  below
//near ele

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		
		WebElement privacyPolicyLink = driver.findElement(By.cssSelector("a.agree"));
		
		driver.findElement(RelativeLocator.with(By.name("agree")).toRightOf(privacyPolicyLink)).click();		
		
		//driver.findElement(RelativeLocator.with(By.xpath("//input[@value='Continue']")).toRightOf(privacyPolicyLink)).click();
		
		String text = 
						driver
							.findElement(RelativeLocator.with(By.xpath("//div[@class='pull-right']"))
											.near(privacyPolicyLink))
													.getText();
		System.out.println(text);
		
	}

}
