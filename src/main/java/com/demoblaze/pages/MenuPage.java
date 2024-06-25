package com.demoblaze.pages;

import com.aventstack.extentreports.Status;
import com.demoblaze.enums.MenuOption;
import com.demoblaze.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    //    private final By homeLabel = By.xpath("//a[contains(text(), 'Home')]");
//    private final By cartLabel = By.linkText("Cart");
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public By getMenuSelector(String option) {
        return By.xpath("//a[contains(text(), '" + option + "')]");
    }

    public void clickOnMenuOption(MenuOption option) {
        driver.findElement(getMenuSelector(option.getMenuOption())).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Click on " + option.getMenuOption());
    }

//    public void clickHomeLabel() {
//        wait.visibilityOfElementLocated(homeLabel);
//        driver.findElement(homeLabel).click();
//    }

//    public void clickCartLabel() {
//        driver.findElement(cartLabel).click();
//    }
}
