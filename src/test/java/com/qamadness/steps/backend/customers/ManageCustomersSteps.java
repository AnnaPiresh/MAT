package com.qamadness.steps.backend.customers;

import com.qamadness.pages.backend.customers.ManageCustomersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class ManageCustomersSteps extends ScenarioSteps {

    ManageCustomersPage manageCustomersPage;

    @Step
    public void check_That_Manage_Customers_Page_Is_Opened (){
        manageCustomersPage.checkThatManageCustomersPageIsOpened();
    }

    @Step
    public void clickAddNewCustomerBtn (){
        manageCustomersPage.clickAddNewCustomerBtn();
    }

    @Step
    public void search_Customer_By_Email (String email){
        manageCustomersPage.searchCustomerByEmail(email);
    }

    @Step
    public void check_Search_Result (String email){
        manageCustomersPage.checkSearchResult(email);
    }

    @Step
    public void open_First_Customer_Profile (){
        manageCustomersPage.openFirstCustomerProfile();
    }
}
