package com.crm.qa.testscases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    String sheetName = "Contacts";

    public ContactsPageTest(){
        super();
    }

    //initialize prop
    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        //contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsPageLabel(){
        contactsPage = homePage.clickOnContactsLink();
       Assert.assertTrue(contactsPage.verifyContactsLabel());
    }

    @Test(priority = 2)
    public void selectSingleContactsTest(){
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.selectContactsByName("1AARaj Thang");
        //Assert.assertEquals(selectedContact,"");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest(){
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.selectContactsByName("1AARaj Thang");
        contactsPage.selectContactsByName("3243532");
        //Assert.assertEquals(selectedContact,"");
    }

    @DataProvider
    public  Object[][] getCRMTestData(){
    Object data[][] = TestUtil.getTestData(sheetName);
    return data;
    }

    @Test(priority = 4 , dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
        homePage.clickOnNewContactLink();
        //contactsPage.createNewContact("Miss","Andra","Marina","Facebook");
        contactsPage.createNewContact(title,firstName,lastName,company);
    }

    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }
}

