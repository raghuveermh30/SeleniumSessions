package selectdropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JqueryDropDownHandling {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
        driver.manage().window().maximize();
        Thread.sleep(4000L);

        By choiceDropDown = By.id("justAnInputBox");
        By choices = By.xpath("//h3[text()='Multi Selection']/following-sibling::div/div//ul//span[contains(@class, 'comboTreeItemTitle')]");

        // Test Case 1 : Select Single Choice
        //   selectChoice(choiceDropDown, choices, "choice 3");

        // Test Case 2 : Select Multiple Choice -> //String... --> 3 dot Parameter --> Var Arg
        //VarArg Parameter should be the last Parameter in the method
        //  selectChoice(choiceDropDown, choices, "choice 3", "choice 2", "choice 2 2", "choice 7");


        // Test Case 3 : Select All Choices
        selectChoice(choiceDropDown, choices, "all");

        driver.quit();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /*
     * This method is handling single/multiple and all the choices selection. Please pass 'all' to select all the choices
     * selectChoice(By choiceDropDown, By choices, String... choiceValue)
     * @param choiceDropDown
     * @param choices
     * @param choiceValue
     * @throws InterruptedException
     */
    public static void selectChoice(By choiceDropDown, By choices, String... choiceValue) throws InterruptedException {

        getElement(choiceDropDown).click();
        Thread.sleep(4000L);

        List<WebElement> choicesList = driver.findElements(choices);
        System.out.println(choicesList.size());

        if (choiceValue[0].equalsIgnoreCase("all")) {
            //Select all the choice : one by one
            for (WebElement element : choicesList) {
                element.click();
            }
        } else {
            for (WebElement element : choicesList) {
                String text = element.getText();
                System.out.println(text);
                for (String ch : choiceValue) {
                    if (text.equals(ch)) {
                        element.click();
                    }
                }
            }
        }
    }
}
