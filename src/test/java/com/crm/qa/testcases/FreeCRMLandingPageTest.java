package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FreeCRMLandingPage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMLandingPageTest extends TestBase {
    FreeCRMLandingPage landingPage;
    LoginPage loginPage;

    public FreeCRMLandingPageTest(){
        super();
    }

    @BeforeMethod
    public  void  setup(){
        initialization();
        landingPage = new FreeCRMLandingPage();
    }

    @Test(priority = 1)
    public void landingPageTitleTest(){
        String title = landingPage.validatePageTitle();
        Assert.assertEquals(title,"#1 Free CRM software for any business - FreeCRM.com");
    }

    @Test(priority = 2)
    public void crmLogoTest(){
        boolean flag = landingPage.validateCRMLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginLinkTest(){
            loginPage = landingPage.validateLoginLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
