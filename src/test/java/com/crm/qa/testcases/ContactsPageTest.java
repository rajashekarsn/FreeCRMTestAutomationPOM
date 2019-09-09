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

public class ContactsPageTest extends TestBase {

    FreeCRMLandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtilities testUtilities;

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        landingPage = new FreeCRMLandingPage();
        loginPage = landingPage.validateLoginLink();
        homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();

    }

    @Test(priority = 1)
    public void verifyNewContactHeaderTest(){
        contactsPage.clickOnNewContactLink();
        String newContactHeader = contactsPage.verifyNewContactHeader();
        Assert.assertEquals(newContactHeader,"Create New Contact");
    }

    @Test(priority = 2)
    public  void createNewContactDetailsTest(){
        contactsPage.clickOnNewContactLink();
        contactsPage.createNewContactDetails("FirstName","SecondName");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
