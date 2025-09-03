package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchSelect {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        By searchField = By.name("q");
        By suggestions = By.xpath("//ul[@class='G43f7e']/li//div[@class='wM6W7d']/span");

        doSearchMethod(searchField, suggestions, "naveen automation labs", "youtube");
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public static void doSearchMethod(By searchField, By suggestions, String searchKey, String actualValue) throws InterruptedException {
        getElement(searchField).sendKeys(searchKey);
        Thread.sleep(2000);

        List<WebElement> suggList = getElements(suggestions);
        System.out.println(suggList.size());
        for (WebElement e : suggList) {
            String text = e.getText();
            System.out.println(text);
            if (text.contains(actualValue)) {
                e.click();
                break;
            }
        }
    }

}
