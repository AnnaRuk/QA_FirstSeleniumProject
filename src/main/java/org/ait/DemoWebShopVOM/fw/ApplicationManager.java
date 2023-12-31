package org.ait.DemoWebShopVOM.fw;

import org.ait.DemoWebShopVOM.fw.CartHelper;
import org.ait.DemoWebShopVOM.fw.HomePageHelper;
import org.ait.DemoWebShopVOM.fw.UserHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class ApplicationManager  {
    String browser;
    WebDriver driver;
    UserHelper userHelper;
    CartHelper cartHelper;
    HomePageHelper homePageHelper;
    AddressHelper addressHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }



    public void init() {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-infobars");
//        options.addArguments("profile.default_content_settings.popups=0");
//
//        driver = new ChromeDriver(options);

        System.err.close();
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("microsoftedge")) {
            driver = new EdgeDriver();
        }

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
//        driver.manage().window().getSize()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userHelper = new UserHelper(driver);
        cartHelper = new CartHelper(driver);
        homePageHelper = new HomePageHelper(driver);
        addressHelper = new AddressHelper(driver);



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

    public AddressHelper getAddressHelper() {
        return addressHelper;
    }

    public void sizeOfWindowLess(){
        driver.manage().window().setSize(new Dimension(800,600));

    }
}
