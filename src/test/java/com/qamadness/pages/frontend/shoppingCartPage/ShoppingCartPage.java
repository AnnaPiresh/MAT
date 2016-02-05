package com.qamadness.pages.frontend.shoppingCartPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anna Piresh on 28.01.2016.
 */
public class ShoppingCartPage extends PageObject{

//--------------------------------------------Objects for Shopping Cart Page-------------------------------------------//

    @FindBy(xpath = ".//*[text()='Checkout with Multiple Addresses']")
    WebElementFacade checkoutMultipleAddressesLink;

    @FindBy(xpath = ".//*[@id='empty_cart_button']")
    WebElementFacade emptyCartButton;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMessage;

    @FindBy(xpath = ".//*[text()='Shopping Cart is Empty']")
    WebElementFacade emptyCartMessage;

    @FindBy(xpath = ".//*[@title='Qty']")
    WebElementFacade qtyField;

//--------------------------------------------Methods for Shopping Cart Page-------------------------------------------//

    public void proceedToMultipleAddressesCheckout(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutMultipleAddressesLink));
        checkoutMultipleAddressesLink.click();
    }

    public void emptyShoppingCart(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(emptyCartButton));
        emptyCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
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

    public void changeProductsQty(String productQty){
        qtyField.clear();
        qtyField.sendKeys(productQty);
        qtyField.sendKeys(Keys.ENTER);
    }



}
