package seleniuminterviewconcepts;

import org.testng.annotations.Test;

public class AmazonTest {

    @Test
    public  void addToCart(){
        System.out.println("Add To Cart Test");
        int i = 9/0;
    }

    @Test(enabled = true, alwaysRun = true, dependsOnMethods = "addToCart")
    public  void paymentTest(){
        System.out.println("Payment Test"); //this test case will not execute in this case -->  @Test(enabled = false, alwaysRun = true)
    }

    //alwaysRun -> if we add this keyword in the method, then it will always execute even dependsOnMethod function has failed


}
