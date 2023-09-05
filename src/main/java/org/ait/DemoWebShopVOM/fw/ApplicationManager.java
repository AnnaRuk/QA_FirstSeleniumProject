package org.ait.DemoWebShopVOM.fw;

import org.ait.DemoWebShopVOM.fw.CartHelper;
import org.ait.DemoWebShopVOM.fw.HomePageHelper;
import org.ait.DemoWebShopVOM.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {
    WebDriver driver;
    UserHelper userHelper;
    CartHelper cartHelper;
    HomePageHelper homePageHelper;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userHelper = new UserHelper(driver);
        cartHelper = new CartHelper(driver);
        homePageHelper = new HomePageHelper(driver);

    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CartHelper getCartHelper() {
        return cartHelper;
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }
}
