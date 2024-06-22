package com.herokuapp.theinternet.multiplewindowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewWindowTests extends TestUtilities {

    //region Variables
    WelcomePage welcomePage;
    //endregion

    @Test
    public void verifyNewWindowTitle() throws IOException {

        welcomePage = new WelcomePage(driver, log);
        MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();
        NewWindowPage newWindowPage = multipleWindowsPage.clickNewWindowLink();

        String currentPageTitle = newWindowPage.getCurrentPageTitle();
        String expectedPageTitle = readCSVFile().get(0);

        log.info("Verify if page title is the expected");
        Assert.assertEquals(currentPageTitle, expectedPageTitle, "Actual page title dos not match the expected page title");

    }

    @Test
    public void verifyNewWindowTabTitle() throws IOException {

        welcomePage = new WelcomePage(driver, log);
        MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();
        NewWindowPage newWindowPage = multipleWindowsPage.clickNewWindowLink();

        String currentPageTitle = newWindowPage.getCurrentWindowTitle();
        String expectedPageTitle = readCSVFile().get(0);

        log.info("Verify if tab title is the expected");
        Assert.assertEquals(currentPageTitle, expectedPageTitle, "Actual page tab title dos not match the expected title");

    }

    @Test
    public void verifyNewWindowUrl() throws IOException {

        welcomePage = new WelcomePage(driver, log);
        MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();
        NewWindowPage newWindowPage = multipleWindowsPage.clickNewWindowLink();

        String currentPageTitle = newWindowPage.getCurrentPageUrl();
        String expectedPageTitle = readCSVFile().get(0);

        log.info("Verify if page URL is the expected");
        Assert.assertEquals(currentPageTitle, expectedPageTitle, "Actual page URL dos not match the expected URL");

    }

}
