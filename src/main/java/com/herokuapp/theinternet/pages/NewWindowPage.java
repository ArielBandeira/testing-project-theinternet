package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePageObject {

    By titleLocator = By.cssSelector("div.example > h3");

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public NewWindowPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get current window tab title
     * @return windowTitle
     */
    public String getCurrentWindowTitle() {
        log.info("Get current page tab title");
        return getCurrentPageTabTitle();
    }

    /**
     * Get current page url
     * @return currentUrl
     */
    public String getCurrentPageUrl() {
        log.info("Get current page url");
        return getCurrentUrl();
    }

    /**
     * Get page main title
     */
    public String getCurrentPageTitle() {
        log.info("Get page main title");
        return find(titleLocator).getText();
    }
}
