package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);

		// a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		// a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']

		// driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();

		selectUser("Joe.Root");
		selectUser("John.Smith");
		
		List<String> joeInfo = getUserInfoList("Joe.Root");
		System.out.println(joeInfo);
		List<String> johnInfo = getUserInfoList("John.Smith");
		System.out.println(johnInfo);


	}

	public static List<String> getUserInfoList(String username) {
		List<WebElement> userInfoList = driver
				.findElements(By.xpath("//a[text()='"+username+"']/parent::td/following-sibling::td"));

		System.out.println(userInfoList.size());
		List<String> infoList = new ArrayList<String>();//[], pc=0
		
		for (WebElement e : userInfoList) {
			String text = e.getText();
			System.out.println(text);
			infoList.add(text);
		}
		
		return infoList;
	}

	public static void selectUser(String username) {
		driver.findElement(
				By.xpath("//a[text()='" + username + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();

	}

}
