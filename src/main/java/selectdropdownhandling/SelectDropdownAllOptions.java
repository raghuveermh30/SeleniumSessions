package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SelectDropdownAllOptions {

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
        int count = getDropdownOptionsCount(country);
        if (count == 233) {
            System.out.println("Count is CORRECT");
        }
        List<String> countryList = getDropdownOptionsTextList(country);
        printDropdownOptionsText(country);

        if (countryList.contains("India")) {
            System.out.println("India is Present");
        }


        driver.quit();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static int getDropdownOptionsCount(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> webElementOptions = select.getOptions();
        System.out.println("Country value size " + webElementOptions.size());
        return webElementOptions.size();
    }

    public static List<String> getDropdownOptionsTextList(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> optionsList = select.getOptions();
        List<String> optionValueList = new ArrayList<>();
        for (WebElement element : optionsList) {
            String text = element.getText();
            optionValueList.add(text);
        }
        return optionValueList;
    }

    public static void printDropdownOptionsText(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> webElementOptions = select.getOptions();

        for (WebElement e : webElementOptions) {
            String text = e.getText();
            System.out.println(text);
        }
        System.out.println("***** End of the List");
    }

}
