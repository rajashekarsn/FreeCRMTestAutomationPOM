package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FreeCRMLandingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    FreeCRMLandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtilities testUtilities;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
//        testUtilities = new TestUtilities();
        landingPage = new FreeCRMLandingPage();
        loginPage = landingPage.validateLoginLink();
        homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void loggedInUserTest(){
        String loggedInUser = homePage.validateLoggedInUser();
        Assert.assertEquals(loggedInUser,"raj sn");
    }

    @Test(priority = 2)
    public void pageTitleTest(){
        String pageTitle = homePage.validatePageTitle();
        Assert.assertEquals(pageTitle,"CRM");
    }

    @Test(priority=0)
    public void verifyContactsLinkTest(){
        contactsPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
