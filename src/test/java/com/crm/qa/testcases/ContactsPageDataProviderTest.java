package com.crm.qa.testcases;

        import com.crm.qa.base.TestBase;
        import com.crm.qa.pages.ContactsPage;
        import com.crm.qa.pages.FreeCRMLandingPage;
        import com.crm.qa.pages.HomePage;
        import com.crm.qa.pages.LoginPage;
        import org.testng.annotations.*;

public class ContactsPageDataProviderTest extends TestBase {

    FreeCRMLandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public ContactsPageDataProviderTest() {
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

    @Test(dataProvider="NewContactList")
    //  values are picked from the data provider
    public  void createNewContactDataProviderTest(String first_name, String second_name){
        contactsPage.clickOnNewContactLink();
        contactsPage.createNewContactDetails(first_name, second_name);
    }

    @DataProvider(name = "NewContactList")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]
                {
                        {"DataProvider1FName", "DataProvider1SName"},
                        {"DataProvider2FName", "DataProvider2SName"}
                };
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
