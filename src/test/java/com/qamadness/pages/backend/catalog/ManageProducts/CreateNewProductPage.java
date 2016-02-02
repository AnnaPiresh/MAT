package com.qamadness.pages.backend.catalog.ManageProducts;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kampa on 14.01.2016.
 */
public class CreateNewProductPage extends PageObject {

    @FindBy (xpath = ".//*[@id='attribute_set_id']")
    WebElementFacade attributeSetDropdown;

    public void selectAttributeSet (String value){
        Select dropdown = new Select(attributeSetDropdown);
        dropdown.selectByValue(value);
    }

    public void selectAttributeSetByName(String setName){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(attributeSetDropdown));
        Select dropdown = new Select(attributeSetDropdown);
        dropdown.selectByVisibleText(setName);
    }


    @FindBy (xpath = ".//*[@id='product_type']")
    WebElementFacade productTypeDropdown;

    public void selectProductType(String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(productTypeDropdown));
        Select dropdown = new Select(productTypeDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy (css = "button[title='Continue']")
    WebElementFacade continueButton;

    public void continueButton () { continueButton.click();}

    @FindBy (xpath = ".//button[@title='Save']")            //(css = "button[title='Save']")
    WebElementFacade saveProduct;

    public void saveProduct () {
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.elementToBeClickable(saveProduct));
        saveProduct.click();}

    @FindBy (xpath = ".//button[@title='Save and Continue Edit']")
    WebElementFacade saveAndEditButton;

    public void clickSaveAndEditButton(){
        saveAndEditButton.click();
    }

