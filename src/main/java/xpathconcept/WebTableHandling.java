package xpathconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebTableHandling {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        Thread.sleep(3000L);

        //  WebElement clickCheckBox = driver.findElement(By.xpath("//a[text()= 'John.Smith']/ancestor::tr//input[@type='checkbox']"));
        WebElement element = selectUser("John.Smith");
        element.click();
        System.out.println(element.isSelected());


        WebElement element1 = selectUser("Joe.Root");
        element1.click();
        System.out.println(element1.isSelected());

        WebElement element2 = selectUser("Jordan.Mathews");
        element2.click();
        System.out.println(element2.isSelected());

        //Ex1 -> //a[text()= 'Joe.Root']/ancestor::tr//input[@type='checkbox']


        //2nd task -> get the Status value in the table
       List<String> jordanListDetails= getUserDetailsList("Jordan.Mathews");
        System.out.println(jordanListDetails);

        List<String> joeListDetails= getUserDetailsList("Joe.Root");
        System.out.println(joeListDetails);

        List<String> jasmineListDetails= getUserDetailsList("Jasmine.Morgan");
        System.out.println(jasmineListDetails);

        driver.quit();
    }

    public static WebElement selectUser(String userName) {
        return driver.findElement(By.xpath("//a[text()= '" + userName + "']/ancestor::tr//input[@type='checkbox']"));
    }

    public static List<String> getUserDetailsList(String userName) {
        List<WebElement> colList = driver.findElements(By.xpath("//a[text()= '" + userName + "']/parent::td/following-sibling::td"));

        List<String> colValueList = new ArrayList<>();

        for (WebElement e : colList) {
            String text = e.getText();
            colValueList.add(text);
        }

        return colValueList;
    }
}
