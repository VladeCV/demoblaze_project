package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDescriptionPage extends BasePage {
    private final By productNameLabel = By.tagName("h2");
    private final By productPriceLabel = By.tagName("h3");
    private final By productDescriptionLabel = By.id("more-information");
    private final By addToCartBtn = By.linkText("Add to cart");
    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName () {
        return driver.findElement(productNameLabel).getText();
    }

    public String getProductPrice () {
        return driver.findElement(productPriceLabel).getText();
    }

    public boolean productDescriptionIsVisible () {
        return driver.findElement(productDescriptionLabel).isDisplayed();
    }

    public void clickAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }

}
