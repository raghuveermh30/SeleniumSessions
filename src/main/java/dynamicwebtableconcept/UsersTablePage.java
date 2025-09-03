package dynamicwebtableconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.ArrayList;

/**
 * Page Object for Users Table on SelectorsHub Practice Page
 */
public class UsersTablePage {

    private final WebDriver driver;

    // Table locators
    @FindBy(xpath = "//table[@id='resultTable']")
    private WebElement usersTable;

    @FindBy(xpath = "//table[@id='resultTable']//thead//th")
    private List<WebElement> tableHeaders;

    @FindBy(xpath = "//table[@id='resultTable']//tbody//tr")
    private List<WebElement> tableRows;

    // Constructor
    public UsersTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Get all table headers
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
     * @return Number of rows
     */
    public int getRowCount() {
        return tableRows.size();
    }

    /**
     * Get specific cell data by row and column index
     * @param rowIndex Row number (1-based)
     * @param columnIndex Column number (1-based)
     * @return Cell text
     */
    public String getCellData(int rowIndex, int columnIndex) {
        String xpath = String.format("//table[@id='resultTable']//tbody//tr[%d]//td[%d]",
                rowIndex, columnIndex);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    /**
     * Get entire row data
     * @param rowIndex Row number (1-based)
     * @return List of cell values in the row
     */
    public List<String> getRowData(int rowIndex) {
        List<String> rowData = new ArrayList<>();
        String xpath = String.format("//table[@id='resultTable']//tbody//tr[%d]//td", rowIndex);
        List<WebElement> cells = driver.findElements(By.xpath(xpath));

        for (WebElement cell : cells) {
            rowData.add(cell.getText());
        }
        return rowData;
    }

    /**
     * Get all data from a specific column
     * @param columnIndex Column number (1-based)
     * @return List of values from the column
     */
    public List<String> getColumnData(int columnIndex) {
        List<String> columnData = new ArrayList<>();
        String xpath = String.format("//table[@id='resultTable']//tbody//tr//td[%d]",
                columnIndex);
        List<WebElement> cells = driver.findElements(By.xpath(xpath));

        for (WebElement cell : cells) {
            columnData.add(cell.getText());
        }
        return columnData;
    }

    /**
     * Get employee name by row index
     * @param rowIndex Row number (1-based)
     * @return Employee name
     */
    public String getEmployeeName(int rowIndex) {
        return getCellData(rowIndex, 2); // Employee Name is column 2
    }

    /**
     * Get user role by row index
     * @param rowIndex Row number (1-based)
     * @return User role
     */
    public String getUserRole(int rowIndex) {
        return getCellData(rowIndex, 1); // User Role is column 1
    }

    /**
     * Get status by row index
     * @param rowIndex Row number (1-based)
     * @return Status
     */
    public String getStatus(int rowIndex) {
        return getCellData(rowIndex, 3); // Status is column 3
    }

    /**
     * Click on a specific cell
     * @param rowIndex Row number (1-based)
     * @param columnIndex Column number (1-based)
     */
    public void clickOnCell(int rowIndex, int columnIndex) {
        String xpath = String.format("//table[@id='resultTable']//tbody//tr[%d]//td[%d]",
                rowIndex, columnIndex);
        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * Find row by employee name
     * @param employeeName Name to search for
     * @return Row index (1-based) or -1 if not found
     */
    //normalize-space() is an XPath function that removes leading and trailing whitespace and replaces multiple spaces between words with a single space.
    public int findRowByEmployeeName(String employeeName) {
        String xpath = String.format("//table[@id='resultTable']//tbody//tr[td[normalize-space()='%s']]",
                employeeName);
        List<WebElement> matchingRows = driver.findElements(By.xpath(xpath));

        if (matchingRows.isEmpty()) {
            return -1;
        }

        // Get the row index
        WebElement row = matchingRows.get(0);
        String rowXpath = "//table[@id='resultTable']//tbody//tr";
        List<WebElement> allRows = driver.findElements(By.xpath(rowXpath));

        for (int i = 0; i < allRows.size(); i++) {
            if (allRows.get(i).equals(row)) {
                return i + 1; // Return 1-based index
            }
        }
        return -1;
    }

    /**
     * Get all table data as a list of lists
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
     * @return true if table is visible
     */
    public boolean isTableDisplayed() {
        return usersTable.isDisplayed();
    }

    /**
     * Click on user link by row index
     * @param rowIndex Row number (1-based)
     */
    public void clickUserLink(int rowIndex) {
        String xpath = String.format("//table[@id='resultTable']//tbody//tr[%d]//td[2]//a",
                rowIndex);
        driver.findElement(By.xpath(xpath)).click();
    }
}