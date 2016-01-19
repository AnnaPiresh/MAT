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

    /*@Step
    public void clearCategoryName () { manageCategoriesPage.clearCategoryName();}*/

    @Step
    public void selectCategoryActivity (String value) { manageCategoriesPage.selectCategoryActivity(value);}

    @Step
    public void selectIncludingInNavigationMenu (String value) { manageCategoriesPage.selectIncludingInNavigationMenu(value);}

    @Step
    public void saveCategory () { manageCategoriesPage.saveCategory();}

    @Step
    public void addNewRootCategory () { manageCategoriesPage.addNewRootCategory();}

    @Step
    public void selectCategoryByName (String name) {manageCategoriesPage.selectCategoryByName(name);}

    @Step
    public void checkSuccessMessage () {manageCategoriesPage.checkSuccessMessage();}

    @Step
    public void deleteCategory () {manageCategoriesPage.deleteCategory();}

    @Step
    public void enterCategoryDescription (String desc) {manageCategoriesPage.enterCategoryDescription(desc);}

    @Step
    public void enterPageTitle (String title) {manageCategoriesPage.enterPageTitle(title);}

    @Step
    public void enterMetaKeywords (String keywords) {manageCategoriesPage.enterMetaKeywords(keywords);}

    @Step
    public void entermetaDescription (String metadesc) {manageCategoriesPage.entermetaDescription(metadesc);}

    @Step
    public void selectDisplaySettingsTab () {manageCategoriesPage.selectDisplaySettingsTab();}
}
