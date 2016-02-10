package com.qamadness.pages.frontend.categoryPage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Vladislav.E on 09.02.2016.
 */
public class CategoryPage extends PageObject{

    @FindBy(css = ".link-compare")
    WebElementFacade addToCompareBtn;

    public void addProductsToCompare() {addToCompareBtn.click();}

}
