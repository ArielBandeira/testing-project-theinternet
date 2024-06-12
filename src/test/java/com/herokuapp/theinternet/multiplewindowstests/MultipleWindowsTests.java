package com.herokuapp.theinternet.multiplewindowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends TestUtilities {

    //region Variables
    String expectedTitle = "New Window";
    String expectedURL = "https://the-internet.herokuapp.com/windows/new";

    WelcomePage welcomePage;
    //endregion

    //TODO Breakdown this test into multiple tests
    // like verify window title, verify new window text, verify new window url etc
    //Click on 'Click Here' link to open new page
    @Test
    public void clickNewWindowLink() {

        welcomePage = new WelcomePage(driver, log);

        //Open Opening a new window page
        MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();

        //Click on 'Click Here' link to open new page
        log.info("Click on 'Click Here' link to open new window");
        multipleWindowsPage.clickNewWindowLink();

        //Switch to new window
        log.info("Switch to window with title: New Window");
        NewWindowPage newWindow = welcomePage.switchToNewWindow();

        //Check new window page title
        log.info("Get new window title");
        String actualTitle = newWindow.getCurrentWindowTitle();

        //Check if new window title is the expected
        log.info("Check if new window title is the expected");
        Assert.assertEquals(actualTitle, expectedTitle, "New window title is not the expected");
        log.info("New window expected title: " + actualTitle);
        log.info("New window actual title: " + actualTitle);

        //Get new window URL
        log.info("Get new window URL");
        String actualURL = newWindow.getCurrentPageUrl();

        //Check if new window URL if the expected
        log.info("Check if the new window URL is the expected");
        Assert.assertEquals(actualURL, expectedURL, "New window URL is not the expected");
        log.info("New window expected URL: " + expectedURL);
        log.info("New window actual URL: " + expectedURL);
        takeScreenshot("new_window_page");
    }
}
