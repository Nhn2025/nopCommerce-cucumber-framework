package stepDefinitions;

import commons.ConfigReader;
import commons.DriverFactory;
import commons.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before(order = 0)
    public void initDriver() {
        DriverManager.setDriver(DriverFactory.initDriver());
    }

    @Before(order = 1)
    public void openBaseUrl() {
        DriverManager.getDriver().get(ConfigReader.getBaseUrl());
    }

    @After(order = 1)
    public void attachScreenshot(Scenario scenario) {

        WebDriver driver = DriverManager.getDriver();

        if (scenario.isFailed() && driver != null) {

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
    }

    @After(order = 0)
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
