package com.cabtm.tests;

import com.cabtm.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    private ConfigFileReader configFileReader;

    @BeforeClass
    public void setUp() {
        // Initialize ConfigFileReader
        configFileReader = new ConfigFileReader();

        // Get the browser choice from ConfigFileReader
        ConfigFileReader.BrowserChoice browserChoice = configFileReader.getBrowserChoice();

        // Set up WebDriver based on the browser choice
        switch (browserChoice) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser choice: " + browserChoice);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}