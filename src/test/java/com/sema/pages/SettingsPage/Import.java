package com.sema.pages.SettingsPage;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Import extends BasePage {
@FindBy(xpath = "//button[normalize-space()='OK']")
private WebElement popUpElement;
    @FindBy(xpath = "//a[normalize-space()='Import Overview']")
    private WebElement importPageVerificationsElement;
    public void onTheImportSettingPage(){
        driver.navigate().to("https://sandbox.efectura.com/Import");
    }
    public void setPopUpElement(){
        popUpElement.click();
    }
    public void verifyImportPage(){
        BrowserUtils.waitForVisibility(importPageVerificationsElement,20);
        Assert.assertTrue(importPageVerificationsElement.isDisplayed());
    }

}
