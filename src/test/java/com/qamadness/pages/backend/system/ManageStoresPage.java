package com.qamadness.pages.backend.system;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by M. Yermolenko on 02.02.2016.
 */
public class ManageStoresPage extends PageObject {

    @FindBy(xpath = ".//*[@id='page:main-container']/div[3]/div/table/tbody/tr[4]/td[2]/a")
    WebElementFacade storeName;

    public void clickStoreName(){
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.elementToBeClickable(storeName));
        storeName.click();
    }

    @FindBy(xpath = ".//*[@id='group_root_category_id']")
    WebElementFacade storeRootCategory;

    public void selectStoreRootCategory (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.elementToBeClickable(storeRootCategory));
        Select dropdown = new Select(storeRootCategory);
        dropdown.selectByVisibleText(value);
    }

    @FindBy(css = "button[title='Save Store']")
    WebElementFacade saveStoreButton;

    public void clickSaveStoreButton () {
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.elementToBeClickable(saveStoreButton));
        saveStoreButton.click();
    }
}
