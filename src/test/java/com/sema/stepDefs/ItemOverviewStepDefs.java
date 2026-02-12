package com.sema.stepDefs;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

import static com.sema.utilities.CommonExcelReader.getExcelPath;

public class ItemOverviewStepDefs extends BaseStep {
    WebDriver driver = Driver.getDriver();

    @And("The user verify Reset button func for {string} text filter")
    public void theUserVerifyResetButtonFuncForTextFilter(String columnName) {
        String locate = "//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/preceding-sibling::th)+1]//input";
        WebElement textFilterInputBox = Driver.getDriver().findElement(By.xpath(locate));
        String actualValue = BrowserUtils.getValueInInputBox(textFilterInputBox);
        Assert.assertEquals("", actualValue);
    }

    @When("The user clicks {string} pagination button")
    public void theUserClicksLastPageTablePaginationButton(String btnName) {
        pages.generalPage().clickPaginationButton(btnName);
        BrowserUtils.wait(20);
    }

    @And("The user verifies {string} button is {string}")
    public void theUserVerifiesButtonIs(String btnName, String btnStatus) {
        pages.generalPage().verifyButtonStatus(btnName,btnStatus);
    }

    @Given("The user go to calender page")
    public void theUserGoToCalenderPage() {
        Driver.getDriver().get("https://diageo.efectura.com/Enrich/EmbedDashboardCalendar");
        BrowserUtils.wait(1);
        pages.editItemPage().getCalendarTab().click();
        BrowserUtils.wait(35);
    }

    @Then("The user verify calendar")
    public void theUserVerifyCalendar() {

        pages.generalPage().verifyNextDayChangesDate();
        pages.generalPage().verifyPrevDayChangesDate();
        pages.generalPage().verifyTodayButtonGoesToToday();

    }

    @When("The user select create item family {string}")
    public void theUserSelectCreateItemFamily(String family) {
        BrowserUtils.wait(12);
        pages.itemOverviewPage()
                .getCreateItemFamilies()
                .stream()
                .filter(el -> el.getText().trim().equalsIgnoreCase(family))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Family not found: " + family))
                .click();

        driver.findElement(By.xpath("//button[@id='nextStepItemAttr']")).click();

    }

    String optionText;
    @When("The user fill event create attributes")
    public void theUserFillEventCreateAttributes() {
        BrowserUtils.wait(30);

        optionText = "Redign 1";
        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[1]/div/span/span[1]/span")).click();
        BrowserUtils.wait(12);
        driver.findElement(By.xpath("//li[.='Redign 1']")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div[15]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div[1]/div/span/span[1]/span/ul/li[2]/input")).
//                sendKeys(optionText + Keys.ENTER);

//        optionText = select.getOptions().get(1).getText();



//        driver.findElement(By.xpath("//input[@id='3832 Localizable']")).sendKeys(UUID.randomUUID().toString());
//
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[3]/div/span")).click();
//        driver.findElement(By.xpath("//span/span/span[1]/input")).sendKeys("Birebir");
//        driver.findElement(By.xpath("//li[.='Birebir']")).click();
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[3]/div/span")).click();
////        WebElement temasTipSelect = driver.findElement(By.xpath("//select[@id='attribute-4953']"));
////        BrowserUtils.selectDropdownOptionByIndex(temasTipSelect,1);
//
//        BrowserUtils.wait(2);
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[4]/div/span/span[1]/span")).click();
//        driver.findElement(By.xpath("//li[.='Mentoring']")).click();
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[4]/div/span/span[1]/span")).click();
////        WebElement stillSelect = driver.findElement(By.xpath("//select[@id='attribute-3822']"));
////        BrowserUtils.selectDropdownOptionByIndex(stillSelect,1);
//
//        driver.findElement(By.xpath("//div[@id='3809 Localizable']//p")).sendKeys("açıklama" + UUID.randomUUID().toString());
//
//        driver.findElement(By.xpath("//input[@id='DIA_Start_Date_E']")).click();
//        BrowserUtils.wait(1);
//        driver.findElement(By.xpath("//div[14]/div[2]/div/div[2]/div/span[contains(@class,'flatpickr-day today')]")).click();
//
//        driver.findElement(By.xpath("//input[@id='DIA_Finish_Date_E']")).click();
//        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div/span[contains(@class,'flatpickr-day today')]/following-sibling::span[1]")).click();
//
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[16]/div/span/span[1]/span")).click();
//        driver.findElement(By.xpath("//li[.='Ankara']")).click();
////        WebElement citySelect = driver.findElement(By.xpath("//select[@id='attribute-4922']"));
////        BrowserUtils.selectDropdownOptionByIndex(citySelect,1);
//
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[19]/div/span")).click();
//        driver.findElement(By.xpath("//li[.='Hayır']")).click();
////        WebElement isCustomer = driver.findElement(By.xpath("//select[@id='attribute-4925']"));
////        BrowserUtils.selectDropdownOptionByVisibleText(isCustomer,"Hayır");
//
//        driver.findElement(By.xpath("//input[@id='4923 Localizable']")).sendKeys("mekan -" + UUID.randomUUID().toString());

        WebElement fileInputCreate = driver.findElement(By.xpath("//input[@id='inputImageOnCreate']"));
//        fileInputCreate.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DIAGEO-PROD\\src\\test\\java\\com\\sema\\pages\\BPM\\ModulFlows.java");
        fileInputCreate.sendKeys(getExcelPath("Attribute"));
        BrowserUtils.wait(5);

        driver.findElement(By.xpath("//button[@id='next-step-btn']")).click();



    }

    @When("The user select category for create")
    public void theUserSelectCategoryForCreate() {
        //driver.findElement(By.xpath("//a[@id='_fast-categories']")).click();
        BrowserUtils.adjustScreenSize(70,driver);
        BrowserUtils.wait(3);
        BrowserUtils.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Anason Akademisi')]/preceding-sibling::div[1]")));
        driver.findElement(By.xpath("//div[contains(text(),'Anason Akademisi')]/preceding-sibling::div[1]")).click();
        driver.findElement(By.xpath("//button[@id='next-step-btn']")).click();
    }

    @When("The user complete create")
    public void theUserCompleteCreate() {
        driver.findElement(By.xpath("//button[@id='next-step-segment-build']")).click();
        BrowserUtils.wait(2);
//        driver.findElement(By.xpath("//button[@id='last-step-preview']")).click();
//        driver.findElement(By.xpath("//button[@id='last-step-preview']")).click();
        driver.findElement(By.xpath("//button[@id='create-segment']")).click();
    }

    @When("The user click event calendar tab")
    public void theUserClickEventCalendarTab() {
        driver.findElement(By.xpath("//a[@id='event-calendar-tab']")).click();
        BrowserUtils.wait(3);
    }

    @When("The user take screenshot for event calendar")
    public void theUserTakeScreenshotForEventCalendar() {
        BrowserUtils.adjustScreenSize(80, Driver.getDriver());
        BrowserUtils.wait(25);

        String testChatId = "-1002156506449";

        String path = BrowserUtils.getScreenshot("Event - Calendar");
        System.out.println("Path: " + path);

        BrowserUtils.sendFileToTelegram(path,testChatId);
    }
}
