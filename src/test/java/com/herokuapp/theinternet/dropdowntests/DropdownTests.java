package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.Map;
import java.util.NoSuchElementException;

public class DropdownTests extends TestUtilities {

    @Test( dataProvider = "csvDataProvider", dataProviderClass = CsvDataProviders.class )
    public void pickOptionTest(Map<String, String> testData) {
        SoftAssert softAssert = new SoftAssert();

        //Data variables
        String option = testData.get("options");

        logMessage(option);

        //Go to Dropdown Page
        DropdownPage dropdownPage = openWelcomePage().clickDropdownLink();

        //Pick one of the options
        dropdownPage.pickOption(option);
        takeScreenshot("Option_picked_" + option);

        //Verify if selected option is the right one
        String expectedOption = dropdownPage.getSelectedOption();
        String actualOption = "Option " + Integer.parseInt(option);

        softAssert.assertTrue(actualOption.equals(expectedOption), "\nOption selected is not the right one\n" +
                "Expected: " + expectedOption + "\nActual: " + actualOption + "\n");

        softAssert.assertAll();

    }

    @Test( dataProvider = "csvDataProvider", dataProviderClass = CsvDataProviders.class )
    public void pickWrongOptionTest(Map<String, String> testData) {
        SoftAssert softAssert = new SoftAssert();

        //Data variables
        String option = testData.get("options");

        logMessage(option);

        //Go to Dropdown Page
        DropdownPage dropdownPage = openWelcomePage().clickDropdownLink();

        //Pick one of the options
        try {
            dropdownPage.pickOption(option);
            takeScreenshot("Option picked");
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e.getCause());
        }

        //Verify if selected option is the right one
        String expectedOption = dropdownPage.getSelectedOption();
        String actualOption = "Option " + Integer.parseInt(option);

        softAssert.assertTrue(actualOption.equals(expectedOption), "\nOption selected is not the right one\n" +
                "Expected: " + expectedOption + "\nActual: " + actualOption + "\n");

        softAssert.assertAll();

    }

    public void logMessage(String option) {
        log.info("Starting test picking option #{} from dropdown", option);
    }
}
