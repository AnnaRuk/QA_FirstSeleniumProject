package org.ait.DemoWebShopVOM.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartHelper extends HelperBase{
    public CartHelper(WebDriver driver) {
        super(driver);
    }

    //TODO remove item from cart
    public void cleanCart(){
        WebElement checkBox = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]"));
        checkBox.click();
        driver.findElement(By.cssSelector(".button-2.update-cart-button")).click();

    }

    public void goIntoCart() {
//        WebElement cartField = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(cartField).perform();
//        click(By.cssSelector("[value='Go to cart']"));

        driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
    }

    public boolean checkTitleOfItemIntoCart(){
        return driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a[1]")).getText().equals("$25 Virtual Gift Card");
    }

    public boolean checkAmoundOfItemIntoCart() {
        WebElement amoundItemIntoCart = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/input[1]"));
        String numberItemIntoCart = amoundItemIntoCart.getAttribute("value");
        return !numberItemIntoCart.equals("0");
    }

    public boolean isGreenFieldPresendAndItemAddToCart() {
        return isElementPresent(By.cssSelector(".content"));
    }

    public void clickButtonAddToCartInItemCard() {
        click(By.cssSelector("#add-to-cart-button-2"));
    }

    public void fillFormNameAndEmailBeforeAddIttenIntoCart(String name, String email) {
        type(By.cssSelector("#giftcard_2_RecipientName"), name);
        type(By.cssSelector("#giftcard_2_RecipientEmail"), email);
    }

    public void clickButtonAddToCartBelowPeactureOfItem() {
        click(By.xpath("//body/div[4]/div[1]/div[4]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]"));
    }

    public boolean checkCartItems (){
        //.cart-qty = css (0)
        return !driver.findElement(By.cssSelector(".cart-qty")).getText().equals("(0)");

    }
}
