package fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/upload");

        //type = file
        driver.findElement(By.id("fileInput")).sendKeys("/Users/rhanumantharaya/Downloads/CLM0519202506330791.pdf");

        driver.findElement(By.id("fileSubmit")).click();


        //Robot class: only for windows, it will not work on Linux Machine, docker, Incognito mode, Its only for Windows, its not recomonded
        //Robot Class doesn;t work in the Headless Mode
        //Sikuli lib: based on image processing, We need to maintain more number of images, if any resolution changes in the diff machine, then it won;t work
        //Sikuli -> It will never work with Headless mode
        //AutoIT: only for windows, Its not recomonded

    }
}
