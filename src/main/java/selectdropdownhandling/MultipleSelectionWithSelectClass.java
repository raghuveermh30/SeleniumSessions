package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectionWithSelectClass {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://html.com/attributes/select-multiple/");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement dropDownEle = driver.findElement(By.xpath("//select[@multiple]"));

        Select select = new Select(dropDownEle);
        System.out.println(select.isMultiple());

        if (select.isMultiple()) {
            System.out.println("multi select is possible");

            select.selectByVisibleText("American flamingo");
            select.selectByVisibleText("Chilean flamingo");
            select.selectByVisibleText("Lesser flamingo");
            select.selectByVisibleText("James's flamingo");
        }

        Thread.sleep(3000L);
        select.deselectByVisibleText("Lesser flamingo");
        Thread.sleep(3000L);
        select.deselectAll();

        driver.quit();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void selectMultipleValuesInDropDown(By locator, String value){
        Select select = new Select(getElement(locator));
        System.out.println(select.isMultiple());
        select.selectByVisibleText(value);
    }

    public static void deSelectMultipleValuesInDropDown(By locator, String value){
        Select select = new Select(getElement(locator));
        System.out.println(select.isMultiple());
        select.deselectByVisibleText(value);
    }
}