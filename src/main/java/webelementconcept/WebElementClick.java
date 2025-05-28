package webelementconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriverconcept.BrowserUtil;

public class WebElementClick {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/en/30-day-free-trial");
        driver.manage().window().maximize();
        Thread.sleep(3000L);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        By fullName = By.id("Form_getForm_Name");
        By businessEmail = By.id("Form_getForm_Email");
        By phoneNumber = By.id("Form_getForm_Contact");
        By getFreeTrail = By.id("Form_getForm_action_submitForm");
        By header = By.className("form-title");

       /* driver.findElement(fullName).sendKeys("raghu");
        driver.findElement(businessEmail).sendKeys("raghu123@gmail.com");
        driver.findElement(phoneNumber).sendKeys("9456789223");
        driver.findElement(getFreeTrail).click();
        String headerText = driver.findElement(header).getText();
        System.out.println(headerText);*/

        doSendKeys(fullName, "raghu");
        doSendKeys(businessEmail, "raghu123@gmail.com");
        doSendKeys(phoneNumber, "9456789223");
        doClick(getFreeTrail);

        String headerText = driver.findElement(header).getText();
        System.out.println(headerText);

        System.out.println(doElementGetText(header));

        driver.quit();


    }

    public static String doElementGetText(By locator) {
        return getElement(locator).getText();
    }

    public static void doClick(By locator) {
        getElement(locator).click();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);

    }

    public static void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }
}
