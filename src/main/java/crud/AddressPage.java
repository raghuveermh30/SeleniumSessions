package crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage {

    private WebDriver driver;
    private By firstName = By.id("address_first_name");
    private By lastName = By.id("address_last_name");
    private By address1 = By.id("address_street_name");
    private By city = By.id("address_city");
    private By zipCode = By.id("address_zip_code");
    private By addressLink = By.linkText("Address");
    private By newAddress = By.linkText("New Address");
    private By createAddress = By.name("commit");
    private By sucessMsg = By.cssSelector("div.alert.alert-notice");
    private By firtNameValue = By.xpath("//span[@data-test=\"first_name\"]");

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickAddressLink() {
        driver.findElement(newAddress).click();
    }

    public String fillAddressForm(Address address) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(address.getFirstName());

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(address.getLastName());

        driver.findElement(address1).clear();
        driver.findElement(address1).sendKeys(address.getAddress1());

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(address.getCity());

        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(address.getZipCode());
        driver.findElement(createAddress).click();
        return driver.findElement(sucessMsg).getText();
    }

    public String addAddress(Address address) {
        clickAddressLink();
        driver.findElement(addressLink).click();
        return fillAddressForm(address);
    }

    public String updateAddress(Address address, String fName) {
        clickAddressLink();
        driver.findElement(By.xpath("//td[text()='" + fName + "']//following-sibling::td/a[text()='Edit']")).click();
        return fillAddressForm(address);
    }

    public String deleteAddress( String fName) {
        clickAddressLink();
        driver.findElement(By.xpath("//td[text()='" + fName + "']//following-sibling::td/a[text()='Destroy']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return driver.findElement(sucessMsg).getText();
    }

    public String getAddress(String fName) {
        clickAddressLink();
        driver.findElement(By.xpath("//td[text()='" + fName + "']//following-sibling::td/a[text()='Show']")).click();
        return driver.findElement(firtNameValue).getText();
    }
}
