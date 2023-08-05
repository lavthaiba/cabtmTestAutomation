package com.cabtm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import com.aventstack.extentreports.Status;
import com.cabtm.Dashboard;

public class DataDrivenLoginTest extends BaseTest {

	@BeforeClass
    public void callBaseTestSetUp() {
        setUp();
    }

	    @Test(dataProvider = "loginTestData")
	    public void testLoginAndWelcomeMessage(String username, String password, String expectedErrorMessage) {
	        driver.get(baseURL);

	        // Perform login using the provided username and password
	        Dashboard dashboard = new Dashboard(driver);
	        dashboard.login(username, password);

	       

	        // Check if invalid credentials message is displayed
	        if (expectedErrorMessage.equals("Admin not found") || expectedErrorMessage.equals("Access Denied")) {
	            try {
	                waitUntilVisible(By.cssSelector(".error_container > span:nth-child(1)"));
	                logTestStep(Status.INFO, "Logged in with invalid credentials: " + username + ", " + password);
	                logTestStep(Status.PASS, "Error message '" + expectedErrorMessage + "' displayed as expected.");
	            } catch (NoSuchElementException e) {
	                logTestStep(Status.FAIL, "Error message '" + expectedErrorMessage + "' not displayed.");
	                Assert.fail("Error message '" + expectedErrorMessage + "' not displayed.");
	            }
	        } else if (expectedErrorMessage.equals("Please fill out this field.")) {
	            try {
	                waitUntilVisible(By.cssSelector("input[placeholder='Username / Email'][required]"));
	                logTestStep(Status.INFO, "Error message '" + expectedErrorMessage + "' displayed as expected.");
	            } catch (NoSuchElementException e) {
	                logTestStep(Status.FAIL, "Error message '" + expectedErrorMessage + "' not displayed.");
	                Assert.fail("Error message '" + expectedErrorMessage + "' not displayed.");
	            }
	        } else {
	            // Wait for the welcome message to be visible
	            waitUntilVisible(By.cssSelector("span.username"));
	            logTestStep(Status.INFO, "Logged in successfully with username: " + username);
	            logTestStep(Status.PASS, "Login Verified and username shown on the dashboard");
	        }
	        
	    }

	   

	    @DataProvider(name = "loginTestData")
    public Object[][] loginTestData() {
        return new Object[][]{
        	
        	
        	 // Test data for valid login
            {configFileReader.getUsername(), configFileReader.getPassword(), "Cabtm Nepal"},

            // Test data for negative testing - incorrect credentials
            {"InvalidUsername", configFileReader.getPassword(), "Admin not found"},
            {configFileReader.getUsername(), "InvalidPassword", "Access Denied"},
           // {"InvalidUsername", "InvalidPassword", "Admin not found"},

            // Test data for empty username and password
            {"", configFileReader.getPassword(), "Please fill out this field."},
            {configFileReader.getUsername(), "", "Please fill out this field."},
            {"", "", "Please fill out this field."}
        };
    }
}
