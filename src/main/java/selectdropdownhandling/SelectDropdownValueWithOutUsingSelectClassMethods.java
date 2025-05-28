package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropdownValueWithOutUsingSelectClassMethods {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /* DropDown --> HtmlTag --> <select> --> <option>
         * Select Class --> default class in selenium called Select class to handle dropdown
         * URL --> Orange HRM
         */

        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        By country = By.id("Form_getForm_Country");
        //Not allowed to use SelectByText, SelectByValue and SelectByIndex


        selectValueFromDropDown(country, "India");


        driver.quit();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void selectValueFromDropDown(By locator, String value) {
        Select select = new Select(getElement(locator));
        List<WebElement> optionsList = select.getOptions();
        boolean flag = false;
        for (WebElement e : optionsList) {
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
