package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage {
    private final By loginLabel = By.id("logInModalLabel");
    private final By usernameLoginInput = By.xpath("//*[@id='loginusername']");
    private final By passwordLoginInput = By.xpath("//*[@id='loginpassword']");
    private final By loginConfirmation = By.xpath("//*[@id='logInModal']//button[text() = 'Log in']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginForm(String username, String password) {
        driver.findElement(usernameLoginInput).sendKeys(username);
        driver.findElement(passwordLoginInput).sendKeys(password);
        driver.findElement(loginConfirmation).click();
    }

    public void clickOnLogin() {
        driver.findElement(loginConfirmation).click();
    }

    public boolean isLoginLabelVisible() {
        return driver.findElement(loginLabel).isDisplayed();
    }

}
