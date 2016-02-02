package com.qamadness.steps.backendSteps;

import com.qamadness.pages.backend.MainMenu;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class MainMenuSteps extends ScenarioSteps {

    MainMenu mainMenu;

    //------------------------------------------Steps for sales menu----------------------------------//

    @Step
    public void open_Orders_Page (){
        mainMenu.openOrdersPage();
    }

    //------------------------------------------Steps for customers menu------------------------------//

    @Step
    public void open_Manage_Customers_Page (){
        mainMenu.openManageCustomersPage();
    }

    @Step
    public void open_Customer_Groups_Page() { mainMenu.openCustomerGroupsPage(); }

    //-------------------------------------------Steps for catalog menu-------------------------------//

    @Step
    public void open_Manage_Attributes_Page() {mainMenu.openManageAttributesPage(); }

    @Step
    public void open_Manage_Attribute_Sets_page() {mainMenu.openManageAttributeSetsPage();}

    //------------------------------------------Steps for promotions menu-----------------------------//

    @Step
    public void open_Catalog_Price_Rules_Page(){ mainMenu.openCatalogPriceRulesPage();}

    @Step
    public void open_Shopping_Cart_Price_Rules_Page() {mainMenu.openShoppingCartPriceRulesPage();}

    //--------------------------------------Steps for CMS menu--------------------------------------//

    @Step
    public void open_CMS_Pages_Page (){
        mainMenu.openCMSPagesPage();
    }

    //-----------------------------------------Steps for system menu----------------------------------//

    @Step
    public void open_Cache_Management_Page() {mainMenu.openCacheManagementPage();}

    @Step
    public void open_Index_Management_Page() {mainMenu.openIndexManagementPage();}

    @Step
    public void openManageProductsPage () {mainMenu.openManageProductsPage();}

    @Step
    public void openManageCategoriesPage () {mainMenu.openManageCategoriesPage();}

    @Step
    public void open_Manage_Admin_Users_Page (){
        mainMenu.openManageAdminUsersPage();
    }

    @Step
    public void open_Manage_Roles_Page (){
        mainMenu.openManageRolesPage();
    }

    @Step
    public void openManageStoresPage () { mainMenu.openManageStoresPage();}
}
