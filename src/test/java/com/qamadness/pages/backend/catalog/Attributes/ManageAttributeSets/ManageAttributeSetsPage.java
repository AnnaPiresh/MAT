package com.qamadness.pages.backend.catalog.Attributes.ManageAttributeSets;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;

/**
 * Created by kampa on 15.01.2016.
 */
public class ManageAttributeSetsPage extends PageObject{

//--------------------------------------------Objects for Managing Attribute Sets--------------------------------------//

    @FindBy(xpath = ".//*[@id='setGrid_filter_set_name']")
    WebElementFacade filterFieldInGrid;

    @FindBy(xpath = ".//*[@id='setGrid_table']/tbody/tr/td")
    WebElementFacade firstLineInGrid;

//-------------------------------------------Methods for Managing Attribute Sets---------------------------------------//

    public void searchForAttributeSet(String searchterm){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(filterFieldInGrid));
        filterFieldInGrid.click();
        filterFieldInGrid.sendKeys(searchterm);
        filterFieldInGrid.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(firstLineInGrid));
    }

    public void checkCorrectAttributeSetIsFiltered(String searchterm){
        Assert.assertTrue(firstLineInGrid.containsText(searchterm));
    }






}
