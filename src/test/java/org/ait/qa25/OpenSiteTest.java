package org.ait.qa25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//    driver.get("https://www.google.com/"); open site without history
        driver.navigate().to("https://www.google.com/"); //// open site with history
        driver.navigate().back(); //return back
        driver.navigate().forward(); //move forvard
        driver.navigate().refresh(); //update

    }

    //tests
    @Test
    public void openGoogleTest() {
        System.out.println("Site is opened!!!");
    }

    //after - tearDown
    @AfterMethod
    public void tearDown(){
       // driver.quit(); ///close all tabs, all browser
        driver.close(); //only one tab, if tab only one - close browser
    }
}
