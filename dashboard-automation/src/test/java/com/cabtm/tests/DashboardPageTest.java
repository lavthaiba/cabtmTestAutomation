package com.cabtm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cabtm.Dashboard;

public class DashboardPageTest extends BaseTest {

	
	
    @Test
    public void testVerifySystemDashboardSections() {
    	driver.get(baseURL);
        // Create an instance of the Dashboard class to interact with the dashboard page
        Dashboard dashboard = new Dashboard(driver);

        // Perform login using the provided username and password
        dashboard.login(username, password);

        // Click on the "System Dashboard" link to navigate to the System Dashboard page
        dashboard.clickSystemDashboard();

        // Verify the presence of various sections on the System Dashboard page
        boolean areSectionsDisplayed = dashboard.verifySystemDashboardSections();
        
        // Log test steps and results using ExtentReports
        logTestStep(Status.INFO, "Logged in successfully.");
        logTestStep(Status.PASS, "System Dashboard page opened successfully.");
        logTestStep(Status.PASS, "Verified presence of sections on the System Dashboard page.");
        
     // Assert the test result using TestNG
        Assert.assertTrue(areSectionsDisplayed, "System Dashboard sections are not displayed.");
    }
}
