package com.qamadness.pages.backend.catalog.ManageCategories;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by M. Yermolenko on 13.01.2016.
 */
public class ManageCategoriesPage extends PageObject {

    public void refreshPage () { getDriver().navigate().refresh();}

    @FindBy (xpath = ".//*[@id='add_subcategory_button']")
    WebElementFacade addNewSubcategoryButton;

    public void addNewSubCategory () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addNewSubcategoryButton));
        addNewSubcategoryButton.click();}

    @FindBy (css = "button[title='Save Category']")
    WebElementFacade saveCategoryButton;

    public void saveCategory () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(saveCategoryButton));
        saveCategoryButton.click();}

    @FindBy(xpath = "//button[@id='add_root_category_button']")
    WebElementFacade addRootCategoryButton;

    public void addNewRootCategory() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addRootCategoryButton));
        addRootCategoryButton.click();}

    public void selectCategoryByName(String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath(name)));
        getDriver().findElement(By.xpath(name)).click();
    }

    public void checkSuccessMessage () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='messages']/ul/li/ul/li/span")));
        WebElement message = getDriver().findElement(By.xpath(".//*[@id='messages']/ul/li/ul/li/span"));
        message.getText();
        if (message.getText().equals("The category has been saved.")){
            System.out.println(message.getText());
        }else{
            Assert.fail("Category isn't saved");
        }
    }

    public void checkNameIsNotAdded () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='advice-required-entry-group_4name']")));
        WebElement message = getDriver().findElement(By.xpath(".//*[@id='advice-required-entry-group_4name']"));
        message.getText();
        if (message.getText().equals("This is a required field.")){
            System.out.println("Category isn't saved, '"+message.getText()+"' message is displayed");
        }else{
            Assert.fail("Fail message isn't displayed");
        }
    }

    @FindBy(xpath = "//button[span='Delete Category']")
    WebElementFacade deleteCategoryButton;
    public void deleteCategory () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(deleteCategoryButton));
        deleteCategoryButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void checkCategoryDeleted(){
        String expected = "The category has been deleted.";
        String actual = getDriver().findElement(By.xpath(".//*[@id='messages']/ul/li/ul/li/span")).getText();
        assertThat(actual, is(expected));
    }

    public void checkDeleteButtonAbsent () {
        int size = getDriver().findElements(By.cssSelector("button[title='Delete Category']")).size();
        if (size > 0) {Assert.fail("'Delete category Button' is displayed");}

        else {
            System.out.println("'Delete category Button' isn't displayed");
        }
    }

    public void moveCategory(String sourcePath, String targetPath){
        WebElement source = getDriver().findElement(By.xpath(sourcePath));
        WebElement target = getDriver().findElement(By.xpath(targetPath));
        new Actions(getDriver()).dragAndDrop(source, target).perform();
    }

    //----------------------------------------------General Tab-------------------------------------------------------//

    @FindBy(xpath = "//a[@title='General Information']/span")
    WebElementFacade generalTab;

    public void selectGeneralTab () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath("//a[@title='General Information']/span")));
        generalTab.click();}

    @FindBy (xpath = ".//*[@id='group_4name']")
    WebElementFacade categoryNameField;

    public void enterCategoryName (String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath(".//*[@id='group_4name']")));
        categoryNameField.sendKeys(name);}

    public void clearCategoryNameField () { categoryNameField.clear();}

    public void clearCategoryName () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.id("group_4name"))));
        getDriver().findElement(By.id("group_4name")).clear();}

    @FindBy(xpath = "//textarea[@name='general[description]']")
    WebElementFacade descriptionField;

    public void enterCategoryDescription (String description) {
        descriptionField.sendKeys(description);
    }

    @FindBy(xpath = "//input[@name='general[meta_title]']")
    WebElementFacade pageTitleField;

    public void enterPageTitle (String title){ pageTitleField.sendKeys(title);}

    @FindBy(xpath = "//textarea[@name='general[meta_keywords]']")
    WebElementFacade metaKeywordsField;

    public void enterMetaKeywords (String keywords) {metaKeywordsField.sendKeys(keywords);}

    @FindBy(xpath = "//textarea[@name='general[meta_description]']")
    WebElementFacade metaDescriptionField;

    public void entermetaDescription (String metadesc) { metaDescriptionField.sendKeys(metadesc);}

    @FindBy (xpath = ".//*[@id='group_4is_active']")
    WebElementFacade activitySelectionDropdown;

    public void selectCategoryActivity (String value){
        Select dropdown = new Select(activitySelectionDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='group_4include_in_menu']")
    WebElementFacade includingInNavigatioMenuDropdown;

    public void selectIncludingInNavigationMenu (String value) {
        Select dropdown = new Select(includingInNavigatioMenuDropdown);
        dropdown.selectByValue(value);
    }

    //---------------------------------------------Display Settings Tab-----------------------------------------------//

    @FindBy(xpath = "//a[@title='Display Settings']/span")
    WebElementFacade displaySettingsTab;

    public void selectDisplaySettingsTab () {displaySettingsTab.click();}

    @FindBy(xpath = ".//*[@id='group_5display_mode']")
    WebElementFacade displayModeDropdown;

    public void selectDisplayMode (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(displayModeDropdown));
        Select dropdown = new Select(displayModeDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy (xpath = ".//*[@id='group_5landing_page']")
    WebElementFacade cMSBlockDropdown;

    public void selectCMSBlock (String value) {
        Select dropdown = new Select(cMSBlockDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='use_config_group_5available_sort_by']")
    WebElementFacade useAllAvailableAttributesCheckbox;

    public void clickUseAllAvailableAttributesCheckbox () { useAllAvailableAttributesCheckbox.click();}

    @FindBy(xpath = ".//*[@id='group_5available_sort_by']")
    WebElementFacade availableProductListingSortDropdown;

    public void selectAvailableProductListingSortBy(String value) {
        Select dropdown = new Select(availableProductListingSortDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='use_config_group_5default_sort_by']")
    WebElementFacade useConfigSettingCheckbox;

    public void clickUseConfigSettingCheckbox () {useConfigSettingCheckbox.click();}

    @FindBy(xpath = ".//*[@id='group_5default_sort_by']")
    WebElementFacade defaultProductListingSortByDropdown;

    public void selectDefaultProductListingSortBy (String value) {
        Select dropdown = new Select(defaultProductListingSortByDropdown);
        dropdown.selectByValue(value);
    }


    @FindBy(xpath = ".//*[@id='use_config_group_5filter_price_range']")
    WebElementFacade priceStepUseConfigSettingCheckbox;

    public void clickPriceStepUseConfigSettingCheckbox () { priceStepUseConfigSettingCheckbox.click();}

    @FindBy(xpath = ".//*[@id='group_5filter_price_range']")
    WebElementFacade layeredNavigationPriceStepField;

    public void enterLayeredNavigationPriceStep (String value) { layeredNavigationPriceStepField.sendKeys(value);}

    @FindBy(xpath = ".//*[@id='group_5is_anchor']")
    WebElementFacade isAnchorDropdown;

    public void selectIsAnchor (String value) {
        Select dropdown = new Select(isAnchorDropdown);
        dropdown.selectByValue(value);
    }

    //-------------------------------------------Custom Design Tab----------------------------------------------------//

    @FindBy(xpath = ".//*[@id='category_info_tabs_group_6']/span")
    WebElementFacade customDesignTab;

    public void selectCustomDesignTab() {customDesignTab.click();}

    @FindBy(xpath = ".//*[@id='group_6custom_use_parent_settings']")
    WebElementFacade useParentCategorySettingsDropdown;

    public void selectUseParentCategorySettings (String value) {
        Select dropdown = new Select(useParentCategorySettingsDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='group_6custom_apply_to_products']")
    WebElementFacade applyToProductsDropdown;

    public void selectApplyToProducts (String value) {
        Select dropdown = new Select(applyToProductsDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='group_6custom_design']")
    WebElementFacade customDesignDropdown;

    public void selectCustomDesign (String value) {
        Select dropdown = new Select(customDesignDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='group_6custom_design_from']")
    WebElementFacade activeFrom;

    public void selectActiveFrom (String value) {activeFrom.sendKeys(value);}

    @FindBy(xpath = ".//*[@id='group_6custom_design_to']")
    WebElementFacade activeTo;

    public void selectActiveTo (String value) {activeTo.sendKeys(value);}

    @FindBy(xpath = ".//*[@id='group_6page_layout']")
    WebElementFacade pageLayoutDropdown;

    public void selectPageLayout (String value) {
        Select dropdown = new Select(pageLayoutDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(xpath = ".//*[@id='group_6custom_layout_update']")
    WebElementFacade customLayoutUpdateField;

    public void enterCustomLayoutUpdate (String value) {customLayoutUpdateField.sendKeys(value);}


    //-----------------------------------------Category Products Tab--------------------------------------------------//

    @FindBy(xpath = ".//*[@id='category_info_tabs_products']")
    WebElementFacade categoryProductsTab;

    public void selectCategoryProductsTab () {categoryProductsTab.click();}

    @FindBy(xpath = ".//*[@id='catalog_category_products_table']/tbody/tr[1]/td[1]/input")
    WebElementFacade firstProductInList;

    @FindBy(xpath = ".//*[@id='catalog_category_products_table']/tbody/tr[2]/td[1]/input")
    WebElementFacade secondProductInList;

    @FindBy(xpath = ".//*[@id='catalog_category_products_table']/tbody/tr[3]/td[1]/input")
    WebElementFacade thirdProductInList;

    public void selectSomeCategoryProducts () {
        firstProductInList.click();
        //secondProductInList.click();
        //thirdProductInList.click();
    }






}
