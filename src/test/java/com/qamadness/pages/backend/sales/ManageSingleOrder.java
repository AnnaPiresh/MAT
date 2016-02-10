package com.qamadness.pages.backend.sales;

import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class ManageSingleOrder extends PageObject{

//-------------------------------Objects for Creating Invoice---------------------------------------------------------//

    @FindBy(xpath = ".//button[@title='Invoice']")
    WebElementFacade invoiceBtn;
    //invoice button at order's page

    @FindBy(xpath = ".//button[@title='Submit Invoice']")
    WebElementFacade submitInvoiceBtn;
    //"Submit invoice" button at new invoice page

//---------------------------------Objects for Creating Full Refund Credit Memo----------------------------------------//

    @FindBy(xpath =".//button[@title='Credit Memo']")
    WebElementFacade creditMemoBtn;
    //"Credit memo" button at order's page

    @FindBy(xpath = ".//button[@title='Refund Offline']")
    WebElementFacade refundOffbtn;
    //"Refund offline" button at new credit memo page

//------------------------------------------Objects for Partial Credit Memo---------------------------------------------//

    @FindBy(xpath = ".//*[@id='shipping_amount']")
    WebElementFacade refundShipmentFld;
    //Field in Credit Memo subtotal where refund for shipment can be changed

//------------------------------------------Objects for Creating Shipment-------------------------------------------------//

    @FindBy(xpath = ".//button[@title='Ship']")
    WebElementFacade shipmentBtn;
    //"Ship" button at order's page

    @FindBy(xpath = ".//button[@title='Submit Shipment']")
    WebElementFacade submitShipmentBtn;
    //"Submit shipment" button at new shipment page

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

//------------------------------------Objects for Resending an email---------------------------------------------------//

    @FindBy(xpath = ".//button[@title='Send Email']")
    WebElementFacade sendEmailBtn;
    //button that resends an email to a customer

//-------------------------------Objects for Success Messages---------------------------------------------------------//
    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

//------------------------------Methods for Creating Invoice-----------------------------------------------------------//

    public void createAnInvoiceForOrder(){
        invoiceBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("/sales_order_invoice/new/order_id/"));
        submitInvoiceBtn.click();
    }

//-----------------------------Methods for Creating Full Refund Credit Memo--------------------------------------------//

    public void startCreatingCreditMemo() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
        creditMemoBtn.click();
    }
    public void submitCreditMemo(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("/sales_order_creditmemo/new/order_id"));
        refundOffbtn.click();
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
    }

//------------------------------------------Methods for Partial Credit Memo---------------------------------------------//

    public void removeRefundForShipment(){
        refundShipmentFld.click();
        refundShipmentFld.clear();
    }

    public void checkMoreCreditMemosCanBeCreated(){
        Assert.assertTrue(creditMemoBtn.isPresent());
    }

//------------------------------------------Methods for Creating Shipment-------------------------------------------------//

    public void createShipmentForOrder(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
        shipmentBtn.click();
        wait.until(ExpectedConditions.urlContains("sales_order_shipment/new/order_id/"));
        submitShipmentBtn.click();
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
    }

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

//------------------------------------Methods for Resending an email----------------------------------------------------//

    public void clickSendEmailBtn(){
        if (sendEmailBtn.isVisible()){
            sendEmailBtn.click();
        } else {
            Assert.fail("Send email button is not present on order's page");
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

//-------------------------------Methods for Success Messages---------------------------------------------------------//

    public void checkSuccessMsg(String message){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(message)){
            System.out.println("Success message is present");
        } else {
            Assert.fail("Success message is not present");
        }
    }

}
