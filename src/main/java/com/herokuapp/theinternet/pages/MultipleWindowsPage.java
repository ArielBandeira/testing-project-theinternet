package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject {

    private final By clickHereLinkLocator = By.xpath("//a[@href='/windows/new']");

    /**
     * Constructor
     * @param driver
     * @param log
     */
     public MultipleWindowsPage(WebDriver driver, Logger log) {
         super(driver, log);
     }

    /**
     * Click on 'Click Here' link to open new tab
     */
    public void clickNewWindowLink() {
        click(clickHereLinkLocator);
    }
}
