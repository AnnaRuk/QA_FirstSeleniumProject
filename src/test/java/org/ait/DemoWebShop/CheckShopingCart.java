package org.ait.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckShopingCart extends TestBase{


    @BeforeMethod
    public void ensurePrecondition(){

        if (!isElementPresent(By.xpath(logIn))){
            driver.findElement(By.xpath(logOut)).click();
        }

        driver.findElement(By.xpath(logIn)).click();
        //email = "//input[@id='Email']"  - xpath
        //type
        driver.findElement(By.xpath(email)).click();
        driver.findElement(By.xpath(email)).clear();
        driver.findElement(By.xpath(email)).sendKeys("anna999@gmail.com");
        //password = "//input[@id='Password']" - xpath
        //type
        driver.findElement(By.xpath(password)).click();
        driver.findElement(By.xpath(password)).clear();
        driver.findElement(By.xpath(password)).sendKeys("Qwerty0010");
        //  buttonLogInScc = "[value=Log in]" - css
        //click
        driver.findElement(By.xpath(buttonLogInScc)).click();

        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();



        //#giftcard_2_RecipientName = input name
        driver.findElement(By.cssSelector("#giftcard_2_RecipientName")).click();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientName")).clear();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientName")).sendKeys("anna999");

        // #giftcard_2_RecipientEmail = input email
        driver.findElement(By.cssSelector("#giftcard_2_RecipientEmail")).click();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientEmail")).clear();
        driver.findElement(By.cssSelector("#giftcard_2_RecipientEmail")).sendKeys("anna999@gmail.com");

        // добавить,
        //.content = css
        driver.findElement(By.cssSelector("#add-to-cart-button-2")).click();
    }

    @Test
    public void checkSelectedItemIntoCart(){
        // зайти в корзину и убедиться, что он добавлен).
        //span[contains(text(),'Shopping cart')]
        WebElement cartField = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cartField).perform();

// [value='Go to cart'] = button

        driver.findElement(By.cssSelector("[value='Go to cart']")).click();


        //1. check title = $25 Virtual Gift Card
        //tbody/tr[1]/td[3]/a[1] = title of item
        Assert.assertTrue(checkTitleOfItemIntoCart());

        //2. check amount of item = >0
        //   //tbody/tr[1]/td[5]/input[1]
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
