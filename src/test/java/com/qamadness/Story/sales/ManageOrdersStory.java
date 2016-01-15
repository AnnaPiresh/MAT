package com.qamadness.Story.sales;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.salesSteps.ManageOrdersSteps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serhii_Boiko on 14.01.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/ManageOrdersData.csv")
public class ManageOrdersStory {

    private String login;
    private String password;

    private String status;
    private String action;
    private String orderID;
    private String ordersPage;
    private String value;
    private String cancelOrderMessage;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManageOrdersSteps manageOrdersSteps;

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
        } else {}
        mainMenuSteps.open_Orders_Page();
    }

    @Issue("MAT-12")
    //@Pending
    @Test
    public void check_that_user_can_change_qty_of_orders_displayed_per_page(){
        manageOrdersSteps.can_user_change_qty_of_orders(value);
        manageOrdersSteps.check_new_qty_of_orders();
        manageOrdersSteps.unselect_orders();
    }

    @Issue("MAT-13")
    //@Pending
    @Test
    public void check_that_user_can_navigate_between_orders_using_arrows() {
        manageOrdersSteps.switch_to_next_orders_page();
        manageOrdersSteps.switch_to_previous_orders_page();
    }

    @Issue("MAT-14")
    @Pending
    @Test
    public void can_user_navigate_to_a_particular_page_of_orders(){
        manageOrdersSteps.enter_orders_page(ordersPage);
        manageOrdersSteps.check_the_page_is_correct(ordersPage);
    }

    @Issue("MAT-15")
    //@Pending
    @Test
    public void can_user_filter_orders_by_id (){
        manageOrdersSteps.filter_orders_in_grid(orderID);
        manageOrdersSteps.check_filtered_order_number(orderID);
        manageOrdersSteps.reset_filter();
    }

    @Issue("MAT-16")
    //@Pending
    @Test
    public void can_user_sort_orders_by_id(){
        manageOrdersSteps.change_sort_order_by_id();
        manageOrdersSteps.check_that_sorting_changed();
    }

    @Issue("MAT-19")
    //@Pending
    @Test
    public void can_user_cancel_order_from_admin(){
        manageOrdersSteps.see_orders_in_pending_status(status);
        manageOrdersSteps.cancel_selected_order(action);
        manageOrdersSteps.check_success_message(cancelOrderMessage);
        manageOrdersSteps.reset_filter();
    }
}
