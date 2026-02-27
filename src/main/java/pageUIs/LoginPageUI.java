package pageUIs;

import org.openqa.selenium.By;

public class LoginPageUI {

    // Header
    public static final By HEADER_LOGIN_LINK = By.cssSelector("a.ico-login");

    // Textboxes
    public static final String DYNAMIC_TEXTBOX_BY_ID = "css=input[id='%s']";

    // Buttons
    public static final By LOGIN_BUTTON = By.cssSelector("button.login-button");
}