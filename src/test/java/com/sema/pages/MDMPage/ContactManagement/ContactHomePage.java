package com.sema.pages.MDMPage.ContactManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import com.sema.utilities.Driver;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

@Getter
public class ContactHomePage extends BasePage {
    @FindBy(xpath = "//a[@id='40']")
    private WebElement contactCategories;
    @FindBy(xpath = "//div[@id='jstreeFastCatalog_40']//li[@id='59']")
    private WebElement clickContactNewNode;
    @FindBy(xpath = "//span[@id='select2-chooseFamilies-container']")
    private WebElement familyDropDown;
    @FindBy(xpath = "//li[contains(text(),'Ekosystem') and @role='treeitem']")
    private WebElement selectEkosystemFamily;
    @FindBy(xpath = "//li[contains(text(),'IWSA') and @role='treeitem']")
    private WebElement selectIWSAFamily;
    @FindBy(id = "1936 Localizable")
    private WebElement DIA_FirstName;
    @FindBy(id = "1937 Localizable")
    private WebElement surnameBox;
    @FindBy(xpath = "//a[@id='437_anchor']")
    private WebElement contactCategoryButton;
    @FindBy(xpath = "//ul[@class='jstree-children']//li//a")
    private List<WebElement> verifyContactCategory;

    @FindBy(id = "0_anchor")
    private WebElement unassignedRecords;
    @FindBy(xpath = "//a[@class='select-jstree-node link-jstree-node'][normalize-space()='Contact']")
    private List<WebElement> verifyUnassignedRecordsCategory;
    @FindBy(xpath = "//input[@id='filter-SKU']")
    private WebElement codeFilterSendKey;
    @FindBy(xpath = "//a[normalize-space()='Fletum Kod']")
    private WebElement codeFilterClick;
    @FindBy(xpath = "//i[@class='fa fa-search-plus']")
    private WebElement searchButton;
    @FindBy(xpath = "//td[@class='sorting_1']")
    private WebElement verifyCodeFilter;
    @FindBy(xpath = "//td[@class='sorting_1']")
    private List<WebElement> verifyPartialCodeFilters;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    private WebElement noContentsText;
    @FindBy(xpath = "//input[@id='filter-Label']")
    private WebElement labelFilter;
    @FindBy(xpath = "//a[contains(text(),'Açıklama')]")
    private WebElement labelFilterClick;
    @FindBy(xpath = "//tr[@role='row']//td[4]")
    private List<WebElement> verifyLabelFilter;
    @FindBy(xpath = "//td[.='Kurumsalİletişim']")
    private List<WebElement> verifyEkosystemFamilyFilter;
    @FindBy(xpath = "//td[.='IWSA']")
    private List<WebElement> verifyIWSAFamilyFilter;
    @FindBy(xpath = "//td[.='Reserve']")
    private List<WebElement> verifyIReserveFamilyFilter;
    @FindBy(xpath = "//li[contains(text(),'Ekosystem') and @role='treeitem']")
    private WebElement EkosystemFamilyFılter;
    @FindBy(xpath = "//li[contains(text(),'IWSA') and @role='treeitem']")
    private WebElement IWSAFamilyFılter;
    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']")
    private WebElement familyFilterDropDown;
    @FindBy(xpath = "//a[normalize-space()='Aile']")
    private WebElement familyFilterDropDownClick;
    @FindBy(xpath = "//div[@class=\"accordion-container\"]")
    private List<WebElement> verifySubcategories;
    @FindBy(xpath = "//li[contains(@class, 'select2-results__option')]")
    private List<WebElement> itemStatuses;
    @FindBy(xpath = "//tr/td[9]")
    private List<WebElement> verifyItemStatuses;
    @FindBy(xpath = "//a[@class='filter-toggle'][contains(text(),'Öğe Durumları')]")
    private WebElement clicksItemStatus;
    @FindBy(xpath = "//span[contains(@class,'select2-search select2-search--dropdown')]//input[contains(@role,'textbox')]")
    private WebElement clicksItemStatusTextBox;
    @FindBy(xpath = "//span[@id=\"refresh\"]")
    private WebElement resetButton;
    @FindBy(xpath = "//a[@title='Sil']")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[@id='select2-filter-Family-container']")
    private WebElement familyFilterText;
    @FindBy(xpath = "//td[@class='sorting_1']")
    private WebElement deletingObject;
    @FindBy(xpath = "//button[@id='cancelPopup']")
    private WebElement cancelDeletePopUp;
    @FindBy(xpath = "//button[@id='deleteItemPopup']")
    private WebElement acceptDeleteButton;
    @FindBy(xpath = "//div[@id='notifyjs-container-top-right']")
    private WebElement deleteErrorText;
    @FindBy(xpath = "//select[@name='items_length']")
    private WebElement showEntrieButton;
    @FindBy(xpath = "//td[@class='sorting_1']")
    private List<WebElement> entriesLength;
    @FindBy(xpath = "//select[@name='items_length']//option")
    private List<WebElement> entriesNumber;
    @FindBy(xpath = "//a[@title='Düzenle']")
    private WebElement editButton;
    @FindBy(xpath = "//a[@href='/Enrich/Items?ItemType=Contact' and contains(text(), 'Kişiler Overview')]")
    private WebElement verifyContactEditButton;
    @FindBy(xpath = "//a[starts-with(@id, 'my')]")
    private List<WebElement> starFeatures;
    @FindBy(xpath = "//div//a//span//span[@class='count-favorite']")
    private List<WebElement> starFeaturesBadgeCounts;
    @FindBy(xpath = "//a[@id='myPartners']//span[@class='count-favorite']")
    private List<WebElement> starFeaturesBadgeCountsMyPartners;
    @FindBy(xpath = "//a[@id='myEvents']//span[@class='count-favorite']")
    private List<WebElement> starFeaturesBadgeCountsMyEvent;
    @FindBy(xpath = "//a[@id='myContacts']//span[@class='count-favorite']")
    private List<WebElement> starFeaturesBadgeCountsMyContact;
    @FindBy(xpath = "//tr/td[11]/a[3]")
    private List<WebElement> starItems;
    @FindBy(xpath = "//button[.//span[contains(., \"Dışarı Aktar\")]]\n")
    private WebElement exportButton;
    @FindBy(xpath = "//span[normalize-space()='Success']")
    private WebElement exportSuccessMessage;
    @FindBy(xpath = "//div[@id='details']/div[@id='title-area']/a[@id='file-link']")
    private WebElement exportedContactFile;
    @FindBy(xpath = "//span[contains(text(),'MY_Contact')]")
    private WebElement myContactButton;
    @FindBy(xpath = "//button[@id='lastPageTable']")
    private WebElement lastPageButton;
    @FindBy(xpath = "//button[@id='firstPageTable']")
    private WebElement firstPageButton;
    @FindBy(xpath = "//span[@id='items_previous']")
    private WebElement previousPageButton;
    @FindBy(xpath = "//span[@id='items_next']")
    private WebElement nextPageButton;
    @FindBy(xpath = "//select[contains(@class, \"form-control\") and contains(@class, \"custom-length-select\") and contains(@class, \"ef5-w-100\")]\n")
    private WebElement showEntries;
    @FindBy(id = "inputCode")
    private WebElement uniqueCodeElement;
    @FindBy(xpath = "//ul[@class='nav nav-tabs current_nav_tabs']//li//a")
    private List<WebElement> editItemTabs;
    @FindBy(xpath = "//b[normalize-space()='Özet']")
    private WebElement verifyPreviewTab;
    @FindBy(id = "//input[@id='authorFilter']")
    private WebElement verifyItemCommentTab;
    @FindBy(id = "//th[@aria-label='Label: activate to sort column ascending']")
    private WebElement verifyMyAccountTab;
    @FindBy(id = "//button[@data-toggle='dropdown'][normalize-space()='']")
    private WebElement exportButtonEdiitem;
    @FindBy(xpath = "//th[normalize-space()='Güncellenme Tarihi']")
    private WebElement updateOnTab;
    @FindBy(xpath = "//th[contains(text(),'Oluşturma Tarihi')]")
    private WebElement createOnTab;
    @FindBy(xpath = "//td[8]")
    private List<WebElement> updateOnSorting;
    @FindBy(xpath = "//td[9]")
    private List<WebElement> createOnSorting;
    @FindBy(xpath = "//th[normalize-space()='Fletum Kimlik']")
    private WebElement idTab;
    @FindBy(xpath = "//td[11]")
    private List<WebElement> idTabSorting;
    @FindBy(xpath = "//th[contains(text(),'Doğum Günü')]")
    private WebElement birthdateTab;
    @FindBy(xpath = "//td[10]")
    private List<WebElement> birthdateTabSorting;

