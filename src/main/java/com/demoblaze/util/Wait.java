package com.demoblaze.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    private final WebDriverWait wait;

    public Wait(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 10);  // Inicializa el WebDriverWait aquí.
    }

    public void waitAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void visibilityOfElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void elementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
