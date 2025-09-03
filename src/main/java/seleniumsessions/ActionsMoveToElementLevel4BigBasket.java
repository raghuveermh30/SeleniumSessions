package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElementLevel4BigBasket {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");	
		
		By menuLevel1 = By.xpath("(//span[text()='Shop by'])[2]");
		
		By menuLevel2 = By.linkText("Beauty & Hygiene");
		
		By menuLevel3 = By.linkText("Skin Care");

		By menuLevel4 = By.linkText("Eye Care");
		
		
		//menuSubMenuHandlingLevel4(menuLevel1, menuLevel2, menuLevel3, menuLevel4);

//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.menuSubMenuHandlingLevel4(menuLevel1, menuLevel2, menuLevel3, menuLevel4, "click");


	}
	
	
	public static void menuSubMenuHandlingLevel4(By menuLevel1, By menuLevel2, By menuLevel3, By menuLevel4) throws InterruptedException {
		Actions act = new Actions(driver);
		driver.findElement(menuLevel1).click();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(menuLevel2)).perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(menuLevel3)).perform();
		Thread.sleep(1000);
		driver.findElement(menuLevel4).click();
	}	
	
	
	
	
	
	

}
