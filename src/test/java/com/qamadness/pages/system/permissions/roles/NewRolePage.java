package com.qamadness.pages.system.permissions.roles;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexandra on 1/15/16.
 */
public class NewRolePage extends PageObject {

    //Tabs:

    @FindBy (xpath = "//a[@id='role_info_tabs_info']")
    WebElementFacade roleInfoTab;

    @FindBy (xpath = "//a[@id='role_info_tabs_account']")
    WebElementFacade roleResourcesTab;

    //Fields on Role Info tab:

    @FindBy (xpath = "//input[@id='role_name']")
    WebElementFacade roleNameField;

    //Dropdown on Role Resources tab:

    @FindBy (xpath = "//select[@id='all']")
    WebElementFacade resourceAccessDropdown;

    //Buttons:

    @FindBy (xpath = "//button[span='Back']")
    WebElementFacade backButton;

    @FindBy (xpath = "//button[span='Reset']")
    WebElementFacade resetButton;

    @FindBy (xpath = "//button[span='Save Role']")
    WebElementFacade saveRoleButton;
}
