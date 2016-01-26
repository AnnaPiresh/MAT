package com.qamadness.pages.backend.cms.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexandra on 1/25/16.
 */
public class managePagesPage extends PageObject {

    //CMS pages grid:

    @FindBy (xpath = "//div[@id='cmsPageGrid']")
    WebElementFacade pagesGrid;

    //Buttons in Pages grid:

    @FindBy (xpath = "//button[span='Reset Filter']")
    WebElementFacade resetFilterButton;

    @FindBy (xpath = "//button[span='Search']")
    WebElementFacade searchButton;

    //Drop downs in Pages grid:

    @FindBy (xpath = "//select[@name='limit']")
    WebElementFacade viewPerPageDropdown;

    @FindBy (xpath = "//select[@name='root_template']")
    WebElementFacade filterLayoutDropdown;

    @FindBy (xpath = "//select[@name='store_id']")
    WebElementFacade filterStoreViewDropdown;

    @FindBy (xpath = "//select[@name='is_active']")
    WebElementFacade filterStatusDropdown;

    //Fields in Pages grid:

    @FindBy (xpath = "//input[@name='page']")
    WebElementFacade pageField;

    @FindBy (xpath = "//input[@name='title']")
    WebElementFacade titleField;

    @FindBy (xpath = "//input[@name='identifier']")
    WebElementFacade urlKeyField;

    @FindBy (xpath = "//input[@name='creation_time[from]']")
    WebElementFacade createdFromField;

    @FindBy (xpath = "//input[@name='creation_time[to]']")
    WebElementFacade createdToField;

    @FindBy (xpath = "//input[@name='update_time[from]']")
    WebElementFacade lastModifiedFromField;

    @FindBy (xpath = "//input[@name='update_time[to]']")
    WebElementFacade lastModifiedToField;

    //Links in Pages grid:

    @FindBy (xpath = "//a[contains(@href, '%url%')]")
    WebElementFacade previewLink;

    //General buttons:

    @FindBy (xpath = "//button[span='Add New Page']")
    WebElementFacade addNewPageButton;

    //Messages:

    @FindBy (xpath = "//li[normalize-space(@class)='success-msg' and contains(.,'The page has been saved.')]")
    WebElementFacade successSavedCMSPageMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='success-msg' and contains(.,'The page has been deleted.')]")
    WebElementFacade successDeletedCMSPageMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'The page URL key cannot consist only of numbers.')]")
    WebElementFacade errorInvalidURLKeyWithNumbersOnlyMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'A page URL key for specified store already exists.')]")
    WebElementFacade errorExistingURLKeyMessage;

    @FindBy (xpath = "//div[@id='advice-validate-identifier-%fieldId%' and not(contains(@style,'display: none;'))]")
    WebElementFacade errorInvalidURLKeySpecSymMessage;

    //Click General buttons methods:

    public void clickAddNewPageButton (){
        addNewPageButton.click();
    }

    //Methods for grid:

    public void filterPagesByUrlKey (String urlKey){
        resetFilterButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        urlKeyField.type(urlKey);
        searchButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
    }

    public void clickFirstPageInTheGrid (){
        getDriver().findElement(By.xpath(".//*[@id='cmsPageGrid_table']/tbody/tr[1]")).click();
    }

    //Verifications:

    public void verifyThatSuccessSavedPageMessageIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successSavedCMSPageMessage));
        Assert.assertTrue(successSavedCMSPageMessage.isDisplayed());
    }
}
