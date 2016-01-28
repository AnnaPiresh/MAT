package com.qamadness.pages.frontend.ProductOverviewPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii_Boiko on 28.01.2016.
 */
public class SearchResultsPage extends PageObject {

//--------------------------------------------Objects for Search Results Page------------------------------------------//

    @FindBy(xpath = ".//*[@title='Sort By']")
    WebElementFacade sortByDropdown;

    @FindBy(css = ".product-name>a")
    WebElementFacade productTitle;


//---------------------------------------------Methods for Search Results Page-----------------------------------------//

    public void selectFirstProductFromResults(){
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.visibilityOf(sortByDropdown));
        getDriver().findElement(By.xpath(".//*[contains(text(), 'Robot auto product1')]")).click();
    }

    public void returnToPreviousPage(){
        getDriver().navigate().back();
    }

    public void selectSecondProductFromResults(){
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.visibilityOf(sortByDropdown));
        getDriver().findElement(By.xpath(".//*[contains(text(), 'Robot auto product2')]")).click();
    }

}
