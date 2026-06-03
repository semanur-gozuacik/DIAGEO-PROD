package com.sema.pages;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.ConfigurationReader;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ItemOverviewPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'accordion-container')]")
    private WebElement accordionContainer;

    @FindBy(xpath = "//div[contains(@class,'category-accordion')]")
    private WebElement overviewSideAccordion;

    @FindBy(xpath = "//li[contains(@class,'is-selected')]/div[2]")
    private List<WebElement> selectedExportOptions;

    @FindBy(xpath = "//div/div/div[3]/div[2]/div/div[2]")
    List<WebElement> createItemFamilies;

    @FindBy(xpath = "//button[@id='configure-columns']")
    private WebElement configureColumnsButton;

    @FindBy(xpath = "//button[@id='cancelColumn']")
    private WebElement columnsCancelButton;

    @FindBy(xpath = "//button[@id='EfSaveColumns']")
    private WebElement columnsSaveButton;

    @FindBy(xpath = "//ul[@id='sortable2']/li")
    private List<WebElement> alreadySelectedColumns;

    @FindBy(xpath = "//ul[contains(@id,'sortableAssociation2')]/li")
    private List<WebElement> alreadySelectedAssocColumns;

    @FindBy(xpath = "//ul[@id='sortableAssociation2']")
    private WebElement alreadySelectedAssocArea;

    @FindBy(xpath = "//ul[@id='sortable1']/li")
    private List<WebElement> toBeSelectedColumns;

    @FindBy(xpath = "//ul[@id='sortableAssociation']/li")
    private List<WebElement> toBeSelectedAssocColumns;

    @FindBy(xpath = "//ul[@id='atg-list']/li")
    private List<WebElement> columnSelectAttributeGroups;

    @FindBy(xpath = "//ul[@id='sortable1']")
    private WebElement toBeSelectedArea;

    @FindBy(xpath = "//ul[@id='sortableAssociation']")
    private WebElement toBeSelectedAssocArea;

    public void goToItemOverviewPage(String item) {
        driver.get(ConfigurationReader.getProperty("itemLinkWithoutItemName") + item);
    }

    public void closeSideAccordionInOverview() {
        boolean isSidebarOpen = BrowserUtils.isElementDisplayed(accordionContainer);
        if (isSidebarOpen) {
            overviewSideAccordion.click();
        }
    }

}
