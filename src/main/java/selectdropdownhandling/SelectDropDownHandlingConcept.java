package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.plaf.TableHeaderUI;

public class SelectDropDownHandlingConcept {

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

        WebElement countryEle = driver.findElement(country);

        Select select = new Select(countryEle);
        //select.selectByIndex(5);
        //It will select whatever the value present in the dropdown based on the index

        //select.selectByVisibleText("Australia");

       // select.selectByValue("Brazil");
        select.selectByContainsVisibleText("Bosnia"); //Partial country name


        //select.selectByVisibleText("Australia"); --> This is the best option




        driver.quit();

    }
}
