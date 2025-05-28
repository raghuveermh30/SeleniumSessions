package actionsconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActionsOpenCart {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By lapNet = By.xpath("//a[text() = 'Laptops & Notebooks']");
        By mac = By.linkText("Macs (0)");
        By macText = By.xpath("//h2[text() = 'Macs']");

        By mp3Players = By.xpath("//a[text() = 'MP3 Players']");
        By mp3PlayersList = By.xpath("//li[@class = 'dropdown open']//div[@class = 'dropdown-inner']//ul/li");

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(lapNet)).build().perform();
        Thread.sleep(3000L);
        actions.click(driver.findElement(mac)).build().perform();
        Thread.sleep(3000L);
        driver.findElement(macText).isDisplayed();
        Thread.sleep(3000L);

        actions.moveToElement(driver.findElement(mp3Players)).build().perform();
        Thread.sleep(3000L);
        List<WebElement> mp3PlayersArray = driver.findElements(mp3PlayersList);
        System.out.println(mp3PlayersArray.size());

        for (WebElement element : mp3PlayersArray) {
            String text = element.getText();
            System.out.println(text);
        }


    }
}
