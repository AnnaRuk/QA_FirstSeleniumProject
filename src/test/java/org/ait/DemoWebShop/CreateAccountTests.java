package org.ait.DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //precondition: user should be logged out
    //click on Login link
    //enter email
    //enter password
    //click on Registration button
    //assert Sign out button displayed

    String logIn = "//a[contains(text(),'Log in')]";
    String logOut = "//a[contains(text(),'Log out')]";
    String email = "//input[@id='Email']";
    String password = "//input[@id='Password']";
    String buttonLogInScc = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]";



    @BeforeMethod
    public void ensurePrecondition(){

        if (!isElementPresent(By.xpath(logIn))){
            driver.findElement(By.xpath(logOut)).click();
        }

        driver.findElement(By.xpath(logIn)).click();
    }


    @Test
    public void isElementOnTheHomePage (){
        isElementPresent(By.xpath("//span[contains(text(),'Wishlist')]"));
    }

    @Test
    public void newUserRegistrationPositiveTest(){
        //email = "//input[@id='Email']"  - xpath
        driver.findElement(By.xpath(email)).click();
        driver.findElement(By.xpath(email)).clear();
        driver.findElement(By.xpath(email)).sendKeys("anna999@gmail.com");
        //password = "//input[@id='Password']" - xpath
        driver.findElement(By.xpath(password)).click();
        driver.findElement(By.xpath(password)).clear();
        driver.findElement(By.xpath(password)).sendKeys("Qwerty0010");
        //  buttonLogInScc = "[value=Log in]" - css
        driver.findElement(By.xpath(buttonLogInScc)).click();
        Assert.assertTrue(isElementPresent(By.xpath(logOut)));
    }

}
