package com.demoblaze.pages;

import com.aventstack.extentreports.Status;
import com.demoblaze.helpers.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class MonitorCategoryPage extends BasePage {

    private final By monitorCategoryBtn = By.xpath("//div[@class=\"list-group\"]//a[contains(text(), 'Monitors')]");

    public MonitorCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectMonitorCategory() {
        final int MAX_ATTEMPTS = 3;
        for (int attempt = 0; true; attempt++) {
            try {
                wait.visibilityOfElementLocated(monitorCategoryBtn);
                driver.findElement(monitorCategoryBtn).click();
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Select Monitor Category");
                break;
            } catch (StaleElementReferenceException e) {
                if (attempt == MAX_ATTEMPTS - 1) {
                    throw e;
                }

            }
        }
    }

}
