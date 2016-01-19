package com.qamadness.pages.backend.system.permissions.roles;

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

    @FindBy (xpath = ".//*[@id='current_password']")
    WebElementFacade currentAdminPassword;

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

    @FindBy (xpath = "//button[span='Delete Role']")
    WebElementFacade deleteRoleButton;

    //Methods for Role Info tabs:

    public void fillRoleNameField (String roleName){
        roleNameField.type(roleName);
    }

    public void fillCurrentAdminPasswordField (String password){
        currentAdminPassword.type(password);
    }

    //Methods for Role Resources tab:

    public void openRoleResourcesTab(){
        roleResourcesTab.click();
    }

    public void selectAllResourcesAccess (){
        resourceAccessDropdown.selectByVisibleText("All");
    }

    //Methods for general buttons:

    public void clickSaveButton (){
        saveRoleButton.click();
    }

    public void clickDeleteRoleButtonAndConfirm (){
        deleteRoleButton.click();
        getDriver().switchTo().alert().accept();
    }
}
