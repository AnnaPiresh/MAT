package com.qamadness.pages.sales;


import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CreatePartialRefundCreditMemo extends PageObject{

    @FindBy(xpath = ".//*[@id='shipping_amount']")
    WebElementFacade refundShipmentFld;
    //Field in Credit Memo subtotal where refund for shipment can be changed

    @FindBy(xpath =".//button[@title='Credit Memo']")
    WebElementFacade creditMemoBtn;
    //"Credit memo" button at order's page

    public void removeRefundForShipment(){
        refundShipmentFld.click();
        refundShipmentFld.clear();
    }

    public void checkMoreCreditMemosCanBeCreated(){
        Assert.assertTrue(creditMemoBtn.isPresent());
    }



}