//-----------------------------------------------General Tab------------------------------------------------------//
    @FindBy(xpath = ".//*[@id='name']")
    WebElementFacade productName;

    public void enterName (String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(productName));
        productName.sendKeys(name);}

    @FindBy(xpath = ".//*[@id='description']")
    WebElementFacade productDescription;

    public void enterProductDescription(String descr) { productDescription.sendKeys(descr);}

    @FindBy(xpath = ".//*[@id='short_description']")
    WebElementFacade productShortDescription;

    public void enterShortDescription (String shortDesrc) { productShortDescription.sendKeys(shortDesrc);}


    @FindBy (xpath = ".//*[@id='sku_type']")
    WebElementFacade productSKUType;

    public void selectProductSKUType (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(productSKUType));
        Select dropdown = new Select(productSKUType);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='weight_type']")
    WebElementFacade productWeightType;

    public void selectProductWeightType (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(productWeightType));
        Select dropdown = new Select(productWeightType);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='sku']")
    WebElementFacade productSKU;

    public void enterSKU (String SKU) { productSKU.sendKeys(SKU);}

    @FindBy(xpath = ".//*[@id='weight']")
    WebElementFacade productWeight;

    public void enterWeight(String weight) { productWeight.sendKeys(weight); }

    @FindBy(xpath = ".//*[@id='status']")
    WebElementFacade selectStatusDropdown;

    public void selectStatus (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(selectStatusDropdown));
        Select dropdown = new Select(selectStatusDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='visibility']")
    WebElementFacade selectVisibilityDropdown;

    public void selectVisibility (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(selectVisibilityDropdown));
        Select dropdown = new Select(selectVisibilityDropdown);
        dropdown.selectByValue(value);
    }

    //------------------------------------------------Prices Tab------------------------------------------------------//

    @FindBy(xpath = ".//*[text()='Prices']") //css = "#product_info_tabs_group_8")
    WebElementFacade pricesTab;

    public void selectPricesTab() { pricesTab.click();}

    @FindBy(xpath = ".//*[@id='global_search']")
    WebElementFacade globalSearch;

    public void clearGlobalSearch () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(globalSearch));
        globalSearch.clear();}

    public void moveToTop () {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.xpath(".//*[@id='global_search']")));
    }

    @FindBy (xpath = ".//*[@id='price_type']")
    WebElementFacade priceType;

    public void selectPriceType (String value) {
        Select dropdown = new Select(priceType);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='price']")
    WebElementFacade productPrice;

    public void enterProductPrice(String price) { productPrice.sendKeys(price);}

    @FindBy (xpath = ".//*[@id='tax_class_id']")
    WebElementFacade selectTaxClassDropdown;

    public void selectTaxClass (String value) {
        Select dropdown = new Select(selectTaxClassDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='price_view']")
    WebElementFacade priceView;

    public void selectPriceView (String value) {
        Select dropdown = new Select(priceView);
        dropdown.selectByValue(value);
    }


    //----------------------------------------------Websites Tab------------------------------------------------------//

    @FindBy(xpath = ".//*[text()='Websites']") //".//*[@id='product_info_tabs_websites']/span")
    WebElementFacade websitesTab;

    public void selectWebsitesTab() { websitesTab.click();}

    @FindBy(xpath = ".//*[@id='product_website_1']")
    WebElementFacade mainWebsite;

    public void selectMainWebsite() { mainWebsite.click();}


    //---------------------------------------------Categories Tab------------------------------------------------------//


    @FindBy(xpath = ".//*[text()='Categories']")    //".//*[@id='product_info_tabs_categories']")
    WebElementFacade categoriesTab;

    public void selectCategoriesTab() { categoriesTab.click();}

    //@FindBy(css = "#ext-gen23")
    @FindBy(xpath = "//*[contains(text(), 'Women')]")
    WebElementFacade firstCategory;

    public void selectFirstCategory() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(firstCategory));
        firstCategory.click();}

    //-----------------------------------------------Bundle Tab-------------------------------------------------------//

    @FindBy (xpath = ".//*[@id='product_info_tabs_bundle_items']/span")
    WebElementFacade bundleTab;

    public void selectBundleTab () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(bundleTab));
        bundleTab.click();}

    @FindBy (xpath = ".//*[@id='shipment_type']")
    WebElementFacade shipmentType;

    public void selectShipmentType (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(shipmentType));
        Select dropdown = new Select(shipmentType);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='add_new_option']")
    WebElementFacade addNewOptionButton;

    public void addNewOption () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addNewOptionButton));
        addNewOptionButton.click();}

    @FindBy (xpath = ".//*[@id='id_bundle_options_0_title']")
    WebElementFacade defaultTitle;

    public void enterDeafultTitle (String title) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(defaultTitle));
        defaultTitle.sendKeys(title);}

    @FindBy (xpath = ".//*[@id='bundle_option_0_add_button']")
    WebElementFacade addSelectionButton;

    public void addSelection () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addSelectionButton));
        addSelectionButton.click();}

    @FindBy (css = "button[title='Reset Filter']")
    WebElementFacade resetFilterButton;

    public void resetFilter () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(resetFilterButton));
        resetFilterButton.click();}

    @FindBy (xpath = ".//*[@id='bundle_selection_search_grid_0_table']/tbody/tr[2]/td[6]/input")
    WebElementFacade productTwo;

    public void selectProductTwo () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(productTwo));
        productTwo.click();}

    @FindBy (xpath = ".//*[@id='bundle_selection_search_grid_0_table']/tbody/tr[3]/td[6]/input")
    WebElementFacade productThree;

    public void selectProductThree () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(productThree));
        productThree.click();}


    //------------------------------------Configurable Product Settings Tab-------------------------------------------//

    @FindBy (xpath = ".//*[@id='settings']/div/table/tbody/tr[2]/td[1]/label")
    WebElementFacade configurableAttribute;

    public void selectConfigurableAttribute () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(configurableAttribute));
        configurableAttribute.click();}

    //---------------------------------Associated Products Tab (Configurable)-----------------------------------------//

    @FindBy (xpath = ".//*[@id='product_info_tabs_configurable']/span")
    WebElementFacade associatedProductsTabConfigurable;

    public void selectAssociatedProductsConfigurableTab() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(associatedProductsTabConfigurable));
        associatedProductsTabConfigurable.click();}

    @FindBy (xpath = ".//*[@id='super_product_links_table']/tbody/tr[1]/td[1]/input[1]")
    WebElementFacade firstConfigurableAssociatedProduct;

    public void checkFirstConfigurableAssociatedProduct() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(firstConfigurableAssociatedProduct));
        firstConfigurableAssociatedProduct.click();}

    @FindBy (xpath = ".//*[@id='super_product_links_table']/tbody/tr[2]/td[1]/input[1]")
    WebElementFacade secondConfigurableAssociatedProduct;

    public void checkSecondConfigurableAssociatedProduct() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(secondConfigurableAssociatedProduct));
        secondConfigurableAssociatedProduct.click();}

    //-----------------------------------Associated Products Tab (Grouped)--------------------------------------------//

    @FindBy (xpath = ".//*[@id='product_info_tabs_super']/span")
    WebElementFacade associatedProductsTabGrouped;

    public void selectAssociatedProductsTabGrouped () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(associatedProductsTabGrouped));
        associatedProductsTabGrouped.click();}

    @FindBy (xpath = ".//*[@id='super_product_grid_table']/tbody/tr[1]/td[1]/input")
    WebElementFacade firstGroupAssociatedProduct;

    public void checkFirstGroupAssociatedProduct () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(firstGroupAssociatedProduct));
        firstGroupAssociatedProduct.click();}

    @FindBy (xpath = ".//*[@id='super_product_grid_table']/tbody/tr[2]/td[1]/input")
    WebElementFacade secondGroupAssociatedProduct;

    public void checkSecondGroupAssociatedProduct () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(secondGroupAssociatedProduct));
        secondGroupAssociatedProduct.click();}

    //-------------------------------Downloadable Information Tab (Downloadable Product)------------------------------//

    @FindBy (xpath = ".//*[@id='product_info_tabs_downloadable_items']/span")
    WebElementFacade downloadableInformationTab;

    public void selectDownloadableInformationTab () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(downloadableInformationTab));
        downloadableInformationTab.click();}

    @FindBy (xpath = ".//*[@id='add_link_item']")
    WebElementFacade addNewRowButton;

    public void addNewRow () {
        WebDriverWait driverWait = new WebDriverWait(getDriver(), 60);
        driverWait.until(ExpectedConditions.elementToBeClickable(addNewRowButton));
        addNewRowButton.click();}

    @FindBy (xpath = ".//*[@id='link_items_body']/tr/td[1]/input[3]")
    WebElementFacade downloadableLinkName;

    public void enterDownloadableLinkName (String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(downloadableLinkName));
        downloadableLinkName.sendKeys(name);}

    @FindBy (xpath = ".//*[@id='downloadable_link_0_sample_url_type']")
    WebElementFacade sampleSelectURL;

    public void sampleSelectURL () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(sampleSelectURL));
        sampleSelectURL.click();}

    @FindBy (xpath = ".//*[@id='link_items_body']/tr/td[5]/div[3]/div[2]/input")
    WebElementFacade sampleURLField;

    public void enterSampleURL (String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(sampleURLField));
        sampleURLField.sendKeys(url);}

    @FindBy (xpath = ".//*[@id='downloadable_link_0_url_type']")
    WebElementFacade fileSelectURL;

    public void fileSelectURL () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(fileSelectURL));
        fileSelectURL.click();}

    @FindBy (xpath = ".//*[@id='link_items_body']/tr/td[6]/div/div[2]/input")
    WebElementFacade fileURLField;

    public void enterFileURL (String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(fileURLField));
        fileURLField.sendKeys(url);}

}


