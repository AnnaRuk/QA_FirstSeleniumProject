package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.models.User;
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

        app.getUserHelper().clickLogInHomePage();
    }


    @Test
    public void newUserRegistrationPositiveTest(){
        app.getUserHelper().fillLoginForm(new User()
                .setEmail("anna999@gmail.com")
                .setPassword("Qwerty0010"));
        app.getUserHelper().clickOnLogInButtonIntoForm();
        Assert.assertTrue(app.getUserHelper().isElementLoOutPresentLoginDone());
    }

}
