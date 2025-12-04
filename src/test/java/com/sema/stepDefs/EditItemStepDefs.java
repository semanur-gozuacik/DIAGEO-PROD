package com.sema.stepDefs;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
        BrowserUtils.waitForVisibility(pages.generalPage().getInfoMessage(),20);
        Assert.assertEquals(expectedMessage, pages.generalPage().getInfoMessage().getText());
        BrowserUtils.wait(1);
    }

    @And("the user unassociate the item")
    public void theUserUnassociateTheItem() {
        pages.editItemPage().unassociate(pages);
    }

    @When("The user click import redirect button")
    public void theUserClickImportRedirectButton() {
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
        pages.editItemPage().getAiAssistanceButton().click();
        BrowserUtils.wait(30);
    }

    @Then("The user verify ai modal")
    public void theUserVerifyAiModal() {
        boolean isModalVisible = BrowserUtils.isElementDisplayed(pages.editItemPage().getAiSummaryBody());
        Assert.assertTrue("AI Modalı açılmadı",isModalVisible);

        boolean isAiModalSectionsVisible = pages.editItemPage().getAiSections().size() > 0;
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

    @Given("The user go to edit item {string}")
    public void theUserGoToEditItem(String itemId) {
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
        pages.editItemPage().getFirstYetkiliSelectContainer().click();
        BrowserUtils.wait(10);
        BrowserUtils.selectDropdownOptionByVisibleText(pages.editItemPage().getFirstYetkiliSelect(),option);
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
        pages.editItemPage().getCommentDeleteButton().click();
    }
}
