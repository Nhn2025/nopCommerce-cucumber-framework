package pages;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DashboardPageUI;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public boolean verifyNavigateToDashboard(){
        return isElementEnabled(DashboardPageUI.MY_ACCOUNT_BUTTON);
    }
}
