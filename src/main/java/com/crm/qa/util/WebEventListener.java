package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

public class WebEventListener extends TestBase implements WebDriverEventListener {


    public void beforeNavigateTo(String url, WebDriver driver) {

        System.out.println("Before navigating to: '" + url + "'");

    }



    public void afterNavigateTo(String url, WebDriver driver) {

        System.out.println("Navigated to:'" + url + "'");

    }



    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

        System.out.println("Value of the:" + element.toString() + " before any changes made");

    }



    public void afterChangeValueOf(WebElement element, WebDriver driver) {

        System.out.println("Element value changed to: " + element.toString());

    }



    public void beforeClickOn(WebElement element, WebDriver driver) {

        System.out.println("Trying to click on: " + element.toString());

    }



    public void afterClickOn(WebElement element, WebDriver driver) {

        System.out.println("Clicked on: " + element.toString());

    }



    public void beforeNavigateBack(WebDriver driver) {

        System.out.println("Navigating back to previous page");

    }



    public void afterNavigateBack(WebDriver driver) {

        System.out.println("Navigated back to previous page");

    }



    public void beforeNavigateForward(WebDriver driver) {

        System.out.println("Navigating forward to next page");

    }



    public void afterNavigateForward(WebDriver driver) {

        System.out.println("Navigated forward to next page");

    }



    public void onException(Throwable error, WebDriver driver) {

        System.out.println("Exception occured: " + error);

        try {

            TestUtil.takeScreenshotAtEndOfTest();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

        System.out.println("Trying to find Element By : " + by.toString());

    }



    public void afterFindBy(By by, WebElement element, WebDriver driver) {

        System.out.println("Found Element By : " + by.toString());

    }



    /*

     * non overridden methods of WebListener class

     */

    public void beforeScript(String script, WebDriver driver) {

    }



    public void afterScript(String script, WebDriver driver) {

    }



    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }


    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }



    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }


    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}