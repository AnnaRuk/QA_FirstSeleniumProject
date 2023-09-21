package org.ait.DemoWebShopVOM.utils;

import org.ait.DemoWebShopVOM.models.MyAcountAddresse;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {


    @DataProvider
    public Iterator<Object[]> newAddress() throws IOException {
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

}
