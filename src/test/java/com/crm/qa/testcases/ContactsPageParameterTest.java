package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FreeCRMLandingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactsPageParameterTest extends TestBase {

    FreeCRMLandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public ContactsPageParameterTest() {
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
    @Parameters({"f_name", "s_name"})
//  values are picked from the 'testng.xml' file
    public  void createNewContactParameterTest(String first_name, String second_name){
        contactsPage.clickOnNewContactLink();
        contactsPage.createNewContactDetails(first_name, second_name);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
