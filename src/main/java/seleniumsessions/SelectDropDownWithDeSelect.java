package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWithDeSelect {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		
		Select select = new Select(driver.findElement(By.xpath("//select[@multiple]")));
		
		boolean isMultiple = select.isMultiple();
		System.out.println(isMultiple);
		
		if(isMultiple) {
			select.selectByVisibleText("American flamingo");
			select.selectByVisibleText("Chilean flamingo");
			select.selectByVisibleText("Lesser flamingo");
		}
		Thread.sleep(2000);
		select.deselectByVisibleText("Chilean flamingo");
		Thread.sleep(2000);
		select.deselectAll();
		
		

	}

}
