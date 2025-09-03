package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsAccessbilityTabSequence {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		WebElement firstName = driver.findElement(By.id("input-firstname"));
		
		Actions act = new Actions(driver);
		
	Action action =	act.sendKeys(firstName, "sachin")
			.pause(500)
			.sendKeys(Keys.TAB)
			.sendKeys("sharma")
			.pause(500)
			.sendKeys(Keys.TAB)
			.sendKeys("sharmajiii@gmail.com")
			.pause(500)
			.sendKeys(Keys.TAB)
			.sendKeys("9898989887")
			.pause(500)
			.sendKeys(Keys.TAB)
			.sendKeys("sharma@123")
			.pause(500)
			.sendKeys(Keys.TAB)
			.sendKeys("sharma@123")
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.SPACE) //checkbox
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.ENTER)
			.build();
			
	action.perform();
	
	
	}

}
