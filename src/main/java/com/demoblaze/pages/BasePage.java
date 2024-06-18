package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import util.Wait;

public class BasePage {

    protected final WebDriver driver;

    protected final Wait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }
    
}
