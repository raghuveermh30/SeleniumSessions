package dynamicwebtableconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Test examples demonstrating usage of Web Table Page Objects
 */
public class WebTableTest {

    private WebDriver driver;
    private UsersTablePage usersTablePage;
    private SystemDistributionTablePage systemTablePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");

        usersTablePage = new UsersTablePage(driver);
        systemTablePage = new SystemDistributionTablePage(driver);
    }

    @Test
    public void testUsersTableHeaders() {
        List<String> headers = usersTablePage.getTableHeaders();
        System.out.println("Users Table Headers: " + headers);
        Assert.assertTrue(headers.contains("User Role"));
        Assert.assertTrue(headers.contains("Employee Name"));
        Assert.assertTrue(headers.contains("Status"));
    }

    @Test
    public void testGetSpecificEmployeeData() {
        // Get data from row 1
        String employeeName = usersTablePage.getEmployeeName(1);
        String userRole = usersTablePage.getUserRole(1);
        String status = usersTablePage.getStatus(1);

        System.out.println("Employee Name: " + employeeName);
        System.out.println("User Role: " + userRole);
        System.out.println("Status: " + status);

        Assert.assertNotNull(employeeName);
    }

    @Test
    public void testFindEmployeeByName() {
        String searchName = "John.Smith";
        int rowIndex = usersTablePage.findRowByEmployeeName(searchName);

        if (rowIndex != -1) {
            System.out.println(searchName + " found at row: " + rowIndex);
            String role = usersTablePage.getUserRole(rowIndex);
            System.out.println("Role: " + role);
        } else {
            System.out.println(searchName + " not found in table");
        }
    }

    @Test
    public void testGetAllEmployeeNames() {
        List<String> employeeNames = usersTablePage.getColumnData(2);
        System.out.println("All Employee Names:");
        for (String name : employeeNames) {
            System.out.println("- " + name);
        }
        Assert.assertTrue(employeeNames.size() > 0);
    }

    @Test
    public void testSystemTableRowCount() {
        int rowCount = systemTablePage.getRowCount();
        System.out.println("System Distribution Table has " + rowCount + " rows");
        Assert.assertTrue(rowCount > 0);
    }

    @Test
    public void testGetSystemDetails() {
        // Get data from first row
        String os = systemTablePage.getOS(1);
        String browser = systemTablePage.getBrowser(1);
        String city = systemTablePage.getCity(1);
        String country = systemTablePage.getCountry(1);

        System.out.println("System Details (Row 1):");
        System.out.println("OS: " + os);
        System.out.println("Browser: " + browser);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
    }

    @Test
    public void testFindWindowsSystems() {
        List<Integer> windowsRows = systemTablePage.findRowsByOS("windows");
        System.out.println("Number of Windows systems: " + windowsRows.size());
        System.out.println("Found at rows: " + windowsRows);
    }

    @Test
    public void testFindIndianSystems() {
        List<Integer> indiaRows = systemTablePage.findRowsByCountry("India");
        System.out.println("Number of systems from India: " + indiaRows.size());
    }

    @Test
    public void testFindSystemsByMultipleCriteria() {
        // Find all Windows systems using Chrome browser from India
        List<Integer> matchingRows = systemTablePage.findRowsByCriteria(
                "windows",
                "chrome",
                null,
                "India"
        );

        System.out.println("Windows + Chrome + India systems: " + matchingRows.size());
        System.out.println("Found at rows: " + matchingRows);
    }

    @Test
    public void testCountBrowsers() {
        int chromeCount = systemTablePage.countValueInColumn(2, "chrome");
        int edgeCount = systemTablePage.countValueInColumn(2, "Edge");
        int firefoxCount = systemTablePage.countValueInColumn(2, "firefox");

        System.out.println("Chrome: " + chromeCount);
        System.out.println("Edge: " + edgeCount);
        System.out.println("Firefox: " + firefoxCount);
    }

    @Test
    public void testGetUniqueCountries() {
        List<String> uniqueCountries = systemTablePage.getUniqueValuesFromColumn(4);
        System.out.println("Unique Countries: " + uniqueCountries);
        System.out.println("Total unique countries: " + uniqueCountries.size());
    }

    @Test
    public void testGetRowAsMap() {
        Map<String, String> rowData = systemTablePage.getRowDataAsMap(1);
        System.out.println("Row 1 as Map:");
        for (Map.Entry<String, String> entry : rowData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void testPrintAllUsersData() {
        System.out.println("All Users Table Data:");
        List<List<String>> allData = usersTablePage.getAllTableData();

        for (int i = 0; i < allData.size(); i++) {
            System.out.println("Row " + (i + 1) + ": " + allData.get(i));
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}