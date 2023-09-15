package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class TestBase {


    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));



    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void Start(){
        logger.info("Start");
    }

    @AfterMethod
    public void Stop(){
        logger.info("Stop");
    }



    @BeforeSuite
    public void SetUp(){
        app.init();
    }

    @AfterSuite(enabled=true)
    // @AfterMethod()
    public void tearDown(){
        app.stop();
    }


}
