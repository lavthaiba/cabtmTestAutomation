package com.cabtm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cabtm.Dashboard;

public class LoginTest extends BaseTest {

	
	  
	 
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
       
       // Log test steps and results using ExtentReports
       logTestStep(Status.INFO, "Logged in successfully.");
       logTestStep(Status.PASS, "Login Verified and username shown on the dashboard");
       
       Assert.assertEquals(welcomeMessage, expectedWelcomeMessage,
           "Welcome message does not match the expected message.");
   }
}