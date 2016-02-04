package com.qamadness.pages.frontend.homePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.Matchers.is;

/**
 * Created by Alexandra on 1/25/16.
 */
public class HomePage extends PageObject {

//-----------------------------------------------------Objects for Homepage--------------------------------------------//

    @FindBy(xpath = ".//*[@id='search']")
    WebElementFacade searchField;

    @FindBy(xpath = ".//*[contains(text(), 'Cart')]")
    WebElementFacade floatingCartLink;

    @FindBy(xpath = ".//*[@id='header-cart']")
    WebElementFacade floatingCart;

    @FindBy(xpath = ".//*[contains(text(), 'View Shopping Cart')]")
    WebElementFacade viewShoppingCartLink;

    @FindBy(xpath = ".//*[text()='Account']")
    WebElementFacade accountButton;

    @FindBy(xpath = ".//*[@id='header-account']")
    WebElementFacade accountMenuHeader;

    @FindBy(xpath = ".//a[@title='Register']")
    WebElementFacade registerLink;

    @FindBy(xpath = ".//div[@id='header-account']/div/ul/li[last()]/a")
    WebElementFacade loginLogoutLink;

    @FindBy(css = ".product-name")
    WebElementFacade productName;

    @FindBy(xpath = ".//*[@id='newsletter']")
    WebElementFacade newsletterField;

    @FindBy(xpath = ".//*[@class='button'][@title='Subscribe']")
    WebElementFacade subscribeBtn;

    @FindBy(xpath = ".//li[@class='success-msg']/ul/li/span[contains(text(),'Thank you for your subscription')]")
    WebElementFacade successSubscribeMsg;

    @FindBy(css = ".error-msg>ul>li>span")
    WebElementFacade errorMsg;

//----------------------------------------------------Methods for Homepage---------------------------------------------//

    public void openHomePage() {
        getDriver().navigate().to("http://qamad:f3Vh!@www.qamadness.dev/");
        getDriver().manage().window().maximize();
    }

    public void searchForProduct(String searchterm){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(searchterm);
        searchField.sendKeys(Keys.ENTER);
    }

    public void openFloatingCart(){ floatingCartLink.click();}

    public Boolean checkIfShoppingCartEmpty(String emptyCartMessage){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(floatingCart));
        if (floatingCart.containsText(emptyCartMessage)){
            System.out.println("Shopping cart is empty");
            return true;
        }else{
            System.out.println("Shopping cart is not empty");
            viewShoppingCartLink.click();
            return false;
        }
    }


    public void navigateToShoppingCartPage(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(floatingCart));
        viewShoppingCartLink.click();
    }

    public void openAccountMenuInHeader() {accountButton.click();}

    public void clickRegisterLink() {registerLink.click();}

    public void navigateToLoginPage () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(accountMenuHeader));
        loginLogoutLink.click();
    }

    public void deleteProductsInCart() { //method is still not working as expected, will be edited and completed in future
         List<WebElement> li = getDriver().findElements(By.cssSelector(".remove"));
            if (productName.isPresent()) {
                int counter = 0;
                int size = getDriver().findElements(By.cssSelector(".remove")).size();
                System.out.println(size);
            while (counter < size) {
                 li.get(counter).click();
                 getDriver().switchTo().alert().accept();
                 WebDriverWait wait = new WebDriverWait(getDriver(), 60);
                 wait.until(ExpectedConditions.visibilityOf(element(org.openqa.selenium.By.cssSelector("#minicart-success-message"))));
                 counter++;
             }
            }

        }


    public void logoutFromWebsite(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(accountMenuHeader));
        loginLogoutLink.click();
    }

    public void enterEmailToNewsletterField(String subscribeEmail) {
        newsletterField.sendKeys(subscribeEmail);
    }

    public void clickSubscribeBtn() {
        subscribeBtn.click();
    }

    public void checkSuccessSubscribeMsg() {
        System.out.println(successSubscribeMsg.getText());
        Assert.assertThat(successSubscribeMsg.getText(), is("Thank you for your subscription."));}

    public void checkSubscribeErrorMsg() {Assert.assertThat(errorMsg.getText(), is("There was a problem with the subscription: This email address is already assigned to another user."));}

}
