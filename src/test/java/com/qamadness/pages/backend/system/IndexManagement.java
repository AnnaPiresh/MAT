package com.qamadness.pages.backend.system;


import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexManagement extends PageObject{

//--------------------------------------Objects for Reindexing Data---------------------------------------------------//

    @FindBy(xpath = ".//*[@id='indexer_processes_grid_massaction']/table/tbody/tr/td[1]/a[1]")
    WebElementFacade selectAllIndexesBtn;

    @FindBy(xpath = ".//*[@id='indexer_processes_grid_massaction-count']")
    WebElementFacade qtyOfReindexedAreas;

    @FindBy(xpath = ".//*[@id='indexer_processes_grid_massaction-select']")
    WebElementFacade actionsIndexesDropdown;

    @FindBy(xpath = ".//button[@title='Submit']")
    WebElementFacade submitActionBtn;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

//-------------------------------------Methods for Reindexing Data----------------------------------------------------//

    public void clickSelectAllIndexes() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(selectAllIndexesBtn));
        selectAllIndexesBtn.click();
    }

    public void selectActionFromDropdown(String indexAction){
        actionsIndexesDropdown.click();
        actionsIndexesDropdown.selectByValue(indexAction);
    }

    public void clickSubmitBtn() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 360);
        wait.until(ExpectedConditions.elementToBeClickable(submitActionBtn));
        submitActionBtn.click();
        submitActionBtn.click();
    }

    public void checkSuccessMsg(String message){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(message)){
            System.out.println("Success message is present");
        } else {
            Assert.fail("Success message is not present");
        }
    }

}