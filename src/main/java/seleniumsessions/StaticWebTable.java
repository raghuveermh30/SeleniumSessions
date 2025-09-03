package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	static WebDriver driver;

	public static void main(String[] args) {

		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//table[@id="customers"]/tbody/tr[4]/td[1]
		//table[@id="customers"]/tbody/tr[5]/td[1]
		//table[@id="customers"]/tbody/tr[6]/td[1]
		//table[@id="customers"]/tbody/tr[7]/td[1]

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		getTableData(1);
		getTableData(2);
		getTableData(3);

	}
	
	
	public static void getTableData(int columnNumber) {
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String aferXpath = "]/td["+columnNumber+"]";
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();		
		
		for(int row=2; row<=rowCount; row++) {
			String xpath = beforeXpath + row + aferXpath;//table[@id=\"customers\"]/tbody/tr[2]/td[1]
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
		
	}
	
	

}
