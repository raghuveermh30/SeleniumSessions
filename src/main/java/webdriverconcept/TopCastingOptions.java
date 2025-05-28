package webdriverconcept;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

    public static void main(String[] args) {

        //Top-casting Options
        // ChromeDriver, EdgeDriver are using the methods which are overridden in the RemoteWebDriver
        //Refer Notes for Hierarchy

        //0. ChromeDriver driver1 = new ChromeDriver();
        ChromeDriver driver1 = new ChromeDriver(); // Only for Chrome
        FirefoxDriver firefoxDriver = new FirefoxDriver(); //Only for Firefox
        // It's valid but not recommended, this will be applicable for chrome Driver
        // This is TopCasting, its an Object creation for ChormeDriver
        // We cannot acheive the cross browser testing
        // This will be executed only for Local Purpose

        //1. Valid and recommended - This is valid and recommended for Local Execution
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //2. ChromeDriver with Search Context
        SearchContext searchContext = new ChromeDriver();
        // Here only FindElement and FindElements can be accessed, but get() cannot be accessed
        //Its valid but not recommended


        //3. ChromeDriver and RemoteWebDriver
        RemoteWebDriver remoteWebDriver = new ChromeDriver();
        remoteWebDriver.get("https://www.google.com");
        // Its a valid top-casting and its recommended and able to access all the methods

        //4. RemoteWebDriver and WebDriver
        //WebDriver webDriver = new RemoteWebDriver();
        //Its a valid top-casting and its recommended but we need to use for only certain conditions
        //This is used only to run the test cases only on the Selenium Grid or Remote Machine - Grid, Server, Docker, Cloud Machine, LamdaTest, SauceLabs

        // 1 -> is recomondded of Local execution
        // 4 -> is for Remote

        //5. SearchContext searchContext1 = new RemoteWebDriver();
        //SearchContext searchContext1 = new RemoteWebDriver();
        // Here only FindElement and FindElements can be accessed, but get() cannot be accessed
        //Its valid but not recommended

        //6. ChromiumDriver chromeDriver = new ChromeDriver();
        ChromiumDriver chromeDriver = new ChromeDriver();
        //Its valid but not recommended
        // Reason is it will serve only for Chrome and Edge Driver, We cannot use the same ChromiumDriver for Firefox, Safari
        // We cannot acheive the cross browser testing
        //But using WebDriver we can acheive the Cross Browser testing and we can access all the properties which are present in RemoteDriver


    }
}
