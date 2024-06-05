package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
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


    /**
     * Set up browser before each test
     *
     * @param method
     * @param ctx
     */
    @BeforeMethod( alwaysRun = true )
    public void setUp(Method method, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserFactory factory = new BrowserFactory(log);
        driver = factory.createDriver();
        driver.manage().window().maximize();
        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    /**
     * Quit browser after test is finished
     */
    @AfterMethod( alwaysRun = true )
    public void tearDown() {
        log.info("Close browser");
        driver.quit();
    }

}
