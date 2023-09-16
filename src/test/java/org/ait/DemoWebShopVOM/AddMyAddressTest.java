package org.ait.DemoWebShopVOM;

import org.ait.DemoWebShopVOM.models.MyAcountAddresse;
import org.openqa.selenium.By;
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
    }


    @DataProvider
    public Iterator <Object[]> newAddress() throws IOException {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"TestField1","TestField1","TestField1","+05045687954"});
        list.add(new Object[]{"TestField2","TestField2","TestField2","+05045687954"});
        list.add(new Object[]{"TestField3","TestField3","TestField3","+05045687954"});
        return list.iterator();
    }


    @DataProvider
    public Iterator <Object[]> newAddressWithSCVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/addresses.csv")));
        String line = reader.readLine();
        while (line !=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new MyAcountAddresse()
                    .setCity(split[0])
                    .setAddress1(split[1])
                    .setZipPostalCode(split[2])
                    .setPhoneNumber(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "newAddress")
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

        //TODO click
        if(app.getAddressHelper().isAlertPresent()){
            //app.getAddressHelper().click(By.cssSelector(".master-wrapper-content"));
            app.getAddressHelper().click(By.xpath("//h1[contains(text(),'My account - Addresses')]"));

        }
        Assert.assertTrue(app.getAddressHelper().isElementPresent(By.cssSelector(".section.address-item")));

    }

    @Test(dataProvider = "newAddressWithSCVFile")
    public void AddAddressToMyAccountPositiveTestFromDataProviderWithCSV(MyAcountAddresse address){
        app.getAddressHelper().clickOnAddAddressButton();
        app.getAddressHelper().addPersonalDataIntoAddressForm();
        app.getAddressHelper().addCountryDataIntoAddressForm();
        app.getAddressHelper().addAddressIntoMyAddressForm(address);
        app.getAddressHelper().clickOnSaveButtonBelowAddressForm();

        Assert.assertEquals(Integer.toString(app.getAddressHelper().sizeOfAddress()),"1");


    }


}
