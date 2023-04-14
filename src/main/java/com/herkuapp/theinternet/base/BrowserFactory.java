package com.herkuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    //Create driver
    public WebDriver createDriver() {
        driver.set(new FirefoxDriver());
        return driver.get();
    }

}
