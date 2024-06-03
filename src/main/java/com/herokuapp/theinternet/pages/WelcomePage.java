package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    String welcomePageUrl = "https://the-internet.herokuapp.com";
    protected By dropdownLinkLocator = By.linkText("Dropdown");
    protected By dynamicControlsLinkLocator = By.linkText("Dynamic Controls");
    protected By dynamicLoadingLinkLocator = By.linkText("Dynamic Loading");
    protected By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    protected By entryAdLinkLocator = By.linkText("Entry Ad");

    public WelcomePage(WebDriver driver, Logger log) { super(driver, log); }

    public void openPage() {
        log.info("Open page: " + welcomePageUrl);
        openUrl(welcomePageUrl);
    }

    //Open Dropdown page
    public DropdownPage clickDropdownLink() {
        log.info("Open Dropdown page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    //Open Dynamic Loading page
    public DynamicLoadingPage clickDynamicLoadingLink() {
        log.info("Open Dynamic Loading page");
        click(dynamicLoadingLinkLocator);
        return new DynamicLoadingPage(driver, log);
    }

   //Open Dynamic Controls page
   public DynamicControlsPage clickDynamicControlsLink() {
        log.info("Open Dynamic Controls page");
        click(dynamicControlsLinkLocator);
        return new DynamicControlsPage(driver, log);
   }

   //Open Multiple Windows page
    public MultipleWindowsPage clickMultipleWindowsLink() {
        log.info("Open Multiple Windows page");
        click(multipleWindowsLinkLocator);
        return new MultipleWindowsPage(driver, log);
    }

    //Open Entry Add page
    public EntryAdPage clickEntryAdLink() {
        log.info("Open Entry Ad page");
        click(entryAdLinkLocator);
        return new EntryAdPage(driver, log);
    }

    public EntryAdModalWindowPage entryAdModalPage() {
        log.info("Open Entry Ad Modal Window");
        return new EntryAdModalWindowPage(driver, log);
    }

}