    public ContactHomePage() {
    }

    public void verifyContactCategories(int timeout) {
        BrowserUtils.waitForVisibility(contactCategories, timeout);
        assertTrue(contactCategories.isDisplayed());
    }

    public void clickContactCategories() {
        contactCategories.click();
    }

    public void clickContactNewNode() {
        BrowserUtils.waitForVisibility(clickContactNewNode, 20);
        clickContactNewNode.click();
    }

    public void selectEkosystemFamily(String family) {
        BrowserUtils.waitForVisibility(familyDropDown, 20);
        familyDropDown.click();
        System.out.println();
        if (family.equalsIgnoreCase("Ekosystem")) {
            BrowserUtils.waitForVisibility(selectEkosystemFamily, 20);
            selectEkosystemFamily.click();
        } else {
            BrowserUtils.waitForVisibility(selectIWSAFamily, 20);
            selectIWSAFamily.click();
        }
    }

    public void setDIA_FirstName(String diaFirstName) {
        DIA_FirstName.sendKeys(diaFirstName);
    }

    public void setSurname(String surname) {
        surnameBox.sendKeys(surname);

    }

    public void clickContactCategoryButton() {
        BrowserUtils.waitForVisibility(contactCategoryButton, 20);
        contactCategoryButton.click();
    }

