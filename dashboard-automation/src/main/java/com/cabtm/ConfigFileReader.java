package com.cabtm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader() {
        try {
            properties = new Properties();
            // Load the config.properties file using resource loading
            InputStream inputStream = ConfigFileReader.class.getResourceAsStream("/config.properties");
            if (inputStream == null) {
                throw new IllegalArgumentException("config.properties file not found.");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseURL() {
        return getProperty("baseURL");
    }

    public String getUsername() {
        return getProperty("username");
    }

    public String getPassword() {
        return getProperty("password");
    }
    private String getProperty(String propertyName) {
        String propertyValue = properties.getProperty(propertyName);
        if (propertyValue == null) {
            throw new IllegalArgumentException("Property not found: " + propertyName);
        }
        return propertyValue;
    }
    
    public BrowserChoice getBrowserChoice() {
        String browserChoice = properties.getProperty("browser");
        return BrowserChoice.fromString(browserChoice);
    }

    public enum BrowserChoice {
        CHROME, FIREFOX;

        public static BrowserChoice fromString(String text) {
            if (text == null) {
                throw new IllegalArgumentException("Browser choice cannot be null.");
            }
            switch (text.trim().toLowerCase()) {
                case "chrome":
                    return CHROME;
                case "firefox":
                    return FIREFOX;
                default:
                    throw new IllegalArgumentException("Invalid browser choice: " + text);
            }
        }
    }
}