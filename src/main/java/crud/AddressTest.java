package crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddressTest {

    private WebDriver driver;
    private AddressPage addressPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("session_email")).sendKeys("naveenautomtion20@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Test@12345");
        driver.findElement(By.name("commit")).click();

        addressPage = new AddressPage(driver);
    }

    @Test
    public void createAddressTest() {
        Address address = new Address("raghu", "veer", "bangalore", "test address", "560072");
        String successMsg = addressPage.addAddress(address);
        Assert.assertEquals(successMsg, "Address was successfully created.");
    }

    @Test
    public void updateAddressTest() {
        Address address = new Address("naveen", "labs", "bangalore labs", "test address labs", "560012");
        addressPage.addAddress(address);
        address.setCity("Pune");
        address.setLastName("automation labs");
        address.setZipCode("568723");
        String successMsg = addressPage.updateAddress(address, address.getFirstName());
        Assert.assertEquals(successMsg, "Address was successfully updated.");
    }

    @Test
    public void deleteAddressTest() {
        Address address = new Address("naveendelete", "labsdelete", "bangalore labs delete", "test address labs delete", "560012");
        addressPage.addAddress(address);
        String successMsg = addressPage.deleteAddress("naveendelete");
        Assert.assertEquals(successMsg, "Address was successfully destroyed.");
    }

    @Test
    public void getAddressTest() {
        Address address = new Address("naveenGet", "labsGet", "bangalore labs GET", "test address labs GET", "560012");
        addressPage.addAddress(address);
        String fNameValue = addressPage.getAddress("naveenGet");
        Assert.assertEquals(fNameValue, address.getFirstName());
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
