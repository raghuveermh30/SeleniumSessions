package calenderhandling;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLabsStream {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Capture All the Prices of the Products
        List<WebElement> pricesList = driver.findElements(By.xpath("//div[@class = 'inventory_item_price']"));

        //pricesList.stream().forEach(ele -> System.out.println(ele.getText()));
        List<Double> prices_desc = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        prices_desc.forEach(price -> System.out.println(price));

        System.out.println("**********************");
        System.out.println("Maximum Price " + prices_desc.get(0));
        System.out.println("Maximum Price " + prices_desc.get(prices_desc.size() - 1));

        System.out.println("**********************");
        double firstPrice = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).findFirst().get();
        System.out.println("First Price: " + firstPrice);

        System.out.println("**********************");
        double lastPrice = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).reduce((first, second) -> second).get();
        System.out.println("Last Price: " + lastPrice);

        System.out.println("**********************");
        double maximumPrice = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).max(Double::compareTo).get();
        System.out.println("Maximum Price " + maximumPrice);

        System.out.println("**********************");
        double minPrice = pricesList.stream().map(e -> Double.parseDouble(e.getText().substring(1))).min(Double::compareTo).get();
        System.out.println("Minimum Price " + minPrice);

        driver.navigate().to("https://demo.guru99.com/test/web-table-element.php");

        List<WebElement> currentPriceList = driver.findElements(By.xpath("//table[@class = 'dataTable']//tr//td[4]"));
        double maxStockPrice = currentPriceList.stream().map(e -> Double.parseDouble(e.getText())).max(Double::compareTo).get();
        System.out.println("Maximum Stock Price : " + maxStockPrice);


    }

}
