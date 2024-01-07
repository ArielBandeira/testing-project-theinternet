package com.herkuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private Logger log;

    public BrowserFactory(Logger log) {
        this.log = log;
    }

    //Create driver
    public WebDriver createDriver() {
        driver.set(new ChromeDriver());
        return driver.get();
    }

}
