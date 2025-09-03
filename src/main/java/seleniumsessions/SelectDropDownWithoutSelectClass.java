package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownWithoutSelectClass {

	static WebDriver driver;

	public static void main(String[] args) {

		// 1. select tag drop down
		// 2. select the value from the drop down without using select class and its methods

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");

		By countryOptions = By.cssSelector("select#Form_getForm_Country > option");
		By employeeOptions = By.cssSelector("select#Form_getForm_NoOfEmployees > option");

		
		selectDropDownValue(countryOptions, "India");
		selectDropDownValue(employeeOptions, "11 - 50");
	}

	public static void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);

		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.contains(value)) {
				e.click();
				break;
			}
		}
	}

}
