package com.cabtm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {

    private WebDriver driver;

    // Locators for web elements on the dashboard page
    private By welcomeMessageLocator = By.cssSelector("span.username");
    private By usernameFieldLocator = By.cssSelector("input[placeholder='Username / Email']");
    private By passwordFieldLocator = By.cssSelector("input[placeholder='Password']");
    private By loginButtonLocator = By.cssSelector("button[type='submit']");
    private By systemDashboardLinkLocator = By.xpath("//span[contains(text(),'System Dashboard')]");
    
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    // Get the welcome message text on the dashboard page
    public String getWelcomeMessage() {
        WebElement welcomeMessageElement = driver.findElement(welcomeMessageLocator);
        return welcomeMessageElement.getText();
    }

    // Perform login action using provided username and password
    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(usernameFieldLocator);
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        WebElement loginButton = driver.findElement(loginButtonLocator);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    


    // Click on the "System Dashboard" link
    public void clickSystemDashboard() {
        WebElement systemDashboardLink = driver.findElement(systemDashboardLinkLocator);
        systemDashboardLink.click();

        // Wait for the page to load (you may need to add an explicit wait here if required)
    }

    // Verify the presence of various sections on the "System Dashboard" page
    public boolean verifySystemDashboardSections() {
        boolean isTotalRidesDisplayed = driver.findElement(By.xpath("//p[contains(text(),'TOTAL Number of rides')]/following-sibling::h3")).isDisplayed();
        boolean isTotalCancelledRidesDisplayed = driver.findElement(By.xpath("//p[contains(text(),'TOTAL Cancelled rides')]/following-sibling::h3")).isDisplayed();
        boolean isTotalRevenueDisplayed = driver.findElement(By.xpath("//p[contains(text(),'TOTAL Revenue')]/following-sibling::h3")).isDisplayed();

        return isTotalRidesDisplayed && isTotalCancelledRidesDisplayed && isTotalRevenueDisplayed;
    }
}