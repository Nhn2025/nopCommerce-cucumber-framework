package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver initDriver() {

        String browser = System.getProperty("browser", ConfigReader.getBrowser());
        String ci = System.getenv("CI"); // GitHub Actions có biến này

        Log.info("========== START BROWSER: " + browser + " ==========");

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "firefox":
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions ffOptions = new FirefoxOptions();

                if (ci != null) { // 🔥 chạy trên CI
                    ffOptions.addArguments("--headless");
                    ffOptions.addArguments("--width=1920");
                    ffOptions.addArguments("--height=1080");
                } else { // chạy local
                    ffOptions.addArguments("--start-maximized");
                }

                driver = new FirefoxDriver(ffOptions);
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();

                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("--headless=new");
                headlessOptions.addArguments("--window-size=1920,1080");
                headlessOptions.addArguments("--no-sandbox");
                headlessOptions.addArguments("--disable-dev-shm-usage");

                driver = new ChromeDriver(headlessOptions);
                break;

            default:
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                if (ci != null) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                } else {
                    options.addArguments("--start-maximized");
                }

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