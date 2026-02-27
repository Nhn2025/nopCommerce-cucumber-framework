package stepDefinitions;

import commons.ConfigReader;
import commons.DriverFactory;
import commons.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
    public void attachScreenshot(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
    }

    @After(order = 0)
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
