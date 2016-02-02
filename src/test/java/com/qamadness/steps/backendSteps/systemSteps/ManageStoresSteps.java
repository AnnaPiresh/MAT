package com.qamadness.steps.backendSteps.systemSteps;

import com.qamadness.pages.backend.system.ManageStoresPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

/**
 * Created by M. Yermolenko on 02.02.2016.
 */
public class ManageStoresSteps extends PageObject {

    ManageStoresPage manageStoresPage;

    @Step
    public void clickStoreName () {manageStoresPage.clickStoreName();}

    @Step
    public void selectStoreRootCategory (String value) {manageStoresPage.selectStoreRootCategory(value);}

    @Step
    public void clickSaveStoreButton () {manageStoresPage.clickSaveStoreButton();}
}
