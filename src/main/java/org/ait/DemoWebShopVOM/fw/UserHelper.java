package org.ait.DemoWebShopVOM.fw;

import org.ait.DemoWebShopVOM.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void logOut(){
        driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='Email']"), user.getEmail());
        type(By.xpath("//input[@id='Password']"), user.getPassword());
    }

    public boolean isLogInAndEmailPresent() {
        return isElementPresent(By.xpath("//a[contains(text(),'anna999@gmail.com')]"));
    }

    public void clickOnLogInButtonIntoForm() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void clickLogInHomePage() {
        if (!isElementPresent(By.xpath("//a[contains(text(),'Log in')]"))){
            click(By.xpath("//a[contains(text(),'Log out')]"));
        }
        click(By.xpath("//a[contains(text(),'Log in')]"));
    }

    public boolean isElementLoOutPresentLoginDone() {
        return isElementPresent(By.xpath("//a[contains(text(),'Log out')]"));
    }

    public void login() {

        fillLoginForm(new User().setEmail("anna999@gmail.com").setPassword("Qwerty0010"));
        clickOnLogInButtonIntoForm();
    }
}
