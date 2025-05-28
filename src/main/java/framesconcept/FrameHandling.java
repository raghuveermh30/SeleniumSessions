package framesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();//browser
        driver.get("http://www.londonfreelance.org/courses/frames/index.html");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        driver.switchTo().frame(driver.findElement(By.name("main")));

        driver.quit();

        //frame --> almost deprecated, multiple frames can be put inside frameset
        //iframe --> this is the latest, w3c standards

        String text = driver.findElement(By.tagName("h2")).getText();
        System.out.println(text);


    }
}
