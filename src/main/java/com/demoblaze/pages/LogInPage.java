package com.demoblaze.pages;

import com.aventstack.extentreports.Status;
import com.demoblaze.helpers.ScreenShotHelper;
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
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO,"Enter credentials");
                break;
            } catch (StaleElementReferenceException e) {
                if (attempt == MAX_ATTEMPTS - 1) {
                    throw e;
                }
            }
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO,"Login");
        driver.findElement(loginConfirmation).click();
    }

    public void clickOnLogin() {
        driver.findElement(loginConfirmation).click();
    }

    public boolean isLoginLabelVisible() {
        return driver.findElement(loginLabel).isDisplayed();
    }

}
