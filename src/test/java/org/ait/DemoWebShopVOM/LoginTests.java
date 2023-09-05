package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        app.getUserHelper().clickLogInHomePage();
    }

    @Test
    public void loginPositiveTest(){
        app.getUserHelper().fillLoginForm(new User()
                .setEmail("anna999@gmail.com")
                .setPassword("Qwerty0010"));
        //click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")); ////button Login in form
        app.getUserHelper().clickOnLogInButtonIntoForm(); //button Login in form
        Assert.assertTrue(app.getUserHelper().isLogInAndEmailPresent());

    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUserHelper().fillLoginForm(new User()
                .setPassword("Qwerty0010"));
        //click(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")); ////button Login in form
        app.getUserHelper().clickOnLogInButtonIntoForm(); //button Login in form
        //Assert.assertTrue(isLogInAndEmailPresent());
        app.getUserHelper().isElementPresent(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]"));

    }
}
