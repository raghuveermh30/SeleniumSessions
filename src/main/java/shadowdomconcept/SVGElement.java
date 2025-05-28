package shadowdomconcept;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        //SVG -> Scalable Vector Graph

        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(3000);

        //Browser --> Page DOM --> iframe DOM --> SVG

        ////*[local-name()='svg']

        driver.findElement(By.name("q")).sendKeys("macbook");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[local-name()='svg']")).click();
    }
}
