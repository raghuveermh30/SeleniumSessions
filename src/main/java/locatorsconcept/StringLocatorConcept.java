package locatorsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webdriverconcept.BrowserUtil;

public class StringLocatorConcept {

    static WebDriver driver;

    public static void main(String[] args) {

        BrowserUtil browserUtil = new BrowserUtil();
        driver = browserUtil.initDriver("chrome");
        browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        System.out.println(browserUtil.getTitle());
        System.out.println(browserUtil.getPageUrl());

        String email_Id = "input-email";
        String pass_Id = "input-password";
        String loginBtnXpath = "//*[@id=\"content\"]/div/div[2]/div/form/input";

       /* doSendKeys(getLocator("ID", email_Id), "raghuveer11@gmail.com");
        doSendKeys(getLocator("ID", pass_Id), "test@123");
        doClick(getLocator("XPATH", loginBtnXpath));*/

        //2nd Approach
        doSendKeys("ID", email_Id, "raghuveer11@gmail.com");
        doSendKeys("ID", pass_Id, "test@123");
        doClick("XPATH", loginBtnXpath);
        browserUtil.closeBrowser();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public static void doSendKeys(String locatorType, String locatorValue, String value) {
        getElement(getLocator(locatorType, locatorValue)).sendKeys(value);
    }

    public static void doClick(By locator) {
        getElement(locator).click();
    }

    public static void doClick(String locatorType, String locatorValue) {
        getElement(getLocator(locatorType, locatorValue)).click();
    }

    public static By getLocator(String locatorType, String locatorValue) {

        By locator = null;
        switch (locatorType.toUpperCase().trim()) {
            case "ID":
                locator = By.id(locatorValue);
                break;
            case "NAME":
                locator = By.name(locatorValue);
                break;
            case "CLASS NAME":
                locator = By.className(locatorValue);
                break;
            case "XPATH":
                locator = By.xpath(locatorValue);
                break;
            case "CSS":
                locator = By.cssSelector(locatorValue);
                break;
            case "LINK TEXT":
                locator = By.linkText(locatorValue);
                break;
            case "PARTIAL LINK TEXT":
                locator = By.partialLinkText(locatorValue);
                break;
            case "TAG NAME":
                locator = By.tagName(locatorValue);
                break;
            default:
                throw new IllegalArgumentException("==INVALID LOCATOR, PLEASE USE CORRECT LOCATOR==");
        }
        return locator;
    }

}
