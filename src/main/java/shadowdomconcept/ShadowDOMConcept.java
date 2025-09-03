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
         * The purpose of the shadow-root is to hide the personal details of the user and to protect the user information from the hackers
         */


        //  driver.findElement(By.id("pizza")).sendKeys("Veg Pizza"); //No Such Element Exception
        //Using Java Script Path --> we can automate

        String jsPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";

        //document.querySelector("#userName").shadowRoot.querySelector("#app2").shadowRoot.querySelector("#pizza")

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pizzaEle = (WebElement) js.executeScript(jsPath); //html Element (converting into) WebElement -> selenium understands WebElement
        pizzaEle.sendKeys("Veg Pizza");

        // #shadow-root(open) is supported only for CSS selector, Xpath is not supported
        //shadow dom:
        //xpath: is not supported
        //css: only css is supported

        /*
        //This Element is inside 2 nested shadow DOM.
        String cssSelectorForHost1 = "#userName";
        String cssSelectorForHost2 = "#app2";
        Thread.sleep(1000);
        SearchContext shadow0 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#app2")).getShadowRoot();
        Thread.sleep(1000);
        WebElement ele =  shadow1.findElement(By.cssSelector("#pizza"));
        ele.sendKeys("Veg Pizza");
*/
    }
}
