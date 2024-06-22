package com.herokuapp.theinternet.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class TestUtilities extends BaseTest {

    /**
     * Sleep test for x milliseconds
     * @param millis
     * millis
     */
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Take screenshot of page
     * @param fileName
     * fileName
     */
    protected void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Path should be:
        //user.dir/test-output/TodayDate(yyyyMMdd)/testSuiteName/testName/testMethodName/SystemsTime(HHmmSSsss)/fileName.png

        String path = System.getProperty("user.dir") + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + getTodaysDate()
                + File.separator + testSuiteName
                + File.separator + testName
                + File.separator + testMethodName
                + File.separator + getSystemTime()
                + " " + fileName + ".png";


        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get today's date in yyyyMMdd format
     * @return todayDate
     */
    private static String getTodaysDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    /**
     * Get current time in HHmmssSSS
     * @return systemTime
     */
    private static String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    public ArrayList<String> readCSVFile() throws IOException {
        String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator
                + "dataproviders" + File.separator + getClass().getSimpleName() + File.separator
                + testMethodName + ".csv";
        File file = new File(pathname);
        BufferedReader bufRdr;
        bufRdr = new BufferedReader(new FileReader(file));
        String record;
        String url= null;
        ArrayList<String> list = new ArrayList<String>();
        while ((record = bufRdr.readLine()) != null)
        {
            String fields[] = record.split(",");
            url= fields[0].toString();
            list.add(record);
        }
        return list;
    }

    public ArrayList<String> readCSVFileWithPath(String pathname) throws IOException {
        File file = new File(pathname);
        BufferedReader bufRdr;
        bufRdr = new BufferedReader(new FileReader(file));
        String record;
        String url= null;
        ArrayList<String> list = new ArrayList<String>();
        while ((record = bufRdr.readLine()) != null)
        {
            String fields[] = record.split(",");
            url= fields[0].toString();
            list.add(record);
        }
        return list;
    }
}
