package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoScoreCardWebTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/major-league-cricket-2025-1481991/mi-new-york-vs-washington-freedom-29th-match-1482020/full-scorecard");
		Thread.sleep(4000);
		
		//span[text()='Tajinder Singh']/ancestor::td/following-sibling::td/span/span
		
		
		String wkTakerName = getWicketTakerName("Tajinder Singh");
		System.out.println(wkTakerName);
		
		wkTakerName = getWicketTakerName("Kunwarjeet Singh");
		System.out.println(wkTakerName);
		
		
		//span[text()='Tajinder Singh']//ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]
		//bat+bowl - 6+10=16
		
		//span[text()='Sharad Lumba']//ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]
		//bat - 6
		
		List<String> tajScore = getScoreCardList("Tajinder Singh");
		System.out.println(tajScore);
		
		List<String> sharadScore = getScoreCardList("Sharad Lumba");
		System.out.println(sharadScore);
		
	}
	
	
	public static List<String> getScoreCardList(String playername) {
		
		List<WebElement> scoreCardList = 
				driver.findElements
					(By.xpath("//span[text()='"+playername+"']//ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
				
		List<String> scoreList = new ArrayList<String>();
		
		for(WebElement e : scoreCardList) {
			String text = e.getText();
				if(text.length()!=0) {
					System.out.println(text);
					scoreList.add(text);
				}
		}
		
		return scoreList;
		
	}
	
	
	
	
	
	public static String getWicketTakerName(String batsmanName) {
		String wktTakerName = driver
				.findElement
					(By.xpath("//span[text()='"+batsmanName+"']/ancestor::td/following-sibling::td/span/span"))
							.getText();
			
		return wktTakerName;
	}
	
	
	

}
