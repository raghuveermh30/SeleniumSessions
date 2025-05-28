package shadowdomconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //browser-->Page DOM-->1st shadow dom(open) --> 2nd shadow dom (open) --> input#pizza

        /* shadow-root concept
         * Shadow-Root is special kind of element where UI developer will return the shadow root
         * It is light-weight container HTML dom inside the tag
         * This will be used for security purpose link Banking application
         * #shadow-root(open) -> Example
         * #shadow-root should be always OPEN not CLOSED
         */


        //  driver.findElement(By.id("pizza")).sendKeys("Veg Pizza"); //No Such Element Exception
        //Using Java Script Path --> we can automate

        String jsPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pizzaEle = (WebElement) js.executeScript(jsPath); //htmlElement (converting into) WebElement
        pizzaEle.sendKeys("Veg Pizza");

        // #shadow-root(open) is supported only for CSS selector, Xpath is not supported
        //shadow dom:
        //xpath: is not supported
        //css: only css is supported

    }
}
