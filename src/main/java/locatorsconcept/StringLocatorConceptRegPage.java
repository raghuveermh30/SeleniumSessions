package locatorsconcept;

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
    }
}
