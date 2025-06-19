package seleniuminterviewconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebTableRowColumn {
    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println(getRowColNum("Germany"));

    }

    public static boolean getRowColNum(String expectedValue) {
        int rowCount = driver.findElements(By.xpath("//table[@id = 'customers']//tr")).size();
        int colCount = driver.findElements(By.xpath("//table[@id = 'customers']//tr/th")).size();
        boolean flag = false;
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                String actualValue = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[" + (i + 1) + "]/td[" + j + "]")).getText();

                if (actualValue.equals(expectedValue)) {
                    System.out.println(expectedValue + " is present in " + i + " row and " + j + " column");
                    flag = true;
                    break;
                }

            }
        }
        return true;
    }
}
