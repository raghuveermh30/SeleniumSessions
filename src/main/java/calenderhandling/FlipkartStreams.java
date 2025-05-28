package calenderhandling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartStreams {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");


        driver.findElements(By.tagName("a")).stream().forEach(e -> System.out.println(e.getText()));
        System.out.println("**********************");

        driver.findElements(By.tagName("a")).stream()
                .filter(e -> !e.getText().isEmpty()).forEach(e -> System.out.println(e.getText()));
        System.out.println("**********************");

        driver.findElements(By.tagName("a")).stream().filter(e -> e.getText().contains("Flipkart"))
                .forEach(e -> System.out.println(e.getText()));
        System.out.println("**********************");

        List<WebElement> flipKartLinkList = driver.findElements(By.tagName("a")).stream().filter(e -> e.getText().contains("Flipkart"))
                .collect(Collectors.toList());
        System.out.println(flipKartLinkList);
        System.out.println("**********************");

        List<WebElement> flipKartArrayList = new ArrayList<>();
        driver.findElements(By.tagName("a")).stream().filter(e -> e.getText().contains("Flipkart")).forEach(e -> flipKartArrayList.add(e));
        System.out.println(flipKartArrayList);

        /* Streams can used for limited number of items
         * Debugging is not possible with streams
         * Performance is lower than typical for loops
         * Streams are applicable for ArrayList only
         */

    }
}

