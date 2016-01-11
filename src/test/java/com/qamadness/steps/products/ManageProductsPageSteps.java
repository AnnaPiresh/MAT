package com.qamadness.steps.products;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import com.qamadness.pages.products.ManageProductsPage;

/**
 * Created by Max on 16.12.2015.
 */
public class ManageProductsPageSteps extends ScenarioSteps {

    ManageProductsPage manageProductPage;

    @Step
    public void addProduct (){ manageProductPage.addProduct();}

    @Step
    public void selectAttributeSet (String value) { manageProductPage.selectAttributeSet(value);}

    @Step
    public void selectProductType(String value) { manageProductPage.selectProductType(value);}

    @Step
    public void continueButton () { manageProductPage.continueButton();}

    @Step
    public void enterName (String name) { manageProductPage.enterName(name);}

    @Step
    public void enterProductDescription (String descr) { manageProductPage.enterProductDescription(descr);}

    @Step
    public void enterShortDescription (String shortDescr) {manageProductPage.enterShortDescription(shortDescr);}

    @Step
    public void selectProductSKUType (String value) { manageProductPage.selectProductSKUType(value);}

    @Step
    public void enterSKU (String SKU) { manageProductPage.enterSKU(SKU);}

    @Step
    public void selectProductWeightType (String value) { manageProductPage.selectProductWeightType(value);}

    @Step
    public void enterWeight (String weight) { manageProductPage.enterWeight(weight);}

    @Step
    public void selectStatus (String value) { manageProductPage.selectStatus(value);}

    @Step
    public void selectVisibility (String value) { manageProductPage.selectVisibility(value);}

    @Step
    public void selectPricesTab () { manageProductPage.selectPricesTab();}

    @Step
    public void clearGlobalSearch () { manageProductPage.clearGlobalSearch();}

    @Step
    public void selectPriceType (String value) { manageProductPage.selectPriceType(value);}

    @Step
    public void enterProductPrice (String price) { manageProductPage.enterProductPrice(price);}

    @Step
    public void selectTaxClass (String value) { manageProductPage.selectTaxClass(value);}

    @Step
    public void selectPriceView (String value) { manageProductPage.selectPriceView(value);}

    @Step
    public void selectWebsitesTab () { manageProductPage.selectWebsitesTab();}

    @Step
    public void selectMainWebsite () { manageProductPage.selectMainWebsite();}

    @Step
    public void moveToTop () { manageProductPage.moveToTop();}

    @Step
    public void selectCategoriesTab () { manageProductPage.selectCategoriesTab();}

    @Step
    public void selectFirstCategory () { manageProductPage.selectFirstCategory();}

    @Step
    public void saveProduct () { manageProductPage.saveProduct();}

    @Step
    public void searchBySku (String SKU) { manageProductPage.searchBySku(SKU);}

    @Step
    public void searchButton () { manageProductPage.searchButton();}

    @Step
    public void checkProduct () { manageProductPage.checkProduct();}

    @Step
    public void selectAction (String value) { manageProductPage.selectAction(value);}

    @Step
    public void submitAction () { manageProductPage.submitAction();}

    @Step
    public void submitActionn () { manageProductPage.submitActionn();}

    @Step
    public void deletionApproveAlert () { manageProductPage.deletionApproveAlert();}

    @Step
    public void edit () { manageProductPage.edit();}

    /*@Step
    public void selectCategory () { manageProductPage.selectCategory();}*/

    @Step
    public void selectBundleTab () { manageProductPage.selectBundleTab();}

    @Step
    public void selectShipmentType (String value) { manageProductPage.selectShipmentType(value);}

    @Step
    public void addNewOption () { manageProductPage.addNewOption();}

    @Step
    public void enterDeafultTitle(String title) { manageProductPage.enterDeafultTitle(title);}

    @Step
    public void addSelection () { manageProductPage.addSelection();}

    @Step
    public void resetFilter () { manageProductPage.resetFilter();}

    @Step
    public void selectProductTwo () { manageProductPage.selectProductTwo();}

    @Step
    public void selectProductThree () { manageProductPage.selectProductThree();}

    @Step
    public void updateProductNameCheckboxClick () { manageProductPage.updateProductNameCheckboxClick();}

    @Step
    public void updateProductName (String name) { manageProductPage.updateProductName(name);}

    @Step
    public void checkNameUpdated (String name) { manageProductPage.checkNameUpdated(name);}
}
