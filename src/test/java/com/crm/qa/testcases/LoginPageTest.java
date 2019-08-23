package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FreeCRMLandingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    FreeCRMLandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        landingPage = new FreeCRMLandingPage();
        loginPage = landingPage.validateLoginLink();
    }

    @Test
    public void validateLoginTest(){
        homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}



