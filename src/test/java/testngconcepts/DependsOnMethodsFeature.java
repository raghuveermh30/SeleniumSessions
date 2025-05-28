package testngconcepts;

import org.testng.annotations.Test;

public class DependsOnMethodsFeature {

    @Test
    public void loginTest() {
        System.out.println("login Test");
        int i =9/3;
    }

    @Test(dependsOnMethods = "loginTest")
    public void homeTest() {
        System.out.println("home Test");
    }

    @Test(dependsOnMethods = "homeTest")
    public void cartTest() {
        System.out.println("cart Test");
    }

    /* Suppose, LoginTest is failed then HomeTest will not be executed. It wil skip the Particular Test.
     * If HomeTest is Passed then CartTest will be executed.
     */

    /* Dependency we will never use in the real time. It is violation of AAA Pattern
     * If the first thread is picking second test case in the execution, then it will fail. Bcz this thread has no idea on the dependency.
     * It will create the DeadLock condition.
     * Here parallel execution is not possible.
     * According to the AAA pattern, we will not use the dependency. Test cases should be independent of each other.
     */
}
