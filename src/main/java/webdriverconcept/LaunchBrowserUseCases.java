package webdriverconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowserUseCases {

    public static void main(String[] args) {

        /*WebDriver driver = new ChromeDriver(); //Browser 1
        driver = new ChromeDriver(); //Browser 2
        driver = new ChromeDriver(); //Browser 3
        driver = new ChromeDriver(); //Browser 4*/

        //driver.quit(); //Here only last browser will be closed, Browser 4 will be closed

        WebDriver driver1 = new ChromeDriver(); //Browser 1
        driver1 = new FirefoxDriver(); //Browser 2
        driver1.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        //Here Firefox browser will be launched
        driver1.quit();
        //Here, Firefox browser will be closed








    }
}
