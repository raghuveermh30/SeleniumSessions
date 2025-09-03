package waitconcepts;

public class SeleniumWaitConcepts {

    public static void main(String[] args) {

        //1. Static Wait: Thread.sleep(5000);
        // This is a static wait, it will wait for 5 seconds at any condition. Even if the element is present in 1 second, it will wait for 5 seconds.
        // It is coming from Java, not from Selenium.

        //2. Dynamic Wait: 10 seconds --> Element to be present at 2 seconds --> rest of the 8 seconds will be ignored
        //a. implicitly wait
        //b. explicitly wait --> Explicit wait is divided into 2 types:
            //b1. WebDriverWait
            //b2. FluentWait



    }
}
