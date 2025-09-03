package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptPopUpAlertHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.switchTo().alert();//NoAlertPresentException: no such alert
		
		
		
		//js pop up: alert, prompt, confirm
		//Alert API
		
		//1. alert:
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();	
		System.out.println(text);
		
		alert.accept();//click on ok button
		//alert.dismiss();//cancel the alert
		
		
		//2. confirm:
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(4000);
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		
//		alert.accept();//click on ok
		//alert.dismiss();//click on cancel
		
		//3. prompt:
//		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		alert.sendKeys("selenium testing");
//		Thread.sleep(4000);
//		alert.accept();//click on ok
		//alert.dismiss();//click on cancel
		
		
		
		
		
		
		
		

	}

}
