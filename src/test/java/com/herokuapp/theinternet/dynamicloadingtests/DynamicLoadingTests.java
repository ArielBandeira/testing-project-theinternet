package com.herokuapp.theinternet.dynamicloadingtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicLoadingPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DynamicLoadingTests extends TestUtilities {

    //TODO
    // MOVE ALL LOCATORS TO THE PAGE CLASS
    // change comments on page class to javadoc

    private final By exampleOnePageLocator = By.xpath("//a[@href='/dynamic_loading/1']");
    private final By exampleTwoPageLocator = By.xpath("//a[@href='/dynamic_loading/2']");
    private final By startButtonLocator = By.tagName("button");
    private final By textLocator = By.id("finish");

    @Test
    //Example 1 test
    public void testExampleOne() {
        String pageName = "Example 1: Element on page that is hidden";
        String expectedUrl = "https://the-internet.herokuapp.com/dynamic_loading/1";

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Open Dynamic Loading Page
        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();

        //Go to page 'Example 1: Element on page that is hidden'
        log.info("Click on 'Example 1: Element on page that is hidden' page");
        dynamicLoadingPage.goToExamplePage(exampleOnePageLocator, pageName);

        //Verify if the page URL is the expected
        String currentUrl = dynamicLoadingPage.getCurrentPageUrl();

        dynamicLoadingPage.verifyCurrentIsExpected(currentUrl, expectedUrl);

        //Click on 'Start' button
        dynamicLoadingPage.clickStartButton(startButtonLocator);

        //Wait for text to be visible and get Text
        String text = dynamicLoadingPage.getText(textLocator);
        String expectedText = "Hello World!";

        //Verify if displayed text is the expected
        dynamicLoadingPage.verifyCurrentIsExpected(text, expectedText);
    }

    @Test
    //Example 2 test
    public void testExampleTwo() {
        String pageName = "Example 2: Element rendered after the fact";
        String expectedUrl = "https://the-internet.herokuapp.com/dynamic_loading/2";

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Open Dynamic Loading Page
        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();

        //Go to page 'Example 1: Element on page that is hidden'
        log.info("Click on 'Example 2: Element rendered after the fact' page");
        dynamicLoadingPage.goToExamplePage(exampleTwoPageLocator, pageName);

        //Verify if the page URL is the expected
        String currentUrl = dynamicLoadingPage.getCurrentPageUrl();

        dynamicLoadingPage.verifyCurrentIsExpected(currentUrl, expectedUrl);

        //Click on 'Start' button
        dynamicLoadingPage.clickStartButton(startButtonLocator);

        //Wait for text to be visible and get Text
        String text = dynamicLoadingPage.getText(textLocator);
        String expectedText = "Hello World!";

        //Verify if displayed text is the expected
        dynamicLoadingPage.verifyCurrentIsExpected(text, expectedText);
    }

}
