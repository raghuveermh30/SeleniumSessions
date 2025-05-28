package webelementconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriverconcept.BrowserUtil;

public class RegistrationPageTest {

    public static void main(String[] args) {

        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.initDriver("chrome");
        browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        System.out.println(browserUtil.getTitle());
        System.out.println(browserUtil.getPageUrl());

        By firstName = By.id("input-firstname");
        By lastName = By.id("input-lastname");
        By email = By.id("input-email");
        By telephone = By.id("input-telephone");
        By password = By.id("input-password");
        By confirmPassword = By.id("input-confirm");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(firstName, "Raghuveer");
        elementUtil.doSendKeys(lastName, "MH");
        elementUtil.doSendKeys(email, "raghuveermh30@gmail.com");
        elementUtil.doSendKeys(telephone, "9480739651");
        elementUtil.doSendKeys(password, "Test@123");
        elementUtil.doSendKeys(confirmPassword, "Test@123");

        browserUtil.closeBrowser();

    }
}
