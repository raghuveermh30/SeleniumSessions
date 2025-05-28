package webtablepagination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablePaginationWithMultiSelect {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        Thread.sleep(5000L);

        //Multi Selection
        while (true) {
            //if element is already present in the first page
            if (!driver.findElements(By.xpath("//td[text() = 'India']")).isEmpty()) {
                Thread.sleep(1000L);
                selectMultipleCountryCheck("India");
            }

            //Pagination Logic: click on Next button to go to the next page
            WebElement next = driver.findElement(By.cssSelector("button.next"));
            if (next.getDomAttribute("class").contains("disabled")) {
                System.out.println("Pagination is completed, no more pages to navigate...");
                break; // Exit the loop if there are no more pages
            }
            next.click();
            Thread.sleep(1000L);
        }
    }

    public static void selectMultipleCountryCheck(String countryName) {
        List<WebElement> countryNameList = driver.findElements(By.xpath("//td[text() = '" + countryName + "']/preceding-sibling::td/input[@type='checkbox']"));
        countryNameList.forEach(WebElement::click);
    }

    public static void selectSingleCountry(String countryName) {
        driver.findElement(By.xpath("//td[text() = '" + countryName + "']/preceding-sibling::td/input[@type='checkbox']")).click();
    }

}
