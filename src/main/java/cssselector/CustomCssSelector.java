package cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CustomCssSelector {

    public static void main(String[] args) throws InterruptedException {

        /* CSS -> Cascaded Style Sheet
         * It is a locator
         */

        //1. id --> #id --> #input-email
        //2. tag --> #tag --> input#input-email

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.hubspot.com/login/legacy");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        By id = By.cssSelector("#input-email");

        //3. Class: --> .classname --> .form-control
        //4. Class with tagname --> input.form-control


        /* If we have multiple class name, then we can create css like below
         * .c1.c2.c3....cn
         * tag.c1.c2...cn
         * Ex1- .form-control.input-lg
         * Ex2- input.form-control.input-lg
         *
         * .c2.c1
         * Ex1- .input-lg.form-control
         */

        //URL --> https://app.hubspot.com/login/legacy

        //Ex --> //input#username

        /* Id with the class name
         * #id.class
         * .class#id
         * tag#id.class
         * tag.class#id
         */

        //Ex1 --> #id.class  --> input#username.form-control.private-form__control
        //Ex2 --> class#id --> .form-control.private-form__control#username
        //Ex3 --> tag.class#id --> input.form-control.private-form__control#username
        //Ex4 --> tag#id.class --> input#username.form-control.private-form__control

        By userName = By.cssSelector("input.form-control.private-form__control#username");

        //For Other or Specific Attributes
        //Syntax --> tag[attribute='value']
        //Ex1 --> input[value='Login']

        //Syntax --> tag[attribute='value']#id
        //Ex1 --> input[name='email']#input-email

        //Syntax --> tag[attribute1='value1'][attribute2='value2']
        //Ex1 --> input[value='Login'][type='submit']

        //Syntax --> tag[attribute1='value1'][attribute2='value2'][attribute3='value3']
        //Ex1 --> input[value='Login'][type='submit'][class='btn btn-primary']
        //Ex2 --> input[type='text'][name='email'][placeholder='E-Mail Address']

        //[id][type][placeholder] --> 2 Elements are available

        //URL -> https://www.amazon.in/

        //Total Number of Links

        //Ex1 --> a[href]
        //Ex2 --> Total Number of Links with Id --> a[href][id]
        //Ex2=3 --> Total Number of Links with Id and with class--> a[href][id][class]

        //text in CSS: No support for text in css

        //contains in CSS --> syntax --> //tag[attribute*='value']
        //Ex1 --> input[placeholder*='E-Mail']
        //Ex2 --> input[name*='email']
        //Ex3 --> input[class*='form-control'] -> 3 class are there --> input[class*='form-control']#input-email


        //startswith in CSS --> syntax --> //tag[attribute^='value']
        //Ex1 -->input[placeholder^='E-Mail']
        //Ex2 --> input[name^='email']
        //Ex3 --> input[class^='form-control']#input-email

        //endswith in Css --> syntax --> //tag[attribute$='value']
        //Ex1 -->input[placeholder$='Address']
        //Ex2 --> input[class$='control']#input-email

        //Parent to Child concept:
        //Syntax --> parentTag childTag --> direct+indirect child elements --> (space)
        //Syntax --> parentTag > childTag --> direct child elements --> (>)

        //Ex1 --> Direct + indirect --> form#hs-login div --> this will give 24 occurance
        //Ex1 --> Direct Only --> form#hs-login>div  --> this will give 9 occurance

        //Ex1 --> div#content form input#input-email
        //Ex2 --> div#content form input#input-password

        //URL --> https://www.orangehrm.com/en/30-day-free-trial

        //Ex1 --> select#Form_getForm_Country>option  --> this will give 233 occurance
        //Ex2 --> select#Form_getForm_Country option  --> this will give 233 occurance

        //Child to Parent  --> this is not supported --> backward traversing is not allowed in CSS
        //WebTable handling is not possible in CSS

        //Sibling in CSS: only following-sibling is allowed
        //Ex1 - label[for = 'input-email']+ input#input-email

        //URL --> https://www.orangehrm.com/en/30-day-free-trial
        //Ex1 -> option[value='Afghanistan']+option[value='Albania']
        // + will give immediate sibling only

        //Ex2 --> option[value='Afghanistan']~option
        // ~ this will give all the countries --> this will give all following option

        By.cssSelector("label[for = 'input-email']+ input#input-email");

        //Index in CSS
        //URL --> https://www.orangehrm.com/en/30-day-free-trial
        //select#Form_getForm_Country>option:nth-of-type(2) --> this is giving 2nd index
        //select#Form_getForm_Country>option:nth-of-type(n) --> this will give all elements
        //select#Form_getForm_Country>option:first-child --> this will give first child
        //select#Form_getForm_Country>option:last-child --> this will give last child
        //select#Form_getForm_Country>option:nth-child(5) -> this will give the 5th element --> based on value of 'n'
        //select#Form_getForm_Country>option:nth-last-child(2) --> this will give last 2nd element  in the dropdown
        //select#Form_getForm_Country>option:nth-last-child(5) --> this will give last 5th element  in the dropdown
        //select#Form_getForm_Country>option:nth-child(odd) --> this will give only 'odd' elements in the dropdown
        //select#Form_getForm_Country>option:nth-child(even) --> this will give only 'even' elements in the dropdown

        //ODD and EVEN in xpath
        //10 % 2 ==0 --> EVEN
        //9 % 2==1 --> ODD
        //Ex1 --> //select[@id = 'Form_getForm_Country']/option[position() mod 2 = 0] --> this will give 116 values in the country dropdown
        //Ex2 --> //select[@id = 'Form_getForm_Country']/option[position() mod 2 = 0] --> this will give 117 values in the country dropdown

        //comma in CSS
        //URL - https://app.hubspot.com/login/legacy
        //input#username, input#password, button#loginBtn --> 3 elements we are getting in single CSS locator
        By impElementList = By.cssSelector("input#username, input#password, input#remember, button#loginBtn");
        List<WebElement> webElementList = driver.findElements(impElementList);
        System.out.println(webElementList.size());

        if(webElementList.size()==3){
            System.out.println("login form have all check elements");
        } else {
            System.out.println("FAIL");
        }

        //not in CSS
        //URL --> https://naveenautomationlabs.com/opencart/index.php?route=account/register
        //Here class name will give 7 elements but this include search as well, hence remove this --> then we will get 6 entries
        //Ex1 -> input.form-control:not(input[name='search']) --> Exclude Search
        //Ex2 -> input.form-control:not(input#input-telephone) --> Exclude Telephone



    }
}
