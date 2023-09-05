package org.ait.DemoWebShopVOM.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageElementPresent() {
        return isElementPresent(By.xpath("//span[contains(text(),'Wishlist')]"));
    }
}
