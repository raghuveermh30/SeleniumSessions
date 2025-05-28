package locatorsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriverconcept.BrowserUtil;
import webelementconcept.ElementUtil;

public class RegistrationPageTest {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
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

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(firstName, "raghuveer");
        elementUtil.doSendKeys(lastName, "automation");
        elementUtil.doSendKeys(searchFiled, "macbook");
        elementUtil.doSendKeys(email, "raghuveer11@gmail.com");
        elementUtil.doSendKeys(telephone, "123456789");
        elementUtil.doSendKeys(password, "test@123");
        elementUtil.doSendKeys(confirmPassword, "test@123");
        elementUtil.doClick(policyCheckBox);
        Thread.sleep(3000L);
        elementUtil.doClick(continueButton);
        Thread.sleep(3000L);
        String successMsg1 = elementUtil.getElementText(successMsg);
        System.out.println(successMsg1);
        Thread.sleep(3000L);
        elementUtil.doClick(myAccountLink);

        browserUtil.closeBrowser();
    }
}
