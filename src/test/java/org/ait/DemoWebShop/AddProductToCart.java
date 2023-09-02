package org.ait.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class AddProductToCart extends TestBase{

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
    }

    @Test

    public void addProductToCart(){
        //выбрать товар на главной странице,
        // зайти в него,//css [alt="Picture of $25 Virtual Gift Card"]
        //driver.findElement(By.cssSelector("[alt='Picture of $25 Virtual Gift Card']")).click();
        //driver.findElement(By.cssSelector("[title='Show details for $25 Virtual Gift Card']")).click();

        //body/div[4]/div[1]/div[4]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]
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

        // #add-to-cart-button-2

        Assert.assertTrue(isElementPresent(By.cssSelector(".content")));

        //check that items into cart not 0
        Assert.assertTrue(checkCartItems());

        //________________________________________


    }




    public boolean checkCartItems (){
        //.cart-qty = css (0)
        return !driver.findElement(By.cssSelector(".cart-qty")).getText().equals("(0)");

    }


//    @AfterMethod()
//    public void tearDown(){
//    cleanCart();
//    }
}
