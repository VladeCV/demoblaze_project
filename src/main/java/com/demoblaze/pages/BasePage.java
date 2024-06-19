package com.demoblaze.pages;

import com.demoblaze.util.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final WebDriver driver;

    protected final Wait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }
    
}
