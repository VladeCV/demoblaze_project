package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    private final By signUpButton = By.id("signin2");
    private final By loginButton = By.id("login2");
    private final By usernameSignUpInput = By.id("sign-username");
    private final By passwordSignUpInput = By.id("sign-password");
    private final By usernameLoginInput = By.xpath("//*[@id=\"loginusername\"]");
    private final By passwordLoginInput = By.xpath("//*[@id=\"loginpassword\"]");
    private final By loginLabel = By.xpath("//*[@id=\"logInModalLabel\"]");
    private final By signUpConfirmation = By.xpath("//*[@id=\"signInModal\"]//button[text() = 'Sign up']");
    private final By loginConfirmation = By.xpath("//*[@id=\"logInModal\"]//button[text() = 'Log in']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void fillSignUpForm(String username, String password) {
        driver.findElement(usernameSignUpInput).sendKeys(username);
        driver.findElement(passwordSignUpInput).sendKeys(password);
        driver.findElement(signUpConfirmation).click();
    }

    public void fillLoginForm(String username, String password) {
        driver.findElement(usernameLoginInput).sendKeys(username);
        driver.findElement(passwordLoginInput).sendKeys(password);
        driver.findElement(loginConfirmation).click();
    }

    public void clickSignUp() {
        driver.findElement(signUpButton).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginLabelVisible() {
        return driver.findElement(loginLabel).isDisplayed();
    }
}
