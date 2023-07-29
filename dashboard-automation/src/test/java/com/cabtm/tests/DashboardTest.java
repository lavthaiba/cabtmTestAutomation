package com.cabtm.tests;

import com.cabtm.Dashboard;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private String baseURL = "https://dev.bbnadmin.cabtm.com";
    private String username = "dev@admin.com";
    private String password = "cabtm123@";

    @Test
    public void testLoginAndWelcomeMessage() {
        driver.get(baseURL);

        // Create an instance of the Dashboard class to interact with the dashboard page
        Dashboard dashboard = new Dashboard(driver);

        // Perform login using the provided username & password
        dashboard.login(username, password);

        // Get the welcome message displayed on the dashboard
        String welcomeMessage = dashboard.getWelcomeMessage();

        //  Validate the welcome message after successful login
        String expectedWelcomeMessage = "Cabtm Nepal";
        Assert.assertEquals(welcomeMessage, expectedWelcomeMessage,
            "Welcome message does not match the expected message.");
    }
}