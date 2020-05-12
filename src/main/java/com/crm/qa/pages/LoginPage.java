package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    //Initializing the Page Objects
    public LoginPage(){
        //initialize page factory, all the above elements will be initialized with this driver
        //this pointing to the current class object
        PageFactory.initElements(driver, this);
    }

    //Actions(different features available on Login Page)
    public String validateLoginPageTitle(){
        return driver.getTitle();
    };

    public Boolean validateCRMImage(){
       return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }
}
