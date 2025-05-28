package shadowdomconcept;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class PsuedoElementsHandle {

    public static void main(String[] args) {

        // ::before
        // ::after
        // ::has
        // Element that is not having any property called Psudeo element
        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        String scriptMandatory = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content');";
        String scriptColor = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('color');";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String content = Objects.requireNonNull(js.executeScript(scriptMandatory)).toString();
        System.out.println(content);
        if (content.contains("*")) {
            System.out.println("First Name is Mandatory");
        }

        String color = Objects.requireNonNull(js.executeScript(scriptColor)).toString();
        System.out.println(color);
        if (color.contains("rgb(255, 0, 0)")) {
            System.out.println("Mandatory icon is Red Color");
        }


    }
}
