package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public void openPageUrl(String url){
        driver.get(url);
    }

    public void clickToElement(By locator){
        waitForElementClickable(locator);
        getElement(locator).click();
    }

    public void sendKeyToElement(By locator, String value){
        waitForElementVisible(locator);
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }

    private void waitForElementVisible(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForElementClickable(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementEnabled(By locator){
        return driver.findElement(locator).isEnabled();
    }
}
