package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPurchase extends BasePage {

    private final By confirMationMessage = By.xpath("//div[contains(@class, 'sweet-alert')]/h2[contains(text(), 'Thank you')]");
    private final By confirmationBtn = By.xpath("//button[text() = 'OK']");

    public ConfirmationPurchase(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirMationMessage).getText();
    }

    public void clickConfirmation() {
        driver.findElement(confirmationBtn).click();
    }
}
