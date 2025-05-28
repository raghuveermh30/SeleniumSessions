package javascriptexecutorexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class JavaScriptExecutorConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        // driver.get("https://classic.freecrm.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = Objects.requireNonNull(js.executeScript("return document.title;")).toString();
        //String title = js.executeScript("return document.title;").toString(); --> This is also correct
        System.out.println(title);

        JavaScriptExecutorUtil javaScriptExecutorUtil = new JavaScriptExecutorUtil(driver);
        // javaScriptExecutorUtil.generateJSAlert("Login Page is displayed");

        String pageInnerText = javaScriptExecutorUtil.getPageInnerText();
        System.out.println(pageInnerText);
        if (pageInnerText.contains("E-Mail Address")) {
            System.out.println("PASS");
        }

       /* javaScriptExecutorUtil.scrollPageDown();
        Thread.sleep(3000L);
        javaScriptExecutorUtil.scrollPageUp();*/

        WebElement specials = driver.findElement(By.linkText("Specials"));
        javaScriptExecutorUtil.scrollIntoView(specials);
        Thread.sleep(3000L);
        javaScriptExecutorUtil.scrollPageUp();


        WebElement forgottenPassword = driver.findElement(By.linkText("Forgotten Password"));
        // WebElement loginSection = driver.findElement(By.xpath(" (//div[@class='well'])[2]"));
        //  javaScriptExecutorUtil.drawBorder(forgottenPassword);

        javaScriptExecutorUtil.flash(forgottenPassword);
        Thread.sleep(3000L);
        javaScriptExecutorUtil.clickElementByJS(forgottenPassword);

        //Normal click is not working on the Element --> Use Action Class --> Use Javascript Executor (this is the last Option)
        //clickElementByJS --> This is not recommender --> reason being, click will inject explicit, this is not the user based actions


        javaScriptExecutorUtil.sendKeysByJSUsingId("input-email", "naveen@test.com");

        //	document.querySelector('#id'); -- this for css selector
        // document.evaluate("//input[@id='input-email']", document, null, XPathResult.ANY_TYPE, null); -- xpath

        //  driver.quit();

    }
}
