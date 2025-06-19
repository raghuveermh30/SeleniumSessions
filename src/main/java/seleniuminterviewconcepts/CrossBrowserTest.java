package seleniuminterviewconcepts;

public class CrossBrowserTest {

    public static void main(String[] args) {

        String browser = "chrome";

        if (browser.equals("chrome")) {
            System.out.println("Launch Chrome");
        } else if (browser.equals("firefox")) {
            System.out.println("Launch Firefox");
        } else if (browser.equals("safari")) {
            System.out.println("Launch Safari");
        } else if (browser.equals("edge")) {
            System.out.println("Launch Edge");
        } else {
            System.out.println("Please pass the correct browser");
            throw new RuntimeException("Invalid Browser");
        }
    }
}
