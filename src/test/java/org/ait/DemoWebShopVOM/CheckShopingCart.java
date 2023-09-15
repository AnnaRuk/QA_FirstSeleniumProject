package org.ait.DemoWebShopVOM;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckShopingCart extends TestBase {


    @BeforeMethod
    public void ensurePrecondition(){

        app.getUserHelper().pauseSelenium(2000);

        app.getUserHelper().clickLogInHomePage();

        app.getUserHelper().pauseSelenium(2000);

        app.getUserHelper().login();

        app.getUserHelper().pauseSelenium(2000);
        app.getCartHelper().clickButtonAddToCartBelowPeactureOfItem();
        app.getCartHelper().fillFormNameAndEmailBeforeAddIttenIntoCart("anna999", "anna999@gmail.com");
        app.getCartHelper().clickButtonAddToCartInItemCard();
    }

    @Test
    public void checkSelectedItemIntoCartTest(){
        // зайти в корзину и убедиться, что он добавлен).
        app.getCartHelper().goIntoCart();
        //1. check title = $25 Virtual Gift Card
        Assert.assertTrue(app.getCartHelper().checkTitleOfItemIntoCart());
        //2. check amount of item = >0
        Assert.assertTrue(app.getCartHelper().checkAmoundOfItemIntoCart());
        app.getCartHelper().cleanCart();

    }

}
