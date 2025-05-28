package mytest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {

    @Test
    public void googleTitleTest() {
        //driver.get("https://www.orangehrm.com/en/30-day-free-trial");
        String actualTitle = driver.getTitle();
        System.out.println("Google Title: " + actualTitle);
        Assert.assertEquals(actualTitle, "30-Day Advanced Free Trial | OrangeHRM HR Software", "Title does not match!");
    }

    @Test
    public void googleUrlTest() {
       // driver.get("https://www.orangehrm.com/en/30-day-free-trial");
        String actualURL = driver.getCurrentUrl();
        System.out.println("Orange HRM: " + actualURL);
        Assert.assertTrue(actualURL.contains("orangehrm"), "URL does not contain 'google'!");
    }
}
