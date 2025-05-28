package otherconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class IncognitoMode {

    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        System.out.println(driver.getTitle());
        driver.quit();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        WebDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        firefoxDriver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        System.out.println(firefoxDriver.getTitle());
        firefoxDriver.quit();

        //Assignment: Open Edge Browser in the Incognito mode
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        WebDriver edgeDriver = new EdgeDriver(options);
        edgeDriver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        System.out.println(edgeDriver.getTitle());
        edgeDriver.quit();

        //Toggle --> true/false
    }
}
