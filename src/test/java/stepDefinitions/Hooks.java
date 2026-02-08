package stepDefinitions;

import commons.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeScenario(){
        driver = DriverFactory.getDriver("chrome");
    }

    @After
    public void afterScenario(){
        driver.quit();
    }
}
