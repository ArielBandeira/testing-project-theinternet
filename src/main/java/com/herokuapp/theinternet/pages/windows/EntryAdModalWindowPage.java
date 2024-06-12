package com.herokuapp.theinternet.pages.windows;

import com.herokuapp.theinternet.pages.EntryAdPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EntryAdModalWindowPage extends EntryAdPage {

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public EntryAdModalWindowPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private final By modalTitleLocator = By.cssSelector("div[class='modal-title'] > h3");
    private final By modalTextLocator = By.cssSelector("div[class='modal-body'] > p");
    private final By closeLinkLocator = By.cssSelector("div[class='modal-footer'] > p");


    /**
     * Get modal window title
     */
    public String getModalWindowTitle() {
        log.info("Check modal window title");
        try{
            isModalDisplayed();
            WebElement actualTitle = find(modalTitleLocator);
            return actualTitle.getAttribute("innerText");
        } catch (Exception e){
            return "Modal is not displayed";
        }
    }

    /**
     * Get modal window body text
     */
    public String getModalWindowText() {
        log.info("Check modal window body text");
        try{
            isModalDisplayed();
            WebElement actualTitle = find(modalTextLocator);
            return actualTitle.getAttribute("innerText");
        } catch (Exception e){
            return "Modal is not displayed";
        }
    }

    /**
     * Click 'Close' link to close the modal window
     */
    public void clickCloseButton() {
        log.info("Click 'Close' link");
        try{
            isModalDisplayed();
            WebElement closeLinkButton = find(closeLinkLocator);
            closeLinkButton.click();
        } catch (Exception e){
            log.info("Modal is not displayed");
        }
    }
}
