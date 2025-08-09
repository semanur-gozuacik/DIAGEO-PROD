package com.sema.pages.MDMPage.ContactManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactEditPage extends BasePage {
    @FindBy(xpath ="//button[@id='floatingSaveButton']")
    private WebElement uploadButton;
    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement uploadCommentArea;
    @FindBy(xpath = "//a[@id='uploadImageButtonAvatar']//i[@class='fa fa-check']")
    private WebElement uploadPhotoSaveButton;
    @FindBy(xpath = "//a[@id='cancelButtonAvatar']")
    private WebElement uploadPhotoCancelButton;
    @FindBy(xpath = "//img[@id='previweImg' and @src='/Content/image_data/no_imageen-US.png']")
    private WebElement verifyUnUploadObject;
    @FindBy(xpath = "//img[@id='previweImg' and starts-with(@src, 'https://sandbox.efectura.com/Content/image_data')]")
    private WebElement verifyUploadObject;
    @FindBy(xpath ="//select[@id='itemStatusDropdown']")
    private WebElement editItemStatuses;
    @FindBy(xpath = "//span[normalize-space()='Unsaved Changes']")
    private WebElement unsavedChanges;
    @FindBy(xpath = "//div[@id='modalSaveChange']//i[@class='fa fa-chevron-left']")
    private WebElement cancelChangeButton;
    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement commentChange;
    @FindBy(xpath = "//div[@class='notifyjs-success']")
    private WebElement changeSucessMessage;
    @FindBy (xpath = "//a[@id='savebutton']")
    private WebElement saveChangeButton;
    @FindBy (xpath = "//a[normalize-space()='testListesi']")
    private WebElement editListItem;
    @FindBy(xpath = "//span[contains(text(),'ExportPDF')]")
    private WebElement exportPDF;
    @FindBy(xpath = "//span[@class='iconbtn iconbtn-green rrbutton']")
    private WebElement refreshButton;
    public ContactEditPage() {
    }

    //public void clickUploadButton() {
       // BrowserUtils.wait(5);
       // uploadButton.click();
       // uploadButton.sendKeys("C:\\Users\\Sema\\Desktop\\UIframework\\UIframework\\UIframework\\src\\test\\resources\\indir.jpeg");
    public void clickUploadButtonAndUploadFile() {
        BrowserUtils.wait(5);
        uploadButton.click();
        BrowserUtils.wait(5);
        uploadButton.sendKeys("semafoto"+ Keys.ENTER);
    }
    public void uploadCommentArea(String comment) {
        BrowserUtils.waitForVisibility(uploadButton, 20);
        uploadCommentArea.sendKeys(comment);
    }

    public void clickUploadPhotoSaveButton() {
        uploadPhotoSaveButton.click();
    }

    public void clickUploadPhotoCancelButton() {
        uploadPhotoCancelButton.click();
    }

    public void verifyUnUpload() {
        BrowserUtils.waitForVisibility(verifyUnUploadObject, 20);
        Assert.assertTrue(verifyUnUploadObject.isDisplayed());
    }

    public void verifyUpload() {
        BrowserUtils.waitForVisibility(verifyUploadObject, 20);
        Assert.assertTrue(verifyUploadObject.isDisplayed());
    }
    public void selectItemStatus(String status){
        BrowserUtils.wait(5);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", editItemStatuses);
        Select select =new Select(editItemStatuses);
        select.selectByVisibleText(status);
    }
    public void clickUnSavedButton(){
        BrowserUtils.waitForVisibility(unsavedChanges,30);
        unsavedChanges.click();
    }
    public void clickCancelChangeButton(){
        BrowserUtils.waitForVisibility(cancelChangeButton,20);
        cancelChangeButton.click();
    }
   public void verifyCancelChange(){
        BrowserUtils.waitForVisibility(unsavedChanges,25);
        Assert.assertTrue(unsavedChanges.isDisplayed());
   }
    public void setChangeCommentArea(String comment) {
        BrowserUtils.waitForVisibility(commentChange, 20);
        commentChange.sendKeys(comment);
    }
    public void verifyChangeSuccesMessage(){
        BrowserUtils.waitForVisibility(changeSucessMessage,20);
        Assert.assertTrue(changeSucessMessage.isDisplayed());
    }
    public void clickSaveChangeButton(){
        //BrowserUtils.waitForVisibility(saveChangeButton,20);
        saveChangeButton.click();
    }
    public void clickListItem() {
        BrowserUtils.waitForVisibility(editListItem, 30);
        editListItem.click();
    }
    public void clickExportPDF() {
           BrowserUtils.wait(6);
            exportPDF.click();


    }
    public void clickRefreshButton() {
        BrowserUtils.waitForVisibility(refreshButton, 30);
        refreshButton.click();
    }
}