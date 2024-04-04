package com.sema.pages.MDMPage.UserManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserHomePage extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='Label']")
    private WebElement labelFilter;
    @FindBy(xpath = "//input[@id='Label-associationTable']")
    private WebElement labelFilterSendKey;
    @FindBy(xpath = "//tbody/tr/td[6]")
    private List<WebElement> labelVerifies;
    @FindBy(xpath ="//span[@class='iconbtn iconbtn-green rrbutton reset_filter-new']//i[@class='fa fa-undo']")
    private WebElement resetButton;
    @FindBy(xpath ="//span[@class='iconbtn iconbtn-green refresh-association-table rrbutton refresh']//span[@class='text'][normalize-space()='Refresh']")
    private WebElement refreshButton;
    @FindBy(xpath ="//span[@id='select2-filter-Family-container']")
    private WebElement familyFilter;
    @FindBy(xpath = "//li[contains(text(),'NEXIO') and @role='treeitem']")
    private WebElement NEXIOFamilyFılter;
    @FindBy(xpath = "//li[contains(text(),'DEF_ACCOUNT') and @role='treeitem']")
    private WebElement DEF_ACCOUNTFamilyFılter;
    @FindBy(xpath = "//li[contains(text(),'HOSPITALITY') and @role='treeitem']")
    private WebElement HOSPITALITYFamilyFılter;
    @FindBy(xpath ="//a[normalize-space()='Durumlar']")
    private WebElement statusFilter;
    @FindBy(xpath = "//span[contains(@class,'select2-search select2-search--dropdown')]//input[contains(@role,'textbox')]")
    private WebElement associatedAllFilter;

    @FindBy(xpath ="//li[contains(text(),'Enable') and @role='treeitem']")
    private WebElement enabledStatusFilter;
    @FindBy(xpath ="//li[contains(text(),'Disabled') and @role='treeitem']")
    private WebElement disabledStatusFilter;


    public UserHomePage() {
    }
    public void onTheUserPage(){
        driver.navigate().to("https://sandbox.efectura.com/Enrich/Items?itemType=MRP");
    }
    public void validLabelFilter(String validLabel){
        BrowserUtils.wait(5);
        labelFilter.click();
        labelFilterSendKey.sendKeys(validLabel);
        labelFilterSendKey.sendKeys(Keys.ENTER);

    }
    public void inValidLabelFilter(String invalidLabel){
        labelFilter.sendKeys(invalidLabel);
        labelFilter.sendKeys(Keys.ENTER);

    }
    public void verifiesLabelIsDisplayed(){
        BrowserUtils.wait(5);
        Assert.assertTrue(labelVerifies.size()==1);

    }
    public void verifiesLabelIsNotDisplayed(){
        BrowserUtils.wait(5);
        Assert.assertTrue(labelVerifies.size()==0);
    }
    public void selectNEXIOFamilyFilter() {
        BrowserUtils.wait(10);
        familyFilter.click();
        BrowserUtils.wait(10);
        NEXIOFamilyFılter.click();
    }
    public void selectDEF_ACCOUNTFamilyFilter() {
        BrowserUtils.wait(10);
        familyFilter.click();
        BrowserUtils.wait(10);
        DEF_ACCOUNTFamilyFılter.click();
    }
    public void selectHOSPITALITYFamilyFilter() {
        BrowserUtils.wait(10);
        familyFilter.click();
        BrowserUtils.wait(10);
        HOSPITALITYFamilyFılter.click();
    }
    public void selectFamily(String family){
        if (family.startsWith("NE")){
            selectNEXIOFamilyFilter();
        } else if (family.startsWith("DEF")) {
            selectDEF_ACCOUNTFamilyFilter();

        }else {selectHOSPITALITYFamilyFilter();
        }
    }  public void selectStatus(String status){
        BrowserUtils.wait(10);
        statusFilter.click();
        if (status.startsWith("Etkin")){
            selectEnabled();

        }else {selectDisabled();

        }

    }
    public void clickEtkinFilter() {
        BrowserUtils.wait(5);
        statusFilter.click();
        BrowserUtils.waitForVisibility(associatedAllFilter, 30);
        associatedAllFilter.sendKeys("Etkin"+ Keys.ENTER);
        BrowserUtils.wait(7);

    }
    public void selectEnabled(){
        BrowserUtils.wait(10);
        enabledStatusFilter.click();
    }
    public void selectDisabled(){
        BrowserUtils.wait(10);
        disabledStatusFilter.click();
    }
public void clickResetButton(){
        BrowserUtils.wait(2);
        resetButton.click();

}
    public void clickRefresgButton(){
        BrowserUtils.wait(2);
        refreshButton.click();

    }
}
