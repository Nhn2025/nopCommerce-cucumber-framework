package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /* ================= GET WAIT ================= */

    protected WebDriverWait getWait(long timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected WebDriverWait getWait() {
        return getWait(GlobalConstants.LONG_TIMEOUT);
    }

    /* ================= PAGE LOAD ================= */

    public void waitForPageLoaded() {
        getWait(GlobalConstants.LONG_TIMEOUT).until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    /* ================= BROWSER ================= */

    public void openPageUrl(String url){
        Log.info("Open URL: " + url);
        driver.get(url);
        waitForPageLoaded();
    }

    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        Log.info("Current URL: " + url);
        return url;
    }

    public void waitForUrlContains(String value){
        Log.info("Wait for URL contains: " + value);
        getWait().until(ExpectedConditions.urlContains(value));
    }

    /* ================= ELEMENT CORE ================= */

    protected WebElement getElement(By locator){
        Log.info("Find element: " + locator);
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> getElements(By locator) {
        return getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void clickToElement(By locator){
        Log.info("Click to element: " + locator);
        int retry = 0;
        while(retry < 3){
            try{
                getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
                return;
            } catch(StaleElementReferenceException e){
                retry++;
                Log.warn("Retry click (" + retry + ") for: " + locator);
            }
        }
        throw new RuntimeException("Cannot click element: " + locator);
    }

    public void sendKeyToElement(By locator, String value){
        Log.info("Send key to element: " + locator + " | Value: " + value);
        WebElement element = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    /* ================= DROPDOWN ================= */

    public void selectItemInDropdown(By locator, String text){
        Log.info("Select dropdown: " + locator + " | Text: " + text);
        Select select = new Select(getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)));
        select.selectByVisibleText(text);
    }

    public String getSelectedItem(By locator){
        Select select = new Select(getElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    /* ================= CHECKBOX / RADIO ================= */

    public void checkToCheckbox(By locator){
        WebElement element = getElement(locator);
        if(!element.isSelected()) element.click();
    }

    public void uncheckCheckbox(By locator){
        WebElement element = getElement(locator);
        if(element.isSelected()) element.click();
    }

    /* ================= ACTIONS ================= */

    public void hoverToElement(By locator){
        new Actions(driver).moveToElement(getElement(locator)).perform();
    }

    public void doubleClick(By locator){
        new Actions(driver).doubleClick(getElement(locator)).perform();
    }

    public void rightClick(By locator){
        new Actions(driver).contextClick(getElement(locator)).perform();
    }

    /* ================= JAVASCRIPT ================= */

    public void clickByJS(By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getElement(locator));
    }

    public void scrollToElement(By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    /* ================= WAIT ================= */

    public void waitForElementInvisible(By locator){
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /* ================= VERIFY ================= */

    public boolean isElementDisplayed(By locator){
        try{
            return getElement(locator).isDisplayed();
        } catch(Exception e){
            return false;
        }
    }

    public boolean isElementEnabled(By locator){
        try{
            return getElement(locator).isEnabled();
        } catch(Exception e){
            return false;
        }
    }

    /* ================= DYNAMIC LOCATOR SUPPORT ================= */

    private By getByLocator(String locator, String... dynamicValues) {
        locator = String.format(locator, (Object[]) dynamicValues);

        if(locator.startsWith("id=")) return By.id(locator.replace("id=", ""));
        if(locator.startsWith("name=")) return By.name(locator.replace("name=", ""));
        if(locator.startsWith("css=")) return By.cssSelector(locator.replace("css=", ""));
        if(locator.startsWith("xpath=")) return By.xpath(locator.replace("xpath=", ""));
        if(locator.startsWith("class=")) return By.className(locator.replace("class=", ""));
        if(locator.startsWith("link=")) return By.linkText(locator.replace("link=", ""));
        if(locator.startsWith("partialLink=")) return By.partialLinkText(locator.replace("partialLink=", ""));
        if(locator.startsWith("tag=")) return By.tagName(locator.replace("tag=", ""));

        throw new RuntimeException("Locator type not supported");
    }

    public void clickToElement(String locator, String... values){
        clickToElement(getByLocator(locator, values));
    }

    public void sendKeyToElement(String locator, String value, String... values){
        sendKeyToElement(getByLocator(locator, values), value);
    }
}
