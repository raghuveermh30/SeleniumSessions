package xpathconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathConcept {

    public static void main(String[] args) {

        /* xpath - is not an attribute/property
         * is address of the particular Element
         *
         * 1. Absolute Xpath --> /html/body/div[2]/div/div/div/div[2]/div/form/div[1]/input  -> Copy fullXpath
         * 2. Relative Xpath --> Custom Xpath: functions, text, axes (Parent, Child, siblings)
         *
         * Absolute Xpath --> Can be changed, Its very fragile
         * It is not readable
         * If any position has changes then it won;t work
         * Performance on the execution is slow
         */

        //using one attribute

        //htmltag[@attributeName = 'Value']
        //Example 1- //input[@id = 'input-email']
        //Example 2 -//input[@ name = 'email']
        //Example 3 - //input[@ placeholder = 'E-Mail Address']

        //Submit button
        //input[@value = 'Login']

        //using two attribute:
        //htmlTag[@attr1 = 'value1' and @attr2 = 'value2']
        //Ex1 - //input[@value = 'Login' and @type='submit']
        //Ex2 - //input[@id = 'input-email' and @name='email']
        //Ex3 - //input[@id = 'input-email' and @name='email' and placeholder='E-Mail Address']

        //Fetch all href attribute using the xpath --> //a[@href] --> use FindElements  - 81 Elements
        //Fetch all id's attribute using the xpath --> //input[@id] - 6 Elements --> use FindElements
        //Fetch all id's and type attribute using the xpath --> --> //input[@id and @type] - 6 Elements --> use FindElements

        //text():
        //htmlTag[@text() = 'textValue']
        //Ex1 --> //a[text() = 'Forgotten Password']
        //Ex2 --> //h1[text() = 'Register Account']
        //Ex3 --> //a[text() = 'About Us']
        //Ex4 --> //strong[text() = 'I am a returning customer']

        //text() and attribute
        //htmlTag[text() = 'value' and @attribute='value']
        //Ex1 --> //a[text() = 'Register' and @class='list-group-item']
        //Ex2 --> //a[text() = 'Address Book' and @class='list-group-item']
        //Ex3 --> //a[text() = 'Downloads' and @class='list-group-item']

        //htmlTag[text() = 'value' and @attribute1='value1' and @attribute2='value2']

        //contains()
        //htmlTag[contains(@attribute, 'value']
        //htmlTag[contains(@text(), 'value']

        //Ex1 - //a[contains(@href, 'route=account/recurring')]
        //Ex2 - //input[contains(@placeholder, 'E-Mail')]
        //Ex3 - //input[contains(@placeholder, 'Address')]

        //htmlTag[contains(@attribute, 'value') and (@attr='value')]
        //Ex1 -->input[contains(@placeholder, 'Address') and @name = 'email']


        //htmlTag[contains(@attribute1, 'value1') and (contains(@attribute2, 'value1'))]
        //Ex 1 --> //input[contains(@placeholder, 'Address') and contains(@id, 'email')]

        //contains() and text():
        //htmlTag[contains(text(), 'value')]
        //Ex1 --> //p[contains(text(), 'By creating an account')]
        //Ex 2 --> //p[contains(text(), 'keep track of the orders')]

        //Ex 3 --> //p[contains(text(), "order's status")]

        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        String paragraphText = driver.findElement(By.xpath("//p[contains(text(), \"order's status\")]")).getText();
        System.out.println(paragraphText);

        //Ex 4 --> //h2[contains(text(), 'Returning')]
        //Ex 5 --> (//h2[contains(text(), 'Customer')])[2]

        //contains() with text() and attribute
        //htmlTag[contains(text(), 'value') and contains(@att, 'value')]
        //Ex 1 -->//a[contains(text(), 'Recurring') and contains(@href, 'route=account/recurring')]

        //starts-with() -> it should start with the value
        //htmlTag[starts-with(text(), value)]
        //Ex1 -- //p[starts-with(text(), 'By creating an account you')]
        //Ex2 --> //div[@id='navFooter']//a[starts-with(text(), 'Help')]

        //<input id="firstName1234">
        //<input id="firstNameyuqu">
        //<input id="firstName978">

        //id[starts-with(@id, 'firstName')]

        //ends-with() --> there is not available in the latest browsers

        //Indexing in Xpath --> Position on the element
        //(//input[@class = 'form-control']) --> this is called CaptureGroup
        //Ex1 --> (//input[@class = 'form-control'])[1]
        //Ex2 --> (//input[@class = 'form-control'])[2]

        //position function in xpath
        //Ex1 --> (//input[@class = 'form-control'])[position()=1]
        //Ex1 --> (//input[@class = 'form-control'])[position()=2]

        //last function in xpath -> it will go directly to the last element
        //Ex1 --> (//input[@class = 'form-control'])[last()]
        //Ex2 --> (//input[@class = 'form-control'])[last()-1] --> second last
        //Ex3 --> (//input[@class = 'form-control'])[last()-1] --> third last
        //Ex4 --> (//*[@class='list-group-item'])[last()]
        //Ex5 --> ((//div[@class = 'navFooterLinkCol navAccessibility'])[last()]//a)[last()]

        //first in the xpath
        //Ex1 --> (//input[@class = 'form-control'])[1]


    }
}
