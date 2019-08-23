package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    /******Page Factory or Object Repository : ***********/
    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//div[@id='ui']/div//form/div/div[.='Login']")
    WebElement loginBtn;

    //Initializing the page objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    /*****************Actions **************************/
    //Validate title
    public HomePage validateLogin(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        return new HomePage();
    }


}
