package pageUIs;

import org.openqa.selenium.By;

public class LoginPageUI {
    // Textboxes
    public static final String DYNAMIC_TEXTBOX_BY_ID = "css=input[id='%s']";

    // Buttons
    public static final By LOGIN_BUTTON = By.cssSelector("input#login-button");
}