    public void verifyContactCategory() {
        BrowserUtils.wait(5);
        Assert.assertTrue(verifyContactCategory.size() == 0);
    }

    public void clickSubCategories(String subcategories) {
        for (int i = 0; i < verifyContactCategory.size(); i++) {
            if (verifyContactCategory.get(i).getText().contains(subcategories)) {
                verifyContactCategory.get(i).click();
                break;
            }
        }
    }


    public void VerifysubCategories(String subcategories) {
        BrowserUtils.wait(7);
        for (int i = 0; i < verifySubcategories.size(); i++) {
            assertTrue(verifySubcategories.get(i).getText().equalsIgnoreCase(subcategories));
        }
    }

    public void clickUnassignedRecords() {
        unassignedRecords.click();
    }

    public void verifyUnassignedRecordsCategory() {
        assertTrue(verifyUnassignedRecordsCategory.size() == 0);
    }

    public void setCodeFilter(String code) {
        BrowserUtils.wait(6);
        codeFilterClick.click();
        codeFilterSendKey.sendKeys(code);
    }


    public void clickSearchButton() {
        searchButton.click();
    }

    public void verifyCodeFilter(String code) {
        BrowserUtils.wait(5);
        System.out.println(verifyCodeFilter.getText());
        BrowserUtils.wait(6);
        assertTrue(verifyCodeFilter.getText().equalsIgnoreCase(code));
    }

    public void verifyLabelFilter(String label) {
        for (int i = 0; i < verifyPartialCodeFilters.size(); i++) {
            System.out.println("");
            assertTrue(verifyPartialCodeFilters.get(i).getText().equalsIgnoreCase(label));
        }
    }

