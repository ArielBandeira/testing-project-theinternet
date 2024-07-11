package com.herokuapp.theinternet.entryadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.configuration.Properties;
import com.herokuapp.theinternet.pages.windows.EntryAdModalWindowPage;
import com.herokuapp.theinternet.pages.EntryAdPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EntryAdTests extends TestUtilities {

    static Properties properties = new Properties();

    //region Tests

    //Check modal title is expected
    @Test
    public void checkModalTitle() {

        EntryAdPage entryAdPage = openWelcomePage().clickEntryAdLink();
        EntryAdModalWindowPage entryAdModalWindowPage = entryAdPage.entryAdModalPage();

        //Verify if modal is displayed
        Assert.assertTrue(entryAdPage.isModalDisplayed(), "Modal is not displayed");

        //Get modal window title
        String actualModalTitle = entryAdModalWindowPage.getModalWindowTitle().toLowerCase();

        //Get modal title from config file
        String expectedModalTitle = properties.getModalTitle();

        //Verify if modal window title is the expected
        Assert.assertEquals(expectedModalTitle.toLowerCase(), actualModalTitle, "Modal title is not the expected");
        takeScreenshot("entryAd_page_with_modal");

    }

    //Check modal text is expected
    @Test
    public void checkModalText() {

        EntryAdPage entryAdPage = openWelcomePage().clickEntryAdLink();
        EntryAdModalWindowPage entryAdModalWindowPage = entryAdPage.entryAdModalPage();

        //Verify if modal is displayed
        Assert.assertTrue(entryAdPage.isModalDisplayed(), "Modal is not displayed");

        //Get modal window text
        String actualModalText = entryAdModalWindowPage.getModalWindowText().toLowerCase();

        //Get modal text from config file
        String expectedModalText = properties.getModalText();

        //Verify if modal window text is the expected
        Assert.assertEquals(expectedModalText.toLowerCase(), actualModalText, "Modal text is not the expected");
        takeScreenshot("entryAd_page_with_modal");

    }

    //Check if 'Close' button closes the modal
    @Test
    public void checkCloseButton() {

        EntryAdPage entryAdPage = openWelcomePage().clickEntryAdLink();
        EntryAdModalWindowPage entryAdModalWindowPage = entryAdPage.entryAdModalPage();

        //Verify if modal is displayed
        Assert.assertTrue(entryAdPage.isModalDisplayed(), "Modal is not displayed");

        //Click 'Close' link
        entryAdModalWindowPage.clickCloseButton();

        //Check if modal window is closed
        Assert.assertFalse(entryAdPage.isModalDisplayed(), "Modal is not closed");
        takeScreenshot("entryAd_page_with_modal_closed");
    }

    //Check if modal is reopened by click on text link
    @Test
    public void checkIfModalIsReOpened() {

        EntryAdPage entryAdPage = openWelcomePage().clickEntryAdLink();
        EntryAdModalWindowPage entryAdModalWindowPage = entryAdPage.entryAdModalPage();

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
        takeScreenshot("entryAd_page_with_modal_opened");
    }
    //endregion

}
