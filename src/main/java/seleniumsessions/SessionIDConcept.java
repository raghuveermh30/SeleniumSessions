package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionIDConcept {

	public static void main(String[] args) {

		
		//case1 : quit:
		
		// 1. Open browser: chrome
		WebDriver driver = new ChromeDriver();//sid=123

		// 2. enter the url
		driver.get("https://www.google.com");//sid=123

		// 3. get the page title
		String title = driver.getTitle();//sid=123
		System.out.println("page title : " + title);//Google,

		//4.
		String url = driver.getCurrentUrl();//sid=123
		System.out.println("page url : " + url);

		//5.
		//driver.quit();// close browser:  //sid=123
		driver.close();//close browser: sid=123
		
		//browser is closed, sid=123: invalid session id, expired
		//NoSuchSessionException: invalid session id
		
		driver = new ChromeDriver();//sid=456
		driver.get("https://www.google.com");//sid=456
		
		System.out.println(driver.getTitle());//sid=456
		
		
		//quit: NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		//close: NoSuchSessionException: invalid session id

		
	}

}
