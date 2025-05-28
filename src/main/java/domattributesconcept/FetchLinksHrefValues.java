package domattributesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FetchLinksHrefValues {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Total Links on the Page
        //Print the HREF Value  on each link if the text is available

        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        System.out.println("**** Print the HREF value ********");
        List<WebElement> getLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links : " + getLinks.size());

        for (WebElement e : getLinks) {
            String hrefValue = e.getDomAttribute("href");
            System.out.println(hrefValue);
        }

        System.out.println("**** Print the SRC value ********");
        List<WebElement> getImages = driver.findElements(By.tagName("img"));
        System.out.println("Total Images : " + getImages.size());
        for (WebElement e : getImages) {
            String srcValue = e.getDomAttribute("src");
            System.out.println(srcValue);
        }

        System.out.println("**** Print the ALT value ********");
        List<WebElement> getAltProp = driver.findElements(By.tagName("img"));
        System.out.println("Total Images : " + getAltProp.size());
        for (WebElement e : getAltProp) {
            String altProps = e.getDomAttribute("alt");
            System.out.println(altProps);
        }

        //This is called Web-Scrapping --> Fetch the Values on the HTML dom --> Fetch the Href values and Src values on the application

        driver.quit();
    }
}
