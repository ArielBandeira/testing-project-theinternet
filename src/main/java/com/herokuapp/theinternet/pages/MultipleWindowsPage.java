package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject {

     public MultipleWindowsPage(WebDriver driver, Logger log) {
         super(driver, log);
     }

    //Click on 'Click Here' link to open new tab
    public void clickNewWindowLink(By locator) {
        click(locator);
    }

    //Switch to new window
    public NewWindowPage switchToNewWindow(){
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver, log);
    }
}
