package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		Actions act = new Actions(driver);

		act.sendKeys(driver.findElement(email), "naveen@gmail.com").perform();
		act.sendKeys(driver.findElement(password), "naveen@123").perform();
		act.click(driver.findElement(loginBtn)).perform();

		// click = moveToElement + click on the middle of the element
		// sendKeys = click + sendKeys
		// sendKeys = moveToElement + click on middle of the element + sendKeys

	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	

	public static WebElement getElement(By lcoator) {
		return driver.findElement(lcoator);
	}

}
