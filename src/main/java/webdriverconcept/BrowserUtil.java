package webdriverconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

public class BrowserUtil {

    WebDriver driver;

    public WebDriver initDriver(String browserName) {
        System.out.println("Browser name is " + browserName);

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
                throw new RuntimeException("====Invalid Browser===");
        }
        return driver;
    }

    /*
     *
     * @param url
     */
    public void launchUrl(String url) {

        if (url == null) {
            throw new RuntimeException("***URL Cannot be NULL***");
        }

        if (url.isEmpty()) {
            throw new RuntimeException("***URL Cannot be Blank or Empty***");
        }

        if (url.indexOf("http") == 0) {
            driver.get(url);
            driver.manage().window().maximize();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("===invalid url: either http/https is missing");
        }
    }

    /*
     * This is the overloaded method to launch the url
     * @param url
     */
    public void launchUrl(URL url) {

        if (url == null) {
            throw new RuntimeException("***URL Cannot be NULL***");
        }

        if (String.valueOf(url).indexOf("http") == 0) {
            driver.navigate().to(url);
            driver.manage().window().maximize();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("===invalid url: either http/https is missing");
        }
    }

    public String getTitle() {
        System.out.println("Page Title is " + driver.getTitle());
        return driver.getTitle();
    }

    public String getPageUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("Current Url is " + url);
        return url;
    }

    public void closeBrowser() {
        System.out.println("Browser is closed");
        driver.close();
    }

    public void quitBrowser() {
        System.out.println("Browser is Quit");
        driver.quit();
    }
}
