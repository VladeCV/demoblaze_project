package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public By getProductSelector(String product) {
        return By.xpath("//a[contains(text(),'"+product+"')]");
    }

    public void clickProductSelected(String product) {
        wait.visibilityOfElementLocated(getProductSelector(product));
        driver.findElement(getProductSelector(product)).click();
    }

//    public boolean listProductsIsVisible() {
//        return driver.findElement(asusMonitorBtn).isDisplayed() || driver.findElement(sonyVaioBtn).isDisplayed();
//    }
}
