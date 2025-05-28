package webtablepagination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.Objects;

public class WebTablePagination {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        Thread.sleep(5000L);

        //Single Selection
        while (true) {
            //if element is already present in the first page
            if (driver.findElements(By.xpath("//td[text() = 'Denmark']")).size() > 0) {
                Thread.sleep(3000L);
                selectSingleCountryWithRelativeLocator("Denmark");
                break;
            } else {
                //click on Next button to go to the next page
                //Pagination is done by clicking on the Next button: Pagination Logic
                WebElement next = driver.findElement(By.cssSelector("button.next"));
                if (next.getDomAttribute("class").contains("disabled")) {
                    System.out.println("Pagination is completed, no more pages to navigate...country is not found");
                    break; // Exit the loop if there are no more pages
                }
                System.out.println("clicking on next button");
                next.click();
                Thread.sleep(1000L);
            }
        }
    }

    //Denmark
    //Hong Kong
    //Ukraine
    //Hong Kong + Ukraine
    public static void selectCountry(String countryName) {
        driver.findElement(By.xpath("//td[text() = '" + countryName + "']/preceding-sibling::td/input[@type='checkbox']")).click();
    }

    public static void selectSingleCountryWithRelativeLocator(String countryName) {
        WebElement ele = driver.findElement(with(By.xpath("//td[text() = '" + countryName + "']")));
        driver.findElement(with(By.xpath("//input[@type='checkbox']")).toLeftOf(ele)).click();
    }

}
