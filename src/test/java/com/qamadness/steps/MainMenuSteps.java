package com.qamadness.steps;

import com.qamadness.pages.MainMenu;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class MainMenuSteps extends ScenarioSteps {

    MainMenu mainMenu;

    @Step
    public void open_Orders_Page (){
        mainMenu.openOrdersPage();
    }

    @Step
    public void open_Manage_Customers_Page (){
        mainMenu.openManageCustomersPage();
    }

    @Step
    public void open_Manage_Attributes_Page() {mainMenu.openManageAttributesPage(); }

    @Step
    public void open_Customer_Groups_Page() { mainMenu.openCustomerGroupsPage(); }

    @Step
    public void open_Catalog_Price_Rules_Page(){ mainMenu.openCatalogPriceRulesPage();}

    @Step
    public void open_Shopping_Cart_Price_Rules_Page() {mainMenu.openShoppingCartPriceRulesPage();}

    @Step
    public void open_Cache_Management_Page() {mainMenu.openCacheManagementPage();}

    @Step
    public void open_Index_Management_Page() {mainMenu.openIndexManagementPage();}

    @Step
    public void openManageProductsPage () {mainMenu.openManageProductsPage();}
}
