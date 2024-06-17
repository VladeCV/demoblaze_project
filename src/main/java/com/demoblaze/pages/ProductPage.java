package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private final By asusMonitorBtn = By.xpath("//*[@id=\"tbodyid\"]//a[contains(text(),\"Apple monitor 24\")]");
    private final By sonyVaioBtn = By.xpath("//*[@id=\"tbodyid\"]//a[contains(text(),\"ASUS Full HD\")]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean listProductsIsVisible() {
        return driver.findElement(asusMonitorBtn).isDisplayed() || driver.findElement(sonyVaioBtn).isDisplayed();
    }
}
