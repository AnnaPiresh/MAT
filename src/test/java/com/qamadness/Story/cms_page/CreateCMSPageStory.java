package com.qamadness.Story.cms_page;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pagesSteps.CreateNewPagesSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pagesSteps.ManagePagesSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.frontendSteps.cmsPageSteps.NewCMSPageSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
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


import java.util.Random;

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
    ManagePagesSteps managePagesSteps;

    @Steps
    CreateNewPagesSteps createNewPagesSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    NewCMSPageSteps newCMSPageSteps;

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
        Random generator = new Random();
        int i = generator.nextInt(1000);
        String generatedUrlKey = urlKey+i;
        //create new page with filling all required fields:
        managePagesSteps.click_Add_New_Page_Button();
        createNewPagesSteps.enter_Page_Title(pageTitle);
        createNewPagesSteps.enter_Url_Key(generatedUrlKey);
        createNewPagesSteps.select_Store_View(allStoreViews);
        createNewPagesSteps.select_Status("Enabled");
        createNewPagesSteps.open_Content_Tab();
        createNewPagesSteps.enter_Content_Heading(contentHeading);
        createNewPagesSteps.enter_Main_Content(mainContent);
        createNewPagesSteps.click_Save_Page_Button();
        //verifications:
        managePagesSteps.verify_That_Success_Saved_Page_Message_Is_Displayed();
        homePageSteps.open_Home_Page();
        newCMSPageSteps.open_New_CMS_Page(generatedUrlKey);
        newCMSPageSteps.verify_That_Page_Contains_Heading_And_Content(contentHeading,mainContent);
        //remove created page
        loginPageSteps.openPage();
        mainMenuSteps.open_CMS_Pages_Page();
        managePagesSteps.filter_Pages_By_Url_Key(generatedUrlKey);
        managePagesSteps.click_First_Page_In_The_Grid();
        createNewPagesSteps.click_Delete_Page_Button_And_Confirm();
    }

    //Test case "Create CMS page with all fields and widgets":

    @Issue("MAT-177")
    @Pending@Test
    public void createPageWithAllFieldsAndWidgets (){
        Random generator = new Random();
        int i = generator.nextInt(1000);
        String generatedUrlKey = urlKey+i;
        //create new page and fill all fields
        managePagesSteps.click_Add_New_Page_Button();
        createNewPagesSteps.enter_Page_Title(pageTitle);
        createNewPagesSteps.enter_Url_Key(generatedUrlKey);
        createNewPagesSteps.select_Store_View(allStoreViews);
        createNewPagesSteps.select_Status("Enabled");
        createNewPagesSteps.open_Content_Tab();
        createNewPagesSteps.enter_Content_Heading(contentHeading);
        createNewPagesSteps.enter_Main_Content(mainContent);
        createNewPagesSteps.open_Design_Tab();
        createNewPagesSteps.select_Page_Layout(layout);
        createNewPagesSteps.set_Current_Date_For_Custom_Design_From_Date();
        createNewPagesSteps.set_Current_Date_For_Custom_Design_To_Field();
        createNewPagesSteps.select_Custom_Theme(customTheme);
        createNewPagesSteps.select_Custom_Layout(customLayout);
        createNewPagesSteps.open_Meta_Data_Tab();
        createNewPagesSteps.enter_Keywords(keywords);
        createNewPagesSteps.enter_Description(description);
        //add all widgets to the page and save
        createNewPagesSteps.open_Content_Tab();
        createNewPagesSteps.add_CMS_Page_Link_Widget(anchorCustomText, anchorCustomTitle);
        createNewPagesSteps.add_Cms_Static_Block_Widget();
        createNewPagesSteps.add_Catalog_Category_Link_Widget(anchorCustomText,anchorCustomTitle);
        createNewPagesSteps.add_Catalog_New_Product_List_Widget(numberOfProducts,cacheLifetime);
        createNewPagesSteps. add_Catalog_Product_Link_Widget(anchorCustomText,anchorCustomTitle);
        createNewPagesSteps.add_Orders_And_Returns_Widget ();
        createNewPagesSteps.add_Recently_Compared_Products_Widget(numberOfProducts);
        createNewPagesSteps.add_Recently_Viewed_Products_Widget(numberOfProducts);
        createNewPagesSteps.click_Save_Page_Button();
       //verifications:
        managePagesSteps.verify_That_Success_Saved_Page_Message_Is_Displayed();
        homePageSteps.open_Home_Page();
        newCMSPageSteps.open_New_CMS_Page(generatedUrlKey);
        newCMSPageSteps.verify_That_Page_Contains_Heading_And_Content(contentHeading,mainContent);
        newCMSPageSteps.verify_That_Three_Columns_Layout_Is_Used();
        newCMSPageSteps.verify_That_Keywords_Are_Added(keywords);
        newCMSPageSteps.verify_That_Meta_Description_Is_Added(description);
        newCMSPageSteps.verify_That_CMS_Page_Link_Widget_Is_Added ();
        newCMSPageSteps.verify_That_Category_Link_Widget_Is_Added ();
        newCMSPageSteps.verify_That_Cms_Static_Block_Widget_Is_Added ();
        newCMSPageSteps.verify_That_New_Products_Widget_Is_Added ();
        newCMSPageSteps.verify_That_Product_Link_Widget_Is_Added ();
        newCMSPageSteps.verify_That_Orders_And_Returns_Widget_Is_Added();
        //remove created page
        loginPageSteps.openPage();
        mainMenuSteps.open_CMS_Pages_Page();
        managePagesSteps.filter_Pages_By_Url_Key(generatedUrlKey);
        managePagesSteps.click_First_Page_In_The_Grid();
        createNewPagesSteps.click_Delete_Page_Button_And_Confirm();
    }

    //Test case "Create CMS page with empty required field"

    @Issue("MAT-178")
    @Pending@Test
    public void createPageWithEmptyRequiredField (){
        //create new page and with empty urlKey field
        managePagesSteps.click_Add_New_Page_Button();
        createNewPagesSteps.enter_Page_Title(pageTitle);
        createNewPagesSteps.enter_Url_Key("");
        createNewPagesSteps.select_Store_View(allStoreViews);
        createNewPagesSteps.select_Status("Enabled");
        createNewPagesSteps.open_Content_Tab();
        createNewPagesSteps.enter_Content_Heading(contentHeading);
        createNewPagesSteps.enter_Main_Content(mainContent);
        createNewPagesSteps.open_Design_Tab();
        createNewPagesSteps.select_Page_Layout(layout);
        createNewPagesSteps.open_Meta_Data_Tab();
        createNewPagesSteps.enter_Keywords(keywords);
        createNewPagesSteps.enter_Description(description);
        createNewPagesSteps.click_Save_Page_Button();
        //verification:
        //createNewPagesSteps.verify_That_Empty_Required_Field_Error_Message_Is_Displayed();
    }

}
