package com.qamadness.steps.backendSteps.catalogSteps.ManageCategoriesSteps;

import com.qamadness.pages.backend.catalog.ManageCategories.ManageCategoriesPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

/**
 * Created by kampa on 13.01.2016.
 */
public class ManageCategoriesPageSteps extends PageObject {

    ManageCategoriesPage manageCategoriesPage;

    @Step
    public void addNewSubCategory () { manageCategoriesPage.addNewSubCategory();}

    @Step
    public void enterCategoryName (String name) { manageCategoriesPage.enterCategoryName(name);}

    @Step
    public void selectCategoryActivity (String value) { manageCategoriesPage.selectCategoryActivity(value);}

    @Step
    public void selectIncludingInNavigationMenu (String value) { manageCategoriesPage.selectIncludingInNavigationMenu(value);}

    @Step
    public void saveCategory () { manageCategoriesPage.saveCategory();}

    @Step
    public void checkCategorySaved () { manageCategoriesPage.checkCategorySaved();}
}
