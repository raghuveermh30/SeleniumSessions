package dynamicwebtableconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Page Object for System Distribution Details Table on SelectorsHub Practice Page
 */
public class SystemDistributionTablePage {

    private WebDriver driver;

    // Table locators
    @FindBy(xpath = "//table[@id='tablepress-1']")
    private WebElement systemDistributionTable;

    @FindBy(xpath = "//table[@id='tablepress-1']//thead//th")
    private List<WebElement> tableHeaders;

    @FindBy(xpath = "//table[@id='tablepress-1']//tbody//tr")
    private List<WebElement> tableRows;

    // Constructor
    public SystemDistributionTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Get all table headers
     *
     * @return List of header text
     */
    public List<String> getTableHeaders() {
        List<String> headers = new ArrayList<>();
        for (WebElement header : tableHeaders) {
            headers.add(header.getText());
        }
        return headers;
    }

    /**
     * Get total number of rows in the table
     *
     * @return Number of rows
     */
    public int getRowCount() {
        return tableRows.size();
    }

    /**
     * Get specific cell data by row and column index
     *
     * @param rowIndex    Row number (1-based)
     * @param columnIndex Column number (1-based)
     * @return Cell text
     */
    public String getCellData(int rowIndex, int columnIndex) {
        String xpath = String.format("//table[@id='tablepress-1']//tbody//tr[%d]//td[%d]",
                rowIndex, columnIndex);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    /**
     * Get entire row data
     *
     * @param rowIndex Row number (1-based)
     * @return List of cell values in the row
     */
    public List<String> getRowData(int rowIndex) {
        List<String> rowData = new ArrayList<>();
        String xpath = String.format("//table[@id='tablepress-1']//tbody//tr[%d]//td", rowIndex);
        List<WebElement> cells = driver.findElements(By.xpath(xpath));

        for (WebElement cell : cells) {
            rowData.add(cell.getText());
        }
        return rowData;
    }

    /**
     * Get row data as a map with column names as keys
     *
     * @param rowIndex Row number (1-based)
     * @return Map of column name to cell value
     */
    public Map<String, String> getRowDataAsMap(int rowIndex) {
        Map<String, String> rowMap = new HashMap<>();
        List<String> headers = getTableHeaders();
        List<String> rowData = getRowData(rowIndex);

        for (int i = 0; i < headers.size() && i < rowData.size(); i++) {
            rowMap.put(headers.get(i), rowData.get(i));
        }
        return rowMap;
    }

    /**
     * Get all data from a specific column
     *
     * @param columnIndex Column number (1-based)
     * @return List of values from the column
     */
    public List<String> getColumnData(int columnIndex) {
        List<String> columnData = new ArrayList<>();
        String xpath = String.format("//table[@id='tablepress-1']//tbody//tr//td[%d]",
                columnIndex);
        List<WebElement> cells = driver.findElements(By.xpath(xpath));

        for (WebElement cell : cells) {
            columnData.add(cell.getText());
        }
        return columnData;
    }

    /**
     * Get OS by row index
     *
     * @param rowIndex Row number (1-based)
     * @return OS name
     */
    public String getOS(int rowIndex) {
        return getCellData(rowIndex, 1); // OS is column 1
    }

    /**
     * Get Browser by row index
     *
     * @param rowIndex Row number (1-based)
     * @return Browser name
     */
    public String getBrowser(int rowIndex) {
        return getCellData(rowIndex, 2); // Browser is column 2
    }

    /**
     * Get City by row index
     *
     * @param rowIndex Row number (1-based)
     * @return City name
     */
    public String getCity(int rowIndex) {
        return getCellData(rowIndex, 3); // City is column 3
    }

    /**
     * Get Country by row index
     *
     * @param rowIndex Row number (1-based)
     * @return Country name
     */
    public String getCountry(int rowIndex) {
        return getCellData(rowIndex, 4); // Country is column 4
    }

    /**
     * Find all rows matching a specific OS
     *
     * @param osName Operating System name
     * @return List of row indices (1-based)
     */
    public List<Integer> findRowsByOS(String osName) {
        List<Integer> matchingRows = new ArrayList<>();
        String xpath = String.format("//table[@id='tablepress-1']//tbody//tr[td[1][normalize-space()='%s']]",
                osName);
        List<WebElement> rows = driver.findElements(By.xpath(xpath));

        for (WebElement row : rows) {
            List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='tablepress-1']//tbody//tr"));
            for (int i = 0; i < allRows.size(); i++) {
                if (allRows.get(i).equals(row)) {
                    matchingRows.add(i + 1);
                    break;
                }
            }
        }
        return matchingRows;
    }

