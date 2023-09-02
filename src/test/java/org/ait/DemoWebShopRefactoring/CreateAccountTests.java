package org.ait.DemoWebShopRefactoring;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    //click on Login link
    //enter email
    //enter password
    //click on Registration button
    //assert Sign out button displayed

    @BeforeMethod
    public void ensurePrecondition(){

        if (!isElementPresent(By.xpath("//a[contains(text(),'Log in')]"))){
            click(By.xpath("//a[contains(text(),'Log out')]"));
        }
        click(By.xpath("//a[contains(text(),'Log in')]"));
    }


    @Test
    public void newUserRegistrationPositiveTest(){
        type(By.xpath("//input[@id='Email']"),"anna999@gmail.com");
        type(By.xpath("//input[@id='Password']"), "Qwerty0010");
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]"));
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(text(),'Log out')]")));
    }

}
