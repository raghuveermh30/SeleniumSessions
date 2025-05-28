package relativeLocatorconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorWithFindElements {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        /* Relative Locator is added in selenium 4.0
         * Relative Locators meaning neighboring elements --> Left, Right, Above, Below, Near to the particular WebElement
         *
         */

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement loginLinkEle = driver.findElement(By.linkText("Login"));

        driver.findElements(with(By.xpath("//a[@class = 'list-group-item']")).below(loginLinkEle)).stream().forEach(e -> System.out.println(e.getText()));
        System.out.println("---------------------------------");

        WebElement loginBtmEle = driver.findElement(By.xpath("//input[@value = 'Login']"));
        driver.findElements(with(By.xpath("//footer//div[@class='container']//div[@class='row']")).below(loginBtmEle)).stream().forEach(e -> System.out.println(e.getText()));

    }
}
