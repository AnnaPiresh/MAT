package com.qamadness.pages.backend.system.permissions.roles;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    //Roles grid:

    @FindBy (xpath = ".//*[@id='roleGrid_table']/tbody/tr/td[@class='empty-text a-center']")
    WebElementFacade noRecordsFoundResult;

    //Click general buttons methods:

    public void clickAddNewRoleButton (){
        addNewRoleButton.click();
    }

    //Verifications:

    public void verifyThatRoleIsCreated (String roleName){
        resetFilterButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        roleNameField.type(roleName);
        searchButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        Assert.assertTrue(getDriver().findElement(By.xpath(".//*[@id='roleGrid_table']/tbody/tr/td[2]")).getText().contentEquals(roleName));
    }

    //Grid methods:

    public void findRoleAndOpen(String roleName){
        resetFilterButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        roleNameField.type(roleName);
        searchButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        getDriver().findElement(By.xpath("//*[@id='roleGrid_table']/tbody/tr/td[2]")).click();
    }
}
