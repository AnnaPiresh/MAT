package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateFullRefundCreditMemo extends PageObject{

//---------------------------------Objects for Creating Full Refund Credit Memo----------------------------------------//

    @FindBy(xpath =".//button[@title='Credit Memo']")
    WebElementFacade creditMemoBtn;
    //"Credit memo" button at order's page

    @FindBy(xpath = ".//button[@title='Refund Offline']")
    WebElementFacade refundOffbtn;
    //"Refund offline" button at new credit memo page

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

}
