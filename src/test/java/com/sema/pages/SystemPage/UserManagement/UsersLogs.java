package com.sema.pages.SystemPage.UserManagement;

import com.sema.pages.BasePage;
import com.sema.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersLogs extends BasePage {
    @FindBy(xpath = "//a[@class='breadcrumbs__item'][normalize-space()='User Logs']")
    private WebElement usersLogsVerificationsElement;
    @FindBy(xpath = "//button[@class='btn btn-primary' and @data-dismiss='modal' and text()='OK']")
    private WebElement logsclick;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    private WebElement userlogsSeachButtons;

    public UsersLogs() {
    }

    public void verifyUsers() {
        BrowserUtils.wait(5);
        Assert.assertTrue(usersLogsVerificationsElement.isDisplayed());
    }

    public void onTheUsersSettingPage() {
        driver.navigate().to("https://sandbox.efectura.com/UserManage/UserLogs");
    }

    public void logsClick() {
        logsclick.click();
    }

    public void logsSearhButton() {
        userlogsSeachButtons.click();
    }
}