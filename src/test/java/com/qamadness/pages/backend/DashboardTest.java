package com.qamadness.pages.backend;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksim on 14-Dec-15.
 */
public class DashboardTest {

    @FindBy(xpath = ".//*[@id='message-popup-window']/div[1]/a/span")
    WebElementFacade closePopup;
    public void closePopup(){
        closePopup.click();
    }
}
