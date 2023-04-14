package com.herkuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

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

}
