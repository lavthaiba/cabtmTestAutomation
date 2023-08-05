package com.cabtm.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cabtm.ConfigFileReader;

public class BaseTest {

    protected WebDriver driver;
    private ConfigFileReader configFileReader;
    protected String baseURL;
    protected String username;
    protected String password;
    protected static ExtentReports extent;
    protected ExtentTest test;
    

 // Static block to initialize the extent object
    static {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(getExtentReportFilePath());
        extent.attachReporter(spark);
    }
    
    
	@BeforeMethod
    public void setUp() {
    	
        // Initialize ConfigFileReader
        configFileReader = new ConfigFileReader();
            
        
        // Get the browser choice from ConfigFileReader
        ConfigFileReader.BrowserChoice browserChoice = configFileReader.getBrowserChoice();
        

        // Set up WebDriver based on the browser choice
        switch (browserChoice) {
            case CHROME:
                // Uncomment the line below if you are using a custom path for chromedriver
                System.setProperty("webdriver.chrome.driver", getResourcePath("/chromedriver.exe"));
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                // Uncomment the line below if you are using a custom path for geckodriver
                String geckoDriverPath = getResourcePath("/geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser choice: " + browserChoice);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Set up test data from ConfigFileReader
        baseURL = configFileReader.getBaseURL();
        username = configFileReader.getUsername();
        password = configFileReader.getPassword();
        test = extent.createTest(getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        
     // Flush and close ExtentReports
        extent.flush();

    }
    
    private static String getExtentReportFilePath() {
        String reportFileName = "ExtentReport.html";
        return new File("test-output", reportFileName).getAbsolutePath();
    }

    protected void logTestStep(Status status, String message) {
        test.log(status, message);
    }

    protected WebElement waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not visible: " + locator);
        }
    }

    private String getResourcePath(String resourceName) {
        // Use resource loading to get the absolute path of the resource
        return BaseTest.class.getResource(resourceName).getPath();
    }
}
