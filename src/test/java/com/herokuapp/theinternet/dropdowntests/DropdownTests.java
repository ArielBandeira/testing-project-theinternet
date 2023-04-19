package com.herokuapp.theinternet.dropdowntests;

import com.herkuapp.theinternet.base.CsvDataProviders;
import com.herkuapp.theinternet.base.TestUtilities;
import com.herkuapp.theinternet.pages.DropdownPage;
import com.herkuapp.theinternet.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Map;
import java.util.NoSuchElementException;

public class DropdownTests extends TestUtilities {

    @Test( dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class )
    public void pickOptionTest(Map<String, String> testData) {
        SoftAssert softAssert = new SoftAssert();

        //Data variables
        String option = testData.get("options");

        log.info("Starting test picking option #" + option + " from dropdown");

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Dropdown Page
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        //Pick one of the options
        dropdownPage.pickOption(option);
        sleep(3000);
        //Verify if selected option is the right one
        String expectedOption = dropdownPage.getSelectedOption();
        String actualOption = "Option " + Integer.parseInt(option);

        softAssert.assertTrue(actualOption.equals(expectedOption), "\nOption selected is not the right one\n" +
                "Expected: " + expectedOption + "\nActual: " + actualOption + "\n");

        softAssert.assertAll();

    }

    @Test( dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class )
    public void pickWrongOptionTest(Map<String, String> testData) {
        SoftAssert softAssert = new SoftAssert();

        //Data variables
        String option = testData.get("options");

        log.info("Starting test picking option #" + option + " from dropdown");

        //Open Welcome Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Go to Dropdown Page
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        //Pick one of the options
        try {
            dropdownPage.pickOption(option);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e.getCause());
        }
        sleep(3000);
        //Verify if selected option is the right one
        String expectedOption = dropdownPage.getSelectedOption();
        String actualOption = "Option " + Integer.parseInt(option);

        softAssert.assertTrue(actualOption.equals(expectedOption), "\nOption selected is not the right one\n" +
                "Expected: " + expectedOption + "\nActual: " + actualOption + "\n");

        softAssert.assertAll();

    }

}
