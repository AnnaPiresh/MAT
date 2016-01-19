package com.qamadness.pages.backend.catalog.ManageCategories;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    /*@FindBy (xpath = "//input[@name='general[name]']")
    WebElementFacade categoryNameField;*/

    public void enterCategoryName (String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(org.openqa.selenium.By.xpath("//input[@name='general[name]']"))));
        getDriver().findElement(org.openqa.selenium.By.xpath("//input[@name='general[name]']")).sendKeys(name);}

    /*public void clearCategoryName () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(categoryNameField));
        categoryNameField.clear();}*/

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
        int size = getDriver().findElements(org.openqa.selenium.By.xpath("//*[contains(text(), 'The category has been saved.')")).size();
        if (size > 0) {
            System.out.println("Category is saved");}

        else {
            Assert.fail("Name is wrong");}
    }

    @FindBy(xpath = "//button[@id='add_root_category_button']")
    WebElementFacade addRootCategoryButton;

    public void addNewRootCategory() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addRootCategoryButton));
        addRootCategoryButton.click();}

    public void selectCategoryByName(String name) {
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

    @FindBy(xpath = "//button[span='Delete Category']")
    WebElementFacade deleteCategoryButton;
    public void deleteCategory () {
        deleteCategoryButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }




}
