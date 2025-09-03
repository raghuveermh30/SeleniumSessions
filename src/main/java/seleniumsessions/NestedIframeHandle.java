package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframeHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();//browser
		driver.get("https://selectorshub.com/iframe-scenario/");//page
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("pact1");//f1
		driver.findElement(By.id("inp_val")).sendKeys("selenium");
		
		driver.switchTo().frame("pact2");//f2
		driver.findElement(By.id("jex")).sendKeys("testing");
		
		driver.switchTo().frame("pact3");//f3
		driver.findElement(By.id("glaf")).sendKeys("automation");
		
		//f3->f2:
//		driver.switchTo().parentFrame();
//		driver.findElement(By.id("jex")).sendKeys(" playwright");
//
//		//f2->f1
//		driver.switchTo().parentFrame();
//		driver.findElement(By.id("inp_val")).sendKeys(" cypress");
//
//		//f1-->page:
//		driver.switchTo().defaultContent();
//		String header = driver.findElement(By.tagName("h3")).getText();
//		System.out.println(header);
		
		
		//f3->f1: not allowed
//		driver.switchTo().frame("pact1");//f1
//		driver.findElement(By.id("inp_val")).sendKeys("naveen");
		
		//f3->f2: not allowed
//		driver.switchTo().frame("pact2");//f2
//		driver.findElement(By.id("jex")).sendKeys(" manual testing");

		//f3->: default content:--> main page
		driver.switchTo().defaultContent();
		String header = driver.findElement(By.tagName("h3")).getText();
		System.out.println(header);
		
		
		//page-->f1: switchto.frame1
		//f1->f2:  switchto.frame2
		//f2->f3:  switchto.frame3
		//f3->f2: switchto.parentframe
		//f2->f1: switchto.parentframe
		//f1-->page: switchto.DC
		//page --> f3: page->f1->f2->f3
		//f3->page: DC
		
		
		

	}

}