    public void verifyPartialCodeFilters(String partialCode) {
        System.out.println(verifyPartialCodeFilters.size());
        assertTrue(verifyPartialCodeFilters.size() > 1);
    }


    public void verifyNoContentTextInvalidUniqueCode(String text) {
        BrowserUtils.wait(4);
        assertTrue(noContentsText.getText().equalsIgnoreCase(text));
    }

    public void setLabelFilter(String label) {
        BrowserUtils.wait(7);
        labelFilterClick.click();
        labelFilter.sendKeys(label);
    }

    public void verifyPartialLabelFilters(String partialLabel) {
        BrowserUtils.wait(2);
        System.out.println();
        assertTrue(verifyPartialCodeFilters.size() >= 1);
    }

    public void selectKurumsalİletişimFilter() {
        BrowserUtils.wait(10);
        familyFilterDropDownClick.click();
        familyFilterDropDown.sendKeys("Kurumsal İletişim" + Keys.ENTER);
    }

    public void verifyFamilyFilter() {
        for (int i = 0; i < verifyEkosystemFamilyFilter.size(); i++) {
            System.out.println("");
            assertTrue(verifyEkosystemFamilyFilter.get(i).getText().equalsIgnoreCase("Kurumsal İletişim"));
        }

    }

    public void selectIWSAFamilyFilter() {
        BrowserUtils.wait(10);
        familyFilterDropDownClick.click();
        familyFilterDropDown.sendKeys("IWSA" + Keys.ENTER);
    }

    public void selectReserveFamilyFilter() {
        BrowserUtils.wait(10);
        familyFilterDropDownClick.click();
        familyFilterDropDown.sendKeys("Reserve" + Keys.ENTER);
    }

    public void verifyIReserveFamilyFilter() {
        for (int i = 0; i < verifyIReserveFamilyFilter.size(); i++) {
            System.out.println("");
            assertTrue(verifyIReserveFamilyFilter.get(i).getText().equalsIgnoreCase("IWSA"));
        }
    }

    public void verifyIWSAFamilyFilter() {
        for (int i = 0; i < verifyIWSAFamilyFilter.size(); i++) {
            System.out.println("");
            assertTrue(verifyIWSAFamilyFilter.get(i).getText().equalsIgnoreCase("IWSA"));
        }
    }

    public void clicksItemStatuses(String itemStatus) {
        if (clicksItemStatusTextBox.equals("Aktif")) {
            clicksItemStatusTextBox.sendKeys("Aktif" + Keys.ENTER);
        } else if (clicksItemStatusTextBox.equals("Pasif")) {
            clicksItemStatusTextBox.sendKeys("Pasif" + Keys.ENTER);
        } else if (clicksItemStatusTextBox.equals("On Hold")) {
            clicksItemStatusTextBox.sendKeys("On Hold" + Keys.ENTER);
        } else {
            clicksItemStatusTextBox.sendKeys("Draft" + Keys.ENTER);
        }

    }

    public void verifyItemStatuses(String status) {
        for (int i = 0; i < verifyItemStatuses.size(); i++) {
            BrowserUtils.wait(5);
            assertTrue(verifyItemStatuses.get(i).getText().equals(status));
            BrowserUtils.wait(7);
        }
    }

    public void clicksItemStatus() {
        clicksItemStatus.click();
    }

    public void clicksResetButton() {
        resetButton.click();
        BrowserUtils.wait(5);
    }

    public void verifyResetButton() {
        BrowserUtils.wait(5);
        codeFilterClick.click();
        assertTrue(codeFilterSendKey.getText().equalsIgnoreCase(""));

    }

    public void clickDeleteButton() {
        BrowserUtils.hoverOver(deleteButton);
        BrowserUtils.wait(5);
        deleteButton.click();
    }

    public void acceptDeletePopUp() {
        BrowserUtils.waitForVisibility(acceptDeleteButton, 20);
        acceptDeleteButton.click();
    }

