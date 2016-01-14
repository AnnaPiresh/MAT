package com.qamadness.pages.promotions;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddShoppingCartPriceRule extends PageObject{

//---------------------------------Objects for Adding Shopping Cart Price Rule-----------------------------------------//

    @FindBy(xpath = ".//*[@id='rule_coupon_type']")
    WebElementFacade couponDropdown;

    @FindBy(xpath = ".//*[@id='rule_coupon_code']")
    WebElementFacade couponCodeField;

    @FindBy(xpath = ".//*[@id='global_search']")
    WebElementFacade globalSearch;

//--------------------------------Methods for Adding Shopping Cart Price Rule------------------------------------------//

    public void selectCouponTypeFromDropdown(String couponType){
        couponDropdown.click();
        couponDropdown.selectByValue(couponType).click();
    }

    public void enterCouponCode(String couponCode){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(couponCodeField));
        couponCodeField.click();
        couponCodeField.sendKeys(couponCode);
    }

    public void clearGlobalSearch () { globalSearch.clear();}


}
