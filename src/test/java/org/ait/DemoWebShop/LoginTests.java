package org.ait.DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){

        if (!isElementPresent(By.xpath(logIn))){
            driver.findElement(By.xpath(logOut)).click();
        }

        driver.findElement(By.xpath(logIn)).click();
    }
    
    @Test
    public void liginPositiveTest(){

        driver.findElement(By.xpath(email)).click();
        driver.findElement(By.xpath(email)).clear();
        driver.findElement(By.xpath(email)).sendKeys("anna999@gmail.com");

        driver.findElement(By.xpath(password)).click();
        driver.findElement(By.xpath(password)).clear();
        driver.findElement(By.xpath(password)).sendKeys("Qwerty0010");


        driver.findElement(By.xpath(buttonLogInScc)).click();

        // na stranice pojavljaetsja pri Log Ine
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(text(),'anna999@gmail.com')]")));

    }


}
