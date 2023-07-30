package com.cabtm.tests;

import com.cabtm.ConfigFileReader;
import com.cabtm.Dashboard;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

	 private String baseURL;
	 private String username;
	 private String password;

	 @BeforeClass
	    public void setUpTestData() {
	        // Create an instance of ConfigFileReader to read the properties
	        ConfigFileReader configFileReader = new ConfigFileReader();
	        baseURL = configFileReader.getBaseURL();
	        username = configFileReader.getUsername();
	        password = configFileReader.getPassword();
	    }
	  
	 
    @Test
    public void testLoginAndWelcomeMessage() {
        driver.get(baseURL);

        // Create an instance of the Dashboard class to interact with the dashboard page
        Dashboard dashboard = new Dashboard(driver);

        // Perform login using the provided username and password
        dashboard.login(username, password);

        // Get the welcome message displayed on the dashboard
        String welcomeMessage = dashboard.getWelcomeMessage();

        // Validate the welcome message after successful login
        String expectedWelcomeMessage = "Cabtm Nepal";
        Assert.assertEquals(welcomeMessage, expectedWelcomeMessage,
            "Welcome message does not match the expected message.");
    }
}