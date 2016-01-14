package com.qamadness.pages.frontend;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductOverviewPage extends PageObject{

    @FindBy(xpath = ".//*[@title='View Details']")
    WebElementFacade viewDetailsBtn;

    public void openProductDetailsPage(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(viewDetailsBtn));
        viewDetailsBtn.click();
    }

}
