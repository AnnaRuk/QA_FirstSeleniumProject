package org.ait.DemoWebShopVOM;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCart extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){

        app.getUserHelper().clickLogInHomePage();
        app.getUserHelper().login();

    }

    @Test

    public void addProductToCartTest(){
        app.getCartHelper().clickButtonAddToCartBelowPeactureOfItem();  //add to cart below img
        app.getCartHelper().fillFormNameAndEmailBeforeAddIttenIntoCart("anna999", "anna999@gmail.com");
        app.getCartHelper().clickButtonAddToCartInItemCard();
        Assert.assertTrue(app.getCartHelper().isGreenFieldPresendAndItemAddToCart());
        Assert.assertTrue(app.getCartHelper().checkCartItems());

    }


}
