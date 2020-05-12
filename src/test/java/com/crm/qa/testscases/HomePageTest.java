package com.crm.qa.testscases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    public LoginPage loginPage;
    public HomePage homePage;
    public TestUtil testUtil;
    public ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser & login
    //after each case close the browser

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        //System.out.println("!!!!!!!!!!!!!!!!!!!" + homePage.verifyCorrectUserName());
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        testUtil.switchToFrame();
         contactsPage = homePage.clickOnContactsLink();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
