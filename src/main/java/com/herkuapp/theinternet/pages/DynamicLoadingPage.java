package com.herkuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class DynamicLoadingPage extends BasePageObject {

    public DynamicLoadingPage(WebDriver driver, Logger log) { super(driver, log); }

    //Go to 'Example' page
    public void goToExamplePage(By example, String pageName) {
        log.info("Opening page: " + pageName);
        click(example);
    }

    //Get current page URL
    public String getCurrentPageUrl() {
        log.info("Get current page URL");
        String currentUrl = getCurrentUrl();
        return currentUrl;
    }

    public void verifyCurrentIsExpected(String current, String expected){
        String passes = "Current is the expected" + "\nCurrent: " + current + "\nExpected: " + expected + "\n";
        String fails = "Current is NOT the expected" + "\nCurrent: " + current + "\nExpected: " + expected + "\n";
        if(current.equals(expected)) {
            log.info(passes);
        }else {
            log.info(fails);
        }
    }

    //Click on 'Start' button
    public void clickStartButton(By locator) {
        log.info("Clicking on Start button");
        click(locator);
    }

    //Verify if 'Hello World!' is visible
    public String getText(By text) {
        log.info("Wait for text to be visible");
        waitForVisibilityOf(text);
        String visibleText = find(text).getText();
        log.info("Text visible: " + visibleText);
        return visibleText;
    }
}
