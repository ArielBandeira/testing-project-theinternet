package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.TestListener;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

@Listeners({ TestListener.class })
public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /**
     * Open page with given URL
     * @param url
     */
    protected void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Read page url
     * @return currentURL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Read page title
     * @return pageTitle
     */
    public String getCurrentPageTabTitle() {
        return driver.getTitle();
    }

    /**
     * Type text
     * @param text
     * @param locator
     */
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
    }

    /**
     * Press key on locator
     * @param locator
     * @param key
     */
    public void pressKey(By locator, Keys key) {
        find(locator).sendKeys(key);
    }

    /**
     * Find list of elements
     * @param locator
     * @return list of elements
     */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Find element
     * @param locator
     * @return element
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Click on element
     * @param locator
     */
    protected void click(By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     * @param condition
     * @param timeOut
     */
    protected void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible on page
     * @param locator
     * @param timeOut
     */
    protected void waitForVisibilityOf(By locator, Duration ... timeOut) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOut.length > 0 ? timeOut[0] : null));
                break;
            } catch (StaleElementReferenceException e) {}
            attempts++;
        }
    }

    /**
     * Switch focus to new windows with given title
     * @param windowTitle
     */
    protected void switchToWindowWithTitle(String windowTitle) {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //Wait for the new window or tab
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //Wait for the new tab to finish loading content
        wait.until(titleIs(windowTitle));
    }

    public Boolean verifyCurrentPageUrlIsExpected(String expectedPageUrl) {
        return getCurrentUrl().contains(expectedPageUrl);
    }
}
