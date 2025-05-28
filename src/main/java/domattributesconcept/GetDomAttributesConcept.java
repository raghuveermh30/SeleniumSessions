package domattributesconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDomAttributesConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        WebElement emailIdElement = driver.findElement(By.id("input-email"));

        //To Capture the DOM attribute
        String emailPlaceHolder = emailIdElement.getDomAttribute("placeholder");
        System.out.println(emailPlaceHolder);

        //Capture the DOM properties
        String baseUri = emailIdElement.getDomProperty("baseURI");
        System.out.println(baseUri);

        String outerHTML = emailIdElement.getDomProperty("outerHTML");
        System.out.println(outerHTML);

        //Get the value entered in the email --> Here we are entering the email Id, and verifying that the value entered is correct
        emailIdElement.sendKeys("naveen@gmail.com");
        String ele = emailIdElement.getText(); //This is not approach
        System.out.println(ele);

        //In DOM -> We will be having value attribute in the property
        //DOM Property Value
        //Using below, we can fetch the entered value in the text field using getDomProperty()
        String enteredValue = emailIdElement.getDomProperty("value");
        System.out.println(enteredValue);
        System.out.println("*************");

        //Using Generic Function

        By emailId = By.id("input-email");
        String domAttribute = doGetDomAttribute(emailId, "placeholder");
        System.out.println(domAttribute);

        String domProperty = doGetDomProperty(emailId, "value");
        System.out.println(domProperty);


        driver.quit();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static String doGetDomAttribute(By locator, String attributeName) {
        return getElement(locator).getDomAttribute(attributeName);
    }

    public static String doGetDomProperty(By locator, String propName) {
        return getElement(locator).getDomProperty(propName);
    }
}
