package com.herkuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WelcomePage {

    @Test
    public void testDriver() {
        String url = "https://the-internet.herokuapp.com";
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
    }

}
