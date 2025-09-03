package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowserHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");// parent window

		String parentWindowId = driver.getWindowHandle();//pop
		
		Thread.sleep(4000);

		WebElement fbEle = driver.findElement(By.cssSelector("img[alt='facebook logo']"));

		WebElement linkEle = driver.findElement(By.cssSelector("img[alt='linkedin logo']"));

		WebElement ytEle = driver.findElement(By.cssSelector("img[alt='youtube logo']"));

		fbEle.click();
		linkEle.click();
		ytEle.click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
				if(!windowId.equals(parentWindowId)) {
					driver.close();
				}			
			Thread.sleep(2000);
		}
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("test automation");

		
		
	}
	
	
	
	
	

}
