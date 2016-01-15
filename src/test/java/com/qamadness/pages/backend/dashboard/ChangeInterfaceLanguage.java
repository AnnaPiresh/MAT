package com.qamadness.pages.backend.dashboard;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ChangeInterfaceLanguage extends PageObject{

//------------------------------------Objects for Language Interface---------------------------------------------------//

    @FindBy(xpath = ".//*[@id='grid_tab_reviewed_products']")
    WebElementFacade reviewedProductsTab;

    @FindBy(xpath = ".//*[@id='interface_locale']")
    WebElementFacade interfaceLocaleDropdown;




}
