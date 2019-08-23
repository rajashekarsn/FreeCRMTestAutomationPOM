package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCRMLandingPage extends TestBase{

    /******Page Factory or Object Repository : ***********/
    @FindBy(xpath = "//img[@class = 'img-responsive']")
    WebElement crmLogo;

    @FindBy(linkText = "Login")
    WebElement loginLink;
    // linkText = "Login"
    // xpath = "//*[@id=\"navbar-collapse\"]/ul/li[1]/a"
    // xpath = "//a[@href = 'https://ui.freecrm.com']"
    // xpath = "//*[contains(text(),'Login')]"
    // xpath = "//*[contains(@href,'ui.freecrm.com')]"

    //Initializing the page objects
    public FreeCRMLandingPage(){
        PageFactory.initElements(driver,this);
    }

    /*****************Actions **************************/
    //Validate title
    public String validatePageTitle(){
        return driver.getTitle();
    }

    //Validate crm logo
    public boolean validateCRMLogo(){
        return crmLogo.isDisplayed();
    }

    // Validate login link , should take to login page
    public LoginPage validateLoginLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(loginLink).click().perform();
//        loginLink.click();
        return new LoginPage();
    }

}

