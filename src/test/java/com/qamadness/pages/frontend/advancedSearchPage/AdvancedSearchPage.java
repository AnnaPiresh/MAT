package com.qamadness.pages.frontend.advancedSearchPage;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.is;

/**
 * Created by Vladislav.E on 08.02.2016.
 */
public class AdvancedSearchPage extends PageObject {

    @FindBy(xpath = ".//ol[@id='compare-items']/li[@class='item last odd']/p[@class='product-name']/a")
    WebElementFacade comparedProduct;

    @FindBy(xpath = ".//a[contains(text(), 'Clear All')]")
    WebElementFacade clearAllLink;

    public void checkComparedProduct(String productName) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(comparedProduct));
        System.out.println(comparedProduct.getText());
        Assert.assertThat(comparedProduct.getText(), is(productName));
    }

    public void checkThatProductInCompareBlock() {
        if(comparedProduct.isDisplayed()){
            System.out.println("Product in compare block");
            clearAllLink.click();
        }else {
            System.out.println("Compare block empty");
        }
    }



    public void clearCompare() {
        clearAllLink.click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }


}