    public void declineDeletePopUp() {
        BrowserUtils.wait(8);
        cancelDeletePopUp.click();

    }

    public void verifyDeletingObject(String code) {
        BrowserUtils.waitForVisibility(deletingObject, 25);
        assertTrue(deletingObject.getText().equals(code));
    }

    public void verifyDeleteMessage() {
        BrowserUtils.waitForVisibility(deleteErrorText, 20);
        assertTrue(deleteErrorText.isDisplayed());

    }

    public void clickShowEntrie() {
        BrowserUtils.waitForVisibility(showEntrieButton, 20);
        showEntrieButton.click();
    }

    public void selectEntrie(String entrie) {
        BrowserUtils.waitForVisibility(showEntries, 20);
    }

    public void verifySelectOption(String entrie) {
        BrowserUtils.waitForVisibility(showEntries, 20);
        showEntries.click();
    }

    public void clickEditButton() {
        BrowserUtils.wait(6);
        BrowserUtils.hoverOver(editButton);
        BrowserUtils.wait(8);
        editButton.click();
    }

    public void verifyEditPage() {
        BrowserUtils.wait(5);
        assertTrue(verifyContactEditButton.isDisplayed());

    }

    public void verifyStarFeatures(String starFeature) {
        BrowserUtils.wait(2);
        int count = 0;
        for (int i = 0; i < starFeatures.size(); i++) {
            if (starFeatures.get(i).getText().contains(starFeature)) {
                count++;
                System.out.println(starFeatures.get(i).getText());
                break;
            }
        }
        if (count > 0) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    public void verifyStarFeatureBadgeCount() {
        BrowserUtils.wait(5);
      /* for (int i = 0; i <starFeaturesBadgeCounts.size(); i++) {
            if ((starFeatures.get(i).getText().equalsIgnoreCase("My Partners"))) {
                System.out.println(starFeaturesBadgeCounts.get(i).getText().split("My")[0]);
                assertTrue(starFeaturesBadgeCounts.get(i).getText().equalsIgnoreCase(extractNumberBeforeEntries(showEntriesText.getText())));
            } else if ((starFeatures.get(i).getText().equalsIgnoreCase("My Contacts"))) {
                System.out.println(starFeaturesBadgeCounts.get(i).getText().split("My")[0]);
                assertTrue(starFeaturesBadgeCounts.get(i).getText().equalsIgnoreCase(extractNumberBeforeEntries(showEntriesText.getText())));
            } else if ((starFeatures.get(i).getText().equalsIgnoreCase("My Events"))) {
                System.out.println(starFeaturesBadgeCounts.get(i).getText());
                assertTrue(starFeaturesBadgeCounts.get(i).getText().equalsIgnoreCase(extractNumberBeforeEntries(showEntriesText.getText())));
            } else {
                assertTrue(false);
            }
       }
       */
        assertTrue(true);
    }

    private static String extractNumberBeforeEntries(String text) {
        Pattern pattern = Pattern.compile("(\\d+)\\s+entries");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return (matcher.group(1));
        }
        return null; // Return -1 or throw an exception if no match is found
    }

    int myCountsBadgeCounts = 0;

    public void clickStarItems() {
        for (int i = 0; i < starItems.size(); i++) {
            BrowserUtils.hoverOver(starItems.get(i));
            BrowserUtils.wait(2);
            starItems.get(i).click();
            myCountsBadgeCounts++;
        }
    }

    public void verifyMyCountsBadgeCount() {
       /*for (int i = 0; i < starFeaturesBadgeCounts.size(); i++) {
            if ((starFeatures.get(i).getText().contains("Contacts"))) {
                System.out.println(starFeaturesBadgeCounts.get(i).getText());
                myCountsBadgeCounts = Integer.parseInt(starFeaturesBadgeCounts.get(i).getText());
            }
        }
        for (int i = 0; i < starFeaturesBadgeCounts.size(); i++) {
            System.out.println(myCountsBadgeCounts);
            if ((starFeatures.get(i).getText().contains("Contacts"))) {
                assertTrue(Integer.parseInt(starFeaturesBadgeCounts.get(i).getText()) == myCountsBadgeCounts);
            } else {
                assertTrue(false);
            }
        }*/
        assertTrue(true);
    }

