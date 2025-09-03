package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCssSelector {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//CSS: cascaded style sheet
		//cssSelector: is a locator
		
		//1. id:
		// #id
		// #input-email
		By.cssSelector("#input-email");
		//2. tagname#id
		// input#input-email
		
		//2. class:
		// .class
		// .img-responsive
		// img.img-responsive
		
		//3. id+class:
		// #id.class
		// .class#id
		// #input-email.form-control
		// .form-control#input-email
		// input.form-control#input-email
		By.cssSelector("input.form-control#input-email");
		
		//3. multiple classes: c1 c2 c3 ...cn
		//.c1.c2.c3...cn
		// .form-control.input-lg
		//tagname.c1.c2.c3...cn
		//input.form-control.input-lg
		// input.nav-input.nav-progressive-attribute
		//tagname.c1.c2#id
		//tagname#id.c1.c2
		//input.TextInput__StyledInput-sc-6paa7q-0.jNjsNZ#username
		
		//for other attributes:
		// tagname[attr='value'] 
		// input[name='email'] -css
		//input[@name='email'] -xpath
		
		// input[name='email']#input-email.form-control
		
		// input[id='input-email']
		
		// tagname[attr1='value'][attr2='value'][attr3='value']
		// input[name='email'][placeholder='E-Mail Address'][id='input-email']
		// input[name='email'][placeholder='E-Mail Address']#input-email
		// input[name='email'][placeholder='E-Mail Address']#input-email[class='form-control']
		// input[name='email'][placeholder='E-Mail Address']#input-email.form-control
		
		// input[id][class][placeholder] --> 2: FEs
		By.cssSelector("input[id][class][placeholder]");
		
		//text in css: no support for element text
		
		//contains:
		// tagname[attr *= 'value']
		// input[placeholder *= 'Address']
		// input[placeholder *= 'E-Mail'][name='email'][id *= 'email']
		
		//startswith:
		// tagname[attr ^= 'value']
		// input[placeholder ^= 'E-Mail']
		
		//endswith:
		// tagname[attr $= 'value']
		// input[placeholder $= 'Address']
		
		
		//parent to child:
		// parenttag childtag -->direct + indirect child elements
		// div.form-group input#input-email --1
		
		// footer li a ---15
		By.cssSelector("footer li a");
		// footer a

		//parenttag > childtag --> direct child elements
		// footer > div
		// select#Form_getForm_Country > option
		
		//indexing in css:
		// select#Form_getForm_Country > option:nth-of-type(2) -- 2nd index
		// select#Form_getForm_Country > option:nth-of-type(n) -- all the elements
		// select#Form_getForm_Country > option:first-child -- first child
		// select#Form_getForm_Country > option:last-child -- last child
		// select#Form_getForm_Country > option:nth-child(5) -- 5th child element
		// select#Form_getForm_Country > option:nth-last-child(3) --from the last fetch 3rd elemenet
		// select#Form_getForm_Country > option:nth-last-child(n) -- all the elements
		
		// select#Form_getForm_Country > option:nth-of-type(4n) -- 4 8 12 16...
		// select#Form_getForm_Country > option:nth-of-type(4n-1) -- ignore this
		
		// select#Form_getForm_Country > option:nth-child(even)--- FEs
		// select#Form_getForm_Country > option:nth-child(odd) ---FEs		
		
		//odd/even in xpath:
		// 10%2 == 0 --> even
		// 9%2 == 1 --> odd
		//select[@id='Form_getForm_Country']/option[position() mod 2 = 0] -- even
		//select[@id='Form_getForm_Country']/option[position() mod 2 = 1] --odd
		
		
		
		//child to parent and child to ancestor: no support for backward traversing in CSS
		
		//sibling: only following sibling is supported
		
		//following sibling: immediate sibling
		// label[for='input-email'] + input#input-email
		// select#Form_getForm_Country > option[value='Afghanistan'] + option ---> Albania -- only immediate sibling
		// select#Form_getForm_Country > option[value='Afghanistan'] ~ option -- all 231 following siblings
		
		
		//comma in css:
		String impEleCSS = "img.img-responsive,input#input-email,input#input-password,input[value='Login']"; //-- 4 elements
		int impFieldsCount = driver.findElements(By.cssSelector(impEleCSS)).size();
		if(impFieldsCount == 4) {
			System.out.println("all the imp fields are present on the page");
		}
		else {
			System.out.println("all the imp fields are not present on the page");
		}
		
		
		//not in css:
		// input.form-control:not(input[name='search'])
		
	
		//id,name,class
		//xpath or css
		//id, xpath: id
		//id, css: id
		//type, xpath/css:
		
		
		
		
		
		
	}

}
