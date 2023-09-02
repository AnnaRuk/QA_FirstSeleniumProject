package org.ait.DemoWebShopRefactoring;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCart extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){

        if (!isElementPresent(By.xpath("//a[contains(text(),'Log in')]"))){
            click(By.xpath("//a[contains(text(),'Log out')]"));
        }
           click(By.xpath("//a[contains(text(),'Log in')]"));
        type(By.xpath("//input[@id='Email']"),"anna999@gmail.com");
        type(By.xpath("//input[@id='Password']"), "Qwerty0010");
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]"));

    }

    @Test

    public void addProductToCart(){
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]"));

        type(By.cssSelector("#giftcard_2_RecipientName"),"anna999");
        type(By.cssSelector("#giftcard_2_RecipientEmail"),"anna999@gmail.com");
        click(By.cssSelector("#add-to-cart-button-2"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".content")));
        Assert.assertTrue(checkCartItems());

    }


    public boolean checkCartItems (){
        //.cart-qty = css (0)
        return !driver.findElement(By.cssSelector(".cart-qty")).getText().equals("(0)");

    }

}
