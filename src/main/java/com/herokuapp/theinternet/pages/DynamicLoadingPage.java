package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePageObject {

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public DynamicLoadingPage(WebDriver driver, Logger log) { super(driver, log); }

    /**
     * Go to 'Example' page
     * @param example
     * @param pageName
     */
    public void goToExamplePage(By example, String pageName) {
        log.info("Opening page: " + pageName);
        click(example);
    }

    /**
     * Get current page URL
     * @return currentUrl
     */
    public String getCurrentPageUrl() {
        log.info("Get current page URL");
        return getCurrentUrl();
    }

    /**
     * Verify if current page is the expected
     * @param current
     * @param expected
     * TODO this check can be done on base page and reused on many other test pages
     */
    public void verifyCurrentIsExpected(String current, String expected){
        String passes = "Current is the expected" + "\nCurrent: " + current + "\nExpected: " + expected + "\n";
        String fails = "Current is NOT the expected" + "\nCurrent: " + current + "\nExpected: " + expected + "\n";
        if(current.equals(expected)) {
            log.info(passes);
        }else {
            log.info(fails);
        }
    }

    /**
     * Click on 'Start' button
     * @param locator
     */
    public void clickStartButton(By locator) {
        log.info("Clicking on Start button");
        click(locator);
    }

    /**
     * Verify if 'Hello World!' is visible
     * @param text
     * @return visibleText
     */
    public String getText(By text) {
        log.info("Wait for text to be visible");
        waitForVisibilityOf(text);
        String visibleText = find(text).getText();
        log.info("Text visible: " + visibleText);
        return visibleText;
    }
}
