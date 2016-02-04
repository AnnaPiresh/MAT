package com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import com.qamadness.pages.backend.catalog.ManageProducts.ManageProductsPage;

/**
 * Created by Max on 16.12.2015.
 */
public class ManageProductsPageSteps extends ScenarioSteps {

    ManageProductsPage manageProductPage;

    @Step
    public void addProduct (){ manageProductPage.addProduct();}

    @Step
    public void searchBySku (String SKU) { manageProductPage.searchBySku(SKU);}

    @Step
    public void clearSKUFilter () { manageProductPage.clearSKUFilter();}

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
    public void check_no_products_are_found(String searchMessage) {manageProductPage.checkNoProductsAreFound(searchMessage);}

    @Step
    public void updateProductNameCheckboxClick () { manageProductPage.updateProductNameCheckboxClick();}

    @Step
    public void check_success_message(){manageProductPage.checkSuccessMessage();}

    @Step
    public void checkNameUpdated (String name) { manageProductPage.checkNameUpdated(name);}

    @Step
    public void select_all_products() {manageProductPage.selectAllProducts();}


}
