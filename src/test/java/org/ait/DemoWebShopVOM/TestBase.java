package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.fw.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {


    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));



    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod
    public void StartTest(Method m, Object[] p){
        logger.info("Start" + m.getName()
        + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void StopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED " + result.getMethod()
                    .getMethodName());
        } else {
            logger.error("FAILED " +result.getMethod()
                    .getMethodName() + " Screenshot: " +
                    app.getUserHelper().takeScreenshot());
        }

        logger.info("Stop");
        logger.error("***********************");
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
