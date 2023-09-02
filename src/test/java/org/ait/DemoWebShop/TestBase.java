package org.ait.DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    String logIn = "//a[contains(text(),'Log in')]";
    String logOut = "//a[contains(text(),'Log out')]";
    String email = "//input[@id='Email']";
    String password = "//input[@id='Password']";
    String buttonLogInScc = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]";


    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }




    public boolean isElementPresent(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public void cleanCart(){
        driver.findElement(By.xpath(logOut)).click();

    }



   @AfterMethod(enabled=false)
    //@AfterMethod()
    public void tearDown(){

        driver.quit();
    }
}
