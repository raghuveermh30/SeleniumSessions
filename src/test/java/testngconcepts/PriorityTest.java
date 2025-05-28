package testngconcepts;

import org.testng.annotations.Test;

public class PriorityTest {

    @Test(priority = 4)
    public void a() {
        System.out.println("a Test");
    }

    @Test(priority = 3)
    public void b() {
        System.out.println("b Test");
    }

    @Test(priority = 0)
    public void c() {
        System.out.println("c Test");
    }

    @Test(priority = 1)
    public void d() {
        System.out.println("d Test");
    }

    @Test(priority = 2)
    public void e() {
        System.out.println("e Test");
    }

    @Test(priority = -1)
    public void f() {
        System.out.println("e Test");
    }

    @Test(priority = 6)
    public void g() {
        System.out.println("g Test");
    }

    @Test
    public void h() {
        System.out.println("h Test");
    }

    @Test
    public void i() {
        System.out.println("i Test");
    }

    /* If the priority is not mentioned, then by default it will take 0 as the priority.
     * Suppose if we give -ve priority, then it will be executed first.
     * If we give +ve priority, then it will be executed last.
     * First Non Priority test will be executed first and then the priority test will be executed.
     * Suppose if we give -ve priority, then it will be executed first, then No Priority test will be executed and then +ve priority test will be executed.
     */

    /* Priority of the test cases then it is called Anti-Pattern
     * Here We are defining the sequence of execution of the test cases using priority.
     * Test cases should be independent of each other. This is the main goal of the test case.
     * According to the AAA (Arrange, Act, Assert) principle, the test cases should be independent of each other.
     *
     */
}
