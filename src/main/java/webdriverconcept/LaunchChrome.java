package webdriverconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchChrome {

    public static void main(String[] args) {

        /* Selenium 3
         * System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Raghuveer.MH\\Desktop\\Project\\chromedriver_win32 (2)\\chromedriver.exe");
		 *	driver = new ChromeDriver();
         * We need to the System.Prop for below versions
         * Selenium 2.x, Selenium 3.x, Selenium 4.0.0 to Selenium 4.5.0 We need to use
         *
         *
         */

        //From Selenium 4.6.0 and Onwards --> SeleniumManager is inbuilt feature, this will take care of all browser responsibilities
        // Selenium Manager is developed by Bonegrica team

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        driver.quit();

    }
}
