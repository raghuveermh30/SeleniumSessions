package webelementconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        //create the webElement + perform an action(click, sendKeys, getText, isDisplayed...--> this is the main Rule

        //1. First Approach
        driver.findElement(By.id("input-email")).isDisplayed();
        driver.findElement(By.id("input-email")).sendKeys("naveenautomation20@gmail.com");
        Thread.sleep(3000L);
        driver.findElement(By.id("input-password")).isDisplayed();
        driver.findElement(By.id("input-password")).sendKeys("naveen@123");

        //2. Second Approach
        WebElement element = driver.findElement(By.id("input-email"));
        element.isDisplayed();
        element.clear();
        element.sendKeys("naveenautomation20@gmail.com");

        WebElement passElement = driver.findElement(By.id("input-password"));
        passElement.isDisplayed();
        element.clear();
        passElement.sendKeys("naveen@123");

        /*
         * This approach will be helpful for reusability
         * We can pass the input values using the single WebElement variable
         */


        //3. Third Approach -- Formula will remain same
        // using By Locator

        By byEmail = By.id("input-email");
        By byPass = By.id("input-password");

        WebElement element1 = driver.findElement(byEmail);
        WebElement password1 = driver.findElement(byPass);
        element1.isDisplayed();
        password1.isDisplayed();

        /*
         * Interaction on the server will be less, suppose if we have 20 elements, we can define here 20 elements, we can use them whenever its needed.
         * We can avoid unnecessary load on the selenium server.
         * if we use By locators, then server won;t be interacted.
         * We can maintain N number of locators here but here were are not interacting with the server, hence speed will be good
         * Maintain the By locator --> Create the WebElement --> when its needed.
         * This approach is better
         *
         * By Locator will behave the Object Repository
         */


        //4. Fourth Approach -- Formula will remain same
        // using By Locator strategy + Generic Function for creating the WebElement

        By byEmail1 = By.id("input-email");
        By byPass1 = By.id("input-password");

        WebElement element2 = getElement(byEmail1);
        element2.isDisplayed();
        WebElement password2 = getElement(byPass1);
        password2.isDisplayed();


        //5. Fifth Approach -- Formula will remain same
        // using By Locator strategy + Generic Function for creating the WebElement + Generic function for Action also
        // This approach is better
        By byEmail2 = By.id("input-email");
        By byPass2 = By.id("input-password");
        doSendKeys(byEmail2, "naveenautomation20@gmail.com");
        doSendKeys(byPass2, "naveen@123");

        //6. Sixth Approach -- Formula will remain same
        // using By Locator strategy + Generic Function for creating the WebElement + Generic function for Action + in ElementUtil
        By byEmail3 = By.id("input-email");
        By byPass3 = By.id("input-password");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(byEmail3, "naveenautomation20@gmail.com");
        elementUtil.doSendKeys(byPass3, "naveen@123");

        //7. Seventh Approach -- Formula will remain same
        // using By Locator strategy + Generic function for Action + in ElementUtil + Browser Util
        // This is the better approach --> Refer LoginPageTest.Java

        driver.quit();

    }

    public static WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
        return element;
    }

    public static void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }
}
