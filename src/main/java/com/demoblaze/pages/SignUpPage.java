package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    private final By usernameSignUpInput = By.id("sign-username");
    private final By passwordSignUpInput = By.id("sign-password");
    private final By signUpConfirmation = By.xpath("//*[@id='signInModal']//button[text() = 'Sign up']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void fillSignUpForm(String username, String password) {
        driver.findElement(usernameSignUpInput).sendKeys(username);
        driver.findElement(passwordSignUpInput).sendKeys(password);
        driver.findElement(signUpConfirmation).click();
    }
}