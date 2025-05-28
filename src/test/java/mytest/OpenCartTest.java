package mytest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

    @Test
    public void titleTest() {
       // driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        String actualTitle = driver.getTitle();
        System.out.println("OpenCart Login Page Title: " + actualTitle);
    }

    @Test
    public void forgotPassLinkExist() {
       // driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        boolean flag = driver.findElement(By.linkText("Forgotten Password")).isDisplayed();
        Assert.assertTrue(flag, "Forgot Password link is not displayed!");
    }
}
