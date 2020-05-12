package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
    WebElement userNameLabel;

    @FindBy(xpath ="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath ="//a[contains(text(),'New Contact')]")
    WebElement newContactLink;

    @FindBy(xpath ="//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath ="//a[contains(text(),'Tasks')]")
    WebElement tasksLink;



    //initializing the Page Objects in the Class constructor

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }
    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }
    public void clickOnNewContactLink(){

        //Actions class available in Selenium used for drag and drop, right click etc
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newContactLink));
        wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
        //.build(), .perform() used everytime when using actions Class
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("New Contact")));
        //action.moveToElement(newContactLink);
        newContactLink.click();
        //action.click(newContactLink).perform();
       // newContactLink.click();

    }

}

