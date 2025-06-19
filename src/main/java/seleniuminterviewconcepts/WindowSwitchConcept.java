package seleniuminterviewconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowSwitchConcept {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//Parent Window
        String parentWindowId = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("(//*[local-name() = 'svg' and @class='oxd-icon orangehrm-sm-icon'])[1]")).click();
        driver.findElement(By.xpath("(//*[local-name() = 'svg' and @class='oxd-icon orangehrm-sm-icon'])[2]")).click();
        driver.findElement(By.xpath("(//*[local-name() = 'svg' and @class='oxd-icon orangehrm-sm-icon'])[3]")).click();
        driver.findElement(By.xpath("(//*[local-name() = 'svg' and @class='oxd-icon orangehrm-sm-icon'])[4]")).click();

        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handles);
        if (switchToRightWindow("Facebook", handlesList)) {
            System.out.println(driver.getTitle() + " : " + driver.getCurrentUrl());
        }

        //Switch To Parent Id
        switchToParentWindow(parentWindowId);
        System.out.println(driver.getTitle() + " : " + driver.getCurrentUrl());

        //close all the windows except the Parent Window
        closeAllWindows(handlesList, parentWindowId);
        switchToParentWindow(parentWindowId);
        System.out.println(driver.getTitle() + " : " + driver.getCurrentUrl());
    }

    public static void closeAllWindows(List<String> handlesList, String parentWindowId) {
        for (String str : handlesList) {
            if (!str.contains(parentWindowId)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    public static void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    public static boolean switchToRightWindow(String windowTitle, List<String> handlesList) {

        for (String str : handlesList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the Right Window");
                return true;
            }
        }
        return false;
    }


}
