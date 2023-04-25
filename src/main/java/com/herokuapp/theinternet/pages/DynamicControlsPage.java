package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DynamicControlsPage extends BasePageObject {

    private By checkboxLocator = By.xpath("//input[@type='checkbox']");

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

    public void clickRemoveButton(By locator){
        log.info("Click 'Remove' button");
        click(locator);
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

}
