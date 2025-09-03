package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// webelement to webelement only

		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));

		
		Actions act = new Actions(driver);
//		Action action = act
//							.clickAndHold(sourceEle)
//									.moveToElement(targetEle)
//												.release()
//													.build();
//							
//								
//		action.perform();
		
		//return type of build: Action (I) -- creating all the compositie actions, but not performing anything on the page
		//return type of perform: void -- peforms all the compositie actions on the page
		//A1.A2.....B.P: valid
		//A1.A2......P: valid
		//A1...A2...B: not valid: but I can store in some Action and then perform it.
		//A1.A2...: not valid
		
		act.dragAndDrop(sourceEle, targetEle).perform();
		
		
	}

}




