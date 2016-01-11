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
    public void openManageProducts (){
        mainMenu.openManageProducts();
    }
}
