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

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginBtn;

    //Initializing the page objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    /*****************Actions **************************/
    //Validate login
    public HomePage validateLogin(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

//        //loginBtn.click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", loginBtn);

        return new HomePage();
    }


}
