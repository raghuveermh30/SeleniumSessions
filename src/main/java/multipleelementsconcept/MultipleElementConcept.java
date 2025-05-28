package multipleelementsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MultipleElementConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Total Links on the Page
        //Print the text on the each link if the text is available

        driver = new ChromeDriver();
        driver.get("https://www.flipkart.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        List<WebElement> getLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links : " + getLinks.size());
        System.out.println("**************");

        //1. using Index Based for loop
        for (int i = 0; i < getLinks.size(); i++) {
            String linkText = getLinks.get(i).getText();
            if (!linkText.isEmpty()) {
                System.out.println(linkText);
            }
        }
        System.out.println("**************");

        //2. using for-each loop
        for (WebElement getLink : getLinks) {
            String linkText = getLink.getText();
            if (!linkText.isEmpty()) {
                System.out.println(linkText);
            }
        }
        System.out.println("**************");


        driver.quit();
    }
}
