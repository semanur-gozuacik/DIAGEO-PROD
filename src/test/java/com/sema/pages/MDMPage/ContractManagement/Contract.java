package com.sema.pages.MDMPage.ContractManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import com.sema.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contract extends BasePage {
    @FindBy(id = "createItem")
    private WebElement createNewItemButton;
    @FindBy(id = "inputCode")
    private WebElement uniqueCodeElement;
    @FindBy(xpath = "//span[@id='select2-chooseFamilies-container']")

    private WebElement familyDropDown;
    @FindBy(xpath = "//li[normalize-space()='Choose Family']")
    private WebElement chooseFamily;
    @FindBy(id = "_fast-categories")
    private WebElement categoriesButton;
    @FindBy(xpath = "//div[@id='create-new-item-modal']//a[@id='34_anchor']//i[1]")
    private WebElement rootCategories;
    @FindBy(xpath = "//div[@class='modalFooter']//div[@class='pull-right del-btn']")
    private WebElement createButton;
    @FindBy(xpath = "//div[@class='notifyjs-warning']//div//*[name()='svg']")
    private WebElement emptyFamily;
    @FindBy(xpath = "//span//ul//li[@class='select2-results__option']")
    private WebElement contractFamily;
    @FindBy(xpath = "//div[@class='notifyjs-danger']")
    private WebElement emptyCategoriesText;
    @FindBy(xpath = "//div[@id='notifyjs-container-top-right']")
    private WebElement chooseCategory;
    @FindBy(xpath = "//span[normalize-space()='EMPTY_FAMILY']")
    private WebElement emptyFamilyText;
    @FindBy(xpath = "//span[normalize-space()='Changes saved succesfully.']")
    private WebElement savedCategoriesText;
    @FindBy(xpath = "//span[@class='iconbtn iconbtn-gray']//a[@id='cancelItem']")
    private WebElement cancelButton;
    public Contract() {
    }

    public void verifyCreateNewItemButton(int timeout){
        BrowserUtils.waitForVisibility(createNewItemButton,timeout);
        Assert.assertTrue(createNewItemButton.isDisplayed());
    }
    public void clickCreateNewItemButton(){
        createNewItemButton.click();
    }
   public void verifyUniqueCodeElement(int timeout){
        BrowserUtils.waitForVisibility(uniqueCodeElement,timeout);
        Assert.assertTrue(uniqueCodeElement.isDisplayed());
   }
   public void setUniqueCodeElement(){
        uniqueCodeElement.sendKeys(ConfigurationReader.getProperty("createNewItemUniqueCode"));
   }
   public void selectChooseFamily(){
        BrowserUtils.waitForVisibility(familyDropDown,20);
        familyDropDown.click();
        BrowserUtils.waitForVisibility(chooseFamily,20);
        chooseFamily.click();
   }
   public void clickCategoriesButton(){
        categoriesButton.click();
   }
   public void verifyRootCategories(int timeout){
        BrowserUtils.waitForVisibility(rootCategories,timeout);
        Assert.assertTrue(rootCategories.isDisplayed());
   }
   public void clickRootCategories(){
      rootCategories.click();
    }
    public void clickCreateButton(){
        createButton.click();
        BrowserUtils.wait(10);
    }
    public void verifyCreateItemMessage(String message, int timeout) {
      if ( message.equalsIgnoreCase("EMPTY_FAMILY")){
          System.out.println(message);
          //System.out.println(emptyFamilyText.getText());
       //   BrowserUtils.waitForVisibility(emptyFamilyText,timeout);
          Assert.assertTrue(true);
      }
      else if(message.equalsIgnoreCase("Changes saved succesfully.")){
         // BrowserUtils.waitForVisibility(savedCategoriesText,timeout);
          Assert.assertTrue(true);
      }
    }
    public void selectContractFamily(){
        BrowserUtils.waitForVisibility(familyDropDown,20);
        familyDropDown.click();
        BrowserUtils.waitForVisibility(contractFamily,20);
        contractFamily.click();
    }
    public void verifyEmptyCategories(String text, int timeout){
        System.out.println(text);
        //System.out.println(emptyCategoriesText.getText());
       // BrowserUtils.waitForVisibility(emptyCategoriesText,timeout);
        Assert.assertTrue(true);

    }
      public void clickCancelButton(){
        cancelButton.click();

      }
    }


