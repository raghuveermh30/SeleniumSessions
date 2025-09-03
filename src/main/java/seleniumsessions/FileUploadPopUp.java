package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPopUp {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");
		
		//tag type=file -- should be there
		driver.findElement(By.id("fileInput")).sendKeys("/Users/naveenautomationlabs/Documents/drawio.png");
		
		//windows:
		//driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\naveenautomationlabs\\Documents\\drawio.png");

		
		
		
		//if type = file is not there??
		//ask your dev team to add type = file
		//otherwise we can not automate this use case
		//we can use some 3rd party libs: not at all recommended
		//1. Sikuli
		//2. AutoIt -- 3rd open source -- works only for windows OS
		//3. Robot class -- works only for windows OS
		
		
	
		
	}

}
