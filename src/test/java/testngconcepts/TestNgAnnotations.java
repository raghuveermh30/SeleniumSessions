package testngconcepts;

import org.testng.annotations.*;

public class TestNgAnnotations {

    //TestNG Annotations
    // Annotations are inbuilt in TestNG framework.
    //1. @BeforeSuite
    //2. @BeforeTest
    //3. @BeforeClass
    //4. @BeforeMethod
    //5. @Test
    //6. @AfterMethod
    //7. @AfterClass
    //8. @AfterTest
    //9. @AfterSuite

    //We can use any number of annotations in the class, but we need to follow the order of execution.

    //Global Pre-Condition
    //Pre Condition
    //Test Cases: Test Steps --> Actual vs Expected result
    //Post Condition
    //Post Steps
    //Global Post-Condition

    //Before Annotations --> Test Annotation --> After Annotations
    //Its not mandatory to use all the annotations on each test cases, It depends on the requirement and use cases

    //1
    @BeforeSuite
    public void connectToDB() {
        System.out.println("BeforeSuite - Connect to DB");
    }

    //2
    @BeforeTest
    public void createUser() {
        System.out.println("BeforeTest - Create User");
    }

    //3
    @BeforeClass
    public void launchBrowser() {
        System.out.println("BeforeClass - Launch Browser");
    }

    //4 --> BeforeMethod says that before every test method, this method will be executed
    //It will pick the alphabetical order of the test method
    //7
    //10
    @BeforeMethod
    public void LoginToApp() {
        System.out.println("BeforeMethod - Login to Application");
    }

    //8
    @Test
    public void titleTest() {
        System.out.println("Title Test");
    }

    //11
    @Test
    public void urlTest() {
        System.out.println("URL Test");
    }

    //5
    @Test
    public void searchTest() {
        System.out.println("Search Test");
    }

    //6 --> AfterMethod says that after every test method, this method will be executed
    //9
    //13
    @AfterMethod
    public void logout() {
        System.out.println("AfterMethod - Logout from Application");
    }

    //14
    @AfterClass
    public void closeBrowser() {
        System.out.println("AfterClass - Close Browser");
    }

    //15
    @AfterTest
    public void deleteUser() {
        System.out.println("AfterTest - Delete User");
    }

    //16
    @AfterSuite
    public void disconnectDB() {
        System.out.println("AfterSuite - Disconnect from DB");
    }

    /*  BeforeSuite - Connect to DB
BeforeTest - Create User
BeforeClass - Launch Browser

    BeforeMethod - Login to Application (Test1)
    Search Test
    AfterMethod - Logout from Application

    BeforeMethod - Login to Application (Test2)
    Title Test
    AfterMethod - Logout from Application

    BeforeMethod - Login to Application (Test3)
    URL Test
    AfterMethod - Logout from Application

AfterClass - Close Browser
AfterTest - Delete User
AfterSuite - Disconnect from DB
     */
}
