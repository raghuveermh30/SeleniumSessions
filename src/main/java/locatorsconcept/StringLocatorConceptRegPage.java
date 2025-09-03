package locatorsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriverconcept.BrowserUtil;

public class StringLocatorConceptRegPage {

    static WebDriver driver;
    public static void main(String[] args) {

        BrowserUtil browserUtil = new BrowserUtil();
        driver = browserUtil.initDriver("chrome");
        browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        System.out.println(browserUtil.getTitle());
        System.out.println(browserUtil.getPageUrl());

        By firstName = By.id("input-firstname");
        By lastName = By.name("lastname");
        By searchFiled = By.className("form-control");
        By email = By.xpath("//*[@id=\"input-email\"]");
        By telephone = By.cssSelector("#input-telephone");
        By password = By.xpath("//*[@id=\"input-password\"]");
        By confirmPassword = By.cssSelector("#input-confirm");
        By policyCheckBox = By.name("agree");
        By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
        By successMsg = By.tagName("h1");
        By myAccountLink = By.linkText("My Account");

        StringLocatorConcept.doSendKeys(firstName, "raghuveer");
        StringLocatorConcept.doSendKeys(lastName, "automation");
        StringLocatorConcept.doSendKeys(searchFiled, "macbook");
        StringLocatorConcept.doSendKeys(email, "raghuveerautomation123@gmai.com");
        StringLocatorConcept.doSendKeys(telephone, "123456789");
        StringLocatorConcept.doSendKeys(password, "test@123");
        StringLocatorConcept.doSendKeys(confirmPassword, "test@123");
        StringLocatorConcept.doClick(policyCheckBox);
        StringLocatorConcept.doClick(continueButton);
        String successMsg1 = StringLocatorConcept.getElementText(successMsg);
        System.out.println(successMsg1);
    }
}
