package com.qamadness.pages.frontend.productDetailsPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Serhii_Boiko on 28.01.2016.
 */
public class ProductDetailsPage extends PageObject {

//---------------------------------------Objects for Simple Product Details page---------------------------------------//

    @FindBy(xpath = ".//*[@id='product_addtocart_form']/div[4]/div[2]/div/div/button")
    WebElementFacade addToCartButton;

//----------------------------------------Objects for Bundle Details page----------------------------------------------//

    @FindBy(xpath = ".//*[@type='radio']")
    WebElementFacade bundleRadioButtons;

    @FindBy(xpath = ".//*[@id='product_addtocart_form']/div[7]/div[2]/div[2]/button")
    WebElementFacade addToCartBtnBundle;

//---------------------------------------Methods for Simple Product Details page---------------------------------------//

    public void clickAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

//--------------------------------------Methods for Grouped Product Details page---------------------------------------//

    public List<WebElement> qty(){
        return getDriver().findElements(By.xpath(".//input[@title='Qty']"));
    }

    public void enterQtyOfProducts(String firstProductQty, String secondProductQty){
        qty().get(0).clear();
        qty().get(0).sendKeys(firstProductQty);
        qty().get(1).clear();
        qty().get(1).sendKeys(secondProductQty);
    }

//--------------------------------------Methods for Bundle Product Details page---------------------------------------//

    public void selectBundleItem(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(bundleRadioButtons));
        bundleRadioButtons.click();
    }

    public void clickAddToCartButtonBundle(){
        addToCartBtnBundle.click();
    }


}
