package com.qamadness.pages.sales;


import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReorderFromAdmin extends PageObject{

//------------------------------------Objects for Reordering from admin-----------------------------------------------//

    @FindBy(xpath = ".//button[@title='Reorder']")
    WebElementFacade reorderBtn;
    //Reorder button at order's page

    @FindBy(xpath = ".//*[@id='order-items_grid']/table/tfoot/tr/td[1]")
    WebElementFacade orderTablegrid;
    //grid with reordered products

    @FindBy(xpath = ".//div[@id='order-shipping_method']")
    WebElementFacade shippingMethodBlock;
    //block with selected shipping method

    @FindBy(xpath = ".//*[@id='p_method_checkmo']")
    WebElementFacade paymentMethodCheckbox;
    //checkbox of the selected payment method

//------------------------------------Methods for Reordering from Admin-----------------------------------------------//

    public void clickReorderBtn(){
        if (reorderBtn.isVisible()){
            reorderBtn.click();
        } else {
            Assert.fail("Reorder btn is not present on page");
        }
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
       wait.until(ExpectedConditions.urlContains("sales_order_create/"));
    }

    public void checkCorrectProductReordered(){
        if(orderTablegrid.containsText("Total 1 product(s)")){
            System.out.println("Product is already added to cart");
        } else {
            Assert.fail("Product is not added to cart");
        }
    }

    public void checkShipmentMethodSelected(){
        if (shippingMethodBlock.containsText("Click to change shipping method")){
            System.out.println("Shipping method is selected");
        } else {
            Assert.fail("Shipping method is not selected");
        }
    }

    public void checkPaymentMethodSelected(){
        if (paymentMethodCheckbox.isSelected()){
            System.out.println("Payment method is selected");
        } else {
            Assert.fail("Payment method is not selected");
        }
    }
}
