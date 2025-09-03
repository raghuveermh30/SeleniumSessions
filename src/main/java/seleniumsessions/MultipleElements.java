package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElements {
	
	static WebDriver driver;

	public static void main(String[] args) {
		//fetch total number of links on the page
		//then print the text of each link on the console, make sure blank text is not printed
		
		//links -- htmltag: <a>
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		int totalLinks = linksList.size();
		System.out.println("total links: "+ totalLinks);
		
		//print the text of each link: iterate this list: using for loop:
		//index for loop:
		for(int i=0; i<totalLinks; i++) {
			String text = linksList.get(i).getText();//
				if(text.length()!=0) {
					System.out.println(text);
				}			
		}
		
		System.out.println("-------------");
		
		//for each loop:
		for(WebElement e : linksList) {
			String text = e.getText();
			if(text.length()!=0) {
				System.out.println(text);
			}
		}
		
		//total number of images on the page:
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		int imageCount = imgList.size();
		System.out.println("total number of images: "+ imageCount);
		
		
		
		//FE: single element | return WebElement | throws NoSuchElementException
		//FEs: multiple elements | List<WebElement>  | empty ArrayList (no exception), zero size
		
		
		
		
		
	}

}
