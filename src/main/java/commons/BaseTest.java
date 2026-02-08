package commons;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get(ConfigReader.getBaseUrl());
    }

    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
