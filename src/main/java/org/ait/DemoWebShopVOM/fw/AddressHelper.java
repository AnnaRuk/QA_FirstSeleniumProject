package org.ait.DemoWebShopVOM.fw;

import org.ait.DemoWebShopVOM.models.MyAcountAddresse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressHelper extends HelperBase{
    public AddressHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddAddressButton() {
        click(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        click(By.xpath("//a[contains(text(),'Addresses')]"));
        click(By.cssSelector(".button-1.add-address-button"));
    }

    public void addAddressIntoMyAddressForm(MyAcountAddresse address) {

        type(By.xpath("//input[@id='Address_City']"), address.getCity());
        type(By.xpath("//input[@id='Address_Address1']"), address.getAddress1());
        type(By.xpath("//input[@id='Address_ZipPostalCode']"), address.getZipPostalCode());
        type(By.xpath("//input[@id='Address_PhoneNumber']"), address.getPhoneNumber());
    }

    public void addPersonalDataIntoAddressForm() {
        type(By.xpath("//input[@id='Address_FirstName']"), "Anna");
        type(By.xpath("//input[@id='Address_LastName']"), "Bel");
        type(By.xpath("//input[@id='Address_Email']"), "anna999@gmail.com");
    }


    public void addCountryDataIntoAddressForm() {
        click(By.xpath("//select[@id='Address_CountryId']"));
        click(By.xpath("//option[contains(text(),'Ukraine')]"));
    }


    public void clickOnSaveButtonBelowAddressForm() {
        click(By.cssSelector(".button-1.save-address-button"));
    }

    public void deleteAddressFromMyAccount() {
       click(By.cssSelector(".button-2.delete-address-button"));
    }

    public int sizeOfAddress(){
        if (isElementPresent(By.cssSelector(".section.address-item"))){
            return driver.findElements(By.cssSelector(".section.address-item")).size();
        }
        return 0;
    }
}
