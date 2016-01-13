package com.qamadness.pages.backend;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maksim on 14-Dec-15.
 */
public class DashboardPage extends PageObject {

    @FindBy(xpath = ".//*[@id='message-popup-window']/div[1]/a/span")
    WebElementFacade closePopup;

    public void closePopup(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(closePopup));
        closePopup.click();
    }
}
