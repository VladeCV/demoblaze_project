package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private final By nameInput = By.id("name");
    private final By countryInput = By.id("country");
    private final By cityInput = By.id("city");
    private final By creditCardInput = By.id("card");
    private final By monthInput = By.id("month");
    private final By yearInput = By.id("year");
    private final By purchaseBtn = By.xpath("//button[text() = 'Purchase']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillPaymentForm(String name, String country, String city, String creditCard, String month, String year) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(countryInput).sendKeys(country);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(creditCardInput).sendKeys(creditCard);
        driver.findElement(monthInput).sendKeys(month);
        driver.findElement(yearInput).sendKeys(year);

    }

    public void clickPurchase() {
        driver.findElement(purchaseBtn).click();
    }

}
