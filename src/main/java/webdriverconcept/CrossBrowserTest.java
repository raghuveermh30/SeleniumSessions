package webdriverconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {

    static WebDriver driver;

    public static void main(String[] args) {

        String browserName = "chrome";

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Please provide the correct browser..." + browserName);
                throw new RuntimeException("==== INVALID BROWSER ===");

        }

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        String tile = driver.getTitle();
        System.out.println("Page Title " + tile);

        if (tile.equalsIgnoreCase("Account Login")) {
            System.out.println("title is correct -- pass");
        } else {
            System.out.println("invalid login url");
        }

        String pageUrl = driver.getCurrentUrl();
        if (pageUrl.contains("route=account/login")) {
            System.out.println("This is the right login URL");
        } else {
            System.out.println("Invalid login URL");
        }

        driver.quit();
    }
}
