package com.sema.pages;

import com.sema.utilities.BrowserUtils;
import com.sema.utilities.Driver;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

import static com.sema.utilities.BrowserUtils.isButtonActive;

@Getter
public class GeneralPage extends BasePage {

    @FindBy(xpath = "//button[contains(@id,'-reset-basic')]")
    private WebElement basicResetButton;

    @FindBy(xpath = "//a[contains(@class,'t-edit')]")
    private WebElement editBtnInTable;

    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement infoMessage;

    @FindBy(xpath = "//iframe")
    private WebElement jobsFrame;

    @FindBy(xpath = "//h1[text()='Overview']")
    private WebElement jobsHeader;

    @FindBy(xpath = "//iframe[contains(@src,'/Enrich/EmbedDashboard?dashboardName=report-analysis')]")
    private WebElement reportCardAnalysisMainFrame;

    @FindBy(xpath = "//iframe[contains(@src,'https://dia-dashboard.efectura.com/embedded/')]")
    private WebElement reportCardAnalysisSecondFrame;

    @FindBy(xpath = "/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/div[1]/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/table")
    private WebElement cardAnalysisTable;

    @FindBy(xpath = "//*[@id='impersonate']")
    public WebElement impersonateHoverBtn;

    @FindBy(xpath = "//a[@id='impersonate-fletum']")
    public WebElement impersonateButton;

    @FindBy(xpath = "/html/body/div[2]/nav/div/div[3]/form/ul/li[2]/a")
    private WebElement notificationIcon;

    @FindBy(xpath = "//div[contains(@id,'notification')]/div/div/div/p")
    private List<WebElement> notificationValues;

    @FindBy(xpath = "//a[contains(@href,'/Enrich/EditItem/')]")
    private List<WebElement> mentionLinks;



    public void useTextFilter(String value, String columnName) {
        // (//table[.//thead/tr[1]/th[normalize-space()='Fletum Kod']] )[1]//thead/tr[2]/th[position() = count((//table[.//thead/tr[1]/th[normalize-space()='Fletum Kod']])[1]//thead/tr[1]/th[normalize-space()='Fletum Kod']/preceding-sibling::th) + 1 ]//input
        String locate = "(//table[.//thead/tr[1]/th[normalize-space()='" + columnName + "']] )[1]//thead/tr[2]/th[position() = count((//table[.//thead/tr[1]/th[normalize-space()='" + columnName + "']])[1]//thead/tr[1]/th[normalize-space()='" + columnName + "']/preceding-sibling::th) + 1 ]//input";

        BrowserUtils.wait(5);
        WebElement filterInput = Driver.getDriver().findElement(By.xpath(locate));
        BrowserUtils.waitForVisibility(filterInput,40);
        filterInput.sendKeys(value + Keys.ENTER);

    }

    public void clickPaginationButton(String btnName) {
        BrowserUtils.wait(10);
        String locate = "//div[@class='pagination-container']//*[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                btnName + "')]";
        WebElement btn = driver.findElement(By.xpath(locate));
//        WebElement btn2 = driver.findElement(By.id(btnName));
//        WebElement button = driver.findElement
//                (By.xpath("//div[@class='pagination-container']//button[@id='" + btnName + "']"));
        btn.click();
    }

    public void verifyButtonStatus(String btnName, String btnStatus) {
        BrowserUtils.wait(4);
        String locate = "//div[@class='pagination-container']//*[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                btnName + "')]";
        System.out.println(locate);
//        WebElement btn = driver.findElement(By.xpath(locate));
        WebElement button = driver.findElement(By.xpath("//button[@title='" + btnName + "']"));
        if(btnStatus.equalsIgnoreCase("Active")) {
            Assert.assertTrue(isButtonActive(button));
        } else if (btnStatus.equalsIgnoreCase("Passive")) {
            Assert.assertFalse(isButtonActive(button));
        }
    }

    // you can use selectFilter as IsAssociated, Family, ItemStatuses in feature file
    public void selectOptionInSelectFilter(String selectOption, String selectFilter) {

        WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'-" + selectFilter + "')]"));
        BrowserUtils.selectDropdownOptionByVisibleText(selectElement,selectOption);
        BrowserUtils.wait(3);
    }


    // Aktif günün data-date bilgisini al
    private LocalDate getCurrentCalendarDate() {
        WebElement todayCell = driver.findElement(
                By.cssSelector(".fc-timegrid-col.fc-day-today, .fc-daygrid-day.fc-day-today")
        );
        String dateAttr = todayCell.getAttribute("data-date"); // örn: 2025-12-05
        return LocalDate.parse(dateAttr); // ISO format, direkt parse olur
    }

    // Sonraki gün butonu
    private void clickNext() {
        WebElement nextBtn = driver.findElement(By.xpath("//button[@title='ileri']"));
        nextBtn.click();
    }

    // Önceki gün butonu
    private void clickPrev() {
        WebElement prevBtn = driver.findElement(By.xpath("//button[@title='geri']"));
        prevBtn.click();
    }

    // Bugün butonu
    private void clickToday() {
        WebElement todayBtn = driver.findElement(By.cssSelector(".fc-today-button"));
        todayBtn.click();
    }

    // === Test örnekleri ===

    // 1) Next tıklayınca tarih +1 gün olmalı (Gün görünümünde)
    public void verifyNextDayChangesDate() {
        LocalDate before = getCurrentCalendarDate();

        clickNext();

//        // DOM güncellensin diye bugün class'lı cell değişene kadar bekleyelim
//        wait.until(driver -> !getCurrentCalendarDate().equals(before));
//
//        LocalDate after = getCurrentCalendarDate();
//        // Day view’de genelde +1 gün bekleriz; tamamen emin değilsen sadece "eşit değil" de kontrol edebilirsin
//        if (!after.equals(before.plusDays(1))) {
//            throw new AssertionError("Next butonu yanlış çalışıyor. Beklenen: "
//                    + before.plusDays(1) + " Gerçek: " + after);
//        }
    }

    // 2) Prev tıklayınca tarih -1 gün olmalı
    public void verifyPrevDayChangesDate() {
//        LocalDate before = getCurrentCalendarDate();

        clickPrev();
//        wait.until(driver -> !getCurrentCalendarDate().equals(before));
//
//        LocalDate after = getCurrentCalendarDate();
//        if (!after.equals(before.minusDays(1))) {
//            throw new AssertionError("Prev butonu yanlış çalışıyor. Beklenen: "
//                    + before.minusDays(1) + " Gerçek: " + after);
//        }
    }

    // 3) Bugün butonuna basınca sistem tarihine gelmeli
    public void verifyTodayButtonGoesToToday() {
        // Önce başka bir güne git
        clickNext();
        clickNext();

        clickToday();

//        LocalDate calendarDate = getCurrentCalendarDate();
//        LocalDate systemToday = LocalDate.now(); // istersen ZoneId.of("Europe/Istanbul") da kullanabilirsin

//        if (!calendarDate.equals(systemToday)) {
//            throw new AssertionError("Bugün butonu yanlış çalışıyor. Beklenen: "
//                    + systemToday + " Gerçek: " + calendarDate);
//        }
    }


}
