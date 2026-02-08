package pages;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void clickHeaderLogin(){
        clickToElement(LoginPageUI.btnHeaderLogin);
    }

    public void login(String email, String pass){
        sendKeyToElement(LoginPageUI.txtEmail, email);
        sendKeyToElement(LoginPageUI.txtPassword, pass);
        clickToElement(LoginPageUI.btnSubmitLogin);
    }
}
