package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void SetUp(){
        app.init();
    }

    @AfterSuite(enabled=false)
    // @AfterMethod()
    public void tearDown(){
        app.stop();
    }


}
