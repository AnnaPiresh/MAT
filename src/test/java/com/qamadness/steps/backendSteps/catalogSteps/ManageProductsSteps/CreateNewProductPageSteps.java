package com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps;


import com.qamadness.pages.backend.catalog.ManageProducts.CreateNewProductPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.yecht.Data;


/**
 * Created by M. Yermolenko on 15.01.2016.
 */


public class CreateNewProductPageSteps extends PageObject {

    CreateNewProductPage createNewProductPage;

    @Step
    public void selectAttributeSet (String value) { createNewProductPage.selectAttributeSet(value);}

    @Step
    public void select_attribute_set_by_name(String setName) {createNewProductPage.selectAttributeSetByName(setName);}

    @Step
    public void selectProductType(String value) { createNewProductPage.selectProductType(value);}

    @Step
    public void continueButton () { createNewProductPage.continueButton();}

    @Step
    public void enterName (String name) { createNewProductPage.enterName(name);}

    @Step
    public void enterProductDescription (String descr) { createNewProductPage.enterProductDescription(descr);}

    @Step
    public void enterShortDescription (String shortDescr) {createNewProductPage.enterShortDescription(shortDescr);}

    @Step
    public void selectProductSKUType (String value) { createNewProductPage.selectProductSKUType(value);}

    @Step
    public void enterSKU (String SKU) { createNewProductPage.enterSKU(SKU);}

    @Step
    public void selectProductWeightType (String value) { createNewProductPage.selectProductWeightType(value);}

    @Step
    public void enterWeight (String weight) { createNewProductPage.enterWeight(weight);}

    @Step
    public void selectStatus (String value) { createNewProductPage.selectStatus(value);}

    @Step
    public void selectVisibility (String value) { createNewProductPage.selectVisibility(value);}

    @Step
    public void selectPricesTab () { createNewProductPage.selectPricesTab();}

    @Step
    public void clearGlobalSearch () { createNewProductPage.clearGlobalSearch();}

    @Step
    public void selectPriceType (String value) { createNewProductPage.selectPriceType(value);}

    @Step
    public void enterProductPrice (String price) { createNewProductPage.enterProductPrice(price);}

    @Step
    public void selectTaxClass (String value) { createNewProductPage.selectTaxClass(value);}

    @Step
    public void selectPriceView (String value) { createNewProductPage.selectPriceView(value);}

    @Step
    public void selectWebsitesTab () { createNewProductPage.selectWebsitesTab();}

    @Step
    public void selectMainWebsite () { createNewProductPage.selectMainWebsite();}

    @Step
    public void moveToTop () { createNewProductPage.moveToTop();}

    @Step
    public void selectCategoriesTab () { createNewProductPage.selectCategoriesTab();}

    @Step
    public void selectFirstCategory () { createNewProductPage.selectFirstCategory();}

    @Step
    public void saveProduct () { createNewProductPage.saveProduct();}

    @Step
    public void selectBundleTab () { createNewProductPage.selectBundleTab();}

    @Step
    public void selectShipmentType (String value) { createNewProductPage.selectShipmentType(value);}

    @Step
    public void addNewOption () { createNewProductPage.addNewOption();}

    @Step
    public void enterDeafultTitle(String title) { createNewProductPage.enterDeafultTitle(title);}

    @Step
    public void addSelection () { createNewProductPage.addSelection();}

    @Step
    public void resetFilter () { createNewProductPage.resetFilter();}

    @Step
    public void selectProductTwo () { createNewProductPage.selectProductTwo();}

    @Step
    public void selectProductThree () { createNewProductPage.selectProductThree();}

    @Step
    public void selectConfigurableAttribute () { createNewProductPage.selectConfigurableAttribute();}

    @Step
    public void selectAssociatedProductsConfigurableTab() { createNewProductPage.selectAssociatedProductsConfigurableTab();}

    @Step
    public void checkFirstConfigurableAssociatedProduct() { createNewProductPage.checkFirstConfigurableAssociatedProduct();}

    @Step
    public void checkSecondConfigurableAssociatedProduct() { createNewProductPage.checkSecondConfigurableAssociatedProduct();}

    @Step
    public void selectAssociatedProductsTabGrouped () { createNewProductPage.selectAssociatedProductsTabGrouped();}

    @Step
    public void checkFirstGroupAssociatedProduct () { createNewProductPage.checkFirstGroupAssociatedProduct();}

    @Step
    public void checkSecondGroupAssociatedProduct () { createNewProductPage.checkSecondGroupAssociatedProduct();}

    @Step
    public void selectDownloadableInformationTab () { createNewProductPage.selectDownloadableInformationTab();}

    @Step
    public void addNewRow () { createNewProductPage.addNewRow();}

    @Step
    public void enterDownloadableLinkName (String name) { createNewProductPage.enterDownloadableLinkName(name);}

    @Step
    public void sampleSelectURL () { createNewProductPage.sampleSelectURL();}

    @Step
    public void enterSampleURL (String url) { createNewProductPage.enterSampleURL(url);}

    @Step
    public void fileSelectURL () { createNewProductPage.fileSelectURL();}

    @Step
    public void enterFileURL (String url) { createNewProductPage.enterFileURL(url);}

    @Step
    public void click_save_and_edit_button(){createNewProductPage.clickSaveAndEditButton();}

    @Step
    public void select_inventory_tab() {createNewProductPage.selectInventoryTab();}

    @Step
    public void select_stock_availability(String stockStatus) {createNewProductPage.selectStockAvailability(stockStatus);}

    @Step
    public void search_associated_products_by_sku(String productSKU){
        createNewProductPage.searchAssociatedProductsBySku(productSKU);}

    @Step
    public void select_all_associated_products(){createNewProductPage.selectAllAssociatedProducts();}

    @Step
    public void untick_use_config_settings_checkbox(){createNewProductPage.untickUseConfigSettingsCheckbox();}

    @Step
    public void change_manage_stock_settings(String stockEnabled) {
        createNewProductPage.changeManageStockSettings(stockEnabled);}

    @Step
    public void search_bundle_items_by_sku(String productSKU) {createNewProductPage.searchBudndleItemsBySku(productSKU);}

    @Step
    public void click_add_selected_products_to_option_button(){createNewProductPage.clickAddSelectedProductsToOptionBtn();}

    @Step
    public void select_input_type_for_bundle_items(String inputType){
        createNewProductPage.selectInputTypeForBundleItems(inputType);}

    @Step
    public void select_clothing_tab(){createNewProductPage.selectClothingTab();}

    @Step
    public void select_product_colour(String productColour){createNewProductPage.selectProductColour(productColour);}

    @Step
    public void select_clothing_type(String clothingType){createNewProductPage.selectClothingType(clothingType);}

    @Step
    public void tick_configurable_attribute_checkbox() {createNewProductPage.tickConfigurableAttributeCheckbox();}

    @Step
    public void search_configurable_associated_products_bu_sku(String productSKU){
        createNewProductPage.searchConfigurableAssociatedProductsBySku(productSKU); }

    @Step
    public void select_all_associated_products_configurable(){
        createNewProductPage.selectAllAssociatedProductsConfigurable();
    }
}
