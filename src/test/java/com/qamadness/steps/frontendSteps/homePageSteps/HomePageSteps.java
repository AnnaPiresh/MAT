package com.qamadness.steps.frontendSteps.homePageSteps;

import com.qamadness.pages.frontend.homePage.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/25/16.
 */
public class HomePageSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void open_Home_Page (){
        homePage.openHomePage();
    }

    @Step
    public void search_for_product(String searchterm){homePage.searchForProduct(searchterm);}

    @Step
    public void open_floating_cart(){homePage.openFloatingCart();}

    @Step
    public void navigate_to_shopping_cart_page(){homePage.navigateToShoppingCartPage();}

    @Step
    public void open_account_menu_in_header(){homePage.openAccountMenuInHeader();}

    @Step
    public void navigate_to_login_page() {homePage.navigateToLoginPage();}

    @Step
    public void delete_products_in_floating_cart(){homePage.deleteProductsInCart();}

    @Step
    public void logout_from_website() {homePage.logoutFromWebsite();}

    @Step
    public Boolean check_if_shopping_cart_is_empty () {return homePage.checkIfShoppingCartEmpty();}
}
