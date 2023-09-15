package org.ait.DemoWebShopVOM.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

//    public boolean isElementPresent(By locator){
//        try {
//            driver.findElement(locator);
//            return true;
//        } catch (NoSuchElementException ex){
//            return false;
//        }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;

    }

    public void click(By selector) {
        driver.findElement(selector).click();
    }

    public void type(By locator, String s) {
        if(s !=null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(s);
        }
    }

    public void pauseSelenium(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e + "Error pauseSelenium");
        }

    }
}
