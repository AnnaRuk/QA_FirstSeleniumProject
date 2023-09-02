package org.ait.DemoWebShopRefactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckShopingCart extends TestBase {


    @BeforeMethod
    public void ensurePrecondition(){
        if (!isElementPresent(By.xpath("//a[contains(text(),'Log in')]"))){
            click(By.xpath("//a[contains(text(),'Log out')]"));
        }
        click(By.xpath("//a[contains(text(),'Log in')]"));
        type(By.xpath("//input[@id='Email']"),"anna999@gmail.com");
        type(By.xpath("//input[@id='Password']"), "Qwerty0010");
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]"));
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]"));
        type(By.cssSelector("#giftcard_2_RecipientName"),"anna999");
        type(By.cssSelector("#giftcard_2_RecipientEmail"),"anna999@gmail.com");
        click(By.cssSelector("#add-to-cart-button-2"));
    }

    @Test
    public void checkSelectedItemIntoCart(){
        // зайти в корзину и убедиться, что он добавлен).
        goIntoCart();
        //1. check title = $25 Virtual Gift Card
        Assert.assertTrue(checkTitleOfItemIntoCart());
        //2. check amount of item = >0
        Assert.assertTrue(checkAmoundOfItemIntoCart());
    }

    public boolean checkTitleOfItemIntoCart(){
        return driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a[1]")).getText().equals("$25 Virtual Gift Card");
    }

    public boolean checkAmoundOfItemIntoCart() {
        WebElement amoundItemIntoCart = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/input[1]"));
        String numberItemIntoCart = amoundItemIntoCart.getAttribute("value");
        return !numberItemIntoCart.equals("0");
    }



    @AfterMethod()
    public void tearDown(){
        cleanCart();
    }
}
