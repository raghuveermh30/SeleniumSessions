package seleniumfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverFactory {

    public Map<String, Supplier<WebDriver>> driverMap = null;

    public WebDriverFactory() {
        driverMap = new HashMap<>();
        driverMap.put("chrome", this::createChromeDriver);
        driverMap.put("firefox", this::createFirefoxDriver);
        driverMap.put("edge", this::createEdgeDriver);
        driverMap.put("safari", this::createSafariDriver);
    }

    public WebDriver getDriver(String browserName) {
        return driverMap.getOrDefault(browserName.toLowerCase().trim(), () -> {
            System.out.println("Browser not Found.." + browserName);
            throw new RuntimeException("Browser Not Found");
        }).get();
    }

    private WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    private WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    private WebDriver createSafariDriver() {
        return new SafariDriver();
    }
}
