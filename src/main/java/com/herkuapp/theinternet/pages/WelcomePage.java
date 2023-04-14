package com.herkuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class WelcomePage extends BasePageObject {

    String welcomePageUrl = "https://the-internet.herokuapp.com";

    protected By basicAuthLinkLocator = By.linkText("Basic Auth");
    protected By dropdownLinkLocator = By.linkText("Dropdown");
    protected By dynamicControlsLinkLocator = By.linkText("Dynamic Controls");
    protected By dynamicLoadingLinkLocator = By.linkText("Dynamic Loading");


    public WelcomePage(WebDriver driver, Logger log) { super(driver, log); }

    public void openPage() {
        log.info("Open page: " + welcomePageUrl);
        openUrl(welcomePageUrl);
    }

    //Open Basic Auth page
    public BasicAuthPage clickBasicAuthLink(By basicAuthLinkLocator) {
        log.info("Open Basic Auth page");
        click(basicAuthLinkLocator);
        return new BasicAuthPage(driver, log);
    }

    //Open Dropdown page
    public DropdownPage clickDropdownLink(By dropdownLinkLocator) {
        log.info("Open Dropdown page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    //Open Dynamic Controls page
    public DynamicControlsPage clickDynamicControlsLink(By dynamicControlsLinkLocator) {
        log.info("Open Dynamic Controls page");
        click(dynamicControlsLinkLocator);
        return new DynamicControlsPage(driver, log);
    }

    //Open Dynamic Loading page
    public DynamicLoadingPage clickDynamicLoadingLink(By dynamicLoadingLinkLocator) {
        log.info("Open Dynamic Loading page");
        click(dynamicLoadingLinkLocator);
        return new DynamicLoadingPage(driver, log);
    }

}
