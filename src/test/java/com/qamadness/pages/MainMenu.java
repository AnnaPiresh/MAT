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

    @FindBy(xpath = ".//*[@id='nav']/li[3]/a/span")
    WebElementFacade catalogMenu;

    @FindBy(xpath = ".//*[@id='nav']/li[3]/ul/li[1]/a/span")
    WebElementFacade manageProducts;

    @FindBy(xpath = ".//*[@id='nav']/li[3]/ul/li[3]/a/span")
    WebElementFacade attributesMenuItem;

    @FindBy(xpath = ".//*[@id='nav']/li[3]/ul/li[3]/ul/li[1]/a/span")
    WebElementFacade manageAttributesMenuItem;

    @FindBy(xpath = ".//*[@id='nav']/li[3]/ul/li[2]/a/span")
    WebElementFacade manageCategoriesMenu;

//------------------------------------------------------Objects for Customers menu------------------------------------//

    @FindBy (xpath = ".//*[@id='nav']/li[4]/a/span")
    WebElementFacade customersMenu;

    @FindBy (xpath = ".//*[@id='nav']/li[4]/ul/li[1]/a/span")
    WebElementFacade manageCustomersMenuItem;

    @FindBy(xpath = ".//*[@id='nav']/li[4]/ul/li[2]/a/span")
    WebElementFacade customerGroupsMenuItem;

//---------------------------------------------------Objects for Promotions menu--------------------------------------//

    @FindBy(xpath = ".//*[@id='nav']/li[5]/a/span")
    WebElementFacade promotionsMenu;

    @FindBy(xpath = ".//*[@id='nav']/li[5]/ul/li[1]/a/span")
    WebElementFacade catalogPriceRulesMenuItem;

//------------------------------------------------------Objects for System menu------------------------------------//

    @FindBy(xpath = ".//*[@id='nav']/li[9]/a/span")
    WebElementFacade systemMenu;

    @FindBy(xpath = ".//*[@id='nav']/li[9]/ul/li[12]/a/span")
    WebElementFacade cacheManagementMenuItem;

    @FindBy(xpath = ".//*[@id='nav']/li[9]/ul/li[13]/a/span")
    WebElementFacade indexManagementMenuItem;

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

    public void openCustomerGroupsPage(){
        customersMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(customerGroupsMenuItem));
        customerGroupsMenuItem.click();
    }

//------------------------------------------------------Methods for Catalog menu------------------------------------//

    public void openManageAttributesPage(){
        catalogMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(attributesMenuItem));
        attributesMenuItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(manageAttributesMenuItem));
        manageAttributesMenuItem.click();
    }

    public void openManageProductsPage () {
        WebDriverWait waitt = new WebDriverWait(getDriver(), 60);
        waitt.until(ExpectedConditions.elementToBeClickable(catalogMenu));
        catalogMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(manageProducts));
        manageProducts.click();
    }

    public void openManageCategoriesPage () {
        WebDriverWait waitt = new WebDriverWait(getDriver(), 60);
        waitt.until(ExpectedConditions.elementToBeClickable(catalogMenu));
        catalogMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(manageCategoriesMenu));
        manageCategoriesMenu.click();
    }


//-----------------------------------------------------Methods for Promotions menu------------------------------------//

    public void openCatalogPriceRulesPage(){
        promotionsMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(catalogPriceRulesMenuItem));
        catalogPriceRulesMenuItem.click();
    }

//------------------------------------------------------Methods for System menu------------------------------------//

    public void openCacheManagementPage(){
        systemMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(cacheManagementMenuItem));
        cacheManagementMenuItem.click();
    }

    public void openIndexManagementPage(){
        systemMenu.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(indexManagementMenuItem));
        indexManagementMenuItem.click();
    }



}
