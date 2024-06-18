package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDescriptionPage extends BasePage {
    private final By productNameLabel = By.tagName("h2");
    private final By productPriceLabel = By.tagName("h3");
    private final By productDescriptionLabel = By.id("more-information");
    private final By addToCartBtn = By.linkText("Add to cart");
    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName () {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLabel));
        wait.visibilityOfElementLocated(productNameLabel);
        return driver.findElement(productNameLabel).getText();
    }

    public String getProductPrice () {
        return driver.findElement(productPriceLabel).getText();
    }

    public boolean productDescriptionIsVisible () {
        return driver.findElement(productDescriptionLabel).isDisplayed();
    }

    public void clickAddToCartBtn() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        wait.elementToBeClickable(addToCartBtn);
        driver.findElement(addToCartBtn).click();
    }

}
