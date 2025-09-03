package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// sel 3.x		
		
		
		//login page: 10 secs
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//ImplicitlyWait -- method
		//global wait - once its applied, it will be there throughout the session
		//it will be applicable for all the web elements
		//and its applicable only for web elements
		//not applicable for non web elements: title, url, alerts, windows
		
		//login page: 10 secs
		driver.findElement(By.id("input-email11")).sendKeys("test@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		
		//home page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//sel 4.x

		//e4 
		//e5
		//e6
		
		//loginpage: 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x

		//home page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//sel 4.x

		
		//product page: 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//sel 4.x

		//cart page: 0 sec -- nullification of imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));//sel 4.x

		//home page: 5 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//sel 4.x

		
		
		
	}

}
