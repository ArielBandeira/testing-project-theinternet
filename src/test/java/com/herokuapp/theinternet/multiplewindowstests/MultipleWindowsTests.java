package com.herokuapp.theinternet.multiplewindowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MultipleWindowsTests extends TestUtilities {

    private By clickHereLinkLocator = By.xpath("//a[@href='/windows/new']");

    //Click on 'Click Here' link to open new page
    @Test
    public void clickNewWindowLink() {
        SoftAssert softAssert = new SoftAssert();
        String pageName = "Opening a new window";

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Open Opening a new window page
        MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();
        takeScreenshot("opening_new_window_page");

        //Click on 'Click Here' link to open new page
        log.info("Click on 'Click Here' link to open new window");
        multipleWindowsPage.clickNewWindowLink(clickHereLinkLocator);

        //Switch to new window
        log.info("Switch to window with title: New Window");
        NewWindowPage newWindow = multipleWindowsPage.switchToNewWindow();
        takeScreenshot("new_window_page");

        //Check new window page title
        log.info("Get new window title");
        String actualTitle = newWindow.getCurrentWindowTitle();

        //Check if new window title is the expected
        log.info("Check if new window title is the expected");
        String expectedTitle = "New Window";
        softAssert.assertEquals(actualTitle, expectedTitle, "New window title is not the expected");
        log.info("New window expected title: " + actualTitle);
        log.info("New window actual title: " + actualTitle);

        //Get new window URL
        log.info("Get new window URL");
        String expectedURL = "https://the-internet.herokuapp.com/windows/new";
        String actualURL = newWindow.getCurrentPageUrl();

        //Check if new window URL if the expected
        log.info("Check if the new window URL is the expected");
        softAssert.assertEquals(actualURL, expectedURL, "New window URL is not the expected");
        log.info("New window expected URL: " + expectedURL);
        log.info("New window actual URL: " + expectedURL);
    }
}
