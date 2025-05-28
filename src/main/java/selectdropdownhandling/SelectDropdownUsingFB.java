package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownUsingFB {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /* DropDown --> HtmlTag --> <select> --> <option>
         * Select Class --> default class in selenium called Select class to handle dropdown
         * URL --> Orange HRM
         */

        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/r.php?entry_point=login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        By day = By.id("day");
        By month = By.id("month");
        By year = By.id("year");

        WebElement dayElement = driver.findElement(day);
        WebElement monthElement = driver.findElement(month);
        WebElement yearElement = driver.findElement(year);

        /*Select daySelect = new Select(dayElement);
        daySelect.selectByVisibleText("30");

        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText("Sep");
        monthSelect.selectByValue("6");

        Select yearSelect = new Select(yearElement);
        yearSelect.selectByVisibleText("1995");*/

        doSelectDropdownByIndex(day,5);
       // doSelectDropdownByVisibleText(day, "5");
        doSelectDropdownByVisibleText(month, "Sep");
        doSelectDropdownByValue(year, "1995");

        driver.quit();
    }

    public static  WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void doSelectDropdownByIndex(By locator, int index){
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public static void doSelectDropdownByVisibleText(By locator, String text){
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    public static void doSelectDropdownByValue(By locator, String value){
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    public static void doSelectDropdownByContainsText(By locator, String value){
        Select select = new Select(getElement(locator));
        select.selectByContainsVisibleText(value);
    }
}
