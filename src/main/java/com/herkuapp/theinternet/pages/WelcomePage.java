package com.herkuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class WelcomePage extends BasePageObject {

    String welcomePageUrl = "https://the-internet.herokuapp.com";

    public WelcomePage(WebDriver driver, Logger log) { super(driver, log); }

    public void openPage() {
        log.info("Open page: " + welcomePageUrl);
        openUrl(welcomePageUrl);
    }

}
