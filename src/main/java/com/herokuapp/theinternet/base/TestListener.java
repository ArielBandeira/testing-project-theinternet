package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestListener implements ITestListener {

    WebDriver driver;
    Logger log;
    String testName;
    String testMethodName;

    /**
     * Logs the start of one test method
     * @param result
     */
    @Override
    public void onTestStart(ITestResult result) {
        this.testMethodName = result.getMethod().getMethodName();
        log.info("[Starting " + testMethodName + "]");
    }

    /**
     * Logs test pause
     * @param result
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("[Test " + testMethodName + " passed]");
    }

    /**
     * Logs a test failure
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result) {
        log.info("[Test " + testMethodName + " failed]");
    }

    /**
     * Logs a test skip
     * @param result
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("[Test " + testMethodName + " was skipped]");
    }

    /**
     * Logs percentage of success on test failure
     * @param result
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    /**
     * Logs a test class start
     * @param context
     */
    @Override
    public void onStart(ITestContext context) {
        this.testName = context.getCurrentXmlTest().getName();
        this.log = LogManager.getLogger(testName);
        log.info("[TEST " + testName + " STARTED]");
    }

    /**
     * Logs when a test is finished
     * @param context
     */
    @Override
    public void onFinish(ITestContext context) {
        log.info("[ALL " + testName + " FINISHED]");
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
