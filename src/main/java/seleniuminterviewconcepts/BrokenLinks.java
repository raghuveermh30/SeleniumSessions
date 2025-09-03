package seleniuminterviewconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links are : " + links.size());

        List<String> urlList = new ArrayList<>();

        for (WebElement element : links) {
            String url = element.getDomAttribute("href");

            urlList.add(url);
        }

        long startTime = System.currentTimeMillis();
        urlList.parallelStream().forEach(e -> brokenLink(e));
        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken in Parallel Stream " + (endTime - startTime));

        System.out.println("**************");

        startTime = System.currentTimeMillis();
        urlList.stream().forEach(e -> brokenLink(e));
        endTime = System.currentTimeMillis();

        System.out.println("Total time taken in Sequential Stream " + (endTime - startTime));


        driver.quit();
    }

    public static void brokenLink(String linkUrl) {
        try {

            URL url = new URL(linkUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.connect();
            if (urlConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + "--->" + urlConnection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + "--->" + urlConnection.getResponseMessage());
            }

        } catch (Exception e) {

        }
    }
}
