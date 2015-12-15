package com.qamadness.Story;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.customers.AddNewCustomerSteps;
import com.qamadness.steps.customers.CustomerInformationSteps;
import com.qamadness.steps.customers.ManageCustomersSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.awt.*;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */

//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value="src/test/resources/LessThan5000.csv")
@RunWith(ThucydidesRunner.class)
public class ManageCustomersStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManageCustomersSteps manageCustomersSteps;

    @Steps
    AddNewCustomerSteps addNewCustomerSteps;

    @Steps
    CustomerInformationSteps customerInformationSteps;

    @Issue("MAT-17")
    @Test
    public void check_that_admin_can_create_new_customer () throws AWTException {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Customers_Page();
        manageCustomersSteps.check_That_Manage_Customers_Page_Is_Opened();
        manageCustomersSteps.clickAddNewCustomerBtn();
        addNewCustomerSteps.select_Associate_To_Website_Option("Main Website");
        addNewCustomerSteps.select_Group("Wholesale");
        addNewCustomerSteps.enter_Prefix("Mrs");
        addNewCustomerSteps.enter_First_Name("Anna");
        addNewCustomerSteps.enter_Middle_Name("Victorovna");
        addNewCustomerSteps.enter_Last_Name("Tester");
        addNewCustomerSteps.enter_Suffix("Madam");
        addNewCustomerSteps.enter_Email("tester.new20110@gmail.com");
        addNewCustomerSteps.enter_Date_Of_Birth("12/12/1989");
        addNewCustomerSteps.enter_Tax_Number("97867565465768");
        addNewCustomerSteps.select_Gender("Female");
        addNewCustomerSteps.enter_Password("123456");
        addNewCustomerSteps.click_Save_Customer_Button();
        manageCustomersSteps.search_Customer_By_Email("tester.new20110@gmail.com");
        manageCustomersSteps.check_Search_Result("tester.new20110@gmail.com");
        manageCustomersSteps.open_First_Customer_Profile();
        customerInformationSteps.open_Account_Information_Tab();
        customerInformationSteps.check_That_Saved_Associate_To_Website_Option_Is_Correct("Main Website");
        customerInformationSteps.check_That_Group_Selected_Option_Is_Saved_Correctly("Wholesale");
        customerInformationSteps.check_That_Prefix_Is_Saved_Correctly("Mrs");
        customerInformationSteps.check_That_First_Name_Is_Saved_Correctly("Anna");
        customerInformationSteps.check_That_Middle_Name_Is_Saved_Correctly("Victorovna");
        customerInformationSteps.check_That_Last_Name_Is_Saved_Correctly("Tester");
        customerInformationSteps.check_That_Suffix_Is_Saved_Correctly("Madam");
        customerInformationSteps.check_That_Email_Is_Saved_Correctly("tester.new20110@gmail.com");
        customerInformationSteps.check_That_Date_Of_Birth_Is_Saved_Correctly("12/12/1989");
        customerInformationSteps.check_That_Tax_Number_Is_Saved_Correctly("97867565465768");
        customerInformationSteps.check_That_Gender_Is_Saved_Correctly("Female");
        customerInformationSteps.click_Delete_Customer_Button();
    }
}
