package com.qamadness.pages.backend.system;


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
