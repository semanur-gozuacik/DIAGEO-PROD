package com.sema.pages.MDMPage.EventManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Getter
public class EventHomePage extends BasePage {
    @FindBy(xpath = "//li[contains(text(),'WSET') and @role='treeitem']")
    private WebElement WSETFamilyFılter;
    @FindBy(xpath = "(//span[@class='select2-selection__arrow' and @role='presentation'])[2]")
    private WebElement familyFilterDropDown;
    @FindBy(xpath = "//td[.='WSET']")
    private List<WebElement> verifyWSETFamilyFilter;
    @FindBy (xpath = "//a[normalize-space()='testttsema']")
    private WebElement editListItem;
    @FindBy (xpath = "//select[@id='filter-IsAssociated']")
    private WebElement associatedStatus;

    @FindBy(xpath = "//a[@id='event-calendar-tab']")
    private WebElement calendarTab;

    @FindBy(xpath = "//div[@id='calendar-container']")
    private WebElement calendarContainer;

    @FindBy(xpath = "//iframe[contains(@src,'https://dia-dashboard.efectura.com/embedded/')]")
    private WebElement eventCalendarIframe;

    public EventHomePage() {
    }
    public void selectIWSAFamilyFilter() {
        BrowserUtils.wait(10);
        familyFilterDropDown.click();
        BrowserUtils.wait(10);
        WSETFamilyFılter.click();
    }
    public void verifyWSETFamilyFilter() {
        for (int i = 0; i < verifyWSETFamilyFilter.size(); i++) {
            System.out.println("");
            assertTrue(verifyWSETFamilyFilter.get(i).getText().equalsIgnoreCase("WSET"));
        }
    }public void onTheEventPage(){
        driver.navigate().to("https://diageo.efectura.com/Enrich/Items?itemType=Event");
    }
    public void clickListItem() {
        BrowserUtils.wait(10);
        editListItem.click();
    }
    public void selectAssociatedFilter(String status){
        BrowserUtils.wait(5);
        associatedStatus.click();
        BrowserUtils.selectOption(associatedStatus,status);

    }

}