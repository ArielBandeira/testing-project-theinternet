package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {

    protected By dropdownOptionLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver, Logger log) { super(driver, log); }

    public void pickOption(String options) {
        log.info("Select option: " + options + " from dropdown");
        WebElement dropdownOption = find(dropdownOptionLocator);
        Select dropdownOptionLocator = new Select(dropdownOption);
        dropdownOptionLocator.selectByValue(options);
    }

    public String getSelectedOption() {
        log.info("Return selected option");
        WebElement dropdownOption = find(dropdownOptionLocator);
        Select dropdownOptionLocator = new Select(dropdownOption);
        String selectedOption = dropdownOptionLocator.getFirstSelectedOption().getText();
        log.info("Selected option is: " + selectedOption);
        return selectedOption;
    }


}
