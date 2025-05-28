package calenderhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {


    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();

        // selectDate("15");

        selectFutureDate("August 2025", 30);//August 2025 is the expected month and year, and 15 is the date to be selected.

        // selectPreviousDate("March 2025", "15"); //March 2025 is the expected month and year, and 15 is the date to be selected.
    }

    public static void selectDate(int date) {
        //table[@class='ui-datepicker-calendar']//td/a[text()='11'] - This XPath is used to select a specific date (11) in the calendar.
        try {
            driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td/a[text()='" + date + "']")).click();
        } catch (NoSuchElementException e) {
            System.out.println("Date " + date + " is not available in the calendar.");
        }
    }

    public static void selectFutureDate(String expMonthYear, int date) {

        if (expMonthYear.contains("Febraury") && date > 29) {
            System.out.println("Wrong date is Passed, Please provide a valid date between 1 to 29 for February.." + date);
            throw new RuntimeException("Invalid Date...");
        }

        if (date > 31 || date < 1) {
            System.out.println("Wrong date is Passed, Please provide a valid date between 1 to 31.." + date);
            throw new RuntimeException("Invalid Date...");
        }

        String actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
        System.out.println(actualMonthYear); //May 2025


        while (!actualMonthYear.equalsIgnoreCase(expMonthYear)) {
            //click on Next button to go to the next month
            driver.findElement(By.xpath("//span[text() = 'Next']")).click();
            actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
        }
        selectDate(date);
    }

    public static void selectPrevDate(String expMonthYear, int date) {

        if (expMonthYear.contains("Febraury") && date > 29) {
            System.out.println("Wrong date is Passed, Please provide a valid date between 1 to 29 for February.." + date);
            throw new RuntimeException("Invalid Date...");
        }

        if (date > 31 || date < 1) {
            System.out.println("Wrong date is Passed, Please provide a valid date between 1 to 31.." + date);
            throw new RuntimeException("Invalid Date...");
        }

        String actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
        System.out.println(actualMonthYear); //May 2025


        while (!actualMonthYear.equalsIgnoreCase(expMonthYear)) {
            //click on Next button to go to the next month
            driver.findElement(By.xpath("//span[text() = 'Prev']")).click();
            actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
        }
        selectDate(date);
    }

}
