package navigationconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BackAndForwardSimulation {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(3000L);
        System.out.println(driver.getTitle()); //Google

       //  driver.navigate().to("https://www.amazon.com");
       // driver.get("https://www.amazon.com");
        driver.navigate().to(new URL("https://www.amazon.com"));
        System.out.println(driver.getTitle()); //Amazon

        driver.navigate().back();
        System.out.println(driver.getTitle()); //Google

        driver.navigate().forward();
        System.out.println(driver.getTitle()); //Amazon

        driver.navigate().back();
        System.out.println(driver.getTitle()); //Google

        driver.navigate().refresh(); //Refresh the Page

        /* navigate().to() and driver.get() --> both are same
         * internally navigate().to() --> is also called get() method only
         * navigate().to() and driver.get() are synonyms
         * driver.get() --> this is only String based URL
         * navigate().to() --> This is overloaded method and we can use URL based function --> this is only the difference
         * to() --> is also called get() internally
         * to() --> is Overloaded: to(String url) and to(URL url)
         * new URL() --> We have use cases but it will be very Rare case.
         * get() -> this method doesn;t have overloaded
         */

        driver.quit();
    }
}
