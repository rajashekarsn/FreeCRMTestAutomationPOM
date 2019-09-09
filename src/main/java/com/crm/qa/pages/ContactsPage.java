package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {


    /******Page Factory or Object Repository : ***********/
    @FindBy(xpath = "//a[@href='/contacts/new']")
    WebElement newContactsLink;

    @FindBy(xpath = "//div[@class= 'ui header item mb5 light-black']")
    WebElement createNewContactHeader;

//    @FindBy(xpath = "//input[@name='first_name']")
    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement secondName;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveButton;

    //  Initializing the page objects
    public ContactsPage (){
        PageFactory.initElements(driver,this);
    }

    /*****************Actions **************************/
    //  Navigate to add new contact
    public void clickOnNewContactLink(){
        newContactsLink.click();
    }

    public String verifyNewContactHeader(){
        return createNewContactHeader.getText();
    }

    public void createNewContactDetails(String f_name, String s_name){
        firstName.sendKeys(f_name);
        secondName.sendKeys((s_name));
        saveButton.click();
    }

}



