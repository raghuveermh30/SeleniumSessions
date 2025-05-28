package webdriverconcept;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebDriverBasics {

    public static void main(String[] args) {

        //Manual Test cases
        //1. Open Browser (chrome)
        //2. Enter the URL
        //3. Get the Page Title -> Tab name
        //4. Verify the title as per the Exceted title
        //5. Close the Browser

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com");
        String title = chromeDriver.getTitle();
        System.out.println(title);
        //Automation test --> Automation steps + Validations (Checkpoint)
        Assert.assertEquals(title, "Google");

        if(title.equals("Google")){
            System.out.println("PASS");
        }
        else {
            System.err.println("FAIL");
        }
        chromeDriver.close();


    }
}
