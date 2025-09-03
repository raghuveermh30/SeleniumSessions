package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropdownAllOptions1 {

    static WebDriver driver;
    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        By country = By.id("Form_getForm_Country");
        int size = getDropdownOptionsCount(country);
        System.out.println(size);



         driver.quit();


    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static int getDropdownOptionsCount(By locator){
        Select select = new Select(getElement(locator));
        List<WebElement> webElementOptions = select.getOptions();
        System.out.println("Country value size " + webElementOptions.size());
        return webElementOptions.size();
    }


}
