package testngconcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGClass {

    //TestNg method will never return anything. It will always be void
    //We never use main method in TestNG
    //@Test method is the entry point for TestNG

    @Test
    public void addMethod() {
        System.out.println("Addition method");
        int a = 10;
        int b = 20;
        int sum = a + b;
        Assert.assertEquals(sum, 30, "Sum is not matching, both are not equal");
    }

    @Test
    public void subMethod() {
        System.out.println("Subtraction method");
        int a = 20;
        int b = 10;
        int sub = a - b;
        Assert.assertEquals(sub, 10, "Subtraction is not matching, both are not equal");
    }

    @Test
    public void mulMethod() {
        System.out.println("Multiplication method");
        int a = 10;
        int b = 20;
        int mul = a * b;
        Assert.assertEquals(mul, 200, "Multiplication is not matching, both are not equal");
    }

    @Test
    public void divMethod() {
        System.out.println("Division method");
        int a = 20;
        int b = 10;
        int div = a / b;
        Assert.assertEquals(div, 2, "Division is not matching, both are not equal");
    }


}
