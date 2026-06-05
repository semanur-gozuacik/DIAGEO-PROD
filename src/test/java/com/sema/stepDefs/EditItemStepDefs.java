package com.sema.stepDefs;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.ConfigurationReader;
import com.sema.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class EditItemStepDefs extends BaseStep {
    WebDriver driver = Driver.getDriver();

    @And("The user select item at order {int} in association tab")
    public void theUserSelectItemAtOrderInAssociationTab(int assocCheckboxOrder) {
        pages.editItemPage().selectItemAtOrderInAssociationTab(assocCheckboxOrder);
    }

    @And("The user clicks save button in edit item")
    public void theUserClicksSaveButtonInEditItem() {
//        pages.editItemPage().getAccordionButton().click();
        BrowserUtils.waitForVisibility(pages.editItemPage().getSaveButton(),10);
        pages.editItemPage().getSaveButton().click();
    }

    @And("The user clicks save button in edit item save modal")
    public void theUserClicksSaveButtonInEditItemSaveModal() {
        pages.editItemPage().getSaveBtnInEditItemSaveModal().click();
    }

    @Then("The user verifies info {string} appears")
    public void theUserVerifiesInfoAppears(String expectedMessage) {
        BrowserUtils.wait(1);
        BrowserUtils.waitForVisibility(pages.generalPage().getInfoMessage(),60);
        Assert.assertEquals(expectedMessage, pages.generalPage().getInfoMessage().getText());
        BrowserUtils.wait(1);
    }

    @And("the user unassociate the item")
    public void theUserUnassociateTheItem() {
        pages.editItemPage().unassociate(pages);
    }

    @When("The user click import redirect button")
    public void theUserClickImportRedirectButton() {
        BrowserUtils.wait(1);
        Driver.getDriver().findElement(By.xpath("//button[@id='rightSidebarToggleBtn']")).click();
        BrowserUtils.wait(1);
        pages.editItemPage().getImportRedirectButton().click();
        BrowserUtils.wait(1);
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: İçe aktarım");
        BrowserUtils.wait(1);
        System.out.println("Title: " + Driver.getDriver().getTitle());

    }

    @Then("The user verify import page is open")
    public void theUserVerifyImportPageIsOpen() {
        Assert.assertEquals("Import Sayfası açılmadı",
                "https://diageo.efectura.com/Import", Driver.getDriver().getCurrentUrl());
    }

    @Given("The user go to edit item")
    public void theUserGoToEditItem() {
        Driver.getDriver().get("https://diageo.efectura.com/Enrich/EditItem/2451749");
        BrowserUtils.wait(3);
    }

    @When("The user click ai button")
    public void theUserClickAiButton() {
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        pages.editItemPage().getAiAssistanceButton().click();
        BrowserUtils.wait(49);
    }

    @Then("The user verify ai modal")
    public void theUserVerifyAiModal() {
        boolean isModalVisible = BrowserUtils.isElementDisplayed(pages.editItemPage().getAiSummaryBody());
        Assert.assertTrue("AI Modalı açılmadı",isModalVisible);

//        boolean isAiModalSectionsVisible = pages.editItemPage().getAiSections().size() > 0;
        boolean isAiModalSectionsVisible = Driver.getDriver().
                findElements(By.xpath("//div[contains(@id,'ai-summary-body')]/div/h2")).size() > 0;
        Assert.assertTrue("AI Modal bölümleri gelmedi",isAiModalSectionsVisible);

    }

    @When("The user click {string} tab")
    public void theUserClickNBATab(String tabName) {
        pages.editItemPage().getEditItemSubTabs().stream()
                .filter(el -> el.getText().trim().contains(tabName))
                .findFirst()
                .ifPresent(WebElement::click);
    }


    String testChatId = ConfigurationReader.getProperty("chatId");
    @When("The user take screenshot")
    public void theUserTakeScreenshot() {
//        BrowserUtils.setZoom(Driver.getDriver(),60);

        BrowserUtils.adjustScreenSize(50,Driver.getDriver());
//        String testChatId = "-5097889346";
        BrowserUtils.wait(20);
        String path = BrowserUtils.getScreenshot("Tamamlayıcı Ürün");
        System.out.println("Path: " + path);
        BrowserUtils.sendFileToTelegram(path,testChatId);

//        Driver.getDriver().switchTo().frame(pages.formsPage().getCardReportDashboard());
//        Driver.getDriver().switchTo().frame(0);

        for (int i = 1; i < 5; i++) {
            pages.editItemPage().getNbaTabs().get(i).click();
            BrowserUtils.wait(4);

            path = BrowserUtils.getScreenshot(pages.editItemPage().getNbaTabs().get(i).getText());
            System.out.println("Path: " + path);
            BrowserUtils.sendFileToTelegram(path,testChatId);

        }


        Driver.getDriver().switchTo().parentFrame(); // içten dışa
        Driver.getDriver().switchTo().defaultContent();


    }

    String chatItemId;
    @Given("The user go to edit item {string}")
    public void theUserGoToEditItem(String itemId) {
        chatItemId = itemId;
        Driver.getDriver().get("https://diageo.efectura.com/Enrich/EditItem/" + itemId);
        BrowserUtils.wait(2);
    }

    @When("The user click add comment button")
    public void theUserClickAddCommentButton() {
        pages.editItemPage().getAddCommentButton().click();
    }

    @When("The user select comment type {string}")
    public void theUserSelectCommentType(String commentType) {
        BrowserUtils.wait(2);
        BrowserUtils.selectDropdownOptionByVisibleText(pages.editItemPage().getCommentTypeSelect(),commentType);
        BrowserUtils.wait(18);
        pages.editItemPage().getCommentSaveButton().click();
        BrowserUtils.wait(2);
    }

    @When("The user select first yetkili option {string}")
    public void theUserSelectFirstYetkiliOption(String option) {
        BrowserUtils.wait(2);
        pages.editItemPage().getFirstYetkiliSelectContainer().click();
        BrowserUtils.wait(12);
        Driver.getDriver().findElement(By.xpath("//li[contains(.,'999999999')]")).click();
//        BrowserUtils.selectDropdownOptionByVisibleText(pages.editItemPage().getFirstYetkiliSelect(),option);
    }

    @When("The user select second yetkili option {string}")
    public void theUserSelectSecondYetkiliOption(String option) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.editItemPage().getSecondYetkiliSelect(),option);
    }

    @When("The user click send comment button")
    public void theUserClickSendCommentButton() {
        pages.editItemPage().getCommentSendButton().click();
    }

    @Then("The user delete the comment")
    public void theUserDeleteTheComment() {
        BrowserUtils.wait(2);
        pages.editItemPage().getCommentDeleteButton().click();
        BrowserUtils.wait(1);
        Driver.getDriver().findElement(By.xpath("//button[@id='deleteComment']")).click();
    }

    String uniqueChatValue;
    @When("The user mention {string} in chat")
    public void theUserMentionInChat(String mentionValue) {
        BrowserUtils.wait(3);
        uniqueChatValue = UUID.randomUUID().toString();
        System.out.println("uniqueChatValue: " + uniqueChatValue);
        pages.editItemPage().getChatBubble().click();

        for (int i = 0; i < mentionValue.length(); i++) {
            pages.editItemPage().getChatInputBox().sendKeys(mentionValue.charAt(i) + "");
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(20);
        pages.editItemPage().getMentionOption().click();
        pages.editItemPage().getChatInputBox().sendKeys(" " + uniqueChatValue);
        pages.editItemPage().getChatMsgSubmitButton().click();
    }


    int notificationIndex;
    @When("The user verify notification")
    public void theUserVerifyNotification() {
        pages.generalPage().getNotificationIcon().click();
        BrowserUtils.wait(3);

        System.out.println(pages.generalPage().getNotificationValues());

        for (WebElement value : pages.generalPage().getNotificationValues()) {
            System.out.println(value.getText());
        }

        boolean contains = pages.generalPage().getNotificationValues().stream()
                .anyMatch(e -> e.getText().contains(uniqueChatValue.substring(0,15)));

        Assert.assertTrue("Notification gelmedi",contains);

        notificationIndex = -1;
        for (int i = 0; i < pages.generalPage().getNotificationValues().size(); i++) {
            if (pages.generalPage().getNotificationValues().get(i).getText().contains(uniqueChatValue.substring(0,15))) {
                notificationIndex = i;
                break;
            }
        }
        System.out.println("İçeren elemanın index'i: " + notificationIndex);

    }

    @When("The user verify link")
    public void theUserVerifyLink() {
        pages.generalPage().getMentionLinks().get(notificationIndex).click();
        BrowserUtils.wait(5);
        String navigatedItemId = Driver.getDriver().getCurrentUrl().split("/")[5];

        Assert.assertEquals("Link yönlendirmesi yanlış",chatItemId,navigatedItemId.split("\\?")[0]);

    }

    @When("The user click nba ai button")
    public void theUserClickNbaAiButton() {
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        pages.editItemPage().getNbaAiAssistanceButton().click();
        BrowserUtils.wait(49);
    }

    @When("The user clicks {string} attribute group")
    public void theUserClicksAttributeGroup(String attrGroup) {
        BrowserUtils.adjustScreenSize(55,Driver.getDriver());
        pages.editItemPage().clickAttributeGroup(attrGroup);
    }

    @When("The user click {string} attribute header")
    public void theUserClickAttributeHeader(String attributeHeader) {
        driver.findElement(By.xpath("//a[contains(text(),'" + attributeHeader + "')]")).click();
        BrowserUtils.wait(2);
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: Özellik Düzenle");
    }

    @Then("The user verifies {string} attribute edit page is open")
    public void theUserVerifiesAttributeEditPageIsOpen(String attributeName) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://diageo.efectura.com/Settings/EditAttribute/4542"));
        Assert.assertTrue(currentUrl.contains("4542"));
        WebElement pageInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/nav/a[4]"));
        Assert.assertTrue(pageInfo.getText().contains(attributeName));
    }

    @Given("The user go to BackupPage")
    public void theUserGoToBackupPage() {
        Driver.getDriver().get("https://diageo.efectura.com/Reports/BackupPage");
    }

    @When("The user select table {string}")
    public void theUserSelectTable(String option) {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"renderBodyWrap\"]/div[2]/div/span/span[1]/span/span[2]")).click();
        BrowserUtils.wait(1);
        WebElement select = Driver.getDriver().findElement(By.xpath("//select[@id='dropdownBackupTables']"));

        BrowserUtils.selectDropdownOptionByVisibleText(select,option);
        BrowserUtils.wait(3);

    }

    @When("The user go to user manage page")
    public void theUserGoToUserManagePage() {
        driver.get("https://diageo.efectura.com/UserManage");
    }

    @When("The user impersonate {string}")
    public void theUserImpersonate(String userName) {
        driver.findElement(By.xpath("//tr/td[2][text()='" + userName + "']")).click();
        BrowserUtils.waitForVisibility(pages.generalPage().impersonateHoverBtn, 30);
        BrowserUtils.hoverOver(pages.generalPage().impersonateHoverBtn);
        pages.generalPage().impersonateButton.click();
        BrowserUtils.wait(3);
    }

    @When("The user search in global search {string}")
    public void theUserSearchInGlobalSearch(String searchInput) {
        driver.findElement(By.xpath("//input[@id='globalSearchInput']")).sendKeys(searchInput);
        BrowserUtils.wait(3);
    }

    @Then("The user verify no result")
    public void theUserVerifyNoResult() {
        boolean isNoResultTextVisible = BrowserUtils.isElementDisplayed(By.xpath("//*[@id=\"searchEmpty\"]/div"));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"searchEmpty\"]/div")).getText());
        Assert.assertTrue("No Result Text gelmedi",isNoResultTextVisible);
        Assert.assertEquals("Sonuç bulunamadı", driver.findElement(By.xpath("//*[@id=\"searchEmpty\"]/div")).getText());
    }

    @And("The user click columns button")
    public void theUserClickColumnsButton() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(pages.itemOverviewPage().getConfigureColumnsButton(),20);
        pages.itemOverviewPage().getConfigureColumnsButton().click();
        BrowserUtils.wait(3);
//        pages.userHomePage().columnsButton();
    }

    String removedColumn;
    @When("The user remove one column")
    public void theUserRemoveOneColumn() {
        for (WebElement column : pages.itemOverviewPage().getAlreadySelectedColumns()) {
            if (!column.getAttribute("class").contains("item-default-columns")) {
                BrowserUtils.dragAndDrop(column, pages.itemOverviewPage().getToBeSelectedArea());
                BrowserUtils.wait(3);
                removedColumn = column.getText();
                System.out.println("Removed Column: " + removedColumn);
                break;
            }
        }
    }

    @And("The user add the removed column")
    public void theUserAddTheRemovedColumn() {
        BrowserUtils.wait(2);
        WebElement matchingElement = pages.itemOverviewPage().getToBeSelectedColumns().stream()
                .filter(el -> el.getText().trim().equalsIgnoreCase(removedColumn))
                .findFirst()
                .orElse(null);

        BrowserUtils.dragAndDrop(matchingElement, pages.itemOverviewPage().getAlreadySelectedColumns().get(0));
        BrowserUtils.wait(1);
    }

    @And("The user clicks overview save button")
    public void theUserClicksOverviewSaveButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='EfSaveColumns']")).click();
        BrowserUtils.wait(4);
    }

}
