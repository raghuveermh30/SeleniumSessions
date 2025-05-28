package testngconcepts;

import org.testng.annotations.Test;

public class InvocationCountFeature {

    @Test(invocationCount = 10)
    public void createUser() {
        System.out.println("Create User");
    }
}
