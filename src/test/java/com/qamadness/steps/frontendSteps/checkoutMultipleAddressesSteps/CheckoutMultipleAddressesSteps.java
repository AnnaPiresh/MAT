package com.qamadness.steps.frontendSteps.checkoutMultipleAddressesSteps;

import com.qamadness.pages.frontend.checkoutMultipleAddressesPage.CheckoutMultipleAddressesPage;
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

}
