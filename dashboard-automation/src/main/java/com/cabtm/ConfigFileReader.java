package com.cabtm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
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