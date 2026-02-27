package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver initDriver() {

        String browser = System.getProperty("browser", ConfigReader.getBrowser());
        Log.info("========== START BROWSER: " + browser + " ==========");

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(ffOptions);
                break;

            case "chrome-headless":
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("--headless=new");
                headlessOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(headlessOptions);
                break;

            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
        }

        configureTimeouts(driver);

        return driver;
    }

    private static void configureTimeouts(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }
}
