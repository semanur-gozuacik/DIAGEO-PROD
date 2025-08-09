package com.sema.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ReportsPage extends BasePage {

    @FindBy(xpath = "//select[@id='dropdownReports']")
    private WebElement reportSelect;

    @FindBy(xpath = "//button[@id='showReport']")
    private WebElement showReportButton;

    @FindBy(xpath = "//div[@id='exportReport']/button")
    private WebElement mainExportButton;

    @FindBy(xpath = "//a[@id='export-reports']")
    private WebElement exportCurrentView;

    @FindBy(xpath = "//a[@class='export-email']")
    private WebElement exportSendMail;

}
