package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DynamicLoadingExampleTwoPage extends BasePageObject {
    //region Variables
    String expectedExampleOneUrl = "https://the-internet.herokuapp.com/dynamic_loading/2";
    By pageTitleLocator = By.xpath("//div[@class='example']/h4");
    By startButtonLocator = By.xpath("//div[@id='start']/button");
    By pageDynamicTextLocator = By.xpath("//div[@id='finish']/h4");

    //endregion

    /**
     * Constructor
     *
     * @param driver
     * @param log
     */
    public DynamicLoadingExampleTwoPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //region Elements

    /**
     * Get page title
     * @return String pageTitle
     */
    public String getPageTitle(){
        return find(pageTitleLocator).getText();
    }

    /**
     * Click 'Start' button
     */
    public void pressStartButton() {
        try {
            click(startButtonLocator);
        } catch (Exception e) {
            log.info("Button is not displayed");
        }
    }

    /**
     * Get dynamic text behind 'Start' button
     *
     * @return
     */
    public String getDynamicText() {
        pressStartButton();
        waitForVisibilityOf(pageDynamicTextLocator, Duration.ofSeconds(10));
        return find(pageDynamicTextLocator).getText();
    }
    //endregion
}
