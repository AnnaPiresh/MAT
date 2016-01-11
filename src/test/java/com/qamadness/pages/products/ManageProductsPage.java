package com.qamadness.pages.products;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ManageProductsPage extends PageObject {

    @FindBy (tagName = "button")
    WebElementFacade addProduct;

    public void addProduct () {
        addProduct.click();
    }

    @FindBy (xpath = ".//*[@id='attribute_set_id']")
    WebElementFacade attributeSetDropdown;

    public void selectAttributeSet (String value){
        Select dropdown = new Select(attributeSetDropdown);
        dropdown.selectByValue(value);
    }


    @FindBy (xpath = ".//*[@id='product_type']")
    WebElementFacade productTypeDropdown;

    public void selectProductType(String value) {
        Select dropdown = new Select(productTypeDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy (css = "button[title='Continue']")
    WebElementFacade continueButton;

    public void continueButton () { continueButton.click();}

    //-----------------------------------------------Product information--------------------------------------------------//
    @FindBy(xpath = ".//*[@id='name']")
    WebElementFacade productName;

    public void enterName (String name) { productName.sendKeys(name);}

    @FindBy(xpath = ".//*[@id='description']")
    WebElementFacade productDescription;

    public void enterProductDescription(String descr) { productDescription.sendKeys(descr);}

    @FindBy(xpath = ".//*[@id='short_description']")
    WebElementFacade productShortDescription;

    public void enterShortDescription (String shortDesrc) { productShortDescription.sendKeys(shortDesrc);}


    @FindBy (xpath = ".//*[@id='sku_type']")
    WebElementFacade productSKUType;

    public void selectProductSKUType (String value) {
        Select dropdown = new Select(productSKUType);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='weight_type']")
    WebElementFacade productWeightType;

    public void selectProductWeightType (String value) {
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
        Select dropdown = new Select(selectStatusDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='visibility']")
    WebElementFacade selectVisibilityDropdown;

    public void selectVisibility (String value) {
        Select dropdown = new Select(selectVisibilityDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(css = "#product_info_tabs_group_8")
    WebElementFacade pricesTab;

    public void selectPricesTab() { pricesTab.click();}

    @FindBy(xpath = ".//*[@id='global_search']")
    WebElementFacade globalSearch;

    public void clearGlobalSearch () { globalSearch.clear();}

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

    @FindBy(xpath = ".//*[@id='product_info_tabs_websites']/span")
    WebElementFacade websitesTab;

    public void selectWebsitesTab() { websitesTab.click();}

    @FindBy(xpath = ".//*[@id='product_website_1']")
    WebElementFacade mainWebsite;

    public void selectMainWebsite() { mainWebsite.click();}

    @FindBy(xpath = ".//*[@id='product_info_tabs_categories']/span")
    WebElementFacade categoriesTab;

    public void selectCategoriesTab() { categoriesTab.click();}

    @FindBy(css = "#ext-gen23")
    WebElementFacade firstCategory;

    public void selectFirstCategory() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(firstCategory));
        firstCategory.click();}

    @FindBy(css = "button[title='Save']")
    WebElementFacade saveProduct;

    public void saveProduct () { saveProduct.click();}

    @FindBy(css = "#productGrid_product_filter_sku")
    WebElementFacade searchBySku;

    public void searchBySku (String SKU) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(searchBySku));
        searchBySku.sendKeys(SKU);}

    @FindBy(css = "button[title='Search']")
    WebElementFacade searchButton;

    public void searchButton () { searchButton.click();}

    @FindBy(css = ".massaction-checkbox")
    WebElementFacade checkProduct;

    public void checkProduct () { checkProduct.click();}

    @FindBy (xpath = ".//*[@id='productGrid_massaction-select']")
    WebElementFacade selectActionDropdown;

    public void selectAction (String value) {
        Select dropdown = new Select(selectActionDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(css = "button[title='Submit']")
    WebElementFacade submit;

    public void submitAction() { /*submit.click();*/}

    public void deletionApproveAlert () {
        submit.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

    }

    @FindBy(xpath = ".//*[@id='productGrid_table']/tbody/tr/td[12]/a")
    WebElementFacade edit;

    public void edit () { edit.click();}

    @FindBy (xpath = ".//*[@id='product_info_tabs_bundle_items']/span")
    WebElementFacade bundleTab;

    public void selectBundleTab () { bundleTab.click();}

    public void selectCategory () {

        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
        List<WebElement> checkboxes = getDriver().findElements(By.cssSelector("input[type='checkbox']"));

        checkboxes.get(1).click();
    }

    @FindBy (xpath = ".//*[@id='shipment_type']")
    WebElementFacade shipmentType;

    public void selectShipmentType (String value) {
        Select dropdown = new Select(shipmentType);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='add_new_option']")
    WebElementFacade addNewOptionButton;

    public void addNewOption () {addNewOptionButton.click();}

    @FindBy (xpath = ".//*[@id='id_bundle_options_0_title']")
    WebElementFacade defaultTitle;

    public void enterDeafultTitle (String title) { defaultTitle.sendKeys(title);}

    @FindBy (xpath = ".//*[@id='bundle_option_0_add_button']")
    WebElementFacade addSelectionButton;

    public void addSelection () { addSelectionButton.click();}

    @FindBy (css = "button[title='Reset Filter']")
    WebElementFacade resetFilterButton;

    public void resetFilter () { resetFilterButton.click();}

    @FindBy (xpath = ".//*[@id='bundle_selection_search_grid_0_table']/tbody/tr[2]/td[6]/input")
    WebElementFacade productTwo;

    public void selectProductTwo () { productTwo.click();}

    @FindBy (xpath = ".//*[@id='bundle_selection_search_grid_0_table']/tbody/tr[3]/td[6]/input")
    WebElementFacade productThree;

    public void selectProductThree () { productThree.click();}
}
