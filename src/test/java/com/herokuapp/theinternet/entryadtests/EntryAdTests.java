package com.herokuapp.theinternet.entryadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EntryAdModalWindowPage;
import com.herokuapp.theinternet.pages.EntryAdPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EntryAdTests extends TestUtilities {

    private final String expectedModalTitle = "This is a modal window";
    private final String expectedModalText = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).";

    //Check modal title is expected
    @Test
    public void checkModalTitle() {

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Entry Ad page
        EntryAdPage entryAdPage = welcomePage.clickEntryAdLink();
        EntryAdModalWindowPage entryAdModalWindowPage = welcomePage.entryAdModalPage();

        //Get modal window title
        String actualModalTitle = entryAdModalWindowPage.getModalWindowTitle().toLowerCase();

        //Verify if modal window title is the expected
        Assert.assertEquals(expectedModalTitle.toLowerCase(), actualModalTitle, "Modal title is not the expected");
    }

    //Check modal text is expected
    @Test
    public void checkModalText() {

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Entry Ad page
        EntryAdPage entryAdPage = welcomePage.clickEntryAdLink();

        //Get modal window text
        EntryAdModalWindowPage entryAdModalWindowPage = welcomePage.entryAdModalPage();
        String actualModalText = entryAdModalWindowPage.getModalWindowText().toLowerCase();

        //Verify if modal window text is the expected
        Assert.assertEquals(expectedModalText.toLowerCase(), actualModalText, "Modal text is not the expected");

    }

    //Check if 'Close' button closes the modal
    @Test
    public void checkCloseButton() {

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Entry Ad page
        EntryAdPage entryAdPage = welcomePage.clickEntryAdLink();
        EntryAdModalWindowPage entryAdModalWindowPage = welcomePage.entryAdModalPage();

        //Click 'Close' link
        entryAdModalWindowPage.clickCloseButton();

        //Check if modal window is closed
        Assert.assertFalse(entryAdPage.isModalDisplayed(), "Modal is not closed");
    }


    //Check if modal is reopened by click on text link
    @Test
    public void checkIfModalIsReOpened() {

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Entry Ad page
        EntryAdPage entryAdPage = welcomePage.clickEntryAdLink();
        EntryAdModalWindowPage entryAdModalWindowPage = welcomePage.entryAdModalPage();

        //Click 'Close' link to close the modal
        entryAdModalWindowPage.clickCloseButton();

        //Verify if modal window is closed
        Assert.assertFalse(entryAdPage.isModalDisplayed(), "Modal window is closed");

        //Click link to reopen the modal window
        entryAdPage.reEnableModal();
        if (!entryAdPage.isModalDisplayed()) {
            do {
                entryAdPage.reEnableModal();
                sleep(1000);
            } while (!entryAdPage.isModalDisplayed());
        }

        //Verify if modal window is opened again
        Assert.assertTrue(entryAdPage.isModalDisplayed(), "Modal window is closed");
    }
}
