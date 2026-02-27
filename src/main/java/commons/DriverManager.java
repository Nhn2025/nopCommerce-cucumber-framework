package commons;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
        Log.info("Driver SET for Thread ID: " + Thread.currentThread().getId());
    }

    public static WebDriver getDriver() {
        WebDriver webDriver = driver.get();

        if (webDriver == null) {
            throw new RuntimeException(
                    "Driver is NULL for Thread ID: " + Thread.currentThread().getId() +
                            " Missing init @Before hook"
            );
        }

        return webDriver;
    }

    public static void quitDriver() {
        WebDriver webDriver = driver.get();

        if (webDriver != null) {
            Log.info("Driver QUIT for Thread ID: " + Thread.currentThread().getId());
            webDriver.quit();
            driver.remove();
        } else {
            Log.warn("Attempt to quit NULL driver for Thread ID: " + Thread.currentThread().getId());
        }
    }
}
