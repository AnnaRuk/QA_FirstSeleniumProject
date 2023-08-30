package org.ait.DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(isElementPresent(By.xpath("//span[contains(text(),'Wishlist')]")));
    }

}
