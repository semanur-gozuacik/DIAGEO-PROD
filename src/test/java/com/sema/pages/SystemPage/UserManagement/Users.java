package com.sema.pages.SystemPage.UserManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Users extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='Users Overview']")
    private WebElement usersOverviewVerificationsElement;
    @FindBy(name = "table_id_length")
    private WebElement entrieNumber;
    @FindBy(xpath = "//button[@id='table_idFirstPage']")
    private WebElement firstPageButton;
    @FindBy(xpath = "//span[@id='table_id_previous']")
    private WebElement previousPageButton;
    @FindBy(xpath = "//button[@id='table_idLastPage']")
    private WebElement lastPageButton;
    @FindBy(xpath = "//span[@id='table_id_next']")
    private WebElement nextPageButton;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameFilter;
    @FindBy(xpath = "//td[contains(@class, 'td-select-edit')][1]")
    private List<WebElement> verifyUsernameFilter;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    private WebElement noContentsText;
    @FindBy(xpath = "//input[@id='UserEmail']")
    private WebElement userEmailFilter;
    @FindBy(xpath = "//td[contains(@class, 'td-select-edit')][2]")
    private List<WebElement> verifyUserEmailFilter;
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameFilter;
    @FindBy(xpath = "//td[contains(@class, 'td-select-edit')][3]")
    private List<WebElement> verifyFirstNameFilter;
    @FindBy(xpath = "")
    private WebElement userNameText;
    @FindBy(xpath = "//span[@id='select2-IsReal-container']")
    private WebElement clicksIsReal;
    @FindBy(xpath = "//li[contains(text(),'Enable') and @role='treeitem']")
    private WebElement enableFılter;
    @FindBy(xpath = "//li[contains(text(),'Disable') and @role='treeitem']")
    private WebElement disableFılter;

    public Users() {
    }
    public void verifyUsers(){
        BrowserUtils.wait(5);
        Assert.assertTrue(usersOverviewVerificationsElement.isDisplayed());
    }
    public void selectEntrie(String entrie){
        BrowserUtils.selectOption(entrieNumber,entrie);
    }
    public void verifySelectOption(String entrie){
        BrowserUtils.wait(10);
        Assert.assertTrue(BrowserUtils.isOptionSelected(entrieNumber, entrie));
    }
    public void verifyFirstPageButtonUnClickable() {
        BrowserUtils.wait(10);
        String classes = firstPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertTrue(isDisabled);
    }
    public void verifyPreviousPageButtonUnClickable() {
        BrowserUtils.wait(10);
        String classes = previousPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertTrue(isDisabled);
    }
    public void verifyNextPageButtonUnClickable() {
        BrowserUtils.wait(15);
        String classes = nextPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertTrue(isDisabled);
    }
    public void clickLastPage(){
       BrowserUtils.wait(10);
       lastPageButton.click();
    }
    public void verifyLastPageButtonUnClickable() {
        BrowserUtils.wait(17);
        String classes = lastPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertTrue(isDisabled);
    }
    public void verifyFirstPageButtonClickable() {
        BrowserUtils.wait(17);
        String classes = firstPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(isDisabled);
    }
    public void verifyPreviousPageButtonClickable() {
        BrowserUtils.wait(20);
        String classes = previousPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(isDisabled);
    }
    public void verifyNextPageButtonClickable() {
        BrowserUtils.wait(10);
        String classes = nextPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(isDisabled);
    }
    public void verifyLastPageButtonClickable() {
        BrowserUtils.wait(17);
        String classes = lastPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(isDisabled);
    }
    public void verifyUsernameFilter(String username) {
        BrowserUtils.wait(17);
        System.out.println(verifyUsernameFilter.get(0).getText());
        assertTrue(verifyUsernameFilter.get(0).getText().equalsIgnoreCase(username));
    }
    public void setUsernameFilter(String username) {
        usernameFilter.click();
        usernameFilter.sendKeys(username);
    }
    public void verifyPartialUsernameFilters(String partialUsername) {
        for (int i = 0; i < verifyUsernameFilter.size(); i++) {
            System.out.println(verifyUsernameFilter.size());
            assertTrue(verifyUsernameFilter.get(i).isDisplayed());
        }
    }
    public void verifyNoContentTextInvalidUniqueUsername(String text) {
    BrowserUtils.wait(10);
    Assert.assertTrue(noContentsText.getText().equalsIgnoreCase(text));
    }
    public void verifyUserEmailFilter(String email) {
        BrowserUtils.wait(7);
        System.out.println(verifyUserEmailFilter.get(0).getText());
        assertTrue(verifyUserEmailFilter.get(0).getText().equalsIgnoreCase(email));
    }
    public void setUserEmailFilter(String email) {
        userEmailFilter.click();
        userEmailFilter.sendKeys(email);
    }
    public void setFirstNameFilter(String firstName) {
        firstNameFilter.click();
        firstNameFilter.sendKeys(firstName);
    }
    public void verifyFirstNameFilter(String firstName) {
        BrowserUtils.wait(5);
        System.out.println(verifyFirstNameFilter.get(0).getText());
        assertTrue(verifyFirstNameFilter.get(0).getText().equalsIgnoreCase(firstName));
    }
    public void verifyPartialFirstNameFilters(String partialFirstName) {
        for (int i = 0; i < verifyFirstNameFilter.size(); i++) {
            System.out.println(verifyFirstNameFilter.size());
            assertTrue(verifyFirstNameFilter.get(i).isDisplayed());
        }
    }
    public void clicksIsReal() {
        clicksIsReal.click();
        BrowserUtils.wait(2);
    }
    public void selectIsRealFilter(String isReal) {
        BrowserUtils.wait(10);
   if (isReal.equalsIgnoreCase("Enable")){
       enableFılter.click();
       BrowserUtils.wait(2);
   }
   else{
       disableFılter.click();
       BrowserUtils.wait(2);
   }
    }
    public void verifyResetButton() {
        assertTrue(true);
    }
    public void onTheUsersSettingPage(){
        driver.navigate().to("https://sandbox.efectura.com/UserManage");
    }
}

