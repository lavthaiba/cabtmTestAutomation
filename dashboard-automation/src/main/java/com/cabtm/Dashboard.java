package com.cabtm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {

    private WebDriver driver;

    // Locators for web elements on the dashboard page
    private By welcomeMessageLocator = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/span[1]");
    private By usernameFieldLocator = By.xpath("/html/body/div/div/div/form/input[1]");
    private By passwordFieldLocator = By.xpath("/html/body/div/div/div/form/input[2]");
    private By loginButtonLocator = By.xpath("/html/body/div/div/div/form/button");

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
}