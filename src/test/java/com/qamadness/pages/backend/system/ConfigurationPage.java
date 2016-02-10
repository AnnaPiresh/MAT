package com.qamadness.pages.backend.system;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexandra on 2/2/16.
 */
public class ConfigurationPage extends PageObject {

    //General buttons:

    @FindBy (xpath = ".//button[@onclick='configForm.submit()']")
    WebElementFacade saveConfigButton;

    //Objects for Advanced Tab:

    @FindBy (xpath = ".//*[@id='system_config_tabs']//span[contains(.,'Advanced')]")
    WebElementFacade advancedTab;

    @FindBy (xpath = ".//select[@id='Mage_Poll']")
    WebElementFacade cmsPoolModuleDropdown;

    //Messages:

    @FindBy (xpath = ".//*[@id='messages']//span[contains(.,'The configuration has been saved.')]")
    WebElementFacade configurationSavedSuccessMessage;

    //Methods for Advanced tab:

    public void openAdvancedTab (){
        advancedTab.click();
    }

    public void enableCmsPoolModule (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(cmsPoolModuleDropdown));
        cmsPoolModuleDropdown.selectByVisibleText("Enable");
        saveConfigButton.click();
        wait.until(ExpectedConditions.visibilityOf(configurationSavedSuccessMessage));
    }
}
