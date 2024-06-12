package com.herokuapp.theinternet.dynamicloadingtests;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicLoadingExampleOnePage;
import com.herokuapp.theinternet.pages.DynamicLoadingPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class DynamicLoadingExampleOneTests extends TestUtilities {

    //region Variables
    WelcomePage welcomePage;
    //endregion

    //region Tests
    @Test
    public void checkPageTitle() throws IOException {
        welcomePage = new WelcomePage(driver, log);
        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();
        DynamicLoadingExampleOnePage dynamicOne = dynamicLoadingPage.goToExampleOnePage();

        log.info("Get current page title");
        String actualTitle = dynamicOne.getPageTitle();

        //Data variables
        ArrayList<String> options = readCSVFile();

        log.info("Verify if page title matches the expected");
        Assert.assertTrue(options.contains(actualTitle), "Actual page title does not match expected");

    }

    @Test
    public void verifyDynamicText() throws IOException {
        welcomePage = new WelcomePage(driver, log);
        DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();
        DynamicLoadingExampleOnePage dynamicOne = dynamicLoadingPage.goToExampleOnePage();

        log.info("Click 'Start' button");
        dynamicOne.pressStartButton();

        log.info("Get current page text");
        String actualText = dynamicOne.getDynamicText();

        //Data variables
        ArrayList<String> options = readCSVFile();

        log.info("Verify if dynamic text is the expected");
        Assert.assertTrue(options.contains(actualText), "Actual page dynamic text does not match the expected");
    }
    //endregion
}
