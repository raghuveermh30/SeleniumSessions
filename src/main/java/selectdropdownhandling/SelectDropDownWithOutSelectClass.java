package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelectDropDownWithOutSelectClass {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        By country = By.xpath("//select[@name='Country']/option");

        selectDropDownValueWithOutSelectClass(country, "India");
        driver.quit();
    }

    public static List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public static void selectDropDownValueWithOutSelectClass(By locator, String value) {
        List<WebElement> optionList = getElements(locator);
        boolean flag = false;
        for (WebElement e : optionList) {
            String text = e.getText();
            System.out.println(text);
            if (text.contains(value)) {
                e.click();
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println(value + " is available and selected");
        } else {
            System.out.println(value + " is not available");
        }
    }


}