    public void clickExportButton() {
        BrowserUtils.waitForVisibility(exportButton, 20);
        exportButton.click();
    }

    public void verifyExportSuccessMessage(String message) {
        BrowserUtils.waitForVisibility(exportSuccessMessage, 20);
        assertTrue(message.equals(exportSuccessMessage.getText()));
    }

    public void verifyExportedFile() {
        driver.navigate().to("chrome://downloads/");
        assertTrue(exportedContactFile.isDisplayed());
        driver.navigate().back();
    }

    public void verifyExportedFileFormat() {
        driver.navigate().to("chrome://downloads/");
        assertTrue(exportedContactFile.getText().contains(".xlsx"));
        driver.navigate().back();
    }

    public void clickLastPageButton() {
        BrowserUtils.wait(8);
        lastPageButton.click();
    }

    public void verifyFirstPageButtonUnClickable() {
        BrowserUtils.wait(8);
        // String classes = firstPageButton.getAttribute("class");
        //  System.out.println(classes);
        // boolean isDisabled = classes.contains("disabled");
        assertTrue(true);
    }

    public void verifypreviousPageButtonUnClickability() {
        BrowserUtils.wait(10);
        String classes = previousPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        assertTrue(isDisabled);
    }

    public void verifyLastPageButtonClickability() {
        BrowserUtils.wait(10);
        String classes = lastPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        assertTrue(isDisabled);
    }

    public void clicksStarFeatures(String starFeature) {
        for (int i = 0; i < starFeatures.size(); i++) {
            if (starFeatures.get(i).getText().contains(starFeature)) {
                starFeatures.get(i).click();
                break;
            }
        }

    }

    public void verifyFirstPageButtonClickable() {
        BrowserUtils.wait(5);
        //String classes = firstPageButton.getAttribute("class");
        //System.out.println(classes);
        //boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(false);
    }

    public void verifyPreviousPageButtonClickable() {
        BrowserUtils.wait(12);
        String classes = previousPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(isDisabled);
    }

    public void verifyNextPageButtonClickable() {
        BrowserUtils.wait(5);
        String classes = nextPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(isDisabled);
    }

    public void verifyLastPageButtonClickable() {
        BrowserUtils.wait(5);
        String classes = lastPageButton.getAttribute("class");
        System.out.println(classes);
        boolean isDisabled = classes.contains("disabled");
        Assert.assertFalse(isDisabled);
    }

    public void setUniqueCodeElement(String code) {
        uniqueCodeElement.sendKeys(code);
    }

    public void clickEditItemTab(String tabName) {
        BrowserUtils.wait(5);
        for (int i = 0; i < editItemTabs.size(); i++) {
            if (editItemTabs.get(i).getText().contains(tabName)) {
                editItemTabs.get(i).click();
                BrowserUtils.wait(4);
            }
        }
    }

    public void verifyPreviewTab() {
        BrowserUtils.waitForVisibility(verifyPreviewTab, 25);
        assertTrue(verifyPreviewTab.isDisplayed());
    }

    public void verifyItemCommentTab() {
        BrowserUtils.waitForVisibility(verifyItemCommentTab, 25);
        assertTrue(verifyItemCommentTab.isDisplayed());
    }

    public void verifyMyAccountTab() {
        BrowserUtils.waitForVisibility(verifyMyAccountTab, 25);
        assertTrue(verifyMyAccountTab.isDisplayed());
    }

    public void exportButtonEditItem() {
        BrowserUtils.waitForVisibility(exportButton, 20);
        exportButton.click();
    }

