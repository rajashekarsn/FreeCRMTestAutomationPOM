package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    /******Page Factory or Object Repository : ***********/
    @FindBy(xpath = "//span[@class='user-display']")
    WebElement loggedInUser;

    @FindBy(xpath = "//a[@href='/home']")
    WebElement homeLink;

    @FindBy(xpath = "//a[@href='/calender']")
    WebElement calenderLink;

    @FindBy(xpath = "//a[@href='/contacts']")
    WebElement contactsLink;

    //  Initializing the page objects
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    /*****************Actions **************************/
    //  Validate title
    public String validatePageTitle(){
        return driver.getTitle();
    }

    //  Validate Logged in user
    public String validateLoggedInUser(){
        return loggedInUser.getText();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

}
