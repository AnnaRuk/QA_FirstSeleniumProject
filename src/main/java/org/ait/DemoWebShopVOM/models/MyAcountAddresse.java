package org.ait.DemoWebShopVOM.models;

public class MyAcountAddresse {

    String city;
    String address1;
    String zipPostalCode;
    String phoneNumber;

    public String getCity() {
        return city;
    }

    public MyAcountAddresse setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public MyAcountAddresse setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public MyAcountAddresse setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public MyAcountAddresse setPhoneNumber(String phoneNumber) {
       this.phoneNumber = phoneNumber;
       return this;
    }

    @Override
    public String toString() {
        return "MyAcountAddresse{" +
                "city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
