package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePageObject {

    //TODO
    // MAKE ALL LOCATORS FINAL
    private final By checkboxLocator = By.xpath("//input[@type='checkbox']");
    private final By textInputLocator = By.xpath("//input[@type='text']");
    private final By removeButtonLocator = By.xpath("//form[@id='checkbox-example']/button[@type='button']");
    private final By enableDisableButtonLocator = By.xpath("//form[@id='input-example']/button[@type='button']");

    private final By textInputMessageLocator = By.xpath("//*[@id='message']");

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public DynamicControlsPage(WebDriver driver, Logger log) { super(driver, log); }

    /**
     * Mark a checkbox option
     * TODO this could be a base page function
     */
    public void markCheckbox() {
        log.info("Mark checkbox");
        WebElement checkbox = find(checkboxLocator);
        checkbox.click();
    }

    /**
     * Verify if checkbox is marked
     * @return boolean
     * True if marked
     * False if not marked
     */
    public boolean isCheckboxMarked() {
        WebElement checkbox = find(checkboxLocator);
        log.info("Verify if checkbox is marked");
        if (checkbox.isSelected()) {
            log.info("Checkbox is marked");
            return true;
        } else {
            log.info("Checkbox is not marked");
            return false;
        }
    }

    /**
     * Click 'Remove' button
     */
    public void clickRemoveButton() {
        log.info("Click 'Remove' button");
        click(removeButtonLocator);
    }

    /**
     * Verify if checkbox is displayed
     * @return String
     * TODO this can be done more elegantly
     */
    public String verifyIsCheckboxDisplayed() {
        log.info("Verify if checkbox is displayed");
        try {
            find(checkboxLocator);
            log.info("Checkbox is displayed");
            return "Checkbox is displayed";
        } catch (NoSuchElementException e) {
            log.info("Checkbox is not displayed");
            return "Checkbox is not displayed";
        }
    }

    /**
     * Click 'Enable/Disable' button
     */
    public void clickEnableDisableButton() {
        log.info("Clicking on 'Enable/Disable' button");
        waitFor(ExpectedConditions.elementToBeClickable(enableDisableButtonLocator), Duration.ofSeconds(30));
        WebElement button = find(enableDisableButtonLocator);
        button.click();
    }

    /**
     * Verify if text input element is displayed
     * @return boolean
     * True if enabled
     * False if disabled
     */
    public Boolean isTextInputEnabled() {
        log.info("Verify if text input is enabled");
        WebElement textInput = find(textInputLocator);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitFor(ExpectedConditions.elementToBeClickable(enableDisableButtonLocator), Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(textInput));
            log.info("Text input is enabled");
            return true;
        }catch (Exception e) {
            log.info("Text input is disabled");
            return false;
        }
    }

    /**
     * Type on text input element
     * @param text
     */
    public void typeOnTextInputTextbox(String text) {
        log.info("Writing on text input: " + text);
        WebElement input = find(textInputLocator);
        waitFor(ExpectedConditions.elementToBeClickable(input), Duration.ofSeconds(30));
        type(text, textInputLocator);
    }

    /**
     * Get text on text input element
     * @return
     */
    public String getTextInputText() {
        String textOnTextInput = find(textInputLocator).getAttribute("value");
        log.info("Text on text input: " + textOnTextInput);
        return textOnTextInput;
    }

    /**
     * Check if text on status message element is the expected
     * @param expectedMessage
     * @return boolean
     * True if text is the expected
     * False if is not the expected
     * TODO this can be done more elegantly
     */
    public boolean checkTextInputStatusMessage(String expectedMessage) {
        log.info("Verify if text input status message is the expected");
        String actualMessage = find(textInputMessageLocator).getText();
        log.info("Text input status message: " + actualMessage);
        return !actualMessage.equals(expectedMessage);
    }

}
