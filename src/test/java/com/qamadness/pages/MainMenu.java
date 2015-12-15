package com.qamadness.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class MainMenu extends PageObject {

//------------------------------------------------------Objects for Sales menu----------------------------------------//

    @FindBy(xpath = ".//*[@id='nav']/li[2]/a/span")
    WebElementFacade salesMenu;

    @FindBy (xpath = ".//*[@id='nav']/li[2]/ul/li[1]/a/span")
    WebElementFacade ordersMenuItem;

//------------------------------------------------------Objects for Catalog menu--------------------------------------//

//------------------------------------------------------Objects for Customers menu------------------------------------//

    @FindBy (xpath = ".//*[@id='nav']/li[4]/a/span")
    WebElementFacade customersMenu;

    @FindBy (xpath = ".//*[@id='nav']/li[4]/ul/li[1]/a/span")
    WebElementFacade manageCustomersMenuItem;

//-----------------------------------------------------Methods for Sales menu-----------------------------------------//

    public void openOrdersPage () {
        salesMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(ordersMenuItem));
        ordersMenuItem.click();
    }

//------------------------------------------------------Methods for Customers menu------------------------------------//

    public void openManageCustomersPage (){
        customersMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(manageCustomersMenuItem));
        manageCustomersMenuItem.click();
    }
}
