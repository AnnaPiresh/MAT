package com.qamadness.pages.backend.customers;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class ManageCustomersPage extends PageObject{

    @FindBy (xpath = ".//h3[@class='icon-head head-customer']")
    WebElementFacade pageTitle;

    @FindBy (xpath = ".//button[@title='Add New Customer']")
    WebElementFacade addNewCustomerBtn;

    @FindBy (xpath = ".//*[@id='customerGrid_filter_email']")
    WebElementFacade gridEmailField;

    @FindBy (xpath = ".//*[@id='customerGrid_table']/tbody/tr/td[4]")
    WebElementFacade gridFirstRowEmailCell;

    public void checkThatManageCustomersPageIsOpened (){
        Assert.assertTrue("Correct page is opened", pageTitle.getText().equalsIgnoreCase("Manage Customers"));
    }

    public void clickAddNewCustomerBtn (){
        addNewCustomerBtn.click();
    }

    public void searchCustomerByEmail (String email){
        gridEmailField.type(email);
        gridEmailField.sendKeys(Keys.ENTER);
    }

    public void checkSearchResult (String email){
        Assert.assertTrue("Correct search result", gridFirstRowEmailCell.getText().equalsIgnoreCase(email));
    }

    public void openFirstCustomerProfile (){
        gridFirstRowEmailCell.click();
    }

}
