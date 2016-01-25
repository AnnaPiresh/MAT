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
    @Test
    public void createPageWithAllRequiredFields (){
        //create new page with filling all required fields:
        managePagesSteps.click_Add_New_Page_Button();
        createNewPagesSteps.enter_Page_Title(pageTitle);
        createNewPagesSteps.enter_Url_Key(urlKey);
        createNewPagesSteps.select_Store_View(allStoreViews);
        createNewPagesSteps.select_Status("Enabled");
        createNewPagesSteps.open_Content_Tab();
        createNewPagesSteps.enter_Content_Heading(contentHeading);
        createNewPagesSteps.enter_Main_Content(mainContent);
        createNewPagesSteps.click_Save_Page_Button();
        //verifications:
        managePagesSteps.verify_That_Success_Saved_Page_Message_Is_Displayed();
        homePageSteps.open_Home_Page();
        newCMSPageSteps.open_New_CMS_Page(urlKey);
        newCMSPageSteps.verify_That_Page_Contains_Heading_And_Content(contentHeading,mainContent);
        //remove created page
        loginPageSteps.openPage();
        mainMenuSteps.open_CMS_Pages_Page();
        managePagesSteps.filter_Pages_By_Url_Key(urlKey);
        managePagesSteps.click_First_Page_In_The_Grid();
        createNewPagesSteps.click_Delete_Page_Button_And_Confirm();
    }
}
