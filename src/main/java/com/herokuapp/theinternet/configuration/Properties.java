package com.herokuapp.theinternet.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Properties {

    protected static java.util.Properties properties;
    private static final String propertiesPath = "configuration/base.properties";

    /**
     * Get a property from config file
     * @param key
     * @return property
     */
    public static String getConfig(String key) {
        return properties.get(key).toString();
    }

    /**
     * Load config file
     */
    static {
        properties = new java.util.Properties();
        try {
            FileInputStream file = new FileInputStream(new File(propertiesPath));
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWelcomePageUrl() {
        return getConfig("welcomePageUrl");
    }

    public String getModalTitle() {
        return getConfig("ModalTitle");
    }

    public String getModalText() {
        return getConfig("ModalText");
    }

    public String getPageOneUrl(){
        return getConfig("PageOneUrl");
    }

    public String getPageTwoUrl(){
        return getConfig("PageTwoUrl");
    }

}
