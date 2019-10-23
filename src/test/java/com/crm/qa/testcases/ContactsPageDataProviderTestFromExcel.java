package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FreeCRMLandingPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageDataProviderTestFromExcel extends TestBase {

    FreeCRMLandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    String sheetName = "newContacts";

    public ContactsPageDataProviderTestFromExcel() {
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

    @Test(dataProvider="NewContactListFromExcel")
    //  values are picked from the data provider excel
    public  void createNewContactDataProviderTestFromExcel(String first_name, String second_name){
        contactsPage.clickOnNewContactLink();
        contactsPage.createNewContactDetails(first_name, second_name);
    }

    @DataProvider(name = "NewContactListFromExcel")
    public Object[][] getDataFromDataProviderFromExcel() {
    // data is picked from the sheet name passed
        Object data[][] = TestUtilities.getTestData(sheetName);
        return data;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
