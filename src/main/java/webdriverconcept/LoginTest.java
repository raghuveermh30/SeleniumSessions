package webdriverconcept;

public class LoginTest {

    public static void main(String[] args) {

        BrowserUtil browserUtil = new BrowserUtil();
        browserUtil.initDriver("chrome");
        browserUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        String title = browserUtil.getTitle();
        if (title.equals("Account Login")) {
            System.out.println("Title is PASSED");
        } else {
            System.out.println("Title is Failed");
        }
        String pageUrl = browserUtil.getPageUrl();
        if (pageUrl.contains("route=account/login")) {
            System.out.println("Page URL is CORRECT");
        }
        browserUtil.closeBrowser();

    }
}
