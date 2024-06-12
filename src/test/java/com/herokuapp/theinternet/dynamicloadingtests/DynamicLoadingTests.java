package com.herokuapp.theinternet.dynamicloadingtests;

import com.beust.ah.A;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicLoadingPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTests extends TestUtilities {

//    //TODO re do all of this tests
//    // change all tests here and ad a new class page for example 1 page and example 2 page
//    WelcomePage welcomePage;
//    String expectedText = "Hello World!";
//    String exampleOnePageName = "Example 1: Element on page that is hidden";
//    String exampleTwoPageName = "Example 2: Element rendered after the fact";
//    String expectedExampleOneUrl = "https://the-internet.herokuapp.com/dynamic_loading/1";
//    String expectedExampleTwoUrl = "https://the-internet.herokuapp.com/dynamic_loading/2";
//
//    @Test
//    //Example 1 test
//    public void testExampleOne() {
//
//        //Open Dynamic Loading Page
//        welcomePage = new WelcomePage(driver, log);
//        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();
//
//        //Go to page 'Example 1: Element on page that is hidden'
//        log.info("Click on 'Example 1: Element on page that is hidden' page");
//        dynamicLoadingPage.goToExampleOnePage();
//
//        //Verify if the page URL is the expected
//        String currentUrl = dynamicLoadingPage.getCurrentPageUrl();
//        Assert.assertEquals(expectedExampleOneUrl, currentUrl, "Current URL is not the expected");
//
//        //Click on 'Start' button
//        dynamicLoadingPage.clickStartButton();
//
//        //Wait for text to be visible and get Text
//        String text = dynamicLoadingPage.getText();
//
//        //Verify if displayed text is the expected
//        Assert.assertEquals(text, expectedText, "Displayed text is not the expected");
//    }
//
//    @Test
//    //Example 2 test
//    public void testExampleTwo() {
//
//        //Open Dynamic Loading Page
//        welcomePage = new WelcomePage(driver, log);
//        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();
//
//        //Go to page 'Example 2: Element rendered after the fact'
//        log.info("Click on 'Example 2: Element rendered after the fact' page");
//        dynamicLoadingPage.goToExampleTwoPage();
//
//        //Verify if the page URL is the expected
//        String currentUrl = dynamicLoadingPage.getCurrentPageUrl();
//        Assert.assertEquals(expectedExampleTwoUrl, currentUrl, "Current URL is not the expected");
//
//        //Click on 'Start' button
//        dynamicLoadingPage.clickStartButton();
//
//        //Wait for text to be visible and get Text
//        String text = dynamicLoadingPage.getText();
//
//        //Verify if displayed text is the expected
//        Assert.assertEquals(text, expectedText);
//        dynamicLoadingPage.verifyCurrentIsExpected(text, expectedText);
//    }

}
