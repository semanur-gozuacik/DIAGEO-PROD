package com.sema.stepDefs;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class EditItemStepDefs extends BaseStep {

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


    @When("The user take screenshot")
    public void theUserTakeScreenshot() {
//        BrowserUtils.setZoom(Driver.getDriver(),60);

        BrowserUtils.adjustScreenSize(50,Driver.getDriver());
        String testChatId = "-1002156506449";
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

    @When("The user verify created event edit page is open")
    public void theUserVerifyCreatedEventEditPageIsOpen() {
        BrowserUtils.wait(10);
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("https://diageo.efectura.com/Enrich/EditItem/"));
    }
}
