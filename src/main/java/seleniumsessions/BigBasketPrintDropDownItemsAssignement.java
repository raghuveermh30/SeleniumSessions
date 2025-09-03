package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class BigBasketPrintDropDownItemsAssignement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//span[contains(text(),'Shop by')])[2]")).click();

		Actions action = new Actions(driver);
		List<WebElement> levelOne = driver.findElements(By.xpath("(((//div[contains(@id,'headlessui-menu-items')])[2]//ul))[1]//a"));
		for (int i = 0; i <= levelOne.size() - 1; i++) {
			action.moveToElement(levelOne.get(i)).perform();
				System.out.println("*********************************"+ levelOne.get(i).getText()+ "*********************************");

				List<WebElement> levelTwo = driver.findElements(By.xpath("(((//div[contains(@id,'headlessui-menu-items')])[2]//ul))[2]//a"));
				for (int j = 0; j <= levelTwo.size() - 1; j++) {
					action.moveToElement(levelTwo.get(j)).perform();
						System.out.println("==============================="+ levelTwo.get(j).getText()+ "===============================");

						List<WebElement> levelThree = driver.findElements(By.xpath("(((//div[contains(@id,'headlessui-menu-items')])[2]//ul))[3]//a"));
						for (int z = 0; z <= levelThree.size() - 1; z++) {
							action.moveToElement(levelThree.get(z)).perform();
							if (levelThree.get(z).getText() != "") {
								System.out.print(levelThree.get(z).getText() + "  ");
							}
						}
						System.out.println();
					
				}
				System.out.println();
			}
		

	}
}

