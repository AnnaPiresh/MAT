package com.qamadness.steps.frontendSteps.checkout.checkoutMultipleAddressesSteps;

import com.qamadness.pages.frontend.checkout.checkoutMultipleAddressesPage.CheckoutMultipleAddressesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Anna Piresh on 27.01.2016.
 */
public class CheckoutMultipleAddressesSteps extends ScenarioSteps {

    CheckoutMultipleAddressesPage checkoutMultipleAddressesPage;

    @Step
    public void enter_first_name(String firstName) {checkoutMultipleAddressesPage.enterFirstName(firstName);}

    @Step
    public void enter_last_name (String lastName) {checkoutMultipleAddressesPage.enterLastName(lastName);}

    @Step
    public void enter_company_name (String company) {checkoutMultipleAddressesPage.enterCompanyName(company);}

    @Step
    public void enter_telephone(String telephone) {checkoutMultipleAddressesPage.enterTelephone(telephone);}

    @Step
    public void enter_fax (String fax) {checkoutMultipleAddressesPage.enterFax(fax);}

    @Step
    public void enter_street_address (String streetAddress) {
        checkoutMultipleAddressesPage.enterStreetAddress(streetAddress);}

    @Step
    public void enter_street_address_2 (String streetAddress2) {
        checkoutMultipleAddressesPage.enterStreetAddress2(streetAddress2);}

    @Step
    public void enter_vat (String vat) {checkoutMultipleAddressesPage.enterVAT(vat);}

    @Step
    public void enter_city (String city) {checkoutMultipleAddressesPage.enterCity(city);}

    @Step
    public void select_state (String state) {checkoutMultipleAddressesPage.selectState(state);}

    @Step
    public void enter_zip_code (String zipcode) {checkoutMultipleAddressesPage.enterZipCode(zipcode);}

    @Step
    public void select_country (String country) {checkoutMultipleAddressesPage.selectCountry(country);}

    @Step
    public void click_save_address_button() {checkoutMultipleAddressesPage.clickSaveAddressButton();}

    @Step
    public void click_back_link() {checkoutMultipleAddressesPage.clickBackLink();}

    @Step
    public Boolean check_if_user_has_a_default_shipping_address(){
        return checkoutMultipleAddressesPage.checkIfUserHasADefaultAddress();}

    @Step
    public void click_enter_new_address_button(){checkoutMultipleAddressesPage.clickEnterNewAddressButton();}

    @Step
    public void select_an_address_from_dropdown(String productName, String fullCustomerAddress){
        checkoutMultipleAddressesPage.selectAnAddressFromDropdown(productName, fullCustomerAddress);}

    @Step
    public void click_continue_to_shipping_information_button(){
        checkoutMultipleAddressesPage.clickContinueToShippingInformationButton();
    }

    @Step
    public void select_shipping_methods(int firstMethod, int secondMethod){
        checkoutMultipleAddressesPage.selectShippingMethods(firstMethod, secondMethod);
    }

    @Step
    public void click_continue_to_billing_information_button(){
        checkoutMultipleAddressesPage.clickContinueToBillingInformationButton();
    }

    @Step
    public void select_payment_method(){checkoutMultipleAddressesPage.selectPaymentMethod();}

    @Step
    public void click_continue_to_review_your_order_button(){
        checkoutMultipleAddressesPage.clickContinueToReviewYourOrderButton();}

    @Step
    public void click_place_order_button(){checkoutMultipleAddressesPage.clickPlaceOrderButton();}

    @Step
    public void check_no_dropdown_for_product(String productName){
        checkoutMultipleAddressesPage.checkNoDropdownForProduct(productName);
    }

    @Step
    public void select_particular_shipping_method(String methodTitle, String methodName){
        checkoutMultipleAddressesPage.selectParticularShippingMethod(methodTitle, methodName);
    }

}
