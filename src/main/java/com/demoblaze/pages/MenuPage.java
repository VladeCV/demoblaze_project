package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage{

    private final By homeLabel = By.linkText("Home ");
    private final By cartLabel = By.linkText("Cart");
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickHomeLabel() {
        driver.findElement(homeLabel).click();
    }

    public void clickCartLabel() {
        driver.findElement(cartLabel).click();
    }
}
