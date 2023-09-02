package org.ait.DemoWebShopRefactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

   // String logIn = "//a[contains(text(),'Log in')]";
   // String logOut = "//a[contains(text(),'Log out')]";
   // String email = "//input[@id='Email']";
    //String password = "//input[@id='Password']";
  //  String buttonLogInScc = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]";


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

    //TODO remove item from cart
    public void cleanCart(){
        driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();

    }

    public void click(By selector) {
        driver.findElement(selector).click();
    }

    public void type(By locator, String s) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(s);
    }
    public void goIntoCart() {
        WebElement cartField = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cartField).perform();
        click(By.cssSelector("[value='Go to cart']"));
    }
   //@AfterMethod(enabled=false)
    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }
}
