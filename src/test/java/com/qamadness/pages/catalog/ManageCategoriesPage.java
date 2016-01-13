package com.qamadness.pages.catalog;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.codehaus.groovy.runtime.powerassert.SourceText;
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

/**
 * Created by M. Yermolenko on 13.01.2016.
 */
public class ManageCategoriesPage extends PageObject {

    @FindBy (xpath = ".//*[@id='add_subcategory_button']")
    WebElementFacade addNewSubcategoryButton;

    public void addNewSubCategory () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addNewSubcategoryButton));
        addNewSubcategoryButton.click();}

    @FindBy (xpath = ".//*[@id='group_4name']")
    WebElementFacade categoryNameField;

    public void enterCategoryName (String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(categoryNameField));
        categoryNameField.sendKeys(name);}

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

    @FindBy (css = "button[title='Save Category']")
    WebElementFacade saveCategoryButton;

    public void saveCategory () { saveCategoryButton.click();}

    //The category has been saved.
    //*[contains(text(), 'New Max auto product name')

    public void checkCategorySaved () {
        int size = getDriver().findElements(org.openqa.selenium.By.xpath("//*[contains(text(), 'The category has been saved.'")).size();
        if (size > 0) {
            System.out.println("Category is saved");}

        else {
            Assert.fail("Name is wrong");}
    }
}
