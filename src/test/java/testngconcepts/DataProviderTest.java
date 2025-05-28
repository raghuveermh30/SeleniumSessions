package testngconcepts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    //getData --> this will help in get the data in the test cases
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {4, 5, 9},
                {10, 20, 30},
                {100, 200, 300},
                {1000, 2000, 3000}
        };
    }

    //add --> this will help in adding the two numbers
    //This is the functional method which will be used in the test case
    public int add(int num1, int num2) {
        int sum;
        return sum = num1 + num2;
    }

    //This is the test case which will be executed
    //Running the test cases with different data sets --> Data Driven Approach: Parameterization
    @Test(dataProvider = "getData")
    public void testAdd(int num1, int num2, int expectedSum) {
        int actualSum = add(num1, num2);
        Assert.assertEquals(actualSum, expectedSum, "The sum is not matching");
    }

    /* org.testng.internal.reflect.MethodMatcherException:
[public void testngconcepts.DataProviderTest.testAdd(int,int,int,int)] has no parameters defined but was found to be using a data provider (either explicitly specified or inherited from class level annotation).
Data provider mismatch
Method: testAdd([int arg0, int arg1, int arg2, int arg3])
Arguments: [(java.lang.Integer) 4,(java.lang.Integer) 5,(java.lang.Integer) 9]
     *
     */

    //Data Driven and Keyword Driven is the approaches, these are not Frameworks
}
