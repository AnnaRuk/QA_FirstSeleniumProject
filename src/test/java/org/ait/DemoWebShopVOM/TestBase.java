package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void SetUp(){
        app.init();
    }

    @AfterMethod(enabled=false)
    // @AfterMethod()
    public void tearDown(){
        app.stop();
    }


}
