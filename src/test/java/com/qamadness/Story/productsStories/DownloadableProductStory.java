package com.qamadness.Story.productsStories;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.products.ManageProductsPageSteps;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(ThucydidesRunner.class)
public class DownloadableProductStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    ManageProductsPageSteps manageProductsPageSteps;

    @Test
    public void addingDownloadableProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProducts();
        manageProductsPageSteps.addProduct();
        manageProductsPageSteps.selectAttributeSet("4");
        manageProductsPageSteps.selectProductType("downloadable");
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.enterName("Max auto downloadable product");
        manageProductsPageSteps.enterProductDescription("Max auto downloadable product description");
        manageProductsPageSteps.enterShortDescription("Max auto downloadable product short description");
        manageProductsPageSteps.enterSKU("100007");
        manageProductsPageSteps.selectStatus("1");
        manageProductsPageSteps.selectVisibility("4");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectPricesTab();
        manageProductsPageSteps.enterProductPrice("173");
        manageProductsPageSteps.selectTaxClass("0");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectWebsitesTab();
        manageProductsPageSteps.selectMainWebsite();
        manageProductsPageSteps.selectCategoriesTab();
        manageProductsPageSteps.selectFirstCategory();
        manageProductsPageSteps.selectDownloadableInformationTab();
        manageProductsPageSteps.addNewRow();
        manageProductsPageSteps.enterDownloadableLinkName("Link name");
        manageProductsPageSteps.sampleSelectURL();
        manageProductsPageSteps.enterSampleURL("http://cs623727.vk.me/v623727867/489f6/xGaqvPMZXOc.jpg");
        manageProductsPageSteps.fileSelectURL();
        manageProductsPageSteps.enterFileURL("http://cs623727.vk.me/v623727867/489f6/xGaqvPMZXOc.jpg");
        manageProductsPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100007");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        //loginPageSteps.delay();

    }
}
