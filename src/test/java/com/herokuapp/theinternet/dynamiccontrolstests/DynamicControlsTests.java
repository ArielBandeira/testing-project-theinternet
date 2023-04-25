package com.herokuapp.theinternet.dynamiccontrolstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicControlsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class DynamicControlsTests extends TestUtilities {

    private By checkboxLocator = By.xpath("//input[@label='blah']");
    private By removeButtonLocator = By.xpath("//form[@id='checkbox-example']/button[@type='button']");

    //REMOVE/ADD
    @Test
    public void checkboxTest(){
        SoftAssert softAssert = new SoftAssert();
        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Dynamic Controls Page
        DynamicControlsPage dynamicControlsPage = welcomePage.clickDynamicControlsLink();

        //Mark checkbox
        dynamicControlsPage.markCheckbox();

        //Verify if checkbox is marked
        softAssert.assertTrue(dynamicControlsPage.isCheckboxMarked(), "Checkbox is not marked");

        //Remove checkbox
        dynamicControlsPage.clickRemoveButton(removeButtonLocator);
        sleep(3000);

        //Verify if checkbox is removed
        String verifyCheckbox = dynamicControlsPage.verifySsCheckboxDisplayed();
        softAssert.assertTrue(Objects.equals(verifyCheckbox, "Checkbox is displayed"), "Checkbox is not displayed");
        sleep(3000);
    }





    //ENABLE/DISABLE
    //Enable text input

    //Add text to text input

    //Disable text input

}
