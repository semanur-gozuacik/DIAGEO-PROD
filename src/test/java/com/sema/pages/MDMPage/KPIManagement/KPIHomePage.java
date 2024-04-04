package com.sema.pages.MDMPage.KPIManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KPIHomePage extends BasePage {
    @FindBy(xpath = "//i[@class='jstree-icon jstree-checkbox']")
    private WebElement ROOTElement;
    @FindBy(xpath = "//span[@id='select2-chooseFamilies-container']")

    private WebElement familyDropDown;
    @FindBy(xpath = "//li[contains(text(),'KPI') and @role='treeitem']")

    private WebElement familyKPI;


    public KPIHomePage() {
    }

    public void clickRootElement() {
        BrowserUtils.waitForVisibility(ROOTElement, 20);
        ROOTElement.click();
    }

    public void selectKPIFamily(String family) {
        BrowserUtils.waitForVisibility(familyDropDown, 20);
        familyDropDown.click();
        BrowserUtils.waitForVisibility(familyKPI, 20);
        familyKPI.click();
    }
    public void selectKPIFamily(){
        BrowserUtils.wait(5);
        if(familyKPI.isEnabled());
    }
    public void onTheKPIPage(){
        driver.navigate().to("https://sandbox.efectura.com/Enrich/Items?itemType=KPI");
    }
}


