package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//xpath: 
		//- its not an attribute
		//- its the address of the element in html DOM
		
		//1. absolute xpath: never use this xpath; fragilel; performance issues
		// /html/body/div[3]/div/div/div/div[2]/div/form/div[1]/input
		
		//2. relative/custom xpath:
		
		//1. with single attribute:
		//htmltag[@attr='value']
		//input[@id='input-email']
		//input[@name='email']
		//input[@placeholder='E-Mail Address']
		
		//input[@id]
		//img[@title='naveenopencart']
		
		//2. with multiple attributes:
		//htmltag[@attr1='value' and @attr2='value']
		//img[@title='naveenopencart' and @class='img-responsive']
		//img[@title='naveenopencart' and @class='img-responsive' and @alt='naveenopencart']
		//input[@type='text' and @placeholder='E-Mail Address']
		
		//input[@type and @placeholder]
		//input[@type or @placeholder]
		
		//3. with the text(): button, link, para, header, label
		//htmltag[text()='value']
		//h2[text()='New Customer']
		//h2[text()='Returning Customer']
		//a[text()='Register']
		//a[text()='Delivery Information']
		
		//4. text() and attribute:
		//htmltag[text()='value' and @attr='value']
		//a[text()='Register' and @class='list-group-item']
		//a[@class='list-group-item' and text()='Register']
		//label[text()='E-Mail Address' and @for='input-email']
		
		//5. contains() with attribute:
		//htmltag[contains(@attr,'value')]
		//input[contains(@placeholder,'E-Mail')]
		//input[contains(@placeholder,'Address')]
		
		//6. contains() with one attribute and another attribute without contains:
		//htmltag[contains(@attr,'value') and @attr2='value']
		//input[contains(@placeholder,'E-Mail') and @name='email']
		//input[contains(@placeholder,'E-Mail') and @name='email' and @type='text' and contains(@id,'email')]
		
		//one text field
		//<input> id="firstname_123" />
		//<input> id="firstname_234" />
		//<input> id="firstname_989" />
		//<input> id="firstname_765" />
		//By.id("firstname_765");//--wrong way of using id, coz id is dynamic
		
		//input[contains(@id, 'firstname_')]
		
		
		//7. contains() with text():
		//htmltag[contains(text(),'value')]
		//h2[contains(text(),'Returning')]
		//p[contains(text(),' shop faster')]
		//a[contains(text(), 'Forgotten')]
		
//		By.xpath("//a[contains(text(), 'Forgotten')]");
//		driver.findElement(By.xpath("//a[contains(text(), 'Forgotten')]")).click();
		
		//8. contains() with text() and contains() with attribute:
		//htmltag[contains(text(),'value') and contains(@attr,'value')]
		//a[contains(text(),'Forgotten') and contains(@class,'list-group-item')]
		
		//9. starts-with():
		//htmltag[starts-with(text(),'value')]
		//a[starts-with(text(),'Recurring')]
		
		//htmltag[starts-with(@attr,'value')]
		//input[starts-with(@placeholder,'E-Mail')]
		
		//input[starts-with(@placeholder,'E-Mail') and contains(@id,email)]
		
		//ends-with: Not available
		
		//parent to child:
		//a. direct child element: /
		//b. indirect + direct child element: //
		
		//div[@class='form-group']/input[@id='input-email']
		//div[@class='form-group']/label[@for='input-email']
		
		//div[@class='list-group']/a
		//div[@class='well']/form//a
		
		//html/body/div -- 2
		//html/body//div -- 40
		
		//xpath axes:
		
		//div[@class='form-group']/child::input[@id='input-email']
		
		//div[@class='form-group']/input[@id='input-email']

		//div[@class='list-group']/child::a
		
		//footer//child::a
		
		//child to parent: yes -- backward traversing
		//input[@id='input-email']/../../../../../../../../../.. ---> html tag
		
		//input[@id='input-email']/.. -->div
		//input[@id='input-email']/parent::div[@class='form-group'] -->div
		
		//child to ancestor:
		//input[@id='input-email']/ancestor::form
		//input[@id='input-email']/ancestor::div
		
		//sibling to sibling:
		
		//label[@for='input-email']/following-sibling::input
		//input[@id='input-email']/preceding-sibling::label
		
		//option[@value='Australia']/preceding-sibling::option
		//option[@value='Afghanistan']/preceding-sibling::option
		
		//indexing in xpath:
		// (//a[text()='Forgotten Password'])[2]
		
		//driver.findElement(By.xpath("(//a[text()='Forgotten Password'])[2]")).click();
		
		
		// (//form//input[@id])[3]
		// (//form//input[@id])[position()=3]
		
		//1 to 100-->last() --> 100th
		// (//form//input[@id])[last()-1]
		
		// ((//div[@class='navFooterVerticalRow navAccessibility']/div[contains(@class,'navFooterLinkCol')])[last()]//a)[last()]
		// (//div[text()='Let Us Help You']/following-sibling::ul//a)[last()]
				
		
		
	}

}
