package com.herokuapp.theinternet.dynamiccontrolstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicControlsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class DynamicControlsTests extends TestUtilities {

    //REMOVE/ADD
    @Test
    public void checkboxTest() {
        SoftAssert softAssert = new SoftAssert();
        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Dynamic Controls Page
        DynamicControlsPage dynamicControlsPage = welcomePage.clickDynamicControlsLink();

        //Mark checkbox
        dynamicControlsPage.markCheckbox();

        //Verify if checkbox is marked
        softAssert.assertTrue(dynamicControlsPage.isCheckboxMarked());
    }

    @Test
    public void checkboxAndRemoveTest() {
        SoftAssert softAssert = new SoftAssert();
        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Dynamic Controls Page
        DynamicControlsPage dynamicControlsPage = welcomePage.clickDynamicControlsLink();

        //Mark checkbox
        dynamicControlsPage.markCheckbox();

        //Verify if checkbox is marked
        softAssert.assertTrue(dynamicControlsPage.isCheckboxMarked());

        //Remove checkbox
        dynamicControlsPage.clickRemoveButton();
        sleep(3000);

        //Verify if checkbox is removed
        String verifyCheckbox = dynamicControlsPage.verifyIsCheckboxDisplayed();
        softAssert.assertTrue(Objects.equals(verifyCheckbox, "Checkbox is displayed"), "Checkbox is not displayed");
        sleep(3000);
    }

    //ENABLE/DISABLE
    @Test
    public void enableTextInputTest() {
        SoftAssert softAssert = new SoftAssert();
        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Dynamic Controls Page
        DynamicControlsPage dynamicControlsPage = welcomePage.clickDynamicControlsLink();

        //Verify if text input is disabled
        softAssert.assertTrue(dynamicControlsPage.isTextInputEnabled());

        //Click on 'Enable' button to enable text input
        dynamicControlsPage.clickEnableDisableButton();

        //Verify if text input is enabled
        softAssert.assertTrue(dynamicControlsPage.isTextInputEnabled());

        //Add text to text input
        String text = "I'm Commander Shepard and this is my favorite test on the Citadel!";
        dynamicControlsPage.typeOnTextInputTextbox(text);

        //Click on 'Disable' button to disable text input
        dynamicControlsPage.clickEnableDisableButton();

        //Verify if text input is disabled
        softAssert.assertTrue(dynamicControlsPage.isTextInputEnabled());

        //Verify if the text in the text input is the expected
        String textOnInput = String.valueOf(dynamicControlsPage.getTextInputText());
        softAssert.assertTrue(text.equals(textOnInput), "Text input is not the expected");

    }

}
