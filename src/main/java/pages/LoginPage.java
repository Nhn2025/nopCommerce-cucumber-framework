package pages;

import commons.BasePage;
import commons.ConfigReader;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void clickHeaderLogin(){
        clickToElement(LoginPageUI.HEADER_LOGIN_LINK);
    }

    public void openBaseUrl(){
        openPageUrl(ConfigReader.getBaseUrl());
    }

    public void login(String emailId, String email, String passId, String pass){
        sendKeyToElement(LoginPageUI.DYNAMIC_TEXTBOX_BY_ID, email, emailId);
        sendKeyToElement(LoginPageUI.DYNAMIC_TEXTBOX_BY_ID, pass, passId);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
    }
}
