package com.herokuapp.theinternet.dynamicloadingtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicLoadingExampleOnePage;
import com.herokuapp.theinternet.pages.DynamicLoadingExampleTwoPage;
import com.herokuapp.theinternet.pages.DynamicLoadingPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;

public class DynamicLoadingTests extends TestUtilities {

    //region Variables
    String expectedPageOneUrl = "https://the-internet.herokuapp.com/dynamic_loading/1";
    String expectedPageTwoUrl = "https://the-internet.herokuapp.com/dynamic_loading/2";
    //endregion

    //region Tests

    @Test
    public void checkPageTitle() throws IOException {

        DynamicLoadingPage dynamicLoadingPage = openWelcomePage().clickDynamicLoadingLink();

        log.info("Get current page title");
        String actualTitle = dynamicLoadingPage.getPageTitle();

        String pathname = "src/test/resources/dataproviders/Shared/"+testMethodName+".csv";

        //Data variables
        ArrayList<String> options = readCSVFileWithPath(pathname);

        log.info("Verify if page title matches the expected");
        Assert.assertTrue(options.contains(actualTitle), "Actual page title does not match expected");
    }

    @Test
    public void verifyPageUrl() throws IOException {

        DynamicLoadingPage dynamicLoadingPage = openWelcomePage().clickDynamicLoadingLink();

        log.info("Get current page URL");
        String currentUrl = dynamicLoadingPage.getCurrentUrl();

        String pathname = "src/test/resources/dataproviders/Shared/" + testMethodName + ".csv";

        //Data variables
        ArrayList<String> options = readCSVFileWithPath(pathname);

        log.info("Verify if current URL is the expected");
        Assert.assertTrue(options.contains(currentUrl), "Actual page URL does not match expected");
    }

    @Test
    public void checkExampleOnePageLink() throws Exception {

        DynamicLoadingPage dynamicLoadingPage = openWelcomePage().clickDynamicLoadingLink();

        log.info("Verify Example One link");
        DynamicLoadingExampleOnePage dynamicExampleOne = dynamicLoadingPage.goToExampleOnePage();

        log.info("Verify if current page URL is the expected");
        Assert.assertTrue(dynamicExampleOne.verifyCurrentPageUrlIsExpected(expectedPageOneUrl));

    }
    @Test
    public void checkExampleTwoPageLink() {

        DynamicLoadingPage dynamicLoadingPage = openWelcomePage().clickDynamicLoadingLink();

        log.info("Verify Example One link");
        DynamicLoadingExampleTwoPage dynamicExampleTwo = dynamicLoadingPage.goToExampleTwoPage();

        log.info("Verify if current page URL is the expected");
        Assert.assertTrue(dynamicExampleTwo.verifyCurrentPageUrlIsExpected(expectedPageTwoUrl));
    }

    //endregion

}
