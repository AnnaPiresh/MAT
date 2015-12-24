package com.qamadness.pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutFromAdmin extends PageObject{

    @FindBy(xpath = ".//a[@class='link-logout']")
    WebElementFacade logOutLnk;
    //Link to Log out from admin panel

    public void logoutfromAdmin(){
        logOutLnk.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("admin/index/index/key"));
    }


}