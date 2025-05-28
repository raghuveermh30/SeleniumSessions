package webelementconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriverconcept.BrowserUtil;

public class LoginPageTest {

    public static void main(String[] args) {

        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.initDriver("chrome");
        browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        System.out.println(browserUtil.getTitle());
        System.out.println(browserUtil.getPageUrl());


        By byEmail2 = By.id("input-email");
        By byPass2 = By.id("input-password");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(byEmail2, "naveenautomation20@gmail.com");
        elementUtil.doSendKeys(byPass2, "naveen@123");

        browserUtil.closeBrowser();

    }
}
