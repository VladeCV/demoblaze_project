package com.demoblaze.pages;

import com.demoblaze.util.PriceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDescriptionPage extends BasePage {
    private final By productNameLabel = By.xpath("//h2[@class='name']");
    private final By productPriceLabel = By.xpath("//h3[@class='price-container']");
    private final By productDescriptionLabel = By.id("more-information");
    private final By addToCartBtn = By.linkText("Add to cart");
    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName () {
        wait.visibilityOfElementLocated(productNameLabel);
        return driver.findElement(productNameLabel).getText();
    }

    public Double getProductPrice () {
        return PriceUtils.cleanPriceTxt(driver.findElement(productPriceLabel).getText());
    }

    public boolean productDescriptionIsVisible () {
        return driver.findElement(productDescriptionLabel).isDisplayed();
    }

    public void clickAddToCartBtn() {
        wait.elementToBeClickable(addToCartBtn);
        driver.findElement(addToCartBtn).click();
    }

}
