package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePageObject {

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public NewWindowPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get current window title
     * @return windowTitle
     */
    public String getCurrentWindowTitle() {
        return getCurrentPageTabTitle();
    }

    /**
     * Get current url
     * @return currentUrl
     */
    public String getCurrentPageUrl() {
        return getCurrentUrl();
    }
}
