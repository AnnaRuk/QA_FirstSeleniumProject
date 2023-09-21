package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.models.MyAcountAddresse;
import org.ait.DemoWebShopVOM.utils.DataProviders;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddMyAddressTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){

        app.getUserHelper().clickLogInHomePage();
        app.getUserHelper().login();

    }

    @Test
    public void AddAddressToMyAccount(){
        app.getAddressHelper().clickOnAddAddressButton();
        app.getAddressHelper().addPersonalDataIntoAddressForm();
        app.getAddressHelper().addCountryDataIntoAddressForm();
        app.getAddressHelper().addAddressIntoMyAddressForm(new MyAcountAddresse()
                .setCity("Kyev")
                .setAddress1("Hreshatik,1")
                .setZipPostalCode("01001")
                .setPhoneNumber("+3805034578922"));
        app.getAddressHelper().clickOnSaveButtonBelowAddressForm();
       Assert.assertTrue(app.getAddressHelper().isElementPresent(By.cssSelector(".section.address-item")));
        app.getUserHelper().pauseSelenium(2000);
    }


    @AfterMethod
    public void deleteAddress(){
        app.getUserHelper().pauseSelenium(2000);
        app.getAddressHelper().deleteAddressFromMyAccount();
        //TODO alert
        app.getAddressHelper().acceptAlert();
    }



    @Test(dataProvider = "newAddress", dataProviderClass = DataProviders.class)
    public void AddAddressToMyAccountPositiveTestFromDataProvider(String city,
                                                                  String address1,
                                                                  String zip,
                                                                  String phone){
        app.getAddressHelper().clickOnAddAddressButton();
        app.getAddressHelper().addPersonalDataIntoAddressForm();
        app.getAddressHelper().addCountryDataIntoAddressForm();
        app.getAddressHelper().addAddressIntoMyAddressForm(new MyAcountAddresse()
                .setCity(city)
                .setAddress1(address1)
                .setZipPostalCode(zip)
                .setPhoneNumber(phone));
        app.getAddressHelper().clickOnSaveButtonBelowAddressForm();

        //TODO click Modal Window
        app.sizeOfWindowLess();

        Assert.assertTrue(app.getAddressHelper().isElementPresent(By.cssSelector(".section.address-item")));

    }

    @Test(dataProvider = "newAddressWithSCVFile", dataProviderClass = DataProviders.class)
    public void AddAddressToMyAccountPositiveTestFromDataProviderWithCSV(MyAcountAddresse address){
        app.getAddressHelper().clickOnAddAddressButton();
        app.getAddressHelper().addPersonalDataIntoAddressForm();
        app.getAddressHelper().addCountryDataIntoAddressForm();
        app.getAddressHelper().addAddressIntoMyAddressForm(address);
        app.getAddressHelper().clickOnSaveButtonBelowAddressForm();

        Assert.assertEquals(Integer.toString(app.getAddressHelper().sizeOfAddress()),"1");


    }


}
