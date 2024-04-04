package com.sema.pages.SettingsPage;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Attributes extends BasePage {
    @FindBy(id="attributesid")
    private WebElement attributesElement;
    @FindBy(xpath="//a[normalize-space()='Attributes Overview']")
    private WebElement attrbutesPageVerificationsElement;
    @FindBy(xpath="//a[@title='Edit Attribute']")
    private WebElement editButton;
    @FindBy(name = "attributes_table_length")
    private WebElement entrieNumber;
    public Attributes() {
    }
    public void clickAttributeElement(){
        BrowserUtils.waitForVisibility(attributesElement,20);
        attributesElement.click();
    }
    public void verifyFamilyPage(){
        BrowserUtils.waitForVisibility(attrbutesPageVerificationsElement,25);
        Assert.assertTrue(attrbutesPageVerificationsElement.isDisplayed());
    }
    public void clickEditButton() {
        BrowserUtils.wait(6);
        editButton.click();
    }
    public void selectEntrie(String entrie){
        BrowserUtils.selectOption(entrieNumber,entrie);
    }
    public void verifySelectOption(String entrie){
        BrowserUtils.wait(5);
        Assert.assertTrue(BrowserUtils.isOptionSelected(entrieNumber, entrie));

    }
    public void onTheAttributeSettingPage(){
        driver.navigate().to("https://sandbox.efectura.com/Settings/Attributes");
    }
}
