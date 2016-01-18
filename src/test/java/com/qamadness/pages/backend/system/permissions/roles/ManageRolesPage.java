package com.qamadness.pages.backend.system.permissions.roles;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexandra on 1/15/16.
 */
public class ManageRolesPage extends PageObject {

    //Manage roles grid:

    @FindBy (xpath = "//div[@id='roleGrid']")
    WebElementFacade manageRolesGrid;

    //Buttons:

    @FindBy (xpath = "//button[span='Add New Role']")
    WebElementFacade addNewRoleButton;

    @FindBy (xpath = "//button[span='Reset Filter']")
    WebElementFacade resetFilterButton;

    @FindBy (xpath = "//button[span='Search']")
    WebElementFacade searchButton;

    //Fields:

    @FindBy (xpath = "//input[@name='role_id']")
    WebElementFacade idField;

    @FindBy (xpath = "//input[@name='role_name']")
    WebElementFacade roleNameField;
}
