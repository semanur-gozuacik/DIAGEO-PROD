package com.sema.pages.MDMPage.AssetManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssetEditPage extends BasePage {
    public AssetEditPage() {
    }

    @FindBy(xpath = "//a[@id='listDropdown']//*[name()='svg']")
    private WebElement listDropDownButton;

    @FindBy(xpath = "//a[normalize-space()='Sematestyeni']")
    private WebElement editListItem;
    @FindBy(xpath = "//li[@class='list-tag']")
    private WebElement verifyEditListItem;
    @FindBy(xpath = "//span[@class='cancel-button']")
    private WebElement deleteEditList;
    @FindBy(xpath = "//div[@class='notifyjs-success']")
    private WebElement verifyRemovedListPopUp;
    @FindBy(xpath = "//a[normalize-space()='test12234testt52']")
    private WebElement editListSecondItem;
    @FindBy(xpath = "//a[normalize-space()='AllListsAdded']")
    private WebElement allListAddedItem;
    @FindBy(xpath = "//a[@id='_group-permissions']")
    private WebElement groupPermissions;
    @FindBy(xpath = "//button[@id='firtPageTableGroup']")
    private WebElement leftPreviousPage;
    @FindBy(xpath = "//button[@id='user-permissions-tableFirstPage']")
    private WebElement leftPreviousPageUser;
    @FindBy(xpath = "//span[@id='group-permissions-table_previous']")
    private WebElement previousPage;
    @FindBy(xpath = "//span[@id='user-permissions-table_previous']")
    private WebElement previousPageUser;
    @FindBy(xpath = "//span[@id='group-permissions-table_next']")
    private WebElement nextPage;
    @FindBy(xpath = "//span[@id='user-permissions-table_next']")
    private WebElement nextPageUser;
    @FindBy(xpath = "//div[@class='custom-button-right groupPermissions custom-button-page']")
    private WebElement lastPage;
    @FindBy(xpath = "//div[@class='custom-button-right userPermissions custom-button-page']")
    private WebElement lastPageUser;
    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement lastPageVerificationText;
    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement lastPageVerificationTextUser;
    @FindBy(xpath = "//a[@id='_user-permissions']")
    private WebElement userPermissions;

    public void clickListDropDown() {
        BrowserUtils.waitForVisibility(listDropDownButton, 20);
        listDropDownButton.click();
    }

    public void clickListItem() {
        BrowserUtils.waitForVisibility(editListItem, 20);
        editListItem.click();
    }

    public void clickListSecondItem() {
        BrowserUtils.waitForVisibility(editListSecondItem, 25);
        editListSecondItem.click();
    }

    public void verifyEditListItem() {
    BrowserUtils.wait(5);
    Assert.assertTrue(verifyEditListItem.isDisplayed());
    }

    public void clicksDeleteEditList() {
        BrowserUtils.waitForVisibility(deleteEditList, 20);
        deleteEditList.click();
    }

    public void verifyEditRemoved() {
        BrowserUtils.waitForVisibility(verifyRemovedListPopUp, 20);
        Assert.assertTrue(verifyRemovedListPopUp.isDisplayed());
    }

    public void verifyAllItemList() {
        BrowserUtils.waitForVisibility(allListAddedItem, 20);
        Assert.assertTrue(allListAddedItem.isDisplayed());
    }

    public void clickGroupPermission() {
    BrowserUtils.wait(5);
        groupPermissions.click();
    }

    public void verifyLeftPreviousePageIsNotClicible() {
        BrowserUtils.wait(5);
        String classAttribute = leftPreviousPage.getAttribute("class");
        Assert.assertTrue(classAttribute.contains("disabled"));
    }

    public void verifyPreviousePageIsNotClicible() {
        BrowserUtils.wait(7);
        String classAttribute = previousPage.getAttribute("class");
        Assert.assertTrue(classAttribute.contains("disabled"));
    }
    public void verifyPreviousePageUserIsNotClicible() {
        BrowserUtils.wait(5);
        String classAttribute = previousPageUser.getAttribute("class");
        Assert.assertTrue(classAttribute.contains("disabled"));
    }
    public void verifyLeftPreviousPageUserIsClickable() {
        BrowserUtils.wait(5);
        String classAttribute = leftPreviousPageUser.getAttribute("class");
        Assert.assertTrue(!classAttribute.contains("disabled"));
    }


    public void clicksNextPageButton() {
        BrowserUtils.wait(7);
        nextPage.click();
    }

    public void verifyNextPageIsNotClickable() {
        BrowserUtils.wait(5);
        String classAttribute = nextPage.getAttribute("class");
        Assert.assertTrue(classAttribute.contains("disabled"));
    }
    public void clicksNextPageUserButton() {
        BrowserUtils.wait(15);
        nextPageUser.click();
    }


    public void verifyNextPageUserIsClickable() {
        BrowserUtils.wait(5);
        String classAttribute = nextPageUser.getAttribute("class");
        Assert.assertTrue(!classAttribute.contains("disabled"));
    }

    public void clickPreviousPageButton() {
        BrowserUtils.wait(5);
        previousPage.click();
    }
    public void clickPreviousPageUserButton() {
        BrowserUtils.waitForVisibility(previousPageUser,20);
        previousPageUser.click();
    }
    public void verifyPreviousPageIsClickable() {
        BrowserUtils.wait(5);
        String classAttribute = previousPage.getAttribute("class");
        Assert.assertTrue(!classAttribute.contains("disabled"));
    }
    public void verifyPreviousPageUserIsClickable() {
        BrowserUtils.wait(5);
        String classAttribute = previousPageUser.getAttribute("class");
        Assert.assertTrue(!classAttribute.contains("disabled"));
    }

    public void clickLastPageButton() {
      BrowserUtils.wait(5);
        lastPage.click();
    }

    public void verifyLastPageIsClickable() {
        BrowserUtils.wait(5);
        Assert.assertTrue(!lastPage.getText().equalsIgnoreCase("1"));
    }

    public void clickLastPageUserButton() {
        BrowserUtils.wait(7);
        lastPageUser.click();
    }

    public void verifyLastPageUserIsClickable() {
        BrowserUtils.wait(7);
        Assert.assertTrue(!lastPageVerificationTextUser.getText().equalsIgnoreCase("1"));
    }

    public void verifyLastPageIsUnClickable() {
        BrowserUtils.wait(7);
        Assert.assertTrue(!lastPageVerificationText.getText().equalsIgnoreCase("1"));  }

    public void verifyNextPageIsClickable() {
        BrowserUtils.wait(7);
        String classAttribute = nextPage.getAttribute("class");
        Assert.assertTrue(!classAttribute.contains("disabled"));
    }
    public void verifyNextPageUserIsUnClickable() {
        BrowserUtils.wait(5);
        String classAttribute = nextPageUser.getAttribute("class");
        Assert.assertTrue(classAttribute.contains("disabled"));
    }

    public void verifyFirstPageIsClickable() {
        BrowserUtils.wait(5);
        String classAttribute = leftPreviousPage.getAttribute("class");
        Assert.assertTrue(!classAttribute.contains("disabled"));
    }

    public void clickUserPermission() {
        BrowserUtils.wait(7);
        userPermissions.click();
    }
    public void verifyLeftPreviousePageUserIsNotClicible() {
        String classAttribute = leftPreviousPageUser.getAttribute("class");
        Assert.assertTrue(classAttribute.contains("disabled"));
    }

}
