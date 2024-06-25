package com.demoblaze.pages;

import com.aventstack.extentreports.Status;
import com.demoblaze.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    //    private final By listCartProductsTable = By.id("tbodyid");
    private final By deleteProductBtn = By.linkText("Delete");
    private final By totalPriceLabel = By.id("totalp");
    private final By placeOrderBtn = By.xpath("//button[text() = 'Place Order']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Click on Place Order");
    }

//    public boolean listCartProductsIsVisible() {
//        return driver.findElement(listCartProductsTable).isDisplayed();
//    }

    public String getTotalPrice() {
        wait.visibilityOfElementLocated(totalPriceLabel);
        return driver.findElement(totalPriceLabel).getText();
    }


}
