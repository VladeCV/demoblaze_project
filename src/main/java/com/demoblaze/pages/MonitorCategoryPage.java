package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MonitorCategoryPage extends BasePage {

    private final By monitorCategoryBtn = By.xpath("//div[@class=\"list-group\"]//a[contains(text(), 'Monitors')]");

    public MonitorCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectMonitorCategory() {
        driver.findElement(monitorCategoryBtn).click();
    }

}
