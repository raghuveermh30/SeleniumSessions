package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorWithWebTable {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		//selectUserName("Joe.Root");

		WebElement usernameEle = driver.findElement(By.linkText("Joe.Root"));
		String abovePlyaer = driver.findElement(with(By.tagName("a")).above(usernameEle)).getText();
		System.out.println(abovePlyaer);
		
		String belowPlyaer = driver.findElement(with(By.tagName("a")).below(usernameEle)).getText();
		System.out.println(belowPlyaer);

		String rightUserRole = driver.findElement(with(By.tagName("td")).toRightOf(usernameEle)).getText();
		System.out.println(rightUserRole);

		
		List<WebElement> belowLinks = driver.findElements(with(By.tagName("a")).below(usernameEle));
		
		System.out.println(belowLinks.size());
		
			for(WebElement e : belowLinks) {
				System.out.println(e.getText());
			}
		
		
		
	}

	public static void selectUserName(String username) {
		WebElement usernameEle = driver.findElement(By.linkText(username));
		driver.findElement(with(By.name("chkSelectRow[]")).toLeftOf(usernameEle)).click();

	}

}
