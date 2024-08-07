package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    public WebDriver createDriverWithOptions(String arguments) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(arguments);
        driver.set(new ChromeDriver(options));
        return driver.get();
    }

}
