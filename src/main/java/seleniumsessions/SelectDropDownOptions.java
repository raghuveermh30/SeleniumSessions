package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownOptions {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");

		By country = By.id("Form_getForm_Country");
		By employee = By.id("Form_getForm_NoOfEmployees");

//		WebElement countryEle = driver.findElement(country);
//
//		Select selectCountry = new Select(countryEle);
//
//		List<WebElement> optionsList = selectCountry.getOptions();
//
//		int totalOptions = optionsList.size();
//		System.out.println("total countries: " + totalOptions);
//		if (totalOptions == 233) {
//			System.out.println("options count is correct");
//		}
//
//		for (WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		List<String> countryList = getDropDownValuesList(country);
		System.out.println(countryList);
		
		System.out.println("----------");
		
		List<String> employeeList = getDropDownValuesList(employee);
		System.out.println(employeeList);
		
		
	}
	
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	

	public static List<String> getDropDownValuesList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("total number of options: " + optionsList.size());

		List<String> optionsValueList = new ArrayList<String>();// pc=0, size=0, []
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValueList.add(text);
		}
		return optionsValueList;
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
