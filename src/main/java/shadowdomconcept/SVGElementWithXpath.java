package shadowdomconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SVGElementWithXpath {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://petdiseasealerts.org/forecast-map");
        driver.manage().window().maximize();
        Thread.sleep(10000);

        //Browser --> Page DOM --> iframe DOM --> SVG   --> Hierarchy


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id = 'map-instance-41199']")));
        Thread.sleep(10000);

        //svg#map-svg g#regions>g

        String svgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id ='regions']/*[name()='g']";

        List<WebElement> statesList = driver.findElements(By.xpath(svgXpath));
        System.out.println(statesList.size());

        Actions actions = new Actions(driver);

        for (WebElement element : statesList) {
            actions.moveToElement(element).build().perform();
            String stateId = element.getDomAttribute("alabama");
            System.out.println(stateId);
        }

    }
}
