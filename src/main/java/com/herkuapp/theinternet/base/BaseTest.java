package com.herkuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    //SetUp
    @BeforeMethod( alwaysRun = true )
    public void setUp(Method method, ITestContext ctx) {
        driver.manage().window().maximize();
        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    //TearDown
    @AfterMethod( alwaysRun = true )
    public void tearDown() {
        log.info("Close browser");
        driver.quit();
    }

}
