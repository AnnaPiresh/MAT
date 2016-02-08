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

import static org.hamcrest.Matchers.is;

/**
 * Created by Serhii_Boiko on 28.01.2016.
 */
public class ProductDetailsPage extends PageObject {

//---------------------------------------Objects for Simple Product Details page---------------------------------------//

    @FindBy(xpath = ".//*[@id='product_addtocart_form']/div[4]/div/div/div[2]/button")
    WebElementFacade addToCartButton;

    @FindBy(xpath = ".//*[@class='link-compare']")
    WebElementFacade compareBtn;

    @FindBy(xpath = ".//li[@class='success-msg']/ul/li")
    WebElementFacade successCompareMsg;

//--------------------------------------Objects for Grouped Product Details page---------------------------------------//

    @FindBy(xpath = ".//*[@id='product_addtocart_form']/div[4]/div[2]/div/div/button")
    WebElementFacade addToCartGrouped;

//--------------------------------------Objects for Bundle Product Details page----------------------------------------//

    @FindBy(xpath = ".//*[@type='radio']")
    WebElementFacade bundleRadioButtons;

    @FindBy(xpath = ".//*[@id='product_addtocart_form']/div[7]/div[2]/div[2]/button")
    WebElementFacade addToCartBundle;

//------------------------------------Objects for Downloadable Product Details page------------------------------------//

    @FindBy(xpath = ".//*[@id='downloadable-links-list']/li/span/label")
    WebElementFacade downloadableLink;

//---------------------------------------Methods for Simple Product Details page---------------------------------------//

    public void clickAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void clickAddToCompareBtn() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(compareBtn));
        compareBtn.click();
    }

    public void checkSuccessCompareMsg(String productName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(successCompareMsg));
        Assert.assertThat(successCompareMsg.getText(), is("The product "+productName+" has been added to comparison list."));
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

    public void clickAddToCartButtonGrouped(){
        addToCartGrouped.click();
    }

//--------------------------------------Methods for Bundle Product Details page---------------------------------------//

    public void selectBundleItem(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(bundleRadioButtons));
        bundleRadioButtons.click();
    }

    public void clickAddToCartButtonBundle(){
        addToCartBundle.click();
    }

//-----------------------------------Methods for Configurable Products Details page------------------------------------//

    public void selectConfigurableOption(String productColour){
        String xpath = String.format(".//*[@id='swatch%s']", productColour);
        getDriver().findElement(By.xpath(xpath)).click();
    }

//------------------------------------Methods for Downloadable Product Details page------------------------------------//

    public void selectDownloadableLink(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(downloadableLink));
        downloadableLink.click();
    }

}
