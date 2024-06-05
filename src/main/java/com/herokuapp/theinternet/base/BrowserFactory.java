package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private final Logger log;

    /**
     * Initiate logger
     * @param log
     */
    public BrowserFactory(Logger log) {
        this.log = log;
    }

    /**
     * Initiate browser driver
     * @return driver
     */
    public WebDriver createDriver() {
        driver.set(new ChromeDriver());
        return driver.get();
    }

}
