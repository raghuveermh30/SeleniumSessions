package xpathconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        /* Parent to Child
         * 1. Direct Child --> / --> this will give only direct child elements
         * 2. InDirect Child --> //  --> This will give direct and indirect both
         */

        //Ex1 -> //form//input[@id] --> 2 Elements are available
        //Ex2 --> //form//input[@id and @placeholder] --> 2 Elements are available

        //URL -> https://www.orangehrm.com/en/30-day-free-trial

        /* Xpath using select
         * //select[@id = 'Form_getForm_Country']//option
         * //select[@id = 'Form_getForm_Country']/option
         * both are correct --> direct and indirect child elements will work
         */

        //URL -> https://app.hubspot.com/login/legacy

        //Direct element
        //Ex1 - //div[@class = 'private-form__input-wrapper']/input[@id='username']

        //InDirect element
        //Ex1 - //form[@id = 'hs-login']//input[@id='username']

        //Xpath using keywords

        //Ex1 -> //div[@class = 'private-form__input-wrapper']//child::input[@id = 'username']
        //Ex2 -> //div[@class = 'private-form__input-wrapper']/child::input[@id = 'username']
        //Ex1 and Ex2 both are same

        //Ex3 --> //form[@id = 'hs-login']//child::input[@id = 'username']
        //Here, We are reading from grand parent and the child hence we used double //child

        //URL - https://naveenautomationlabs.com/opencart/index.php?route=account/register

        //Ex1 --> //form[@class='form-horizontal']//child::input[@placeholder]
        //Ex2 --> //form[@class='form-horizontal']//input[@placeholder]

        //Take the Immediate/Direct Parent -> this is called Backward Traversing in the DOM
        //Ex1 -> //input[@id = 'input-firstname']/..
        //Ex2 -> //input[@id = 'input-firstname']/../..

        //Parent Keyword in Xpath -> this should be the direct parent
        //Ex1 -> //input[@id = 'input-firstname']/parent::div
        //Ex2 -> //input[@id = 'input-firstname']/parent::div/parent::div --> Grandparent
        //Ex3 --> //input[@id = 'input-firstname']/parent::div/parent::div/parent::fieldset
        //Ex4 --> //input[@id = 'input-firstname']/parent::div/parent::div/parent::fieldset/parent::form

        //ancestor Keyword in Xpath --> this will be used for child to ancestor --> We can fetch GrandParents
        //Ex1 -> //input[@id = 'input-firstname']/ancestor::form

        //URL -> https://naveenautomationlabs.com/opencart/index.php?route=account/login

        //Following keyword
        //Ex1 -> //label[text()='E-Mail Address']/following-sibling::input[@name='email']
        //Ex2 -> //label[text()='Password']/following-sibling::input[@name='password']

        //Preceding keyword
        //Ex1 -//input[@id = 'input-email']/preceding-sibling::label[@for='input-email']

        //URL -> https://selectorshub.com/xpath-practice-page/

        //Handling WebTable -> click checkbox
        //Ex 1 - //a[text()= 'Joe.Root']/parent::td/preceding-sibling::td//input[@type='checkbox']

        //2nd way
        //Ex 1 -> //a[text()= 'John.Smith']/ancestor::tr//input[@type='checkbox']

    }
}
