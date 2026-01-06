package com.sema.stepDefs;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import com.sema.utilities.ConfigurationReader;
import com.sema.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.sema.utilities.CommonExcelReader.getExcelPath;

public class GeneralStepDefs extends BaseStep {

    @Then("The user verify {string} text filter with value {string} in {string}")
    public void theUserVerifyTextFilterWithValueIn(String columnName, String expectedValue, String table) {
        BrowserUtils.wait(2);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(table)));
        List<String> values =  BasePage.getColumnData(tableElement,columnName);

        System.out.println(values);
        BrowserUtils.wait(2);
        for (String actualValue : values) {
            Assert.assertTrue(actualValue.toLowerCase().contains(expectedValue.toLowerCase()));
//            Assert.assertEquals(expectedValue,actualValue);
        }
    }

    @And("The user enters {string} into {string} filter text input box")
    public void theUserEntersIntoFilterTextInputBox(String value, String columnName) {
        pages.generalPage().useTextFilter(value,columnName);
        BrowserUtils.wait(7);
    }

    @And("The user reset the basic filters")
    public void theUserResetTheBasicFilters() {
        BrowserUtils.wait(10);
        BrowserUtils.waitForClickability(pages.generalPage().getBasicResetButton(),20);
        pages.generalPage().getBasicResetButton().click();
        BrowserUtils.wait(15);
    }

    @When("The user go to {string} overview page")
    public void theUserGoToAccountOverviewPage(String item) {
        pages.itemOverviewPage().goToItemOverviewPage(item);
    }

    @Then("The user verify {string} table is visible")
    public void theUserVerifyTableTableIsVisible(String tableName) {
        System.out.println("tableName " + tableName);
        Assert.assertTrue(tableName + "tablosu Bulunamadı",
                BrowserUtils.isElementDisplayed
                        (Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(tableName)))));
    }

    @And("The user clicks on edit button in table")
    public void theUserClicksOnEditButtonInTable() {

        pages.itemOverviewPage().closeSideAccordionInOverview();
        BrowserUtils.wait(3);
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        BrowserUtils.hoverOver(pages.generalPage().getEditBtnInTable());
        BrowserUtils.wait(2);
        pages.generalPage().getEditBtnInTable().click();
    }

    @And("The user select {string} in {string} select filter")
    public void theUserSelectInSelectFilter(String selectOption, String selectFilter) {
        BrowserUtils.adjustScreenSize(70,Driver.getDriver());
        pages.generalPage().selectOptionInSelectFilter(selectOption,selectFilter);
        BrowserUtils.wait(5);
    }

    @Then("The user verify that first item with code {string} has association on {string}")
    public void theUserVerifyThatFirstItemWithCodeHasAssociationOn(String itemCode, String associationTypeCode) throws SQLException {
        BrowserUtils.wait(2);
        Assert.assertTrue(pages.editItemPage().getAssociations(itemCode,associationTypeCode));
    }

    @Given("The user go to Reports page")
    public void theUserGoToReportsPage() {
        Driver.getDriver().get("https://diageo.efectura.com/Reports");
    }

    @Given("The user go to Imports page")
    public void theUserGoToImportsPage() {
        Driver.getDriver().get("https://diageo.efectura.com/Import");
    }

    @Given("The user go to DB module page")
    public void theUserGoToDBModulePage() {
        Driver.getDriver().get("https://diageo.efectura.com/Settings/DBModuleMonitor");
    }

    @Given("The user go to Jobs page")
    public void theUserGoToJobsPage() {
        Driver.getDriver().get("https://diageo.efectura.com/Job/Jobs");
    }

    @Then("The user verify job page is open")
    public void theUserVerifyJobPageIsOpen() {
        Driver.getDriver().switchTo().frame(pages.generalPage().getJobsFrame());

        Assert.assertTrue("Jobs sayfası yüklenmedi",
                BrowserUtils.isElementDisplayed(pages.generalPage().getJobsHeader()));
    }

    @Given("the user go in the item {string}")
    public void theUserGoInTheItem(String itemId) {
        Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + itemId);
    }

    @When("The user go to ReportCardAnalysis page")
    public void theUserGoToReportCardAnalysisPage() {
        Driver.getDriver().get("https://diageo.efectura.com/Enrich/ReportCardAnalysis");
        BrowserUtils.wait(4);
    }

    @Then("The user verify table is displayed")
    public void theUserVerifyTableIsDisplayed() {
        Driver.getDriver().switchTo().frame(pages.generalPage().getReportCardAnalysisMainFrame());
        Driver.getDriver().switchTo().frame(pages.generalPage().getReportCardAnalysisSecondFrame());
        BrowserUtils.wait(2);
        Assert.assertTrue("ReportCardAnalysis table is not displayed",
                BrowserUtils.isElementDisplayed(pages.generalPage().getCardAnalysisTable()));
    }

    @When("The user go to reserve karne")
    public void theUserGoToReserveKarne() {
        Driver.getDriver().get("https://diageo.efectura.com:8112/KarnePilotReserve.html?token=pAGPE6qyyq10hb0XLUdPNJ70WSZjDRtOYnH42kH5z9q0nhSNA5xpU76AqyDk5lZIE%2fBDXVSMg50tLkJbxkqzCfB%2bE34nZM6lipTO%2bzxThXXh6VxUocLQgp5TDFQcuDHq3eBs4%2f6sxSrBHIrGoRn%2blm7eFYJSsR%2biXPY4fZr4UI8%3d&bolge=Reserve%20Ege");

    }

    @Then("The user verify reserve karne")
    public void theUserVerifyReserveKarne() {
        Assert.assertTrue("Reserve Karne İçeriği Bulunamadı",
                BrowserUtils.isElementDisplayed(Driver.getDriver().findElement(By.xpath("//div[@id='myTabContent']"))));
    }

    @When("The user impersonate Enis")
    public void theUserImpersonateEnis() {
        Driver.getDriver().get("https://diageo.efectura.com/UserManage/Edit/1812e8c5-a9f8-40c5-8f42-2aab632bf8d9");
        BrowserUtils.waitForVisibility(pages.generalPage().impersonateHoverBtn, 30);
        BrowserUtils.hoverOver(pages.generalPage().impersonateHoverBtn);
        pages.generalPage().impersonateButton.click();
        BrowserUtils.wait(3);
    }

    @Given("The user go to User Manage page")
    public void theUserGoToUserManagePage() {
        Driver.getDriver().get("https://diageo.efectura.com/UserManage");
    }

    @Given("The user go to karne screen")
    public void theUserGoToKarneScreen() {
        Driver.getDriver().get("https://diageo.efectura.com:8112/KarnePilotMY.html?token=eZeHsIqYiiKBuydOq1DOBKU9WCbQ1KZXVTWHY8pTxhSq6BcJw2dlr76rduAhpnp44DvlyFaGnYQgmc2pLedbGFJYyD%2bJ5r33UgnZqZCE02P49kfkRsTI6cku2e57J6rvle1HMNnwBYVkkcG4xFkXZD7sTD1ioGr%2fNBqe7aqf3XeFDO1fot6OaTWlhmRgSf99&type=Offtrade");
        BrowserUtils.wait(2);
    }

    @When("The user click excel export button")
    public void theUserClickExcelExportButton() {
        BrowserUtils.wait(1);
        Driver.getDriver().findElement(By.xpath("//button[@id='export-reserve']/span")).click();
        BrowserUtils.wait(3);
    }

    @Then("The user verify {string} file is downloaded")
    public void theUserVerifyExcelFileIsDownloaded(String fileType) {
        if (fileType.equals("excel")) {
            Assert.assertTrue("Dosya indirilemedi!",
                    BrowserUtils.isNewExcelDownloaded(System.getProperty("user.home") + "/Downloads",5));
        } else if (fileType.equals("pdf")) {
            Assert.assertTrue("Dosya indirilemedi!",
                    BrowserUtils.isNewPdfDownloaded(System.getProperty("user.home") + "/Downloads",8));
        }
    }

    @When("The user click pdf export button")
    public void theUserClickPdfExportButton() {
        Driver.getDriver().findElement(By.xpath("//span[contains(text(),'PDF Olarak İndir')]")).click();
        BrowserUtils.wait(1);
    }

    @When("The user click siralamalar tab")
    public void theUserClickSiralamalarTab() {
        Driver.getDriver().findElement(By.xpath("//button[contains(.,'Sıralamalar')]")).click();
        BrowserUtils.wait(1);
    }

    @When("The user click excel button")
    public void theUserClickExcelButton() {
        BrowserUtils.wait(6);
        Driver.getDriver().findElement(By.xpath("//span[.='Excel']")).click();
        BrowserUtils.wait(1);
    }

    @Given("The user go to reserve karne screen")
    public void theUserGoToReserveKarneScreen() {
        Driver.getDriver().get("https://diageo.efectura.com:8112/KarnePilotReserve.html?token=4FouYUf23OgGnWsrRMnweYAVwx7bNFzjeo7kqmKJZZREXUBUHKnfTMzxOHLkPRgU4hwmMHTtVNt5X%2bcaNbtlXPUqoXKOImlYDY3pgt4axqMNqUPcwdskLx5OW0iWsRqMpXBOi9poVK54eRxcg3SIKw%3d%3d&bolge=Reserve%20Istanbul%201");
        BrowserUtils.wait(2);
    }

    @Then("The user verify table has value")
    public void theUserVerifyTableHasValue() {
        BrowserUtils.wait(5);
        By locate = By.xpath("//td[.='İlgili Döneme Ait Veri Bulunamadı']");
        boolean hasNoValueText = BrowserUtils.isElementDisplayed(locate);

        Assert.assertFalse("İlgili Döneme Ait Veri Bulunamadı Uyarısı Geldi",hasNoValueText);

    }


    @Given("The user go to EmbedDashboardCalendar")
    public void theUserGoToEmbedDashboardCalendar() {
        Driver.getDriver().get("https://diageo.efectura.com/Enrich/EmbedDashboardCalendar");
        BrowserUtils.wait(34);
        Driver.getDriver().findElement(By.xpath("//a[@id='_general-events-tab']")).click();
        // === IFRAME'LER ===
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("general-events")));
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(
                By.xpath("//iframe[contains(@src,'6e294a66-6956-4f68-935e-59212fc5dbed')]")
        ));
    }



    @When("The user take screenshot for EmbedDashboardCalendar")
    public void theUserTakeScreenshotForEmbedDashboardCalendar() {

        BrowserUtils.adjustScreenSize(55, Driver.getDriver());
        BrowserUtils.wait(10);

        String testChatId = "-1002156506449";

        String path = BrowserUtils.getScreenshot("EmbedDashboard-Grafikler");
        System.out.println("Path: " + path);

        BrowserUtils.sendFileToTelegram(path,testChatId);

        BrowserUtils.wait(2);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        By veriTabLocator = By.xpath(
                "//div[contains(@class,'ant-tabs-nav')]//div[@role='tab' and .//span[contains(.,'Veri Tablosu')]]"
        );

        WebElement veriTablosuTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(veriTabLocator)
        );

        System.out.println("veri tablosu tab text: " + veriTablosuTab.getText());
        System.out.println("before aria-selected: " + veriTablosuTab.getAttribute("aria-selected"));

        // Görüş alanına getir
        ((JavascriptExecutor) Driver.getDriver()).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", veriTablosuTab
        );

        // 1) Normal click dene
        try {
            veriTablosuTab.click();
            System.out.println("try block: normal click denendi.");
        } catch (Exception e) {
            System.out.println("normal click hata verdi: " + e.getClass().getSimpleName());
        }

        BrowserUtils.wait(2);
        System.out.println("after aria-selected (normal click sonrası): " + veriTablosuTab.getAttribute("aria-selected"));

        // 2) aria-selected hâlâ false ise JS click dene
        if (!"true".equalsIgnoreCase(veriTablosuTab.getAttribute("aria-selected"))) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", veriTablosuTab);
            System.out.println("JS click denendi.");
            BrowserUtils.wait(2);
            System.out.println("after aria-selected (JS click sonrası): " + veriTablosuTab.getAttribute("aria-selected"));
        }

        // 3) Hâlâ false ise ENTER / SPACE ile tab’ı tetikle
        if (!"true".equalsIgnoreCase(veriTablosuTab.getAttribute("aria-selected"))) {
            veriTablosuTab.sendKeys(Keys.ENTER);
            System.out.println("ENTER gönderildi.");
            BrowserUtils.wait(2);
            System.out.println("after aria-selected (ENTER sonrası): " + veriTablosuTab.getAttribute("aria-selected"));
        }

        BrowserUtils.wait(26);
        path = BrowserUtils.getScreenshot("EmbedDashboard-VeriTablosu");
        System.out.println("Path: " + path);
        BrowserUtils.sendFileToTelegram(path,testChatId);

        Driver.getDriver().switchTo().defaultContent();
    }

    @When("The user go to redirection link")
    public void theUserGoToRedirectionLink() {
        Driver.getDriver().get(
                "https://diageo.efectura.com:8112/DiageoRedirection.html?token=eZeHsIqYiiKBuydOq1DOBKU9WCbQ1KZXVTWHY8pTxhQyLjSnmliYngKJKsz%2fDDmh0Gv%2fW2ntl4ohDyR2FyqfDxf0kuDGRE4ObmSVZ9%2bQTy2iZunwSOMd3YfXQFkNdGbnUVl%2b%2bXWhL5AnSW9n%2f3ZU%2bHgxE%2ba0NTdFyaZ63UAAgVcURGBVeFNyXQqPQAIMjl6F"
        );
    }


    @When("The user click penetration tab")
    public void theUserClickPenetrationTab() {
        WebElement penetrationTab = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'Q2 Penetrasyon Offtrade Dashboard')]/preceding-sibling::a[1]"));
        penetrationTab.click();
        BrowserUtils.wait(30);
    }

    @Then("The user take screenshot for penetration")
    public void theUserTakeScreenshotForPenetration() {
        BrowserUtils.adjustScreenSize(55, Driver.getDriver());
        BrowserUtils.wait(10);

        String testChatId = "-1002156506449";

        String path = BrowserUtils.getScreenshot("Penetrasyon");
        System.out.println("Path: " + path);

        BrowserUtils.sendFileToTelegram(path,testChatId);
    }

    @When("The user go to MY360 page")
    public void goToMYPage360() {
        Driver.getDriver().get("https://diageo.efectura.com/Guest?id=eZeHsIqYiiKBuydOq1DOBKU9WCbQ1KZXVTWHY8pTxhQyLjSnmliYngKJKsz%2FDDmh0Gv%2FW2ntl4ohDyR2FyqfDxf0kuDGRE4ObmSVZ9%20QTy2iZunwSOMd3YfXQFkNdGbnUVl%20%20XWhL5AnSW9n%2F3ZU%20HgxE%20a0NTdFyaZ63UAAgVcURGBVeFNyXQqPQAIMjl6F&routeCode=PR_BAKIRKOY&myName=MAZLUM%20S%C3%96NMEZ&userName=mazlums&userEmailAddress=mazlum.sonmez1%40diageo.com");

        BrowserUtils.wait(3);
    }

    @When("The user select customer {string}")
    public void theUserSelectCustomer(String customerName) {
        WebElement selectCustomerElement = Driver.getDriver().findElement(By.xpath("//select[@id='item-select']"));
        BrowserUtils.selectDropdownOptionByVisibleText(selectCustomerElement,customerName);
        BrowserUtils.wait(26);
    }

    @Then("The user take screenshot for my")
    public void theUserTakeScreenshotForMy() {
        BrowserUtils.adjustScreenSize(55, Driver.getDriver());
        BrowserUtils.wait(30);

        String testChatId = "-1002156506449";

        String path = BrowserUtils.getScreenshot("Ömizleme-GenelBilgi");
        System.out.println("Path: " + path);
        BrowserUtils.sendFileToTelegram(path,testChatId);
        BrowserUtils.wait(2);


//        Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[1]/ul/li[12]/a")).click();
//        BrowserUtils.wait(25);
//        path = BrowserUtils.getScreenshot("Ömizleme-BorçYaşlandırmaAnalizi");
//        System.out.println("Path: " + path);
//        BrowserUtils.sendFileToTelegram(path,testChatId);

    }

    @When("The user wait {int} seconds")
    public void theUserWaitSeconds(int second) {
        BrowserUtils.wait(second);
    }

    @When("The user verify {string}")
    public void theUserVerifyNoData(String text) {
        List<WebElement> noDataElements = Driver.getDriver().
                findElements(By.xpath("//*[contains(normalize-space(.), '" + text + "')]"));

        Assert.assertEquals("No Data Yazan Element Mevcut!", 0, noDataElements.size());

    }

    @When("The user click support button")
    public void theUserClickSupportButton() {
        Driver.getDriver().findElement(By.xpath("//a[@id='userSupportBtn']")).click();
    }

    String uniqueMailBody;
    @When("The user fill support inputs")
    public void theUserFillSupportInputs() {
        uniqueMailBody = UUID.randomUUID().toString();
        System.out.println("uniqueMailBody: " + uniqueMailBody);

        Driver.getDriver().findElement(By.xpath("//input[@id='ticketTitle']")).
                sendKeys("Test Automation Title");

        Driver.getDriver().findElement(By.xpath("//textarea[@id='explanationTicket']")).
                sendKeys("test automation ticket explanation - " + uniqueMailBody);

    }

    @When("The user upload support file")
    public void theUserUploadSupportFile() {
        Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']")).
                sendKeys(getExcelPath("Attribute"));
    }

    @When("The user click send ticket button")
    public void theUserClickSendTicketButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='sendTicket']")).click();
        BrowserUtils.wait(1);
    }

    @Then("The user verify mail is sent")
    public void theUserVerifyMailIsSent() {
        BrowserUtils.wait(5);
        boolean iSent = pages.dbProcess().isSupportMailSent(uniqueMailBody);

        Assert.assertTrue("Support Maili Db'ye düşmedi!!", iSent);

    }


    @When("The user search in global input")
    public void theUserSearchInGlobalInput() {
        Driver.getDriver().findElement(By.xpath("//input[@id='globalSearchInput']")).sendKeys();
    }

    @When("The user click {string} button")
    public void theUserClickButton(String buttonName) {
        String locate = "//button[contains(normalize-space(),'" + buttonName + "')]";
        Driver.getDriver().findElement(By.xpath(locate)).click();

    }

    List<String> selectedTexts = new ArrayList<>();
    @When("The user get selected export options")
    public void theUserGetSelectedExportOptions() {
        selectedTexts = pages.itemOverviewPage().getSelectedExportOptions().stream()
                .map(WebElement::getText)
                .map(String::trim)
                .map(t -> t.equalsIgnoreCase("Kod") ? "Fletum Kod" : t).toList();
    }

    @When("The user complete the export")
    public void theUserCompleteTheExport() {
        Driver.getDriver().findElement(By.xpath("//button[@id='export-columns-next']")).click();
        BrowserUtils.wait(1);
//        Driver.getDriver().findElement(By.xpath("//button[@id='export-columns-done']")).click();
//        BrowserUtils.wait(2);
    }

    @When("The user wait {int} second")
    public void theUserWaitSecond(int secondAmount) {
        BrowserUtils.wait(secondAmount);
    }

    @Then("The user verify file is downloaded")
    public void theUserVerifyFileIsDownloaded() {
        boolean isDownloaded = BrowserUtils.isNewExcelDownloaded
                (System.getProperty("user.home") + "/Downloads",10);
        Assert.assertTrue("Dosya indirilmedi",isDownloaded);
        Driver.getDriver().navigate().refresh();

    }

    @Given("The user go to rota edit item")
    public void theUserGoToRotaEditItem() {
        Driver.getDriver().get("https://diageo.efectura.com/Enrich/EditItem/3577492");
        BrowserUtils.wait(3);
    }
}
