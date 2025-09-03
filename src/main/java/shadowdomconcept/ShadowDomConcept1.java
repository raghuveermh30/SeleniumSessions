package shadowdomconcept;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomConcept1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Handle the Shadow DOM using Java Script Executor

        String jsPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pizzaElement = (WebElement) js.executeScript(jsPath); //html Element (converting into) WebElement -> selenium understands WebElement
        assert pizzaElement != null;
        pizzaElement.sendKeys("Veg Pizza");


    }
}
