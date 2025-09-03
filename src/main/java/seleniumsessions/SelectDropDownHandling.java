package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	static WebDriver driver;

	public static void main(String[] args) {

		// htmltag: <select />
		// class: Select class in selenium to handle select tag drop down
		// select(parent) --->option(child)
		// if select html tag is not present, then we can not use Select class

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");

		By country = By.id("Form_getForm_Country");
		By employee = By.id("Form_getForm_NoOfEmployees");

//		WebElement countryEle = driver.findElement(country);
//		Select select_country = new Select(countryEle);
//		select_country.selectByIndex(5);// index/position number
//		select_country.selectByVisibleText("Australia");// check the text of the option
//		select_country.selectByValue("India");// check the value attribute
//
//		// month: 1 to 12: jan to dec
//		// day: 1 to 31
//
//		WebElement employeeEle = driver.findElement(employee);
//		Select select_employee = new Select(employeeEle);
//		select_employee.selectByVisibleText("11 - 50");
		
//		doSelectByIndex(country, 5);
//		doSelectByIndex(employee, 2);
		
		doSelectByVisibleText(country, "India");
		doSelectByVisibleText(employee, "200 - 1,000");
		
		

	}

	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectByVisibleText(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(eleText);
	}
	
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
