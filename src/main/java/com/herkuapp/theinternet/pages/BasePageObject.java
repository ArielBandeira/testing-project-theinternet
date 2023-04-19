package com.herkuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.List;

@Listeners({ com.herkuapp.theinternet.base.TestListener.class })
public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //Open page with given URL
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Read page url
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //Read page title
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    //Type text
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
    }

    //Press key on locator
    public void pressKey(By locator, Keys key) {
        find(locator).sendKeys(key);
    }

    //Find list of elements
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    //Find element
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    //Click on element
    protected void click(By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    //Wait for specific ExpectedCondition for the given amount of time in seconds
    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    //Wait for given number of seconds for element with given locator to be visible on page
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

}