    /**
     * Find all rows matching a specific country
     *
     * @param country Country name
     * @return List of row indices (1-based)
     */
    public List<Integer> findRowsByCountry(String country) {
        List<Integer> matchingRows = new ArrayList<>();
        String xpath = String.format("//table[@id='tablepress-1']//tbody//tr[td[4][normalize-space()='%s']]",
                country);
        List<WebElement> rows = driver.findElements(By.xpath(xpath));

        for (WebElement row : rows) {
            List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='tablepress-1']//tbody//tr"));
            for (int i = 0; i < allRows.size(); i++) {
                if (allRows.get(i).equals(row)) {
                    matchingRows.add(i + 1);
                    break;
                }
            }
        }
        return matchingRows;
    }

    /**
     * Find rows matching multiple criteria
     *
     * @param os      Operating System (null to ignore)
     * @param browser Browser name (null to ignore)
     * @param city    City name (null to ignore)
     * @param country Country name (null to ignore)
     * @return List of row indices matching criteria
     */
    public List<Integer> findRowsByCriteria(String os, String browser, String city, String country) {
        List<Integer> matchingRows = new ArrayList<>();

        for (int i = 1; i <= getRowCount(); i++) {
            boolean matches = true;

            if (os != null && !getOS(i).equalsIgnoreCase(os)) {
                matches = false;
            }
            if (browser != null && !getBrowser(i).equalsIgnoreCase(browser)) {
                matches = false;
            }
            if (city != null && !getCity(i).equalsIgnoreCase(city)) {
                matches = false;
            }
            if (country != null && !getCountry(i).equalsIgnoreCase(country)) {
                matches = false;
            }

            if (matches) {
                matchingRows.add(i);
            }
        }
        return matchingRows;
    }

    /**
     * Count occurrences of a specific value in a column
     *
     * @param columnIndex Column number (1-based)
     * @param value       Value to count
     * @return Number of occurrences
     */
    public int countValueInColumn(int columnIndex, String value) {
        int count = 0;
        List<String> columnData = getColumnData(columnIndex);

        for (String cellValue : columnData) {
            if (cellValue.equalsIgnoreCase(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get unique values from a column
     *
     * @param columnIndex Column number (1-based)
     * @return List of unique values
     */
    public List<String> getUniqueValuesFromColumn(int columnIndex) {
        List<String> uniqueValues = new ArrayList<>();
        List<String> columnData = getColumnData(columnIndex);

        for (String value : columnData) {
            if (!uniqueValues.contains(value)) {
                uniqueValues.add(value);
            }
        }
        return uniqueValues;
    }

    /**
     * Get all table data as a list of lists
     *
     * @return All table data
     */
    public List<List<String>> getAllTableData() {
        List<List<String>> allData = new ArrayList<>();

        for (int i = 1; i <= getRowCount(); i++) {
            allData.add(getRowData(i));
        }
        return allData;
    }

    /**
     * Check if table is displayed
     *
     * @return true if table is visible
     */
    public boolean isTableDisplayed() {
        return systemDistributionTable.isDisplayed();
    }

    /**
     * Click on a specific cell
     *
     * @param rowIndex    Row number (1-based)
     * @param columnIndex Column number (1-based)
     */
    public void clickOnCell(int rowIndex, int columnIndex) {
        String xpath = String.format("//table[@id='tablepress-1']//tbody//tr[%d]//td[%d]",
                rowIndex, columnIndex);
        driver.findElement(By.xpath(xpath)).click();
    }
}