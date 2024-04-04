package com.sema.pages.MDMPage.ContactManagement;
import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactHomePageMyContactPage extends BasePage {
    @FindBy(xpath = "//tr//td[@class='sorting_1']")
    private List<WebElement> myContactsNames;
    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement peginationText;
    @FindBy(xpath = "//span[@id='items_next']")
    private WebElement itemNextButton;
    @FindBy(xpath = "//div[@id='items_info']")
    private WebElement showingEntriesText;
    @FindBy(xpath = "//span[@id='items_previous']")
    private WebElement itemPreviousButton;
    @FindBy(xpath = "//button[@id='firtPageTable']")
    private WebElement itemLeftPreviousButton;
    @FindBy(xpath = "//div[@class='custom-button-right custom-button-page']")
    private WebElement itemRightNextButton;
    @FindBy(id = "inputCode")
    private WebElement uniqueCodeElement;

    public ContactHomePageMyContactPage() {
    }

    public void verifyMyContact() {
        BrowserUtils.waitForVisibility(myContactsNames.get(0), 20);
        Assert.assertTrue(myContactsNames.size() > 0);
    }

    public void clickItemNextButton() {
        BrowserUtils.waitForVisibility(itemNextButton, 20);
        itemNextButton.click();
    }

    public void verifyItemNextShowingEntriesText() {
        BrowserUtils.wait(5);
        Assert.assertFalse(showingEntriesText.getText().contains("11 to 1"));

    }
    public void clickItemPreviousButton() {
        BrowserUtils.wait(5);
        itemPreviousButton.click();
    }
    public void verifyItemPreviousShowingEntriesText() {
        BrowserUtils.wait(5);
        System.out.println(showingEntriesText.getText());
        Assert.assertTrue(showingEntriesText.getText().contains("1 to 10"));
    }
    public void verifyItemPreviousButtonUnclickable(){
        BrowserUtils.wait(7);
        String classes = itemPreviousButton.getAttribute("class");
        Assert.assertTrue(classes.contains("disabled"));
    }
    public void verifyItemLeftPreviousButtonUnclickable(){
        String classes = itemLeftPreviousButton.getAttribute("class");
        Assert.assertTrue(classes.contains("disabled"));
    }
    public void verifyNextPageButtonUnClickable() {
        BrowserUtils.wait(8);
        String classes = itemNextButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertTrue(isDisabled);
    }
    public void setUniqueCodeElement(String uniqueCode1){
        uniqueCodeElement.sendKeys(uniqueCode1);
    }
}