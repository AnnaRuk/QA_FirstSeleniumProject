package org.ait.qa25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteHW {
    WebDriver driver;
    String url  = "https://demowebshop.tricentis.com/";

    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void openSiteHwTest(){
        System.out.println("site is" + url + "opened!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
