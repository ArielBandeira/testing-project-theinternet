package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicControlsPage extends BasePageObject {

    private By checkboxLocator = By.xpath("//input[@type='checkbox']");
    private By textInputLocator = By.xpath("//input[@type='text']");
    private By removeButtonLocator = By.xpath("//form[@id='checkbox-example']/button[@type='button']");
    private By enableDisableButtonLocator = By.xpath("//form[@id='input-example']/button[@type='button']");

    public DynamicControlsPage(WebDriver driver, Logger log) { super(driver, log); }

    public void markCheckbox() {
        log.info("Mark checkbox");
        WebElement checkbox = find(checkboxLocator);
        checkbox.click();
    }

    public boolean isCheckboxMarked() {
        log.info("Verify if checkbox is marked");
        WebElement checkbox = find(checkboxLocator);
        return checkbox.isSelected();
    }

    public void clickRemoveButton() {
        log.info("Click 'Remove' button");
        click(removeButtonLocator);
    }

    public String verifySsCheckboxDisplayed() {
        log.info("Verify if checkbox is displayed");
        try {
            WebElement checkbox = find(checkboxLocator);
            log.info("Checkbox is displayed");
            return "Checkbox is displayed";
        } catch (NoSuchElementException e) {
            log.info("Checkbox is not displayed");
            return "Checkbox is not displayed";
        }
    }

    public void clickEnableDisableButton() {
        log.info("Clicking on 'Enable/Disable' button");
        waitFor(ExpectedConditions.elementToBeClickable(enableDisableButtonLocator), Duration.ofSeconds(30));
        WebElement button = find(enableDisableButtonLocator);
        button.click();
    }

    public boolean isTextInputEnabled() {
        log.info("Verify if text input is enabled");
        WebElement textInput = find(textInputLocator);
        return !textInput.isEnabled();
    }

    public void typeOnTextInputTextbox(String text) {
        log.info("Writing on text input: " + text);
        WebElement input = find(textInputLocator);
        waitFor(ExpectedConditions.elementToBeClickable(input), Duration.ofSeconds(30));
        type(text, textInputLocator);
    }

    public String getTextInputText() {
        String textOnTextInput = find(textInputLocator).getAttribute("value").toString();
        log.info("Text on text input: " + textOnTextInput);
        return textOnTextInput;
    }

}
