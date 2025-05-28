package testngconcepts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CRUDTest {

    // Create
    // Read
    // Update
    // Delete

    // Create - POST
    // Read - GET
    // Update - PUT/PATCH
    // Delete - DELETE

    // CRUD operations are used in API Testing.
    // CRUD operations are used in Database Testing.

    // Create USER --> Get USER --> Update USER --> Delete USER

    public int createUser() {
        System.out.println("Create User");
        return 100;
    }

    public String getUserInfo(int userId) {
        return "Get User Info for User ID: ";
    }


    @Test
    public void createUserTest() {
        int userId = createUser();
        Assert.assertEquals(userId, 100);
    }

    /* AAA --> Arrange --> Act --> Assert
     * Arrange --> Create the User
     * Act --> Get the User Info
     * Assert --> Validate the User Info
     * This is the best practice to write the test cases.
     * This single test case should have only one assertion. This is the rule.
     * This will be applicable for UI and Backend automation
     * Single test case shouldn;t have multiple assertions. It is the violation of AAA pattern.
     * This will be applicable for Parallel execution. It won;t cause any issues.
     */

    @Test
    public void getUserTest() {
        //I want to get the user using ID

        //Create the User --> Get the User Id -->  Get the User Info -> getUserTest(userId)
        int userId = createUser();
        Assert.assertEquals(userId, 100);
        String userInfo = getUserInfo(userId);
        Assert.assertEquals(userInfo, "Get User Info for User ID: ");
    }

    public String updateUserInfo(int userId) {
        return "Update User Info";

    }

    @Test
    public void updateUserTest() {

        //Create the User --> Get the User Id -->  Get the User Info -> getUserTest(userId) --> Update the User Info --> updateUserTest(userId) --> getUserInfo(userId)
        int userId = createUser();
        Assert.assertEquals(userId, 100);
        String userInfo = getUserInfo(userId);
        Assert.assertEquals(userInfo, "Get User Info for User ID: ");

        //Update the User Info
        String updatedUserId = updateUserInfo(userId);
        String updatedUserInfo = getUserInfo(userId);
        Assert.assertEquals(updatedUserId, "Update User Info");

    }

    public String deleteUserInfo(int userId) {
        return "User is deleted, User is not available";

    }

    @Test
    public void deleteUserTest() {
        //I want to get the user using ID

        //Create the User --> Get the User Id -->  Get the User Info -> getUserTest(userId) --> Delete the User --> deleteUserTest(userId) --> getUserInfo(userId)
        int userId = createUser();
        Assert.assertEquals(userId, 100);
        String userInfo = getUserInfo(userId);
        Assert.assertEquals(userInfo, "Get User Info for User ID: ");
        String deleteUserInfo = deleteUserInfo(userId);
        Assert.assertEquals(deleteUserInfo, "User is deleted, User is not available");

    }


}
