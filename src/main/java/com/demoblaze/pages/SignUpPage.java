package com.demoblaze.pages;

import com.demoblaze.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    private final By usernameSignUpInput = new By.ById("sign-username");
    private final By passwordSignUpInput = new By.ById("sign-password");
    private final By signUpConfirmation = By.xpath("//*[@id='signInModal']//button[text() = 'Sign up']");
    private final Wait wait;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.wait = new Wait(driver);
    }

    public void fillSignUpForm(String username, String password) {
        final int MAX_ATTEMPTS = 3;
        for (int attempt = 0; true; attempt++) {
            try {
                wait.visibilityOfElementLocated(usernameSignUpInput);
                driver.findElement(usernameSignUpInput).sendKeys(username);
                wait.visibilityOfElementLocated(passwordSignUpInput);
                driver.findElement(passwordSignUpInput).sendKeys(password);
                break; // if successful, break the loop
            } catch (StaleElementReferenceException e) {
                if (attempt == MAX_ATTEMPTS - 1) {
                    throw e; // if it's the last attempt, rethrow the exception
                }
                // if not the last attempt, ignore the exception and try again
            }
        }
        driver.findElement(signUpConfirmation).click();
    }

}
