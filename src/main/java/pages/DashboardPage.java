package pages;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUIs.DashboardPageUI;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver){
        super(driver); // truyền driver lên BasePage
    }

    public boolean verifyNavigateToDashboard(){
        return isElementEnabled(DashboardPageUI.btnMyAccount);
    }
}

