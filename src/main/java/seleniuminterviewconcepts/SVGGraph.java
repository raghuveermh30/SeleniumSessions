package seleniuminterviewconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SVGGraph {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.worldometers.info/coronavirus/country/india/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Wait for the second SVG (Highcharts graph) to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement svgContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[2]")));

            // Scroll SVG into viewport to ensure it’s interactable
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", svgContainer);

            // Get SVG dimensions for calculating hover offsets
            int svgWidth = svgContainer.getSize().getWidth();
            int svgHeight = svgContainer.getSize().getHeight();
            System.out.println("SVG dimensions: width=" + svgWidth + ", height=" + svgHeight);

            // Initialize Actions for mouse hover simulation
            Actions actions = new Actions(driver);
            List<String> tooltips = new ArrayList<>();

            // Hover across SVG in small increments (svgWidth / 20) to trigger tooltips
            // x-offsets start at svgWidth / 20, increment by svgWidth / 20
            // y-offset is 0 (middle of SVG) to align with data points
            // Adjust increment (e.g., svgWidth / 50) for denser graphs to capture more tooltips
            for (int x = svgWidth / 20; x < svgWidth; x += svgWidth / 20) {
                try {
                    // Hover at calculated x-offset, pause 500ms for tooltip to render
                    // Increase pause to 1000ms if tooltips are missed
                    actions.moveToElement(svgContainer, x - (svgWidth / 2), 0)
                            .pause(500)
                            .perform();

                    // Wait for tooltip to appear
                    WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[local-name()='g' and contains(@class, 'highcharts-tooltip')]//*[local-name()='text']")));

                    String tooltipText = tooltip.getText();
                    if (!tooltipText.isEmpty() && !tooltips.contains(tooltipText)) {
                        tooltips.add(tooltipText);
                        System.out.println("Tooltip: " + tooltipText);
                    }
                } catch (Exception e) {
                    System.out.println("No tooltip at x=" + x + ": " + e.getMessage());
                }
            }

            System.out.println("\nCollected Tooltips:");
            for (String tooltip : tooltips) {
                System.out.println(tooltip);
            }
        } finally {
            driver.quit();
        }
    }
}

/*
Notes
Tooltip Format:
Tooltips are expected to show a date and case count (e.g., "Mar 15, 2020\n100 cases"). The exact format depends on the Highcharts graph.

XPath for Tooltip:
The XPath //*[local-name()='g' and contains(@class, 'highcharts-tooltip')]//*[local-name()='text'] targets SVG tooltips.
If the tooltip is an HTML element, you may need to adjust to By.cssSelector(".highcharts-tooltip").

Increment Tuning:
The svgWidth / 20 increment may need adjustment (e.g., svgWidth / 50) to capture all data points if some tooltips are missed.

Debugging: If no tooltips appear, manually hover over the graph in Chrome Developer Tools (F12) to inspect the tooltip’s structure and adjust the XPath.
 */
