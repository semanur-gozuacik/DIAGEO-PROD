package com.sema.stepDefs;

import com.sema.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class ReportsStepDefs extends BaseStep {

    @When("The user select {string} report")
    public void theUserSelectOutletPointHistoryReport(String reportName) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.reportsPage().getReportSelect(),reportName);
        pages.reportsPage().getShowReportButton().click();
        BrowserUtils.wait(1);
        BrowserUtils.waitForClickability(pages.reportsPage().getMainExportButton(),30);
        BrowserUtils.wait(2);
    }

}
