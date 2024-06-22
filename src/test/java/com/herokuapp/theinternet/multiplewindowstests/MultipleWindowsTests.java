package com.herokuapp.theinternet.multiplewindowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class MultipleWindowsTests extends TestUtilities {

    //region Variables
    WelcomePage welcomePage;
    //endregion

    @Test
    public void verifyNewWindowLinkOpensCorrectPageUrl() throws IOException {

        welcomePage = new WelcomePage(driver, log);
        MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();


        multipleWindowsPage.clickNewWindowLink();

        String currentPageUrl = driver.getCurrentUrl();
        String expectedPageUrl = readCSVFile().get(0);

        log.info("Verify if page URL is the expected");
        Assert.assertEquals(currentPageUrl, expectedPageUrl, "Actual page URL dos not match the expected");

    }
}
