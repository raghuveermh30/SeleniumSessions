package webdriverconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class QuitvsClose {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Get Title
        String title = driver.getTitle();
        System.out.println(title);
        //Automation test --> Automation steps + Validations (Checkpoint)
        Assert.assertEquals(title, "Google");

        // Get Page Url
        String pageUrl = driver.getCurrentUrl();
        System.out.println("Page URL is " + pageUrl);

        // close the browser
        driver.close();

        /*
        title= driver.getTitle(); //org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
        System.out.println(title);*/

        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        title = driver.getTitle();
        System.out.println("Title is " + title);

    }
}
