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
    public void refreshPage () {manageCategoriesPage.refreshPage();}

    @Step
    public void addNewSubCategory () { manageCategoriesPage.addNewSubCategory();}

    @Step
    public void selectGeneralTab () { manageCategoriesPage.selectGeneralTab();}

    @Step
    public void enterCategoryName (String name) { manageCategoriesPage.enterCategoryName(name);}

    @Step
    public void clearCategoryNameField () {manageCategoriesPage.clearCategoryNameField();}

    @Step
    public void clearCategoryName () { manageCategoriesPage.clearCategoryName();}

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
    public void checkNameIsNotAdded () {manageCategoriesPage.checkNameIsNotAdded();}

    @Step
    public void deleteCategory () {manageCategoriesPage.deleteCategory();}

    @Step
    public void checkCategoryDeleted(){manageCategoriesPage.checkCategoryDeleted();}

    @Step
    public void checkDeleteButtonAbsent(){manageCategoriesPage.checkDeleteButtonAbsent();}

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

    @Step
    public void selectDisplayMode (String value) {manageCategoriesPage.selectDisplayMode(value);}

    @Step
    public void selectCMSBlock (String value) {manageCategoriesPage.selectCMSBlock(value);}

    @Step
    public void clickUseAllAvailableAttributesCheckbox () {manageCategoriesPage.clickUseAllAvailableAttributesCheckbox();}

    @Step
    public void selectAvailableProductListingSortBy (String value) {manageCategoriesPage.selectAvailableProductListingSortBy(value);}

    @Step
    public void clickUseConfigSettingCheckbox () {manageCategoriesPage.clickUseConfigSettingCheckbox();}

    @Step
    public void selectDefaultProductListingSortBy (String value) {manageCategoriesPage.selectDefaultProductListingSortBy(value);}

    @Step
    public void clickPriceStepUseConfigSettingCheckbox () {manageCategoriesPage.clickPriceStepUseConfigSettingCheckbox();}

    @Step
    public void enterLayeredNavigationPriceStep (String value) {manageCategoriesPage.enterLayeredNavigationPriceStep(value);}

    @Step
    public void selectIsAnchor (String value) {manageCategoriesPage.selectIsAnchor(value);}

    @Step
    public void selectCustomDesignTab () {manageCategoriesPage.selectCustomDesignTab();}

    @Step
    public void selectUseParentCategorySettings (String value) {manageCategoriesPage.selectUseParentCategorySettings(value);}

    @Step
    public void selectApplyToProducts(String value) {manageCategoriesPage.selectApplyToProducts(value);}

    @Step
    public void selectCustomDesign (String value) {manageCategoriesPage.selectCustomDesign(value);}

    @Step
    public void selectActiveFrom (String value) {manageCategoriesPage.selectActiveFrom(value);}

    @Step
    public void selectActiveTo(String value) {manageCategoriesPage.selectActiveTo(value);}

    @Step
    public void selectPageLayout(String value) {manageCategoriesPage.selectPageLayout(value);}

    @Step
    public void enterCustomLayoutUpdate(String value) {manageCategoriesPage.enterCustomLayoutUpdate(value);}

    @Step
    public void selectCategoryProductsTab () {manageCategoriesPage.selectCategoryProductsTab();}

    @Step
    public void selectSomeCategoryProducts () {manageCategoriesPage.selectSomeCategoryProducts();}
}
