package com.qamadness.pages.frontend;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@DefaultUrl("http://qamad:f3Vh!@www.qamadness.dev")
public class Homepage extends PageObject{

//----------------------------------------------Objects for Main menu---------------------------------------------------//

    @FindBy(xpath = ".//*[@id='nav']/ol/li[1]/a")
    WebElementFacade firstNavMenuItem;

    @FindBy(xpath = ".//*[@id='nav']/ol/li[1]/ul/li[3]/a")
    WebElementFacade thirdSubmenuitem;

//---------------------------------------------Methods for Main menu---------------------------------------------------//

    public void openProductOverviewPage(){
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.visibilityOf(firstNavMenuItem));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(firstNavMenuItem).build().perform();
        wait.until(ExpectedConditions.visibilityOf(thirdSubmenuitem));
        actions.moveToElement(thirdSubmenuitem).click().perform();
    }



}
