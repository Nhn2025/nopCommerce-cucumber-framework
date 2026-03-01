package pages;

import commons.BasePage;
import commons.ConfigReader;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void openBaseUrl() {
        String baseUrl = ConfigReader.getBaseUrl();
        driver.get(baseUrl);
    }

    public void login(String usernameId, String username, String passId, String pass){
        sendKeyToElement(LoginPageUI.DYNAMIC_TEXTBOX_BY_ID, username, usernameId);
        sendKeyToElement(LoginPageUI.DYNAMIC_TEXTBOX_BY_ID, pass, passId);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
    }
}
