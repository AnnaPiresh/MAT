package com.qamadness.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class ManageCustomersPage extends PageObject{

    @FindBy (xpath = ".//h3[@class='icon-head head-customer']")
    WebElementFacade pageTitle;

    @FindBy (xpath = ".//button[@title='Add New Customer']")
    WebElementFacade addNewCustomerBtn;

}
