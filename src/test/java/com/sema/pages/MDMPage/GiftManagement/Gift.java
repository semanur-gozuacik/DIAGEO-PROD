package com.sema.pages.MDMPage.GiftManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Gift extends BasePage {
    @FindBy(xpath = "//ul[@role='group']//ul[@role='group']//i[2]")
    private WebElement testCategories;
    @FindBy(xpath = "//a[@id='31']")
    private WebElement rootCategoriesGift;

    public Gift() {

    }

    public void verifyTestCategories() {
        BrowserUtils.waitForVisibility(testCategories, 20);
        Assert.assertTrue(testCategories.isDisplayed());
    }

    public void clickTestCategories() {
        testCategories.click();
    }

    public void verifyGiftRootCategories(int timeout) {
        BrowserUtils.waitForVisibility(rootCategoriesGift, timeout);
        Assert.assertTrue(rootCategoriesGift.isDisplayed());
    }
}
