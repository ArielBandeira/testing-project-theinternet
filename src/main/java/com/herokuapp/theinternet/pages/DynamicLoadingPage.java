package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePageObject {

    private final By pageTitleLocator = By.xpath("//div[@class='example']/h3");

    private final By exampleOnePageLocator = By.xpath("//a[@href='/dynamic_loading/1']");
    private final By exampleTwoPageLocator = By.xpath("//a[@href='/dynamic_loading/2']");

    /**
     * Constructor
     * @param driver
     * @param log
     */
    public DynamicLoadingPage(WebDriver driver, Logger log) { super(driver, log); }

    /**
     * Get page title
     * @return String pageTitle
     */
    public String getPageTitle(){
        return find(pageTitleLocator).getText();
    }

    /**
     * Go to 'Example 1' page
     * @return ExampleOnePage
     */
    public DynamicLoadingExampleOnePage goToExampleOnePage() {
        log.info("Opening Example 1 page");
        click(exampleOnePageLocator);
        return new DynamicLoadingExampleOnePage(driver, log);
    }

    /**
     * Go to 'Example 2' page
     * @return ExampleTwoPage
     */
    public DynamicLoadingExampleTwoPage goToExampleTwoPage() {
        log.info("Opening Example 2 page");
        click(exampleTwoPageLocator);
        return new DynamicLoadingExampleTwoPage(driver, log);
    }
}
