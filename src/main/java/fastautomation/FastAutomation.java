package fastautomation;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastAutomation {

    public static void main(String[] args) {

        //Launch the browser
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--start-maximized");

        WebDriver wd = new ChromeDriver(chromeoptions);
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
        wd.get("https://fast.com/");

        By speedValueLocator = By.id("speed-value");
        By speedUnitLocator = By.id("speed-units");
        By finalSpeedLocator = By.xpath("//div[contains(@class,'succeeded') and contains(@id,'speed-value')]");



        while (true) {
            WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
            WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));

            System.out.println(speedValueElement.getText() + " " + speedUnitElement.getText());

            String className = speedValueElement.getAttribute("class");
            if (className != null && className.contains("succeeded")) {
                break;
            }

        }

        WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
        WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));
        System.out.println("----------------Final Speed------------------");
        System.out.println(speedValueElement.getText() + " " + speedUnitElement.getText());


    }
}
