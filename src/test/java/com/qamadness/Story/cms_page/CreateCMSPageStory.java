package com.qamadness.Story.cms_page;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pagesSteps.CreateNewPagesSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pagesSteps.ManagePagesSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.frontendSteps.cmsPageSteps.NewCMSPageSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
import com.sun.org.apache.bcel.internal.generic.NEW;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Alexandra on 1/25/16.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/cms_page/CreateCMSPageData.csv")
public class CreateCMSPageStory {

    //Data in CSV file:

    private String adminLogin;
    private String adminPassword;
    private String pageTitle;
    private String urlKey;
    private String englishStoreView;
    private String allStoreViews;
    private String contentHeading;
    private String mainContent;
    private String layout;
    private String customTheme;
    private String customLayout;
    private String keywords;
    private String description;
    private String anchorCustomText;
    private String anchorCustomTitle;
    private String numberOfProducts;
    private String cacheLifetime;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManagePagesSteps ManagePagesSteps;

    @Steps
    CreateNewPagesSteps CreateNewPagesSteps;

    @Steps
    HomePageSteps HomePageSteps;

    @Steps
    NewCMSPageSteps NewCMSPageSteps;

    /*Precondition:
    * 1)Login to admin and navigate to CMS->Pages page*/

    @Before
    public void preconditionLoginAndNavigate(){
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_CMS_Pages_Page();
    }

    //Test case "Create page with all required fields"

    @Issue("MAT-176")
    @Pending @Test
    public void createPageWithAllRequiredFields (){
        //create new page with filling all required fields:
        ManagePagesSteps.click_Add_New_Page_Button();
        CreateNewPagesSteps.enter_Page_Title(pageTitle);
        CreateNewPagesSteps.enter_Url_Key(urlKey);
        CreateNewPagesSteps.select_Store_View(allStoreViews);
        CreateNewPagesSteps.select_Status("Enabled");
        CreateNewPagesSteps.open_Content_Tab();
        CreateNewPagesSteps.enter_Content_Heading(contentHeading);
        CreateNewPagesSteps.enter_Main_Content(mainContent);
        CreateNewPagesSteps.click_Save_Page_Button();
        //verifications:
        ManagePagesSteps.verify_That_Success_Saved_Page_Message_Is_Displayed();
        HomePageSteps.open_Home_Page();
        NewCMSPageSteps.open_New_CMS_Page(urlKey);
        NewCMSPageSteps.verify_That_Page_Contains_Heading_And_Content(contentHeading,mainContent);
        //remove created page
        loginPageSteps.openPage();
        mainMenuSteps.open_CMS_Pages_Page();
        ManagePagesSteps.filter_Pages_By_Url_Key(urlKey);
        ManagePagesSteps.click_First_Page_In_The_Grid();
        CreateNewPagesSteps.click_Delete_Page_Button_And_Confirm();
    }

    //Test case "Create CMS page with all fields and widgets":

    @Issue("MAT-177")
    @Pending @Test
    public void createPageWithAllFieldsAndWidgets (){
        //create new page and fill all fields
        ManagePagesSteps.click_Add_New_Page_Button();
        CreateNewPagesSteps.enter_Page_Title(pageTitle);
        CreateNewPagesSteps.enter_Url_Key(urlKey);
        CreateNewPagesSteps.select_Store_View(allStoreViews);
        CreateNewPagesSteps.select_Status("Enabled");
        CreateNewPagesSteps.open_Content_Tab();
        CreateNewPagesSteps.enter_Content_Heading(contentHeading);
        CreateNewPagesSteps.enter_Main_Content(mainContent);
        CreateNewPagesSteps.open_Design_Tab();
        CreateNewPagesSteps.select_Page_Layout(layout);
        CreateNewPagesSteps.set_Current_Date_For_Custom_Design_From_Date();
        CreateNewPagesSteps.set_Current_Date_For_Custom_Design_To_Field();
        CreateNewPagesSteps.select_Custom_Theme(customTheme);
        CreateNewPagesSteps.select_Custom_Layout(customLayout);
        CreateNewPagesSteps.open_Meta_Data_Tab();
        CreateNewPagesSteps.enter_Keywords(keywords);
        CreateNewPagesSteps.enter_Description(description);
        //add all widgets to the page and save
        CreateNewPagesSteps.open_Content_Tab();
        CreateNewPagesSteps.add_CMS_Page_Link_Widget(anchorCustomText, anchorCustomTitle);
        CreateNewPagesSteps.add_Cms_Static_Block_Widget();
        CreateNewPagesSteps.add_Catalog_Category_Link_Widget(anchorCustomText,anchorCustomTitle);
        CreateNewPagesSteps.add_Catalog_New_Product_List_Widget(numberOfProducts,cacheLifetime);
        CreateNewPagesSteps. add_Catalog_Product_Link_Widget(anchorCustomText,anchorCustomTitle);
        CreateNewPagesSteps.add_Orders_And_Returns_Widget ();
        CreateNewPagesSteps.add_Recently_Compared_Products_Widget(numberOfProducts);
        CreateNewPagesSteps.add_Recently_Viewed_Products_Widget(numberOfProducts);
        CreateNewPagesSteps.click_Save_Page_Button();
        //verifications:
        ManagePagesSteps.verify_That_Success_Saved_Page_Message_Is_Displayed();
        HomePageSteps.open_Home_Page();
        NewCMSPageSteps.open_New_CMS_Page(urlKey);
        NewCMSPageSteps.verify_That_Page_Contains_Heading_And_Content(contentHeading,mainContent);
        NewCMSPageSteps.verify_That_Three_Columns_Layout_Is_Used();
        NewCMSPageSteps.verify_That_Keywords_Are_Added(keywords);
        NewCMSPageSteps.verify_That_Meta_Description_Is_Added(description);
        NewCMSPageSteps.verify_That_CMS_Page_Link_Widget_Is_Added ();
        NewCMSPageSteps.verify_That_Category_Link_Widget_Is_Added ();
        NewCMSPageSteps.verify_That_Cms_Static_Block_Widget_Is_Added ();
        NewCMSPageSteps.verify_That_New_Products_Widget_Is_Added ();
        NewCMSPageSteps.verify_That_Product_Link_Widget_Is_Added ();
        //remove created page
        loginPageSteps.openPage();
        mainMenuSteps.open_CMS_Pages_Page();
        ManagePagesSteps.filter_Pages_By_Url_Key(urlKey);
        ManagePagesSteps.click_First_Page_In_The_Grid();
        CreateNewPagesSteps.click_Delete_Page_Button_And_Confirm();

    }

}
