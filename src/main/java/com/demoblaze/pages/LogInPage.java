package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import com.demoblaze.util.Wait;

public class LogInPage extends BasePage {
    private final By loginLabel = new By.ById("logInModalLabel");
    private final By usernameLoginInput = new By.ById("loginusername");
    private final By passwordLoginInput = new By.ById("loginpassword");
    private final By loginConfirmation = By.xpath("//*[@id='logInModal']//button[text() = 'Log in']");
    private final Wait wait;

    public LogInPage(WebDriver driver) {
        super(driver);
        this.wait = new Wait(driver);
    }

    public void fillLoginForm(String username, String password) {
        final int MAX_ATTEMPTS = 3;
        for (int attempt = 0; true; attempt++) {
            try {
                wait.visibilityOfElementLocated(usernameLoginInput);
                driver.findElement(usernameLoginInput).sendKeys(username);
                wait.visibilityOfElementLocated(passwordLoginInput);
                driver.findElement(passwordLoginInput).sendKeys(password);
                break; // if successful, break the loop
            } catch (StaleElementReferenceException e) {
                if (attempt == MAX_ATTEMPTS - 1) {
                    throw e; // if it's the last attempt, rethrow the exception
                }
                // if not the last attempt, ignore the exception and try again
            }
        }
        driver.findElement(loginConfirmation).click();
    }

    public void clickOnLogin() {
        driver.findElement(loginConfirmation).click();
    }

    public boolean isLoginLabelVisible() {
        return driver.findElement(loginLabel).isDisplayed();
    }

}
