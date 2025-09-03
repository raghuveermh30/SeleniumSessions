package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();// browser - chrome
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");// page
		
		By footer = By.cssSelector("footer a");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		List<WebElement> footerList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(footer));
//		
		
		List<WebElement> footerList = waitForElementsPresence(footer, 10);
		System.out.println(footerList.size());
		
	}
	
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static List<WebElement> waitForElementsPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static List<WebElement> waitForElementsVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	
	
	

}
