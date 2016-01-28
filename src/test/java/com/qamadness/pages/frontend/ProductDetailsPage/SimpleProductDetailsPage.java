package com.qamadness.pages.frontend.ProductDetailsPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii_Boiko on 28.01.2016.
 */
public class SimpleProductDetailsPage extends PageObject {

//-------------------------------------------Objects for Product Details Page------------------------------------------//

    @FindBy(xpath = ".//*[@id='product_addtocart_form']/div[4]/div/div/div[2]/button")
    WebElementFacade addToCartButton;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMessage;


//------------------------------------------Methods for Product Details page-------------------------------------------//

    public void clickAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public void checkProductIsAddedToCart(String productMessage){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        if (successMessage.containsText(productMessage)){
            System.out.println("Success message is present");
        } else{
            Assert.fail("Success message is not present");
        }
    }
}
