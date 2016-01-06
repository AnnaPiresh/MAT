package com.qamadness.pages.system;


import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisableAndEnableMagentoCaching extends PageObject{

//------------------------------------------Objects for Disabling caching----------------------------------------------//

    @FindBy(xpath = ".//*[@id='cache_grid_massaction']/table/tbody/tr/td[1]/a[1]")
    WebElementFacade selectAllCachesBtn;

    @FindBy(xpath = ".//*[@id='cache_grid_massaction-select']")
    WebElementFacade cacheActionsDropdown;

    @FindBy(xpath = ".//button[@title='Submit']")
    WebElementFacade submitActionBtn;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

//----------------------------------------Methods for Disabling caching------------------------------------------------//

    public void selectAllCaches(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(selectAllCachesBtn));
        selectAllCachesBtn.click();
    }

    public void chooseValueFromActionsDropdown(String cachesAction){
        cacheActionsDropdown.click();
        cacheActionsDropdown.selectByValue(cachesAction);
    }

    public void clickSubmitBtn(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(submitActionBtn));
        submitActionBtn.click();
        submitActionBtn.click();
    }

    public void checkSuccessMsg(String messageCaches){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(messageCaches)){
            System.out.println("Magento Caching settings have been changed");
        } else {
            Assert.fail("Magento Caching haven't been changed");
        }
    }
}
