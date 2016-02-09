package com.qamadness.pages.backend.system;

import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class CacheManagement extends PageObject {

//--------------------------------------------------Objects for Flushing Caches----------------------------------------//

    @FindBy(xpath = ".//button[@title='Flush Magento Cache']")
    WebElementFacade flushMagentoCachesBtn;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

//------------------------------------------Objects for Disabling caching----------------------------------------------//

    @FindBy(xpath = ".//*[@id='cache_grid_massaction']/table/tbody/tr/td[1]/a[1]")
    WebElementFacade selectAllCachesBtn;

    @FindBy(xpath = ".//*[@id='cache_grid_massaction-select']")
    WebElementFacade cacheActionsDropdown;

    @FindBy(xpath = ".//button[@title='Submit']")
    WebElementFacade submitActionBtn;

//--------------------------------------------------Methods for Flushing Caches----------------------------------------//

    public void clickFlushCacheBtn(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(flushMagentoCachesBtn));
        flushMagentoCachesBtn.click();
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


}
