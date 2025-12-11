package com.sema.pages;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.Database;
import com.sema.utilities.Pages;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
public class EditItemPage extends BasePage {

    @FindBy(xpath = "//tr/td[3]/div/div/label")
    private List<WebElement> associateCheckBoxes;

    @FindBy(id = "association-table")
    private WebElement associationTable;

    @FindBy(xpath = "//div[@id='saveChangeButton']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[contains(@id,'floatingSaveButton')]")
    private WebElement saveBtnInEditItemSaveModal;

    @FindBy(xpath = "//button[@id='import-redirect']")
    private WebElement importRedirectButton;

    @FindBy(xpath = "//span[@id='ai-assistance']")
    private WebElement aiAssistanceButton;

    @FindBy(xpath = "//div[@class='ai-section']")
    private List<WebElement> aiSections;

    @FindBy(xpath = "//div[contains(@id,'ai-summary-body')]")
    private WebElement aiSummaryBody;

    @FindBy(xpath = "//ul[contains(@class,'preview-tabs')]/li/a")
    private List<WebElement> editItemSubTabs;

    @FindBy(xpath = "//div[@id='preview-nba']/div/ul/li/a")
    private List<WebElement> nbaTabs;

    @FindBy(xpath = "//button[@class='btn-filter-primary comment-add-btn']")
    private WebElement addCommentButton;

    @FindBy(xpath = "//select[@id='comment-type']")
    private WebElement commentTypeSelect;

    @FindBy(xpath = "//button[@id='addCommentBtn']")
    private WebElement commentSaveButton;

    @FindBy(xpath = "//select[@id='send-email-notes']")
    private WebElement firstYetkiliSelect;

    @FindBy(xpath = "//span[@id='select2-send-email-notes-container']")
    private WebElement firstYetkiliSelectContainer;

    @FindBy(xpath = "//select[@id='additional-recipients']")
    private WebElement secondYetkiliSelect;

    @FindBy(xpath = "//button[@id='meeting-note-confirm']")
    private WebElement commentSendButton;

    @FindBy(xpath = "//button[@class='btn-filter-secondary comment-delete-btn']")
    private WebElement commentDeleteButton;

    @FindBy(xpath = "//button[@id='deleteComment']")
    private WebElement lastCommentDeleteButton;

    @FindBy(xpath = "//div[@id='chat-bubble']")
    private WebElement chatBubble;

    @FindBy(xpath = "//input[@id='message-input']")
    private WebElement chatInputBox;

    @FindBy(xpath = "//div[contains(text(),'Kanal Geliştirme Uzmanı')]")
    private WebElement mentionOption;

    @FindBy(xpath = "//div[4]/div[2]/div[3]/button")
    private WebElement chatMsgSubmitButton;

    @FindBy(xpath = "//a[@id='_calendar-tab']")
    private WebElement calendarTab;


    int itemIdToBeAssociated;
    public void selectItemAtOrderInAssociationTab(int assocCheckboxOrder) {
        BrowserUtils.wait(2);
        associateCheckBoxes.get(assocCheckboxOrder - 1).click();
        String itemIdToBeAssociatedText = GeneralPage.getColumnData(associationTable,"Öğe Kimliği").get(0);
        itemIdToBeAssociated = Integer.parseInt(itemIdToBeAssociatedText);
    }

    public int getItemIdFromSKU(String sku) {
        String sql = "SELECT Id FROM TEST_MDM.dbo.Items WHERE SKU = '" + sku + "'";
        try (Connection connection = Database.getInstance();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean getAssociations(String itemCode, String associationTypeCode) {
        int firstItemId = 0;
        int secondItemId = 0;
        int assocType = 0;
        int itemId = getItemIdFromSKU(itemCode);
        if (itemId == -1) {
            System.out.println("Item not found for SKU: " + itemCode);
        }

        String query = "SELECT * FROM TEST_MDM.dbo.Associations a " +
                "WHERE (FirstItemId = ? AND SecondItemId = ?) " +
                "   OR (FirstItemId = ? AND SecondItemId = ?)";

        try (Connection connection = Database.getInstance();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, itemIdToBeAssociated);
            ps.setInt(2, itemId);
            ps.setInt(3, itemId);
            ps.setInt(4, itemIdToBeAssociated);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Association ID: " + rs.getInt("Id"));
                firstItemId = rs.getInt("FirstItemId");
                secondItemId = rs.getInt("SecondItemId");
                assocType = rs.getInt("AssociationTypeId");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("FirstItemId " + firstItemId);
        System.out.println("SecondItemId " + secondItemId);
        System.out.println("AssociationTypeId " + assocType);
        System.out.println(itemIdToBeAssociated);
        return firstItemId != 0 && secondItemId != 0;
    }

    public void unassociate(Pages pages) {
        pages.generalPage().useTextFilter(itemIdToBeAssociated + "","Öğe Kimliği");
    }
}
