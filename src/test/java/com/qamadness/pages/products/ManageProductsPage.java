package com.qamadness.pages.products;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.ws.WebEndpoint;

public class ManageProductsPage extends PageObject {

    @FindBy (css = "button[title='Add Product']")
    WebElementFacade addProduct;

    public void addProduct () {
        addProduct.click();
    }

    @FindBy(css = "#productGrid_product_filter_sku")
    WebElementFacade searchBySku;

    public void searchBySku (String SKU) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(searchBySku));
        searchBySku.sendKeys(SKU);}

    public void clearSKUFilter () {
        searchBySku.clear();
        searchBySku.sendKeys(Keys.ENTER);}

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

    public void submitActionn() { submit.click();}

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

    @FindBy (xpath = ".//*[@id='name-checkbox']")
    WebElementFacade updateProductNameCheckbox;

    public void updateProductNameCheckboxClick () { updateProductNameCheckbox.click();}

    @FindBy (xpath = ".//*[@id='name']")
    WebElementFacade updateProductNameField;

    public void updateProductName (String name) { updateProductNameField.sendKeys(name);}

    public void checkNameUpdated (String name) {
        int size = getDriver().findElements(org.openqa.selenium.By.xpath(name)).size();
        if (size > 0) {
            checkProduct();}

        else {
            Assert.fail("Name is wrong");}
    }

    @FindBy (xpath = ".//*[@id='settings']/div/table/tbody/tr[2]/td[1]/label")
    WebElementFacade configurableAttribute;

    public void selectConfigurableAttribute () { configurableAttribute.click();}

    @FindBy (xpath = ".//*[@id='product_info_tabs_configurable']/span")
    WebElementFacade associatedProductsTabConfigurable;

    public void selectAssociatedProductsConfigurableTab() { associatedProductsTabConfigurable.click();}

    @FindBy (xpath = ".//*[@id='super_product_links_table']/tbody/tr[1]/td[1]/input[1]")
    WebElementFacade firstConfigurableAssociatedProduct;

    public void checkFirstConfigurableAssociatedProduct() { firstConfigurableAssociatedProduct.click();}

    @FindBy (xpath = ".//*[@id='super_product_links_table']/tbody/tr[2]/td[1]/input[1]")
    WebElementFacade secondConfigurableAssociatedProduct;

    public void checkSecondConfigurableAssociatedProduct() { secondConfigurableAssociatedProduct.click();}

    @FindBy (xpath = ".//*[@id='product_info_tabs_super']/span")
    WebElementFacade associatedProductsTabGrouped;

    public void selectAssociatedProductsTabGrouped () { associatedProductsTabGrouped.click();}

    @FindBy (xpath = ".//*[@id='super_product_grid_table']/tbody/tr[1]/td[1]/input")
    WebElementFacade firstGroupAssociatedProduct;

    public void checkFirstGroupAssociatedProduct () { firstGroupAssociatedProduct.click();}

    @FindBy (xpath = ".//*[@id='super_product_grid_table']/tbody/tr[2]/td[1]/input")
    WebElementFacade secondGroupAssociatedProduct;

    public void checkSecondGroupAssociatedProduct () { secondGroupAssociatedProduct.click();}

//---------------------------------------Downloadable Information Tab (Downloadable Product)--------------------------//

    @FindBy (xpath = ".//*[@id='product_info_tabs_downloadable_items']/span")
    WebElementFacade downloadableInformationTab;

    public void selectDownloadableInformationTab () { downloadableInformationTab.click();}

    @FindBy (xpath = ".//*[@id='add_link_item']")
    WebElementFacade addNewRowButton;

    public void addNewRow () {
        /*WebDriverWait driverWait = new WebDriverWait(getDriver(), 60);
        driverWait.until(ExpectedConditions.elementToBeClickable(addNewOptionButton));*/
        addNewRowButton.click();}

    @FindBy (xpath = ".//*[@id='link_items_body']/tr/td[1]/input[3]")
    WebElementFacade downloadableLinkName;

    public void enterDownloadableLinkName (String name) { downloadableLinkName.sendKeys(name);}

    @FindBy (xpath = ".//*[@id='downloadable_link_0_sample_url_type']")
    WebElementFacade sampleSelectURL;

    public void sampleSelectURL () { sampleSelectURL.click();}

    @FindBy (xpath = ".//*[@id='link_items_body']/tr/td[5]/div[3]/div[2]/input")
    WebElementFacade sampleURLField;

    public void enterSampleURL (String url) { sampleURLField.sendKeys(url);}

    @FindBy (xpath = ".//*[@id='downloadable_link_0_url_type']")
    WebElementFacade fileSelectURL;

    public void fileSelectURL () { fileSelectURL.click();}

    @FindBy (xpath = ".//*[@id='link_items_body']/tr/td[6]/div/div[2]/input")
    WebElementFacade fileURLField;

    public void enterFileURL (String url) { fileURLField.sendKeys(url);}



}
