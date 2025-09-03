package alertconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopupHandle {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        String username = "admin";
        String password = "admin";
        //driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");

        //basic Auth --> we need to pass the username and password


        // basic auth
        ((HasAuthentication) driver).register(() -> new UsernameAndPassword(username, password));
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        String mesg = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
        System.out.println(mesg);


    }
}
