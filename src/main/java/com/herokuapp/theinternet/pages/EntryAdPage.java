package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.pages.windows.EntryAdModalWindowPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class EntryAdPage extends BasePageObject {

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public EntryAdPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //region Variables
    private final By modalLocator = By.cssSelector("div[id='modal']");

    private final By reOpenModalLinkLocator = By.xpath("//*[@id='restart-ad']");
    //endregion

    //region Elements
    /**
     * Check if modal window is displayed
     */
    public boolean isModalDisplayed() {
        log.info("Check if modal window is displayed");
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(modalLocator), Duration.ofSeconds(3));
        } catch (Exception e) {
            return false;
        }
        WebElement modalWindow = find(modalLocator);
        return modalWindow.isDisplayed();
    }

    /**
     * Click the 'Click here' link
     */
    public void reEnableModal() {
        log.info("Click to re enable the modal window");
        WebElement reOpenModalLink = find(reOpenModalLinkLocator);
        reOpenModalLink.click();
        waitFor(ExpectedConditions.presenceOfElementLocated(modalLocator), Duration.ofSeconds(500));
        try {
            isModalDisplayed();
        } catch (Exception e) {
            log.info("Modal is not displayed");
        }
    }

    /**
     * Initiate Entry Ad modal
     * @return entryAdModalPage
     */
    public EntryAdModalWindowPage entryAdModalPage() {
        log.info("Open Entry Ad Modal Window");
        return new EntryAdModalWindowPage(driver, log);
    }
    //endregion

}
