package com.qamadness.pages.backend.system.permissions.roles;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexandra on 1/15/16.
 */
public class EditRolePage extends PageObject {

    //Tabs:

    @FindBy (xpath = "//a[@id='role_info_tabs_info']")
    WebElementFacade roleInfoTab;

    @FindBy (xpath = "//a[@id='role_info_tabs_account']")
    WebElementFacade roleResourcesTab;

    @FindBy (xpath = "//a[@id='role_info_tabs_roles']")
    WebElementFacade roleUsersTab;

    //Fields on Role Info tab:

    @FindBy (xpath = "//input[@id='role_name']")
    WebElementFacade roleNameField;

    //Dropdown on Role Resources tab:

    @FindBy (xpath = "//select[@id='all']")
    WebElementFacade resourceAccessDropdown;

    //Fields on Role Users tab:

    @FindBy (xpath = "//input[@name='role_user_id']")
    WebElementFacade userIdField;

    @FindBy (xpath = "//input[@name='role_user_username']")
    WebElementFacade userNameField;

    @FindBy (xpath = "//input[@name='role_user_firstname']")
    WebElementFacade firstNameField;

    @FindBy (xpath = "//input[@name='role_user_lastname']")
    WebElementFacade lastNameField;

    @FindBy (xpath = "//input[@name='role_user_email']")
    WebElementFacade emailField;

    //Dropdown on Role Users tab:

    @FindBy (xpath = "//select[@name='in_role_users']")
    WebElementFacade filerInRoleUsersDropdown;

    @FindBy (xpath = "//select[@name='role_user_is_active']")
    WebElementFacade statusDropdown;

    //Checkbox on Role Users tab:

    @FindBy (xpath = "//tr//input[@class='checkbox']")
    WebElementFacade selectByUserNameCheckbox;

    //Buttons on Role Users tab:

    @FindBy (xpath = "//button[span='Search']")
    WebElementFacade searchButton;

    @FindBy (xpath = "//button[span='Reset Filter']")
    WebElementFacade resetFilterButton;

    //Buttons:

    @FindBy (xpath = "//button[span='Back']")
    WebElementFacade backButton;

    @FindBy (xpath = "//button[span='Reset']")
    WebElementFacade resetButton;

    @FindBy (xpath = "//button[span='Delete Role']")
    WebElementFacade deleteRoleButton;

    @FindBy (xpath = "//button[span='Save Role']")
    WebElementFacade saveRoleButton;


}