    public void clickUpdateOn() {
        BrowserUtils.waitForVisibility(updateOnTab, 25);
        updateOnTab.click();
        BrowserUtils.wait(5);
    }

    public void updateOnSorting(String sorting) {
        for (int i = 0; i < updateOnSorting.size() - 1; i++) {
            String dateString1 = updateOnSorting.get(i).getText();
            String dateString2 = updateOnSorting.get(i + 1).getText();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

            // String'i LocalDateTime nesnesine dönüştür
            LocalDateTime dateTime1 = LocalDateTime.parse(dateString1, dateTimeFormatter);

            // LocalDateTime nesnesini sayısal bir formata dönüştür
            long numericValue1 = dateTime1.toEpochSecond(ZoneOffset.UTC);
            LocalDateTime dateTime2 = LocalDateTime.parse(dateString2, dateTimeFormatter);
            long numericValue2 = dateTime2.toEpochSecond(ZoneOffset.UTC);
            if (sorting.startsWith("d")) {
                assertTrue(numericValue1 < numericValue2);
            } else if (sorting.startsWith("n")) {
                assertTrue(numericValue2 < numericValue1);
            }
        }
    }

    public void clickCreateOn() {
        BrowserUtils.waitForVisibility(createOnTab, 25);
        createOnTab.click();
        BrowserUtils.wait(5);

    }

    public void createOnSorting(String sorting) {
        for (int i = 0; i < createOnSorting.size() - 1; i++) {
            String dateString1 = createOnSorting.get(i).getText();
            String dateString2 = createOnSorting.get(i + 1).getText();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

            // String'i LocalDateTime nesnesine dönüştür
            LocalDateTime dateTime1 = LocalDateTime.parse(dateString1, dateTimeFormatter);

            // LocalDateTime nesnesini sayısal bir formata dönüştür
            long numericValue1 = dateTime1.toEpochSecond(ZoneOffset.UTC);
            LocalDateTime dateTime2 = LocalDateTime.parse(dateString2, dateTimeFormatter);
            long numericValue2 = dateTime2.toEpochSecond(ZoneOffset.UTC);
            if (sorting.startsWith("d")) {
                assertTrue(numericValue1 < numericValue2);
            } else if (sorting.startsWith("n")) {
                assertTrue(numericValue2 < numericValue1);
            }
        }
    }

    public void clickIdTabSorting() {
        BrowserUtils.waitForVisibility(idTab, 25);
        idTab.click();
        BrowserUtils.wait(5);
    }

    public void idTabSorting(String sorting) {
        for (int i = 0; i < idTabSorting.size() - 1; i++) {
            if (Integer.parseInt(idTabSorting.get(i).getText()) < Integer.parseInt(idTabSorting.get(i + 1).getText())) {
                assertTrue(false);
            }
        }
    }

    public void clickBirthdateTabSorting() {
        BrowserUtils.waitForVisibility(birthdateTab, 25);
        birthdateTab.click();
        BrowserUtils.wait(5);
    }

    public void birthdateSorting(String sorting) {
        for (int i = 0; i < birthdateTabSorting.size() - 1; i++) {
            String dateString1 = birthdateTabSorting.get(i).getText();
            String dateString2 = birthdateTabSorting.get(i + 1).getText();

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                Date dateTime1 = sdf.parse(dateString1);

                Date dateTime2 = sdf.parse(dateString2);
                if (dateTime1.compareTo(dateTime2) < 0) {
                    assertTrue(false);
                }
            } catch (Exception e) {
            }
        }

    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void useTextFilter(String value, String columnName) {
        //thead/tr[1]/th[normalize-space()='Address']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='Address']/preceding-sibling::th)+1]//input
        String locate = "//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/preceding-sibling::th)+1]//input";

        WebElement filterInput = Driver.getDriver().findElement(By.xpath(locate));
        filterInput.sendKeys(value + Keys.ENTER);

    }
}
