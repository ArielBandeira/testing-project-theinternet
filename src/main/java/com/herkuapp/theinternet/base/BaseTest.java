package com.herkuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    //SetUp
    @BeforeMethod( alwaysRun = true )
    public void setUp() {
        driver.manage().window().maximize();
    }

    //TearDown
    @AfterMethod( alwaysRun = true )
    public void tearDown() {
        log.info("Close browser");
        driver.quit();
    }

}
