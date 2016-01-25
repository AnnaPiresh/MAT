package com.qamadness.pages.backend.cms.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hibernate.validator.valuehandling.UnwrapValidatedValue;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexandra on 1/25/16.
 */
public class CreateNewPagePage  extends PageObject{

    //Tabs:

    @FindBy (xpath = "//a[@title='Page Information']")
    WebElementFacade pageInformationTab;

    @FindBy (xpath = "//a[@title='Content']")
    WebElementFacade contentTab;

    @FindBy (xpath = "//a[@title='Design']")
    WebElementFacade designTab;

    @FindBy (xpath = "//a[@title='Meta Data']")
    WebElementFacade metaDataTab;

    //Messages:

    @FindBy(xpath = "//div[@id='advice-required-entry-%fieldId%' and not(contains(@style,'display: none;'))]")
    WebElementFacade errorEmptyRequiredField;

    //Fields on Page information tab:

    @FindBy (xpath = "//input[@name='title']")
    WebElementFacade pageTitleField;

    @FindBy (xpath = "//input[@name='identifier']")
    WebElementFacade urlKeyField;

    //Dropdowns on Page information tab:

    @FindBy (xpath = "//select[@name='is_active']")
    WebElementFacade statusDropdown;

    //Multiselects on Page information tab:

    @FindBy (xpath = "//select[@name='stores[]']")
    WebElementFacade storeViewMultiselect;

    //Fields on Content tab:

    @FindBy (xpath = "//input[@name='content_heading']")
    WebElementFacade contentHeadingField;

    @FindBy (xpath = "//textarea[@name='content' and not(contains(@style,'display: none;'))]")
    WebElementFacade editorField;

    @FindBy (xpath = "//textarea[@name='content' and contains(@style,'display: none;')]")
    WebElementFacade editorDisabledField;

    //Buttons on Content tab:

    @FindBy (xpath = "//button[span='Insert Widget...']")
    WebElementFacade insertWidgetButton;

    @FindBy (xpath = "//button[span='Insert Image...']")
    WebElementFacade insertImageButton;

    @FindBy (xpath = "//button[span='Insert Variable...']")
    WebElementFacade insertVariableButton;

    @FindBy (xpath = "//button[span='Show / Hide Editor']")
    WebElementFacade showAndHideEditorButton;

    //** Widget insertion pop up window **:

    @FindBy (xpath = "//div[@id='widget_window']")
    WebElementFacade widgetInsertionPopUp;

    @FindBy (xpath = "//select[@name='widget_type']")
    WebElementFacade widgetTypeDropdown;

    @FindBy (xpath = "//select[@name='parameters[template]']")
    WebElementFacade templateDropdown;

    @FindBy (xpath = "//input[@name='parameters[anchor_text]']")
    WebElementFacade anchorCustomTextField;

    @FindBy (xpath = "//input[@name='parameters[title]']")
    WebElementFacade anchorCustomTitleField;

    @FindBy (xpath = "//input[@name='parameters[products_count]']")
    WebElementFacade numberOfProductsToDisplayField;

    @FindBy (xpath = "//input[@name='parameters[page_size]']")
    WebElementFacade numberOfProductsToDisplayComparedAndViewedField;

    @FindBy (xpath = "//input[@name='parameters[cache_lifetime]']")
    WebElementFacade cacheLifetimeField;

    @FindBy (xpath = "//button[span='Insert Widget']")
    WebElementFacade submitWidgetInsertButton;

    @FindBy (xpath = "//div[div/h3='Widget Insertion']//button[contains(span,'Select')]")
    WebElementFacade selectOptionButton;

    @FindBy (xpath = "//div[@id='widget_window_close']")
    WebElementFacade closeWidgetInsertionButton;

    //Fields on Design tab:

    @FindBy (xpath = "//textarea[@name='layout_update_xml']")
    WebElementFacade layoutUpdateXMLField;

    @FindBy (xpath = "//input[@name='custom_theme_from']")
    WebElementFacade customDesignFrom;

    @FindBy (xpath = "//input[@name='custom_theme_to']")
    WebElementFacade customDesignTo;

    @FindBy (xpath = "//textarea[@name='custom_layout_update_xml']")
    WebElementFacade customLayoutUpdateXMLField;

    //Dropdowns on Design tab:

    @FindBy (xpath = "//select[@name='root_template']")
    WebElementFacade layoutDropdown;

    @FindBy (xpath = "//select[@name='custom_theme']")
    WebElementFacade customThemeDropdown;

    @FindBy (xpath = "//select[@name='custom_root_template']")
    WebElementFacade customLayoutDropdown;

    //Fields on Meta Data tab:

    @FindBy (xpath = "//textarea[@name='meta_keywords']")
    WebElementFacade keywordsField;

    @FindBy (xpath = "//textarea[@name='meta_description']")
    WebElementFacade descriptionField;

    //General buttons:

    @FindBy (xpath = "//button[span='Back']")
    WebElementFacade backButton;

    @FindBy (xpath = "//button[span='Reset']")
    WebElementFacade resetButton;

    @FindBy (xpath = "//button[span='Save Page']")
    WebElementFacade savePageButton;

    @FindBy (xpath = "//button[span='Save and Continue Edit']")
    WebElementFacade saveAndContinueEditButton;

    @FindBy (xpath = "//button[span='Delete Page']")
    WebElementFacade deletePageButton;

    //Methods for General buttons:

    public void clickSavePageButton (){
        savePageButton.click();
    }

    public void clickDeletePageButtonAndConfirm (){
        deletePageButton.click();
        getDriver().switchTo().alert().accept();
    }

    //Methods for Page Information tab:

    public void enterPageTitle (String pageTitle){
        pageTitleField.type(pageTitle);
    }

    public void enterUrlKey (String urlKey){
        urlKeyField.type(urlKey);
    }

    public void selectStoreView (String storeView){
        storeViewMultiselect.selectByVisibleText(storeView);
    }

    public void selectStatus (String staus){
        statusDropdown.selectByVisibleText(staus);
    }

    //Methods for Content tab:

    public void openContentTab (){
        contentTab.click();
    }

    public void enterContentHeading (String contentHeading){
        contentHeadingField.type(contentHeading);
    }

    public void enterMainContent (String content){
        editorField.type(content);
    }


}
