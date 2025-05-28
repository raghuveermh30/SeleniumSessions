package otherconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessConcept {

    public static void main(String[] args) {

        /* Headless is no browser visible to the user.
         * Execution will happen in the headless
         * Testing is slightly faster than normal mode
         * Headless mode is used in CI/CD pipeline in Jenkins, Linux, docker
         * It is not recommended to use headless mode in local machine
         * There is no limitation as such of using Headless mode
         * Suppose, if we are using many Actions class then Headless might not work
         * This is not a real time user Journey
         */

        /*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);*/

        // Launch Firefox in headless mode
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        System.out.println(driver.getTitle());
        driver.quit();

        //Toggle : true/false
        //HTMLUnitDriver: It is different External Library that we need to add in pom.xml
        //PhantomJsDriver: Depreceated from market

    }
}
