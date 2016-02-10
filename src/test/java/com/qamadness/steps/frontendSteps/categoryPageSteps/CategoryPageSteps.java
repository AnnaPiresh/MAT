package com.qamadness.steps.frontendSteps.categoryPageSteps;

import com.qamadness.pages.frontend.categoryPage.CategoryPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

/**
 * Created by Vladislav.E on 09.02.2016.
 */
public class CategoryPageSteps extends PageObject {

    CategoryPage categoryPage;

    @Step
    public void add_Products_To_Compare() {categoryPage.addProductsToCompare();}

}
