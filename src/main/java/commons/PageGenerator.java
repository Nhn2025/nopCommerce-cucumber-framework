package commons;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.DashboardPage;

public class PageGenerator {

    public static LoginPage getLoginPage(WebDriver driver){
        return new LoginPage(driver);
    }

    public static DashboardPage getDashboardPage(WebDriver driver){
        return new DashboardPage(driver);
    }
}
