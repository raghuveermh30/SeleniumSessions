package mytest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void googleTitleTest() {
        //driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        System.out.println("Google Title: " + actualTitle);
        Assert.assertEquals(actualTitle, "Google", "Title does not match!");
    }

   // @Ignore
    @Test //(enabled = false)
    public void googleUrlTest() {
       // driver.get("https://www.google.com");
        String actualURL = driver.getCurrentUrl();
        System.out.println("Google URL: " + actualURL);
        Assert.assertTrue(actualURL.contains("google"), "URL does not contain 'google'!");
    }

}
